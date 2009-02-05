
package twilio.markup.internal.xstream;

import java.lang.reflect.Field;
import java.util.Iterator;

import twilio.markup.*;

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
        throw new IllegalStateException("unmarshall not supported");
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

	/*
    protected void marshallField(final MarshallingContext context, Object newObj, Field field) {
    	
    	if (field.getName().equals(fieldName))
    	{
    		System.out.println("word up: " + fieldName);
    	}
    	else
    	{
    		context.convertAnother(newObj, mapper.getLocalConverter(field.getDeclaringClass(), field.getName()));
    	} 
    	
    }
    
    */

    
	/*
    protected void marshallField(final MarshallingContext context, Object newObj, Field field) {
    	
    	System.out.println(field);
    	
    	System.out.println(field.getType());
    	
    	if (field.getType() == String.class)
    	{
    		
    	}
    	else
    	{
    		super.marshallField(context, newObj, field);
    	}
    } */

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
