
package twilio.client.internal.xstream;

import twilio.client.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
// import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class XStreamFactory
{
	
	public static XStream createXStream() 
	{
		
		XStream xstream;
		
		// todo : use XppDriver ?
		
		xstream = new XStream(new DomDriver())
		{
			protected MapperWrapper wrapMapper(MapperWrapper next)
			{
				return new TwilioMapper(next);
			}
		};
		
 		xstream.registerConverter(new CalendarConverter(), XStream.PRIORITY_VERY_HIGH);
 		xstream.registerConverter(new IntConverter(), XStream.PRIORITY_VERY_HIGH);
 		xstream.registerConverter(new BigDecimalConverter(), XStream.PRIORITY_VERY_HIGH);
 		
 		xstream.registerConverter(new TwilioListConverter(xstream.getMapper()), XStream.PRIORITY_VERY_HIGH);
 		
 		// xstream.aliasField("Calls", TwilioResponse.class, "calls");
 		// xstream.aliasField("Sid", Call.class, "sid");
 		
		xstream.alias("Account", Account.class);
		xstream.alias("Call", Call.class);
		xstream.alias("Calls", Calls.class);
		xstream.alias("IncomingPhoneNumber", IncomingPhoneNumber.class);
		xstream.alias("IncomingPhoneNumbers", IncomingPhoneNumbers.class);
		xstream.alias("Notification", Notification.class);
		xstream.alias("Notifications", Notifications.class);
		xstream.alias("OutgoingCallerId", OutgoingCallerId.class);
		xstream.alias("OutgoingCallerIds", OutgoingCallerIds.class);
		xstream.alias("Recording", Recording.class);
		xstream.alias("Recordings", Recordings.class);
		xstream.alias("TwilioException", TwilioException.class);
		xstream.alias("TwilioResponse", TwilioResponse.class);
		xstream.alias("ValidationRequest", ValidationRequest.class);
		
		
		return xstream;
		
	}

}
