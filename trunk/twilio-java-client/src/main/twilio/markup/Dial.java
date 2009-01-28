
package twilio.markup;

import java.util.*;

import com.thoughtworks.xstream.annotations.*;

@XStreamAlias("Dial")
public class Dial extends Verb
{
	private String phoneNumber;
	private List<Number> numbers = new ArrayList<Number>();
	
	public Dial(String phoneNum)
	{
		setPhoneNumber(phoneNum);
	}
	
	public void setPhoneNumber(String phoneNum)
	{
		phoneNumber = phoneNum;
	}

	public void addNumber(Number n)
	{
		this.numbers.add(n);
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<Dial");
		sb.append(">\n");
		sb.append("</Dial>\n");
		return sb.toString();
	}

}
