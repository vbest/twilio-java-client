
package twilio.client;

import java.util.*;

public class SMSMessage implements java.io.Serializable
{
	private String sid;
	private Date dateCreated;
	private Date dateUpdated;
	private Date dateSent;
	private String accountSid;
	private String to;
	private String from;
	private String body;
	private String status;
	private Integer flags;
	public String getSid()
	{
		return sid;
	}
	public void setSid(String sid)
	{
		this.sid = sid;
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
	public Date getDateSent()
	{
		return dateSent;
	}
	public void setDateSent(Date dateSent)
	{
		this.dateSent = dateSent;
	}
	public String getAccountSid()
	{
		return accountSid;
	}
	public void setAccountSid(String accountSid)
	{
		this.accountSid = accountSid;
	}
	public String getTo()
	{
		return to;
	}
	public void setTo(String to)
	{
		this.to = to;
	}
	public String getFrom()
	{
		return from;
	}
	public void setFrom(String from)
	{
		this.from = from;
	}
	public String getBody()
	{
		return body;
	}
	public void setBody(String body)
	{
		this.body = body;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public Integer getFlags()
	{
		return flags;
	}
	public void setFlags(Integer flags)
	{
		this.flags = flags;
	}
	
	
}
