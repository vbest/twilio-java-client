
package twilio.markup;

public enum Language
{
	ENGLISH("en", "English"), 
	SPAIN("es", "Spanish"),
	FRENCH("fr", "French"),
	GERMAN("de", "German");
	
	private String code;
	private String name; 
	
	Language(String code, String name)
	{
		this.code = code;
		this.name = name;
	}
	
	public String getCode()
	{
		return this.code;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String toString()
	{
		return getCode();
	}
}
