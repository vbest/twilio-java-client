
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
	
		OutgoingCallerIds callerIds = c.getOutgoingCallerIds(); 
		
		assertNotNull(callerIds);
		
		System.out.println(callerIds);
	}
	
}
