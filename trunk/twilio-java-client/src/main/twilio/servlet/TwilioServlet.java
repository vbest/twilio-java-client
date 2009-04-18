
package twilio.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class TwilioServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
	{
		doTwilioRequest(new TwilioRequest(req), resp);
	}
	
	protected void doTwilioRequest(TwilioRequest req, HttpServletResponse resp)
	{
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
		else 
		{
			onUnknownRequest(req, resp);
		}
	}

	abstract protected void onUnknownRequest(TwilioRequest req, HttpServletResponse resp);

	abstract protected void onRecordCallback(TwilioRequest req, HttpServletResponse resp);

	abstract protected void onInboundCall(TwilioRequest req, HttpServletResponse resp);

	abstract protected void onGatherCallback(TwilioRequest req, HttpServletResponse resp);

	abstract protected void onDialCallback(TwilioRequest req, HttpServletResponse resp);

}
