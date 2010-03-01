
package twilio.client;

public class SmsMessageTest extends AbstractTwilioTest
{
	
	public void testSmsMessage() throws Exception
	{
		TwilioClient c = getClient();
	
		c.sendSmsMessage( 
						getCallFrom(), 
						getCallTo(),
						"Hello world");
		
//		assertNotNull(call);
		
//		System.out.println(call);
		
	}	
}
