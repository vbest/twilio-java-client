
package twilio.markup.internal.xstream;

import com.thoughtworks.xstream.XStream;
import twilio.markup.*;
import twilio.markup.Number;


/**
 * 
 * XStream factory for twilio.markup package
 *
 */
public class XStreamFactory
{
	public static XStream createXStream()
	{
		XStream xstream = new XStream();
		
		xstream.registerConverter(new TwilioConverter(xstream.getMapper(), Dial.class, "phoneNumber"), XStream.PRIORITY_VERY_HIGH);
		xstream.registerConverter(new TwilioConverter(xstream.getMapper(), Play.class, "url"), XStream.PRIORITY_VERY_HIGH);
		xstream.registerConverter(new TwilioConverter(xstream.getMapper(), Number.class, "value"), XStream.PRIORITY_VERY_HIGH);
		xstream.registerConverter(new TwilioConverter(xstream.getMapper(), Say.class, "message"), XStream.PRIORITY_VERY_HIGH);
		xstream.registerConverter(new TwilioConverter(xstream.getMapper(), Redirect.class, "url"), XStream.PRIORITY_VERY_HIGH);
		
		xstream.autodetectAnnotations(true);
		
		return xstream;
	}
}
