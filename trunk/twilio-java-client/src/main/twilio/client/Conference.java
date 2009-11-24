
package twilio.client;

import java.util.Date;

public class Conference implements java.io.Serializable
{
	private String sid;
	private String accountSid;
	private String friendlyName;
	private Integer status;
	private Date dateCreated;
	private Date dateUpdated;
	
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
	
	public String getFriendlyName()
	{
		return friendlyName;
	}
	
	public void setFriendlyName(String friendlyName)
	{
		this.friendlyName = friendlyName;
	}
	
	public Integer getStatus()
	{
		return status;
	}
	
	public void setStatus(Integer status)
	{
		this.status = status;
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
