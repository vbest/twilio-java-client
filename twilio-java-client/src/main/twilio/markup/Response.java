
package twilio.markup;

import java.util.*;

import twilio.markup.internal.xstream.XStreamFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 *  Twilio markup language (TwiML) response
 *
 */
@XStreamAlias("Response")
public class Response
{
	private List<Verb> verbs = new ArrayList<Verb>();
	
	public void add(Verb v)
	{
		verbs.add(v);
	}

	
	public String toXml()
	{
		XStream xstream = XStreamFactory.createXStream();
		
		return xstream.toXML(this);
	}
	
	public String toString()
	{
		return toXml();
	}
}
