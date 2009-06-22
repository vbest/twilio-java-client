
package twilio.markup;

import junit.framework.TestCase;

public class MarkupTest extends TestCase
{
	public void test() throws Exception
	{
		Response rsp = new Response();

		Dial dial = new Dial();
		
		Number n = new Number("+1 503-555-5555");
		
		dial.add(n);
		
		rsp.add(dial);
		
		Play play = new Play();
		play.setUrl("http://www.foo.com/music.mp3");
		play.setLoop(1);
		
		rsp.add(play);
		
		
		rsp.add(new Say("Tell me your name"));
		
		Record r = new Record();
		r.setAction("/foo");
		r.setHttpMethod("POST");
		r.setFinishOnKey('#');
		r.setMaxLength(60);
		r.setTimeout(10);
		
		rsp.add(r);
		
		rsp.add(new Say("Thank you"));
		
		rsp.add(new Pause(5));
		
		rsp.add(new Hangup());
		
		rsp.add(new Redirect("http://www.twilioapp.com/foo/bar"));
		
		String xml = rsp.toXml();
		
		assertNotNull(xml);
		
		assertTrue(xml.length() > 0);
		
		System.out.println(xml);
	}
}
