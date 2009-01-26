
package twilio.client;

/*
 *    
 *    
 */
public class GetOutgoingCallerIdsTest extends AbstractTwilioTest
{

	
	public void testGetOutgoingCallerIds() throws Exception
	{
		
		TwilioClient c = getClient();
	
		OutgoingCallerIds callerIds = c.getOutgoingCallerIds(getAccountSid()); 
		
		assertNotNull(callerIds);
		
		System.out.println(callerIds);
	}
	
}
