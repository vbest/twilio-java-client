
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
	private String method = "POST";
	
	@XStreamAlias("timeout")
	@XStreamAsAttribute
	private int timeout = 10;
	
	@XStreamAlias("finishOnKey")
	@XStreamAsAttribute
	private Character finishOnKey = new Character('#');
	
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


	public String getMethod()
	{
		return method;
	}


	public void setMethod(String method)
	{
		this.method = method;
	}


	public int getTimeout()
	{
		return timeout;
	}


	public void setTimeout(int timeout)
	{
		this.timeout = timeout;
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
