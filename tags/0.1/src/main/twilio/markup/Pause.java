
package twilio.markup;

import com.thoughtworks.xstream.annotations.*;

@XStreamAlias("Pause")
public class Pause extends Verb
{
	@XStreamAsAttribute
	@XStreamAlias("length")
	private int lengthInSeconds = 1;
	
	public Pause(int seconds)
	{
		setLengthInSeconds(seconds);
	}

	public int getLengthInSeconds()
	{
		return lengthInSeconds;
	}

	public void setLengthInSeconds(int seconds)
	{
		this.lengthInSeconds = seconds;
	}
	
	
}
