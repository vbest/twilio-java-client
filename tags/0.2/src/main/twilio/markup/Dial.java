
package twilio.markup;

import java.util.*;

import com.thoughtworks.xstream.annotations.*;

@XStreamAlias("Dial")
public class Dial extends Verb
{
	private String phoneNumber;
	
	@XStreamImplicit
	private List<Number> numbers = new ArrayList<Number>();
	
	public Dial()
	{
		
	}
	
	public Dial(String phoneNum)
	{
		setPhoneNumber(phoneNum);
	}
	
	public void setPhoneNumber(String phoneNum)
	{
		phoneNumber = phoneNum;
	}

	public void add(Number n)
	{
		this.numbers.add(n);
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
}
