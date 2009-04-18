
package twilio.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class TwilioRequest extends HttpServletRequestWrapper
{

	public TwilioRequest(HttpServletRequest request)
	{
		super(request);
	}

	public String getCallGuid()
	{
		return this.getParameter("CallGuid");
	}
	
	public String getCaller()
	{
		return this.getParameter("Caller");
	}
	
	public String getCalled()
	{
		return this.getParameter("Called");
	}
	
	public String getAccountGuid()
	{
		return this.getParameter("AccountGuid");
	}
	
	public String getCallStatus()
	{
		return this.getParameter("CallStatus");
	}
	
	public String getCallerCity()
	{
		return this.getParameter("CallerCity");
	}
	
	public String getCallerState()
	{
		return this.getParameter("CallerState");
	}
	
	public String getCallerZip()
	{
		return this.getParameter("CallerZip");
	}
	
	public String getCallerCountry()
	{
		return this.getParameter("CallerCountry");
	}
	
	public String getCalledCity()
	{
		return this.getParameter("CalledCity");
	}
	
	public String getCalledState()
	{
		return this.getParameter("CalledState");
	}
	
	public String getCalledZip()
	{
		return this.getParameter("CalledZip");
	}
	
	public String getCalledCountry()
	{
		return this.getParameter("CalledCountry");
	}
	
	public String getDigits()
	{
		return this.getParameter("Digits");
	}
	
	public String getRecordingUrl()
	{
		return this.getParameter("RecordingUrl");
	}
	
	public String getDuration()
	{
		return this.getParameter("Duration");
	}
	
	public String getTwilioSignature()
	{
		return this.getParameter("X-Twilio-Signature");
	}

	public String getDialStatus()
	{
		return this.getParameter("DialStatus");
	}

	public boolean isInboundCall()
	{
		// todo : return ( (getCalled() != null) || (getCalled().equalsIgnoreCase(getAccountPhoneNumber()));
		
		return false;
	}
	
	public boolean isDialCallback()
	{
		return (getDialStatus() != null);
	}
	
	public boolean isRecordCallback()
	{
		return (getRecordingUrl() != null);
	}
	

	public boolean isGatherCallback()
	{
		return (getDigits() != null);
	}

	public boolean isGet()
	{
		return this.getMethod().equalsIgnoreCase("GET");
	}
	
	public boolean isPost()
	{
		return this.getMethod().equalsIgnoreCase("POST");
	}
	
}
