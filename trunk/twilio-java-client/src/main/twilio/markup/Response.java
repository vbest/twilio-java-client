
package twilio.markup;

import java.util.*;

/**
 * 
 *  Twilio markup language (TwiML) response
 *
 */
public class Response
{
	private List<Verb> verbs = new ArrayList<Verb>();
	
	public void add(Verb v)
	{
		verbs.add(v);
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<Response>\n");
		
		for (Verb v : verbs)
		{
			sb.append("\n");
			sb.append(v.toString());
			sb.append("\n");
		}
		
		sb.append("</Response>\n");
		
		return sb.toString();
	}
}
