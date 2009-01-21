
package twilio.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil
{
	// example:  "Tue, 01 Apr 2008 11:26:32 -0700"
	public static final String TWILIO_DATE_PATTERN = "EEE, dd MMM yyyy HH:mm:ss Z";
	
	public static String toString(Calendar c)
	{
		return toString(c.getTime());
	}
	
	public static String toString(Date d)
	{
		SimpleDateFormat fmt = new SimpleDateFormat(TWILIO_DATE_PATTERN);

		return fmt.format(d);
	}
	
	public static Calendar parseDate(String s)
	{
		
		SimpleDateFormat fmt = new SimpleDateFormat(TWILIO_DATE_PATTERN);
		
		try
		{
			Date d = fmt.parse(s);
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			
			return c;
		} 
		catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
	}
}
