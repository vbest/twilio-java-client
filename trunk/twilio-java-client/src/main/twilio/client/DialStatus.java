
package twilio.client;

public enum DialStatus
{
	ANSWERED, ANSWERED_HUMAN, ANSWERED_MACHINE, HANGUP_MACHINE, BUSY, NO_ANSWER, FAIL, UNKNOWN;
	
	public static DialStatus getDialStatus(String dialStatusText)
	{
		DialStatus ds = DialStatus.valueOf(dialStatusText);
		
		if (ds == null)
		{
			ds = DialStatus.UNKNOWN;
		}
		
		return ds;
	}
	
}
