
package twilio.client;

import java.util.*;

public class Account implements java.io.Serializable
{
	private String sid;
	private Date dateCreated;
	private Date dateUpdated;
	private String friendlyName;
	private Integer status;
	private String statusText;
	private String authToken;
	private Type type;
	
	
	public Type getType()
	{
		return type;
	}

	public void setType(Type t)
	{
		this.type = t;
	}

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
		// return ToStringBuilder.build(this);
		return "";
	}

	public boolean isActive()
	{
		if (getStatus() == null)
		{
			return false;
		}
		else
		{
			return getStatus().intValue() == 2;
		}
	}
	
	static public class Type
	{
		private String type;
		
		public Type()
		{
			
		}
		
		public Type(String type)
		{
			this.type = type;
		}
	}
}
