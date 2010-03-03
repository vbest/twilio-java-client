
package twilio.client;

public enum SmsStatus
{
	SENDING("sending"), FAILED("failed"), RECEIVED("received"), 
	SENT("sent"), INVALID("invalid"), UNKNOWN("unknown");
	
	private String description;
	
	SmsStatus(String descriptionText)
	{
		this.description = descriptionText;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public static SmsStatus getSmsStatus(String s)
	{
		if (s == null)
		{
			return UNKNOWN;
		}
		else 
		{
			SmsStatus ss = SmsStatus.valueOf(s.toUpperCase());
			if (ss == null)
			{
				return UNKNOWN;
			}
			else
			{
				return ss;
			}
		}
		
	}
}
