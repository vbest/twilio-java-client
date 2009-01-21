
package twilio.client;

public class TwilioException extends RuntimeException
{
	private String status;
	private String message;
	private String code;
	private String moreInfo;
	
	public TwilioException()
	{
		super();
	}
	
	public TwilioException(String msg)
	{
		super(msg);
		this.message = msg;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public String getCode()
	{
		return code;
	}
	
	public void setCode(String code)
	{
		this.code = code;
	}
	
	public String getMoreInfo()
	{
		return moreInfo;
	}
	
	public void setMoreInfo(String moreInfo)
	{
		this.moreInfo = moreInfo;
	}
	

	
}
