
package twilio.markup;

import com.thoughtworks.xstream.annotations.*;

@XStreamAlias("Number")
public class Number extends Noun
{
	private String value;
	private String sendDigits;
	
	public Number(String value)
	{
		setValue(value);
	}
	
	
	public void setValue(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return value;
	}
	
	public String getName()
	{
		return "Number";
	}

	public void setSendDigits(CharSequence s)
	{
		sendDigits = s.toString();
	}
	
	public String getSendDigits()
	{
		return sendDigits;
	}
	

}
