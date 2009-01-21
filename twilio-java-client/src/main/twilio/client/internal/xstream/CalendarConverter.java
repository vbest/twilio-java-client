
package twilio.client.internal.xstream;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import twilio.client.DateUtil;
import java.util.Calendar;

class CalendarConverter extends AbstractSingleValueConverter
{
	public CalendarConverter()
	{
		super();
	}
	
	@Override
	public boolean canConvert(Class c)
	{
		return Calendar.class.isAssignableFrom(c);
	}

	@Override
	public Object fromString(String s)
	{
		try
		{
			return DateUtil.parseDate(s);
		}
		catch (Exception ex)
		{
			return null;
		}
	}

	public static void main(String[] args)
	{
		CalendarConverter converter = new CalendarConverter();
		Calendar c = (Calendar) converter.fromString("Tue, 01 Apr 2008 11:26:32 -0700");
	}
	
}
