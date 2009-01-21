
package twilio.client;

public class CallTest extends AbstractTwilioTest
{
	
	public void testCall() throws Exception
	{
		Client c = getClient();
	
		Call call = c.call(getAccountSid(), 
						getCallFrom(), 
						getCallTo(),
						"http://www.google.com/");
		
		assertNotNull(call);
		
		System.out.println(call);
	}	
}
