
package twilio.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twilio.markup.Constants;
import twilio.markup.Hangup;
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
	static private final long serialVersionUID = 1L;
	static private ThreadLocal<HttpServletResponse> httpResponseTL = new ThreadLocal<HttpServletResponse>();
	static private ThreadLocal<Response> twilioResponseTL = new ThreadLocal<Response>();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		try
		{
			setTwilioResponse(new Response());
			httpResponseTL.set(resp);
			doTwilioRequest(new TwilioRequest(req));
		}
		finally
		{
			httpResponseTL.remove();
		}
	}
	
	static public Response getTwilioResponse()
	{
		return twilioResponseTL.get();
	}
	
	static public void setTwilioResponse(Response r)
	{
		twilioResponseTL.set(r);
	}
	
	protected Response say(String msg)
	{
		return say(msg, Voice.MAN);
	}
	
	protected Response say(String msg, Voice v)
	{
		return say(msg, v, 1);
	}
	
	protected Response say(String msg, Voice v, int loop)
	{
		Say s = new Say(msg);
		s.setVoice(v);
		s.setLoop(loop);
		return add(s);
	}
	
	protected Response hangup()
	{
		return add(new Hangup());
	}
	
	protected Response add(Verb v)
	{
		return getTwilioResponse().add(v);
	}
	
	static public HttpServletResponse getHttpServletResponse()
	{
		return httpResponseTL.get();
	}
	
	protected void doTwilioRequest(TwilioRequest req) throws IOException
	{
		
		if (req.isDialCallback())
		{
			onDialCallback(req);
		}
		else if (req.isGatherCallback())
		{
			onGatherCallback(req);
		}
		else if (req.isRecordCallback())
		{
			onRecordCallback(req);
		}
		else if (req.isInboundCall())
		{
			onInboundCall(req);
		}
		else if (req.isTranscribeCallback())
		{
			onTranscribeCallback(req);
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

	protected void onUnknownRequest(TwilioRequest req) throws IOException
	{
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

	abstract protected void onRecordCallback(TwilioRequest req);

	abstract protected void onInboundCall(TwilioRequest req);

	abstract protected void onGatherCallback(TwilioRequest req);

	abstract protected void onDialCallback(TwilioRequest req);

	abstract protected void onTranscribeCallback(TwilioRequest req);

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
			rsp.toXml();
		}
		catch (Throwable t)
		{
			xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
				+ "<Response>"
				+ "<Say loop=\"3\" voice=\"man\">Nom nom nom</Say>"
				+ "</Response>";

		}
		finally
		{
			writeTwilioResponse(xml);
		}
	}
	
	protected void writeTwilioResponse(String response)
	{
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
}
