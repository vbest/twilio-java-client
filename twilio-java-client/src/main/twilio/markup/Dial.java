
package twilio.markup;

import java.util.*;

import com.thoughtworks.xstream.annotations.*;

@XStreamAlias("Dial")
public class Dial extends Verb
{
	private String phoneNumber;
	
	@XStreamImplicit
	private List<Number> numbers = new ArrayList<Number>();

	private Conference conference;
	
	public Dial()
	{
		
	}
	
	public Dial(Conference c)
	{
		this.add(c);
	}
	
	public Dial(String phoneNum)
	{
		setPhoneNumber(phoneNum);
	}
	
	public void setPhoneNumber(String phoneNum)
	{
		phoneNumber = phoneNum;
	}

	public void add(CharSequence number)
	{
		this.add(new Number(number));
	}
	
	public void add(Conference c)
	{
		this.conference = c;
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
