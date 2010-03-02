
package twilio.client;

public class SmsMessageTest extends AbstractTwilioTest
{
	
	public void testSmsMessage() throws Exception
	{
		TwilioClient c = getClient();
	
		String messageBody = "Hello world " + System.currentTimeMillis();
		
		SMSMessage msg = c.sendSmsMessage( 
								getCallFrom(), 
								getCallTo(),
								messageBody);
		
		assertNotNull(msg);
		
		System.out.println(msg);
		
		assertNotNull(msg.getAccountSid());
		
		assertEquals(messageBody, msg.getBody());
		
		assertNotNull(msg.getTo());
		
		assertNotNull(msg.getFrom());
		
		assertNotNull(msg.getDateCreated());
		
		assertNotNull(msg.getSid());
		
		assertNotNull(msg.getPrice());
		
	}	
}
