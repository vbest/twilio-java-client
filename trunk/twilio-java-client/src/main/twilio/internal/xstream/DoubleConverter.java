
package twilio.internal.xstream;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

public class DoubleConverter extends AbstractSingleValueConverter
{

	@Override
	public boolean canConvert(Class clazz)
	{
		return Double.class.equals(clazz);
	}

	@Override
	public Object fromString(String s)
	{
		if (s == null)
		{
			return null;
		}
		else if (s.trim().length() == 0)
		{
			return null;
		}
		else
		{
			return new Double(s);
		}
	}

}
