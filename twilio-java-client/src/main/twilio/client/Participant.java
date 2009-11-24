
package twilio.client;

import java.util.Date;

public class Participant implements java.io.Serializable
{
	private String callSid;
	private String conferenceSid;
	private String accountSid;
	private Boolean muted;
	private Boolean startConferenceOnEnter;
	private Boolean endConferenceOnExit;
	private Date dateCreated;
	private Date dateUpdated;
	
	public String getCallSid()
	{
		return callSid;
	}
	
	public void setCallSid(String callSid)
	{
		this.callSid = callSid;
	}
	
	public String getConferenceSid()
	{
		return conferenceSid;
	}
	
	public void setConferenceSid(String conferenceSid)
	{
		this.conferenceSid = conferenceSid;
	}
	
	public String getAccountSid()
	{
		return accountSid;
	}
	
	public void setAccountSid(String accountSid)
	{
		this.accountSid = accountSid;
	}
	
	public Boolean getMuted()
	{
		return muted;
	}
	
	public void setMuted(Boolean muted)
	{
		this.muted = muted;
	}
	
	public Boolean getStartConferenceOnEnter()
	{
		return startConferenceOnEnter;
	}
	
	public void setStartConferenceOnEnter(Boolean startConferenceOnEnter)
	{
		this.startConferenceOnEnter = startConferenceOnEnter;
	}
	
	public Boolean getEndConferenceOnExit()
	{
		return endConferenceOnExit;
	}
	
	public void setEndConferenceOnExit(Boolean endConferenceOnExit)
	{
		this.endConferenceOnExit = endConferenceOnExit;
	}
	
	public Date getDateCreated()
	{
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}
	
	public Date getDateUpdated()
	{
		return dateUpdated;
	}
	
	public void setDateUpdated(Date dateUpdated)
	{
		this.dateUpdated = dateUpdated;
	}
	
	
}
