
package twilio.markup;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Play")
public class Play extends Verb
{
	private String url;
	
	@XStreamAsAttribute
	@XStreamAlias("loop")
	private int loop = 1;
	
	
	public Play()
	{
		super();
	}
	
	public void setUrl(CharSequence url)
	{
		this.url = url.toString();
	}
	
	public String getUrl()
	{
		return url;
	}
	
	public int getLoop()
	{
		return loop;
	}

	/**
	 * 
	 * @param loop number of times to play the audio file
	 * 
	 */
	public void setLoop(int loop)
	{
		this.loop = loop;
	}


}
