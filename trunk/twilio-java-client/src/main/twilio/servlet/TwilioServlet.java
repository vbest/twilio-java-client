
package twilio.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twilio.client.DialStatus;
import twilio.client.SmsStatus;
import twilio.client.TranscriptionStatus;
import twilio.markup.Conference;
import twilio.markup.Constants;
import twilio.markup.Dial;
import twilio.markup.Gather;
import twilio.markup.Hangup;
import twilio.markup.Pause;
import twilio.markup.Play;
import twilio.markup.Record;
import twilio.markup.Redirect;
import twilio.markup.Response;
import twilio.markup.Say;
import twilio.markup.Verb;
import twilio.markup.Voice;

/**
 * 
 *  This is an abstract class. You'll need to extend it.
 *
 *  <code>
 *   public class MyTwilioServlet extends TwilioServlet
 *   {
 *      // code here
 *   }
 *  </code>
 *  
 */
public abstract class TwilioServlet extends HttpServlet
{
	private static final Logger log =
	      Logger.getLogger(TwilioServlet.class.getName());
	
	static private final long serialVersionUID = 1L;
	static private ThreadLocal<HttpServletRequest> httpRequestTL = new ThreadLocal<HttpServletRequest>();
	static private ThreadLocal<HttpServletResponse> httpResponseTL = new ThreadLocal<HttpServletResponse>();
	static private ThreadLocal<Response> twilioResponseTL = new ThreadLocal<Response>();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		try
		{
			setTwilioResponse(new Response());
			httpResponseTL.set(resp);
			httpRequestTL.set(req);
			doTwilioRequest(new TwilioRequest(req, getTwilioAccountPhoneNumber()));
		}
		finally
		{
			httpRequestTL.remove();
			httpResponseTL.remove();
		}
	}
	
	abstract protected String getTwilioAccountPhoneNumber();

	static public Response getTwilioResponse()
	{
		return twilioResponseTL.get();
	}
	
	static public void setTwilioResponse(Response r)
	{
		twilioResponseTL.set(r);
	}
	
	protected Response say(CharSequence msg)
	{
		return say(msg, Voice.MAN);
	}
	
	protected Response say(String[] messages)
	{
		for (String msg : messages)
		{
			say(msg, Voice.MAN);
		}
		
		return getTwilioResponse();
	}

	protected Response say(java.util.Collection<? extends CharSequence> messages)
	{
		for (CharSequence msg : messages)
		{
			say(msg, Voice.MAN);
		}
		
		return getTwilioResponse();
	}
	
	
	protected Response say(CharSequence msg, Voice v)
	{
		return say(msg, v, 1);
	}
	
	protected Response say(CharSequence msg, Voice v, int loop)
	{
		Say s = new Say(msg);
		s.setVoice(v);
		s.setLoop(loop);
		return add(s);
	}
	
	protected Response gather()
	{
		return gather(null, 1, Constants.DEFAULT_TIMEOUT, null);
	}
	
	protected Response gather(int numberOfDigits)
	{
		return gather(null, numberOfDigits, Constants.DEFAULT_TIMEOUT, null);
	}
	
	protected Response gather(int numberOfDigits, int timeoutInSeconds)
	{
		return gather(null, numberOfDigits, timeoutInSeconds, null);
	}

	protected Response gather(int numberOfDigits, int timeoutInSeconds, String... sayMessages)
	{
		return gather(sayMessages, numberOfDigits, timeoutInSeconds, null);
	}
	
	protected Response gather(String[] sayMessages, int numberOfDigits, int timeoutInSeconds, String queryStringForActionUrl)
	{
		Gather g = new Gather();
		
		if (sayMessages != null)
		{
			for (String msg : sayMessages)
			{
				if ( (msg != null) && (msg.length() > 0) )
				{
					Say s = new Say(msg);
					g.add(s);
				}
			}
		}
		
		g.setNumDigits(numberOfDigits);
		g.setTimeout(timeoutInSeconds);
		
		StringBuffer action = getRequestURL();
		
		if (queryStringForActionUrl != null)
		{
			if ( ! queryStringForActionUrl.startsWith("?"))
			{
				action.append("?");
			}
			action.append(queryStringForActionUrl);
		}
		
		g.setAction(action.toString());
		
		return add(g);
	}
	
	protected Response record()
	{
		return record(false);
	}
	
	protected Response record(boolean transcription)
	{
		String recordCallbackUrl = getHttpServletRequest().getRequestURL().toString();
		
		String transcriptionCallbackUrl = null;
		
		if (transcription)
		{
			transcriptionCallbackUrl = getHttpServletRequest().getRequestURL().toString();
		}
		
		return record(recordCallbackUrl, 
					Constants.DEFAULT_TIMEOUT, 
					Constants.DEFAULT_FINISH_ON_KEY, 
					transcriptionCallbackUrl);
	}
	
	protected Response record(Integer timeout, Character finishOnKey)
	{
		String callbackUrl = getHttpServletRequest().getRequestURL().toString();
		
		return record(callbackUrl, timeout, finishOnKey, null);
	}
	
	protected Response record(String recordCallbackUrl, 
					Integer timeout, 
					Character finishOnKey,
					String transcribeCallbackUrl)
	{
		Record r = new Record();
		r.setAction(recordCallbackUrl);
		if (timeout != null)
		{
			r.setTimeout(timeout);
		}
		r.setFinishOnKey(finishOnKey);
		r.setTranscribeCallback(transcribeCallbackUrl);
		
		return add(r);
	}
	
	protected Response hangup()
	{
		return add(new Hangup());
	}
	
	protected Response add(Verb v)
	{
		return getTwilioResponse().add(v);
	}
	
	protected Response pause(int seconds)
	{
		if (seconds < 0)
		{
			seconds = 0;
		}
		
		Pause p = new Pause(seconds);
		return add(p);
	}
	
	protected Response play(CharSequence url)
	{
		return play(url, 1);
	}
	
	protected Response redirect(CharSequence url)
	{
		Redirect r = new Redirect();
		r.setUrl(url);
		
		return add(r);
	}
	
	protected Response redirect()
	{
		return redirect(getHttpServletRequest().getRequestURL());
	}

	protected Response dial(Conference c)
	{
		Dial d = new Dial();
		
		d.add(c);
		
		return add(d);
	}
	
	protected Response dial(CharSequence... numbers)
	{
		Dial d = new Dial();
		
		for (CharSequence num : numbers)
		{
			d.add(num);
		}
		
		return add(d);
	}
	
	protected Response play(CharSequence url, int loop)
	{
		
		Play p = new Play();
		p.setLoop(loop);
		p.setUrl(url);
		
		return add(p);
	}
	
	static public HttpServletResponse getHttpServletResponse()
	{
		return httpResponseTL.get();
	}
	
	protected void doTwilioRequest(TwilioRequest req) throws IOException
	{
		log.info("doTwilioRequest called\n\n" + ServletUtil.toString(req));
		
		if (! verifyRequest(req))
		{
			log.info("verification failed");
			setTwilioResponse(null);
			getHttpServletResponse().setContentType("text/plain");
			getHttpServletResponse().setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
		else if (req.isSmsCallback())
		{
			onInboundSms(req, req.getSmsSid(), req.getSmsStatus());
		}
		else if (req.isRecordCallback())
		{
			onRecordCallback(req, req.getRecordingUrl());
		}
		else if (req.isTranscribeCallback())
		{
			onTranscribeCallback(req, 
						req.getTranscriptionStatus(), 
						req.getTranscriptionText());
		}
		else if (req.isGatherCallback())
		{
			onGatherCallback(req, req.getDigits());
		}
		else if (req.isDialCallback())
		{
			onDialCallback(req, req.getDialStatus());
		}
		else if (req.isInboundCall())
		{
			onInboundCall(req, req.getCaller(), req.getCalled());
		}
		else 
		{
			setTwilioResponse(null);
			onUnknownRequest(req);
		}
		
		if (getTwilioResponse() != null)
		{
			writeTwilioResponse(getTwilioResponse());
		}
	}

	protected boolean verifyRequest(TwilioRequest req)
	{
		return SecurityUtil.verifyRequest(req, getTwilioAuthToken());
	}

	abstract protected String getTwilioAuthToken();

	protected void onUnknownRequest(TwilioRequest req) throws IOException
	{
		log.info("onUnknownRequest called");
		
		HttpServletResponse resp = getHttpServletResponse();
		
		resp.setContentType("text/plain");
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		
		PrintWriter w = resp.getWriter();
		
		w.println("unexpected request");
		w.print("Request URL: " + req.getRequestURL());
		
		if (req.getQueryString() != null)
		{
			w.print("?" + req.getQueryString());
		}
		
		w.println();
		w.flush();
		
	}

	abstract protected void onInboundSms(TwilioRequest req, 
										String smsSid,
										SmsStatus smsStatus);
	
	abstract protected void onRecordCallback(TwilioRequest req, String recordingUrl);

	abstract protected void onInboundCall(TwilioRequest req, String caller, String called);

	abstract protected void onGatherCallback(TwilioRequest req, String digits);

	abstract protected void onDialCallback(TwilioRequest req, DialStatus status);

	abstract protected void onTranscribeCallback(TwilioRequest req, TranscriptionStatus status, String text);

	protected void sendBinaryResponse(HttpServletResponse resp, byte[] data, String mimeType)
	{
		sendBinaryResponse(resp, data, data.length, mimeType);
	}
	
	protected void sendBinaryResponse(HttpServletResponse resp, InputStream data, int length, String mimeType)
	{
		sendBinaryResponse(resp, data, length, mimeType);
	}
	
	
	protected void sendBinaryResponse(HttpServletResponse resp, Object data, int length, String mimeType)
	{
		resp.setContentType(mimeType);
		
		if (length >= 0)
		{
			resp.setContentLength(length);
		}
		
		try
		{
			OutputStream out = resp.getOutputStream();
			
			if (data instanceof byte[])
			{
				byte[] byteArray = (byte[]) data;
				out.write(byteArray, 0, byteArray.length);
			}
			else if (data instanceof InputStream)
			{
				InputStream input = (InputStream) data;
				byte[] buffer = new byte[8192];
				
				int n = -1;
				
				while ( (n = input.read(buffer)) != -1)
				{
					out.write(buffer, 0, n);
				}
				
			}
			else if (data instanceof ByteArrayOutputStream)
			{
				ByteArrayOutputStream baos = (ByteArrayOutputStream) data;
				baos.writeTo(out);
			}
			else
			{
				resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				// todo : log an error
			}
			out.flush();
		}
		catch (IOException ignored)
		{
			// ignored
		}
			
		
	}
	
	protected void writeTwilioResponse(Response rsp)
	{
		String xml = "";
		
		try
		{
			xml = rsp.toXml();
		}
		catch (Throwable t)
		{
			xml = "<!-- fail: "
				+ t.getClass().getName()
				+ " -->";

		}
		finally
		{
			writeTwilioResponse(xml);
		}
	}
	
	protected void writeTwilioResponse(String response)
	{
		log.info("TwiML response: " + response);
		
		HttpServletResponse httpResp = getHttpServletResponse();
		
		httpResp.setContentType(Constants.TWILIO_MARKUP_CONTENT_TYPE);
		httpResp.setStatus(HttpServletResponse.SC_OK);
		
		PrintWriter writer = null;
		
		try
		{
			writer = httpResp.getWriter();
			writer.write(response);
			writer.flush();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		
	}
	
	protected void sendWavResponse(HttpServletResponse resp, byte[] wav)
	{
		sendBinaryResponse(resp, wav, "audio/x-wav");
	}


	protected void sendMp3Response(HttpServletResponse resp, byte[] mp3)
	{
		sendBinaryResponse(resp, mp3, "audio/mpeg");
	}
	
	protected static HttpServletRequest getHttpServletRequest()
	{
		return httpRequestTL.get();
	}
	
	protected static StringBuffer getRequestURL()
	{
		return getHttpServletRequest().getRequestURL();
	}

	protected static String getQueryString()
	{
		return getHttpServletRequest().getQueryString();
	}

	protected String urlEncode(String s)
	{
		try
		{
			return URLEncoder.encode(s, "UTF-8");
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
