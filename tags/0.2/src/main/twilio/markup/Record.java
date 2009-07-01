
package twilio.markup;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Record")
public class Record extends Verb
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
	
	@XStreamAlias("maxLength")
	@XStreamAsAttribute
	private int maxLength = 5;
	
	@XStreamAlias("transcribe")
	@XStreamAsAttribute
	private boolean transcribe = false;
	
	@XStreamAlias("transcribeCallback")
	@XStreamAsAttribute
	private String transcribeCallback;
	
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


	public int getMaxLength()
	{
		return maxLength;
	}


	public void setMaxLength(int maxLength)
	{
		this.maxLength = maxLength;
	}


	public boolean isTranscribe()
	{
		return transcribe;
	}


	public void setTranscribe(boolean b)
	{
		this.transcribe = b;
	}


	public String getTranscribeCallback()
	{
		return transcribeCallback;
	}


	public void setTranscribeCallback(String callbackUrl)
	{
		this.transcribeCallback = callbackUrl;
	}


}
