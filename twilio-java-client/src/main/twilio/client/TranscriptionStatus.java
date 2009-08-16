
package twilio.client;

public enum TranscriptionStatus
{
	COMPLETED("completed"), FAILED("failed");
	
	private String description;
	
	TranscriptionStatus(String descriptionText)
	{
		this.description = descriptionText;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public static TranscriptionStatus getTranscriptionStatus(String s)
	{
		if (s == null)
		{
			return FAILED;
		}
		else 
		{
			TranscriptionStatus ts = TranscriptionStatus.valueOf(s);
			if (ts == null)
			{
				return FAILED;
			}
			else
			{
				return ts;
			}
		}
		
	}
}
