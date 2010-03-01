
package twilio.internal.xstream;

import com.thoughtworks.xstream.mapper.MapperWrapper;

public class TwilioMapper extends MapperWrapper
{
	public TwilioMapper(MapperWrapper wrapped)
	{
		super(wrapped);
	}

    public String realMember(Class type, String originalNodeName) {
    	
        String fieldName = super.realMember(type, originalNodeName);
        
        char firstChar = fieldName.charAt(0);
        
        if (Character.isUpperCase(firstChar))
        {
        		fieldName = Character.toString(firstChar).toLowerCase()
        					+ fieldName.substring(1);
        }
        
        return fieldName;
    }

	
}
