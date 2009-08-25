
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
	private Character finishOnKey = Constants.DEFAULT_FINISH_ON_KEY;
	
	@XStreamAlias("numDigits")
	@XStreamAsAttribute
	private int numDigits = 5000;
	
	public void add(Say s)
	{
		this.add(s);
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
	
	public String getAction()
	{
		return action;
	}


	public void setAction(String action)
	{
		this.action = action;
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


	public Character getFinishOnKey()
	{
		return finishOnKey;
	}


	public void setFinishOnKey(Character finishOnKey)
	{
		this.finishOnKey = finishOnKey;
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
