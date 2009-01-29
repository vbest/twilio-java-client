
package twilio.markup;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.basic.StringConverter;

@XStreamAlias("Say")
public class Say extends Verb
{
	@XStreamConverter(StringConverter.class)
	// @XStreamImplicit
	// @XStreamAlias("")
	private String message;
	
	@XStreamAsAttribute
	@XStreamAlias("voice")
	private Voice voice = Voice.MAN;

	@XStreamAsAttribute
	@XStreamAlias("language")
	private Language language = Language.ENGLISH;

	@XStreamAsAttribute
	@XStreamAlias("loop")
	private int loop = 1;
	
	
	public Say()
	{
		super();
	}
	
	public Say(CharSequence msg)
	{
		setMessage(msg);
	}
	
	public void setMessage(CharSequence msg)
	{
		message = msg.toString();
	}
	
	public String getMessage()
	{
		return message;
	}
	

	
	public Voice getVoice()
	{
		return voice;
	}

	public void setVoice(Voice voice)
	{
		this.voice = voice;
	}

	public Language getLanguage()
	{
		return language;
	}

	public void setLanguage(Language lang)
	{
		this.language = lang;
	}

	public int getLoop()
	{
		return loop;
	}

	/**
	 * 
	 * @param loop number of times the message will be repeated
	 * 
	 */
	public void setLoop(int loop)
	{
		this.loop = loop;
	}


}
