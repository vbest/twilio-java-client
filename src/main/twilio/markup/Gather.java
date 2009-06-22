
package twilio.markup;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Gather")
public class Gather extends Verb
{
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
