
package twilio.markup;

import java.io.StringWriter;
import java.util.*;

import twilio.markup.internal.xstream.XStreamFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 
 *  Twilio markup language (TwiML) response
 *
 */
@XStreamAlias("Response")
public class Response
{
	@XStreamImplicit
	private List<Verb> verbs = new ArrayList<Verb>();
	
	public void add(Verb v)
	{
		verbs.add(v);
	}

	
	public String toXml()
	{
		XStream xstream = XStreamFactory.createXStream();
		
		StringWriter writer = new StringWriter();
		
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		
		xstream.toXML(this, writer);
		
		return writer.toString();
		
	}
	
	public String toString()
	{
		return toXml();
	}
}
