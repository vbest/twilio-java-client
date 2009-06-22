
package twilio.internal.xstream;

import java.math.BigDecimal;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

public class BigDecimalConverter extends AbstractSingleValueConverter
{

	@Override
	public boolean canConvert(Class clazz)
	{
		return clazz.equals(BigDecimal.class);
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
			return new BigDecimal(s);
		}
	}

}
