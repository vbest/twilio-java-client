
package twilio.client;

/*
 *    
 *    
 */
public class GetAccountTest extends AbstractTwilioTest
{

	
	public void testGetAccount() throws Exception
	{
		
		Client c = getClient();
	
		Account account = c.getAccount(getAccountSid()); 
		
		assertNotNull(account);
		
		System.out.println(account);
	}
	
}
