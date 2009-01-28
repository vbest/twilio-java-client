
package twilio.markup.internal.xstream;

import com.thoughtworks.xstream.XStream;


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
		
		xstream.autodetectAnnotations(true);
		
		return xstream;
	}
}
