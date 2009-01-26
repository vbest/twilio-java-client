
package twilio.client;

public class GetCallsTest extends AbstractTwilioTest
{

	
	public void testGetCalls() throws Exception
	{
		TwilioClient c = getClient();
	
		Calls calls = c.getCalls(getAccountSid()); 
		
		assertNotNull(calls);
		
		System.out.println(calls);
	}
	
}
