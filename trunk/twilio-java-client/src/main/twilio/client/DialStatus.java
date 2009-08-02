
package twilio.client;

public enum DialStatus
{
	ANSWERED, ANSWERED_HUMAN, ANSWERED_MACHINE, HANGUP_MACHINE, BUSY, NO_ANSWER, FAIL;
	
	public static DialStatus getDialStatus(String dialStatusText)
	{
		return DialStatus.valueOf(dialStatusText);
	}
	
}
