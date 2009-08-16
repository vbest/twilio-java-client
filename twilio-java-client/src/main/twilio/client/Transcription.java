
package twilio.client;

import java.util.Date;

public class Transcription implements java.io.Serializable
{
	private String sid;
	private Date dateCreated;
	private Date dateUpdated;
	private String accountSid;
	private String status; // transcription status
	private String recordingSid;
	private Integer duration;
	private String transcriptionText;
	private String price;
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
	public String getAccountSid()
	{
		return accountSid;
	}
	public void setAccountSid(String accountSid)
	{
		this.accountSid = accountSid;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getRecordingSid()
	{
		return recordingSid;
	}
	public void setRecordingSid(String recordingSid)
	{
		this.recordingSid = recordingSid;
	}
	public Integer getDuration()
	{
		return duration;
	}
	public void setDuration(Integer duration)
	{
		this.duration = duration;
	}
	public String getTranscriptionText()
	{
		return transcriptionText;
	}
	
	public void setTranscriptionText(String text)
	{
		this.transcriptionText = text;
	}
	
	public String getPrice()
	{
		return price;
	}
	
	public void setPrice(String price)
	{
		this.price = price;
	}


}
