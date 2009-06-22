
package twilio.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		doTwilioRequest(new TwilioRequest(req), resp);
	}
	
	protected void doTwilioRequest(TwilioRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType(twilio.markup.Constants.TWILIO_MARKUP_CONTENT_TYPE);
		
		if (req.isDialCallback())
		{
			onDialCallback(req, resp);
		}
		else if (req.isGatherCallback())
		{
			onGatherCallback(req, resp);
		}
		else if (req.isRecordCallback())
		{
			onRecordCallback(req, resp);
		}
		else if (req.isInboundCall())
		{
			onInboundCall(req, resp);
		}
		else if (req.isTranscribeCallback())
		{
			onTranscribeCallback(req, resp);
		}
		else 
		{
			onUnknownRequest(req, resp);
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

	abstract protected void onRecordCallback(TwilioRequest req, HttpServletResponse resp);

	abstract protected void onInboundCall(TwilioRequest req, HttpServletResponse resp);

	abstract protected void onGatherCallback(TwilioRequest req, HttpServletResponse resp);

	abstract protected void onDialCallback(TwilioRequest req, HttpServletResponse resp);

	abstract protected void onTranscribeCallback(TwilioRequest req, HttpServletResponse resp);

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
	
	protected void sendWavResponse(HttpServletResponse resp, byte[] wav)
	{
		sendBinaryResponse(resp, wav, "audio/x-wav");
	}


	protected void sendMp3Response(HttpServletResponse resp, byte[] mp3)
	{
		sendBinaryResponse(resp, mp3, "audio/mpeg");
	}
}
