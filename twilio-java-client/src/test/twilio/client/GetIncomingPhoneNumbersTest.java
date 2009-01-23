
package twilio.client;

public class GetIncomingPhoneNumbersTest extends AbstractTwilioTest
{

	
	public void testGetIncomingPhoneNumbers() throws Exception
	{
		Client c = getClient();
	
		IncomingPhoneNumbers phoneNumbers = c.getIncomingPhoneNumbers(getAccountSid()); 
		
		assertNotNull(phoneNumbers);
		
		System.out.println(phoneNumbers);
	}
	
}
