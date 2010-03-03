
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
		
		Sms sms = new Sms();
		sms.setFrom("503-111-2222");
		sms.setTo("503-222-3333");
		sms.setMessage("This is a message!");
		
		rsp.add(sms);
		
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
		
		Gather gather = new Gather();
		gather.say("Press 1 for something cool.");
		gather.setAction("http://www.twilioapp.com/foo/gather");
		gather.setNumDigits(1);
		gather.setTimeout(15);
		
		rsp.add(gather);
		
		rsp.add(new Say("Good bye"));
		rsp.add(new Hangup());
		
		rsp.add(new Redirect("http://www.twilioapp.com/foo/bar"));
		
		String xml = rsp.toXml();
		
		assertNotNull(xml);
		
		assertTrue(xml.length() > 0);
		
		System.out.println(xml);
	}
}
