
package twilio.markup;

import java.io.StringWriter;
import java.util.*;

import twilio.internal.xstream.XStreamFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 
 *  Twilio markup language (TwiML) response
 *
 */
@XStreamAlias("Response")
public class Response
{
	public static final String DEFAULT_ENCODING = "UTF-8";
	
	@XStreamAlias("version")
	@XStreamAsAttribute
	private String version = "2008-08-01";
	
	
	@XStreamImplicit
	private List<Verb> verbs = new ArrayList<Verb>();
	
	public Response()
	{
		super();
	}
	
	public Response(Verb... verbs)
	{
		this.add(verbs);
	}
	
	public Response add(Verb v)
	{
		verbs.add(v);
		return this;
	}

	public Response add(Verb...verbs)
	{
		for (Verb v : verbs)
		{
			this.add(v);
		}
		
		return this;
	}
	
	public Response add(java.util.Collection<Verb> verbs)
	{
		for (Verb v : verbs)
		{
			this.add(v);
		}
		
		return this;
	}

	
	public String getVersion()
	{
		return version;
	}


	public void setVersion(String v)
	{
		this.version = v;
	}


	public String toXml()
	{
		XStream xstream = XStreamFactory.createMarkupXStream();
		
		StringWriter writer = new StringWriter();
		
		writer.write("<?xml version=\"1.0\" encoding=\""
					+ DEFAULT_ENCODING
					+ "\" ?>\n");
		
		xstream.toXML(this, writer);
		
		writer.flush();
		
		return writer.toString();
		
	}
	
	public String toString()
	{
		return toXml();
	}
}
