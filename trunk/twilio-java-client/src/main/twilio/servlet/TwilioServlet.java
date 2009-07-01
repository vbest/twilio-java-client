
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
import twilio.markup.Response;

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
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		try
		{
			httpResponseTL.set(resp);
			doTwilioRequest(new TwilioRequest(req), resp);
		}
		finally
		{
			httpResponseTL.remove();
		}
	}
	
	static public HttpServletResponse getHttpServletResponse()
	{
		return httpResponseTL.get();
	}
	
	protected void doTwilioRequest(TwilioRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType(twilio.markup.Constants.TWILIO_MARKUP_CONTENT_TYPE);
		
		Response twilioResponse = null;
		
		if (req.isDialCallback())
		{
			twilioResponse = onDialCallback(req, resp);
		}
		else if (req.isGatherCallback())
		{
			twilioResponse = onGatherCallback(req, resp);
		}
		else if (req.isRecordCallback())
		{
			twilioResponse = onRecordCallback(req, resp);
		}
		else if (req.isInboundCall())
		{
			twilioResponse = onInboundCall(req, resp);
		}
		else if (req.isTranscribeCallback())
		{
			twilioResponse = onTranscribeCallback(req, resp);
		}
		else 
		{
			onUnknownRequest(req, resp);
		}
		
		if (twilioResponse != null)
		{
			writeTwilioResponse(twilioResponse);
		}
	}

	protected void onUnknownRequest(TwilioRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		
		PrintWriter w = resp.getWriter();
		
		w.println("unexpected request");
		w.print("Request URL: " + req.getRequestURL());
		if (req.getQueryString() != null)
		{
			w.print("?" + req.getQueryString());
		}
		
	}

	abstract protected Response onRecordCallback(TwilioRequest req, HttpServletResponse resp);

	abstract protected Response onInboundCall(TwilioRequest req, HttpServletResponse resp);

	abstract protected Response onGatherCallback(TwilioRequest req, HttpServletResponse resp);

	abstract protected Response onDialCallback(TwilioRequest req, HttpServletResponse resp);

	abstract protected Response onTranscribeCallback(TwilioRequest req, HttpServletResponse resp);

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
		writeTwilioResponse(rsp.toXml());
	}
	
	protected void writeTwilioResponse(String response)
	{
		HttpServletResponse httpResp = getHttpServletResponse();
		
		httpResp.setContentType(Constants.TWILIO_MARKUP_CONTENT_TYPE);
		
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
