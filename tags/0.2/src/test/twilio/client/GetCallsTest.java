
package twilio.client;

public class GetCallsTest extends AbstractTwilioTest
{

	
	public void testGetCalls() throws Exception
	{
		TwilioClient c = getClient();
	
		Calls calls = c.getCalls(); 
		
		System.out.println("calls.size() = " + calls.size());
		
		assertNotNull(calls);
		
		for (Call call : calls)
		{
			assertValid(call);
			System.out.println(call);
			Call cc = c.getCall(call.getSid());
			assertValid(cc);
		}
		
	}
	
	
}
