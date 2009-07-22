
package twilio.client;

import java.util.*;

public class Notification implements java.io.Serializable
{
 
	private String sid;
	private String accountSid;
	private String callSid;
	private Integer log;
	private Integer errorCode;
	private String moreInfo;
	private String requestUrl;
	private String requestMethod;
	private String messageText;
	private Date messageDate;
	
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
	public Integer getLog()
	{
		return log;
	}
	public void setLog(Integer log)
	{
		this.log = log;
	}
	public Integer getErrorCode()
	{
		return errorCode;
	}
	public void setErrorCode(Integer errorCode)
	{
		this.errorCode = errorCode;
	}
	public String getMoreInfo()
	{
		return moreInfo;
	}
	public void setMoreInfo(String moreInfo)
	{
		this.moreInfo = moreInfo;
	}
	public String getRequestUrl()
	{
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl)
	{
		this.requestUrl = requestUrl;
	}
	public String getRequestMethod()
	{
		return requestMethod;
	}
	public void setRequestMethod(String requestMethod)
	{
		this.requestMethod = requestMethod;
	}
	public String getMessageText()
	{
		return messageText;
	}
	public void setMessageText(String messageText)
	{
		this.messageText = messageText;
	}
	public Date getMessageDate()
	{
		return messageDate;
	}
	public void setMessageDate(Date messageDate)
	{
		this.messageDate = messageDate;
	}
	
	
	public String toString()
	{
		// return ToStringBuilder.build(this);
		return "";
	}
	
	public  final boolean isError()
	{
		return ( (log != null) && (log.equals(Log.ERROR)) );
	}

	public  final boolean isWarning()
	{
		return ( (log != null) && (log.equals(Log.WARNING)) );
	}
	
	public static class Log
	{
		public static final Integer ERROR = new Integer(0);
		public static final Integer WARNING = new Integer(1);
		
	}
}
