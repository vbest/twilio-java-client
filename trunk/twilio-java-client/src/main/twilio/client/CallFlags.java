
package twilio.client;

public class CallFlags
{
	static public final int INBOUND = 1;
	static public final int INITIATED_BY_API = 2;
	static public final int INITIATED_BY_DIAL_VERB = 4;
	
	static public boolean callWasInbound(int flags)
	{
		return (flags | INBOUND) == INBOUND;
	}
	
	static public boolean callWasInitiatedByApi(int flags)
	{
		return (flags | INITIATED_BY_API) == INITIATED_BY_API;
	}
	
	static public boolean callWasInitiatedByDialVerb(int flags)
	{
		return (flags | INITIATED_BY_DIAL_VERB) == INITIATED_BY_DIAL_VERB;
	}
}
