
package twilio.client;

import java.math.BigDecimal;
import java.util.Calendar;

public class Call
{
	private String sid;
	private String accountSid;
	private String called;
	private String caller;
	private String phoneNumberSid;
	private Integer status;
	private Calendar startTime;
	private Calendar endTime;
	private Calendar dateCreated;
	private Calendar dateUpdated;
	private Integer duration;
	private BigDecimal price;
	private Integer flags;
	private String callSegmentSid;
	private String annotation;
	
	
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
	public String getCalled()
	{
		return called;
	}
	public void setCalled(String called)
	{
		this.called = called;
	}
	public String getCaller()
	{
		return caller;
	}
	public void setCaller(String caller)
	{
		this.caller = caller;
	}
	public String getPhoneNumberSid()
	{
		return phoneNumberSid;
	}
	public void setPhoneNumberSid(String phoneNumberSid)
	{
		this.phoneNumberSid = phoneNumberSid;
	}
	
	public Integer getStatus()
	{
		return status;
	}
	
	public boolean isNoAnswer()
	{
		return CallStatus.isNoAnswer(status);
	}
	
	public boolean isBusy()
	{
		return CallStatus.isBusy(status);
	}
	
	public boolean isApplicationError()
	{
		return CallStatus.isApplicationError(status);
	}
	
	public boolean isNotYetDialed()
	{
		return CallStatus.isNotYetDialed(status);
	}
	
	public boolean isComplete()
	{
		return CallStatus.isComplete(status);
	}
	
	public void setStatus(Integer s)
	{
		this.status = s;
	}
	
	public Calendar getStartTime()
	{
		return startTime;
	}
	
	public void setStartTime(Calendar startTime)
	{
		this.startTime = startTime;
	}
	
	public Calendar getEndTime()
	{
		return endTime;
	}
	
	public void setEndTime(Calendar endTime)
	{
		this.endTime = endTime;
	}
	
	public Integer getDuration()
	{
		return duration;
	}
	
	public void setDuration(Integer duration)
	{
		this.duration = duration;
	}
	
	public BigDecimal getPrice()
	{
		return price;
	}
	
	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}
	public Integer getFlags()
	{
		return flags;
	}
	public void setFlags(Integer flags)
	{
		this.flags = flags;
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

	public String getCallSegmentSid()
	{
		return callSegmentSid;
	}
	
	public void setCallSegmentSid(String callSegmentSid)
	{
		this.callSegmentSid = callSegmentSid;
	}

	public String getAnnotation()
	{
		return annotation;
	}
	
	public void setAnnotation(String annotation)
	{
		this.annotation = annotation;
	}
	
	public String toString()
	{
		return ToStringBuilder.build(this);
	}
}
