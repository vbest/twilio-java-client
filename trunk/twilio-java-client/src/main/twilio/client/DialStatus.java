
package twilio.client;

public enum DialStatus
{
	ANSWERED, ANSWERED_HUMAN, ANSWERED_MACHINE, HANGUP_MACHINE, BUSY, NO_ANSWER, FAIL, UNKNOWN;
	
	public static DialStatus getDialStatus(String dialStatusText)
	{
		DialStatus ds = DialStatus.UNKNOWN;
		
		if (dialStatusText != null)
		{
			try
			{
				ds = DialStatus.valueOf(dialStatusText.toUpperCase());
			}
			catch (Exception ex)
			{
				ds = DialStatus.UNKNOWN;
			}
			finally
			{
				if (ds == null)
				{
					ds = DialStatus.UNKNOWN;
				}
			}
		}
		
		return ds;
	}
	
}
