
package twilio.client;

import java.util.*;

public class Recording
{
	private String sid;
	private String accountSid;
	private String callSid;
	private Integer duration;
	private Calendar dateCreated;
	private Calendar dateUpdated;
	
	public String getSid()
	{
		return sid;
	}
	
	public void setSid(String sid)
	{
		this.sid = sid;
	}
	
	public String getAccountSid()
	{
		return accountSid;
	}
	
	public void setAccountSid(String accountSid)
	{
		this.accountSid = accountSid;
	}
	
	public String getCallSid()
	{
		return callSid;
	}
	
	public void setCallSid(String callSid)
	{
		this.callSid = callSid;
	}
	
	public Integer getDuration()
	{
		return duration;
	}
	
	public void setDuration(Integer duration)
	{
		this.duration = duration;
	}
	
	public Calendar getDateCreated()
	{
		return dateCreated;
	}
	
	public void setDateCreated(Calendar dateCreated)
	{
		this.dateCreated = dateCreated;
	}
	
	public Calendar getDateUpdated()
	{
		return dateUpdated;
	}
	
	public void setDateUpdated(Calendar dateUpdated)
	{
		this.dateUpdated = dateUpdated;
	}

	public String toString()
	{
		return ToStringBuilder.build(this);
	}
}
