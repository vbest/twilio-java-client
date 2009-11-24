
package twilio.markup;

import com.thoughtworks.xstream.annotations.*;

@XStreamAlias("Conference")
public class Conference extends Noun
{
	private String conferenceName;
	
	@XStreamAsAttribute
	private boolean muted = false;
	
	@XStreamAsAttribute
	@XStreamAlias("beep")
	private boolean beep = true;
	
	@XStreamAsAttribute
	private boolean startConferenceOnEnter = true;
	
	@XStreamAsAttribute
	private boolean endConferenceOnExit = false;
	
	@XStreamAsAttribute
	private String waitUrl = "";
	
	@XStreamAsAttribute
	private String waitMethod = "POST";
	
	public Conference(String name)
	{
		this.conferenceName = name;
	}

	public String getConferenceName()
	{
		return conferenceName;
	}

	public void setConferenceName(String conferenceName)
	{
		this.conferenceName = conferenceName;
	}

	public boolean isMuted()
	{
		return muted;
	}

	public void setMuted(boolean muted)
	{
		this.muted = muted;
	}

	public boolean isBeep()
	{
		return beep;
	}

	public void setBeep(boolean beep)
	{
		this.beep = beep;
	}

	public boolean isStartConferenceOnEnter()
	{
		return startConferenceOnEnter;
	}

	public void setStartConferenceOnEnter(boolean startConferenceOnEnter)
	{
		this.startConferenceOnEnter = startConferenceOnEnter;
	}

	public boolean isEndConferenceOnExit()
	{
		return endConferenceOnExit;
	}

	public void setEndConferenceOnExit(boolean endConferenceOnExit)
	{
		this.endConferenceOnExit = endConferenceOnExit;
	}

	public String getWaitUrl()
	{
		return waitUrl;
	}

	public void setWaitUrl(String waitUrl)
	{
		this.waitUrl = waitUrl;
	}

	public String getWaitMethod()
	{
		return waitMethod;
	}

	public void setWaitMethod(String waitMethod)
	{
		this.waitMethod = waitMethod;
	}
	
	
	
}
