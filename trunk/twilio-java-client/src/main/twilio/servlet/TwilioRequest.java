
package twilio.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import twilio.client.CallStatus;
import twilio.client.DialStatus;
import twilio.client.RecordingFormat;
import twilio.client.TranscriptionStatus;

public class TwilioRequest extends HttpServletRequestWrapper
{
	private String twilioAccountPhoneNumber = null;
	
	public TwilioRequest(HttpServletRequest request, String twilioAccountPhoneNum)
	{
		super(request);
		this.twilioAccountPhoneNumber = twilioAccountPhoneNum;
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
	
	public String getCallStatusParameter()
	{
		return this.getParameter("CallStatus");
	}
	
	public boolean isCallInProgress()
	{
		return "in-progress".equalsIgnoreCase(getCallStatusParameter());
	}
	
	public CallStatus getCallStatus()
	{
		if (getCallStatusParameter() == null)
		{
			return null;
		}
		else
		{
			return CallStatus.UNKNOWN; // todo : fix this
		}
		
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
	
	public String getRecordingUrl(RecordingFormat fmt)
	{
		if (this.getRecordingUrl() == null)
		{
			return null;
		}
		else
		{
			return this.getRecordingUrl() + fmt.getFileExtension();
		}
	}
	
	public String getDuration()
	{
		return this.getParameter("Duration");
	}
	
	public String getTwilioSignature()
	{
		return this.getParameter("X-Twilio-Signature");
	}

	public DialStatus getDialStatus()
	{
		return DialStatus.getDialStatus(this.getParameter("DialStatus"));
	}

	public String getTranscriptionText()
	{
		return this.getParameter("TranscriptionText");
	}
	
	public String getTranscriptionStatusParameter()
	{
		return this.getParameter("TranscriptionStatus");	
	}
	
	public TranscriptionStatus getTranscriptionStatus()
	{
		String ts = getTranscriptionStatusParameter(); 
		
		return TranscriptionStatus.getTranscriptionStatus(ts);
	}
	
	public String getTranscriptionUrl()
	{
		return this.getParameter("TranscriptionUrl");
	}
	
	public boolean isInboundCall()
	{
		return ( (getCallStatusParameter() != null) 
				  && (getCalled().equalsIgnoreCase(twilioAccountPhoneNumber)));
	}
	
	public boolean isDialCallback()
	{
		return ( (getCallStatusParameter() != null) 
				  && (!getCalled().equalsIgnoreCase(twilioAccountPhoneNumber)));
	}
	
	public boolean isRecordCallback()
	{
		return (getRecordingUrl() != null);
	}
	

	public boolean isGatherCallback()
	{
		return (getDigits() != null);
	}

	public boolean isTranscribeCallback()
	{
		return (getTranscriptionStatusParameter() != null);
	}
	
	public boolean isGet()
	{
		return this.getMethod().equalsIgnoreCase("GET");
	}
	
	public boolean isPost()
	{
		return this.getMethod().equalsIgnoreCase("POST");
	}

	public String toString()
	{
		return ServletUtil.toString(this);
	}
}
