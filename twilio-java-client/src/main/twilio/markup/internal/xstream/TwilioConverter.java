
package twilio.markup.internal.xstream;

import java.lang.reflect.Field;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class TwilioConverter 
	extends com.thoughtworks.xstream.converters.reflection.ReflectionConverter
{
	private Class targetClass;
	private String fieldName;
	
    public TwilioConverter(Mapper m, Class clazz, String fieldName)
	{
    	super(new CustomMapper(m, fieldName), 
    			new PureJavaReflectionProvider());
    	
    	this.targetClass = clazz;
    	this.fieldName = fieldName;
	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context)
	{
        throw new UnsupportedOperationException("unmarshall not supported");
	}

	public boolean canConvert(Class type)
	{
		return targetClass.getName().equals(type.getName());
	}

	public void marshal(Object source, HierarchicalStreamWriter writer,
			MarshallingContext context)
	{
		super.marshal(source, writer, context);
		
		try
		{
			
			Field f = targetClass.getDeclaredField(this.fieldName);
			
			f.setAccessible(true);
			
			Object value = f.get(source);
			
			if (value != null)
			{
				writer.setValue(String.valueOf(value));
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		
	}


    static class CustomMapper extends MapperWrapper
    {
    	private String fieldName;
    	
		public CustomMapper(Mapper wrapped, String fieldName)
		{
			super(wrapped);
			this.fieldName = fieldName;
		}
		
		public boolean shouldSerializeMember(Class definedIn,
                String fieldName)
		{
			if (fieldName.equalsIgnoreCase(this.fieldName))
			{
				return false;
			}
			else
			{
				return super.shouldSerializeMember(definedIn, fieldName);
			}
		}

    }
}
