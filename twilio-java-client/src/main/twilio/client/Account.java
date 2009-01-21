
package twilio.client;

import java.util.*;

public class Account
{
	private String sid;
	private Calendar dateCreated;
	private Calendar dateUpdated;
	private String friendlyName;
	private Integer status;
	private String statusText;
	private String authToken;
	
	public String getSid()
	{
		return sid;
	}
	
	public void setSid(String sid)
	{
		this.sid = sid;
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

	public String getStatusText()
	{
		return statusText;
	}

	public void setStatusText(String statusText)
	{
		this.statusText = statusText;
	}

	public String getAuthToken()
	{
		return authToken;
	}

	public void setAuthToken(String authToken)
	{
		this.authToken = authToken;
	}
	
	
	public String toString()
	{
		return ToStringBuilder.build(this);
	}

}
