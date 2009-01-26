
package twilio.client;

/*
 *    
 *    
 */
public class GetAccountTest extends AbstractTwilioTest
{

	
	public void testGetAccount() throws Exception
	{
		
		TwilioClient c = getClient();
	
		Account account = c.getAccount(getAccountSid()); 
		
		assertNotNull(account);
		
		System.out.println(account);
	}
	
}
