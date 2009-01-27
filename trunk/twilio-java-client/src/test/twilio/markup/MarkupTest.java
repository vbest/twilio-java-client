
package twilio.markup;

import junit.framework.TestCase;

public class MarkupTest extends TestCase
{
	public void test() throws Exception
	{
		Response rsp = new Response();
		
		rsp.add(new Say("Tell me your name"));
		
		Record r = new Record();
		r.setAction("/foo");
		r.setMethod("POST");
		r.setTimeout(10);
		
		rsp.add(r);
		
		rsp.add(new Say("Thank you"));
		
		String xml = rsp.toString();
		
		assertNotNull(xml);
		
		assertTrue(xml.length() > 0);
		
		System.out.println(xml);
	}
}
