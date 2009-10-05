
package twilio.markup;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Gather")
public class Gather extends Verb
{
	@XStreamImplicit
	private List<Verb> nestedVerbs = new ArrayList<Verb>();
	
	@XStreamAlias("action")
	@XStreamAsAttribute
	private String action;

	@XStreamAlias("method")
	@XStreamAsAttribute
	private String httpMethod = Constants.DEFAULT_HTTP_METHOD;
	
	@XStreamAlias("timeout")
	@XStreamAsAttribute
	private int timeout = Constants.DEFAULT_TIMEOUT;
	
	@XStreamAlias("finishOnKey")
	@XStreamAsAttribute
	private String finishOnKey = Constants.DEFAULT_FINISH_ON_KEY.toString();
	
	@XStreamAlias("numDigits")
	@XStreamAsAttribute
	private int numDigits = 5000;
	
	public void add(Say s)
	{
		this.nestedVerbs.add(s);
	}
	
	public void say(String sayMessage)
	{
		this.add(new Say(sayMessage));
	}
	
	public void play(String url)
	{
		this.add(new Play(url));
	}
	
	public void add(Play p)
	{
		this.nestedVerbs.add(p);
	}
	
	public void add(Pause p)
	{
		this.nestedVerbs.add(p);
	}
	
	public void pause(int duration)
	{
		Pause p = new Pause(duration);
		add(p);
	}
	
	public String getAction()
	{
		return action;
	}


	public void setAction(CharSequence action)
	{
		if (action == null)
		{
			this.action = null;
		}
		else
		{
			this.action = action.toString();
		}
	}


	public String getHttpMethod()
	{
		return httpMethod;
	}


	public void setHttpMethod(String method)
	{
		this.httpMethod = method;
	}


	/**
	 * 
	 * @return timeout in seconds
	 * 
	 */
	public int getTimeout()
	{
		return timeout;
	}


	/**
	 * 
	 * 
	 * @param timeout in seconds
	 * 
	 */
	public void setTimeout(int timeoutInSeconds)
	{
		this.timeout = timeoutInSeconds;
	}


	public String getFinishOnKey()
	{
		return this.finishOnKey;
	}


	public void setFinishOnKey(Character c)
	{
		if (c == null)
		{
			this.finishOnKey = "";
		}
		else
		{
			this.finishOnKey = c.toString();
		}
	}


	public int getNumDigits()
	{
		return numDigits;
	}


	public void setNumDigits(int numDigits)
	{
		this.numDigits = numDigits;
	}


}
