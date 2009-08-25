
package twilio.client;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Calls extends TwilioList<Call>
{
	public Collection<String> getCallers()
	{
		Set<String> callers = new HashSet<String>();
		
		for (Call c : this)
		{
			callers.add(c.getCaller());
		}
		
		return callers;
	}
	
	public Collection<String> getCalledNumbers()
	{
		Set<String> called = new HashSet<String>();
		
		for (Call c : this)
		{
			called.add(c.getCalled());
		}
		
		return called;
	}
}
