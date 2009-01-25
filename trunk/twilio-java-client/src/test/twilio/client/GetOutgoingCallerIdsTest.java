
package twilio.client;

/*
 *    /2008-08-01/Accounts/{YourAccountSid}/OutgoingCallerIds
 *    
 */
public class GetOutgoingCallerIdsTest extends AbstractTwilioTest
{

	
	public void testGetOutgoingCallerIds() throws Exception
	{
		
		Client c = getClient();
	
		OutgoingCallerIds callerIds = c.getOutgoingCallerIds(getAccountSid()); 
		
		assertNotNull(callerIds);
		
		System.out.println(callerIds);
	}
	
}
