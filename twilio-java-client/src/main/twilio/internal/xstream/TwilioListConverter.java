package twilio.internal.xstream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.mapper.Mapper;

import twilio.client.*;

public class TwilioListConverter extends CollectionConverter
{

	public TwilioListConverter(Mapper mapper)
	{
		super(mapper);
	}

    public boolean canConvert(Class type) {
        return TwilioList.class.isAssignableFrom(type);
    }

    protected Object createCollection(Class type) {
    	try
    	{
    		return type.newInstance();
    	}
    	catch (Exception ex)
    	{
    		throw new RuntimeException(ex);
    	}
    }
}
