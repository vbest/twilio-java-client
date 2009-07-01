
package twilio.client;

import java.util.ArrayList;
import java.util.List;

public class OutgoingCallerIds extends TwilioList<OutgoingCallerId>
{

	public List<String> getPhoneNumbers()
	{
		List<String> phoneNumbers = new ArrayList<String>();
		
		for (OutgoingCallerId outgoing : this)
		{
			phoneNumbers.add(outgoing.getPhoneNumber());
		}
		
		return phoneNumbers;
	}
}
