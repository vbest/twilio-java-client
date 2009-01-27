
package twilio.markup;

public class Say extends Verb
{
	private String message;
	private Voice voice = Voice.MAN;
	private Language language = Language.ENGLISH;
	private int loop = 1;
	
	
	public Say()
	{
		super();
	}
	
	public Say(String msg)
	{
		setMessage(msg);
	}
	
	public void setMessage(String msg)
	{
		message = msg;
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

	public void setLanguage(Language language)
	{
		this.language = language;
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

	@Override
	public String getName()
	{
		return "Say";
	}

	@Override
	public String toString()
	{
		
		StringBuilder sb = new StringBuilder();
		sb.append("<Say");
		
		if (this.getVoice() != null)
		{
			sb.append(" voice=\"" + this.getVoice().getValue() + "\" ");
		}
		
		if (this.getLanguage() != null)
		{
			sb.append(" language=\"" + this.getLanguage().getCode() + "\" ");
		}
		
		if (this.getLoop() >= 0)
		{
			sb.append(" loop=\"" + this.getLoop() + "\" ");
		}
		sb.append(">\n");
		sb.append(this.getMessage());
		sb.append("\n</Say>\n");
		
		return sb.toString();
		
	}

}
