
package twilio.client;

import java.util.ArrayList;
import java.util.List;

public class IncomingPhoneNumbers extends TwilioList<IncomingPhoneNumber>
{
	public List<String> getPhoneNumbers()
	{
		List<String> phoneNumbers = new ArrayList<String>();
		
		for (IncomingPhoneNumber incoming : this)
		{
			phoneNumbers.add(incoming.getPhoneNumber());
		}
		
		return phoneNumbers;
	}
}
