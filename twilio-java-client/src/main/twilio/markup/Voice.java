
package twilio.markup;

public enum Voice
{
	MAN("man"), WOMAN("woman");
	
	private String value;
	
	Voice(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return this.value;
	}
	
	public String toString()
	{
		return getValue();
	}
}
