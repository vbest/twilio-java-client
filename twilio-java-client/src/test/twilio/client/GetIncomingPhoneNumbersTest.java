
package twilio.client;

public class GetIncomingPhoneNumbersTest extends AbstractTwilioTest
{

	
	public void testGetIncomingPhoneNumbers() throws Exception
	{
		TwilioClient c = getClient();
	
		IncomingPhoneNumbers phoneNumbers = c.getIncomingPhoneNumbers(); 
		
		assertNotNull(phoneNumbers);
		
		System.out.println(phoneNumbers);
	}
	
}
