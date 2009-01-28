
package twilio.markup.internal.xstream;

import com.thoughtworks.xstream.XStream;

import twilio.markup.*;

public class XStreamFactory
{
	public static XStream createXStream()
	{
		XStream xstream = new XStream();
		
		xstream.autodetectAnnotations(true);
		
		return xstream;
	}
}
