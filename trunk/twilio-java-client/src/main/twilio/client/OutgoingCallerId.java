
package twilio.client;

import java.util.*;

public class OutgoingCallerId implements java.io.Serializable
{
	private String sid;
	private String accountSid;
	private String friendlyName;
	private String phoneNumber;
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



	public String getPhoneNumber()
	{
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
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



	public String toString()
	{
		// return ToStringBuilder.build(this);
		return "";
	}
}
