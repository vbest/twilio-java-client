
package twilio.client;

import java.lang.reflect.*;
import java.util.LinkedHashSet;
import java.util.Set;

class ToStringBuilder
{
	private static Field[] getFields(Class<?> clazz)
	{
		Set<Field> fields = new LinkedHashSet<Field>();
		
		while (clazz != null)
		{
			Field[] fieldArray = clazz.getDeclaredFields();
			for (Field f : fieldArray)
			{
				fields.add(f);
			}
			clazz = clazz.getSuperclass();
		}
		
		return fields.toArray(new Field[fields.size()]);
	}
	
	public static String build(Object obj)
	{
		StringBuilder builder = new StringBuilder();
		
		if (obj != null)
		{
			Class<?> clazz = obj.getClass();
			Field[] fields = getFields(clazz);
			
			if (fields != null)
			{
				try
				{
					AccessibleObject.setAccessible(fields, true);
					appendFields(builder, fields, obj);
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
		
		return builder.toString();
	}

	private static void appendFields(StringBuilder builder, Field[] fields, Object obj)
	{
		Class<?> clazz = obj.getClass();
		for (int i = 0; i < fields.length; i++)
		{
			Field f = fields[i];
			
			if (Modifier.isStatic(f.getModifiers()))
			{
				continue;
			}
			
			try
			{
				Object value = f.get(obj);
				if ( !f.getName().equalsIgnoreCase("class") )
				{
					builder.append(clazz.getSimpleName());
					builder.append(".");
					builder.append(f.getName());
					builder.append(": ");
					builder.append(String.valueOf(value));
					builder.append("\n");
				}
			}
			catch (Exception ignore)
			{
				// ignored
			}
		}
	}
}
