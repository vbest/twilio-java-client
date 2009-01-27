
package twilio.markup;

public class Record extends Verb
{
	private String action;
	private String method = "POST";
	private int timeout = -1;
	private Character finishOnKey = new Character('#');
	private int maxLength = -1;
	
	@Override
	public String getName()
	{
		return "Record";
	}

	
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


	public int getMaxLength()
	{
		return maxLength;
	}


	public void setMaxLength(int maxLength)
	{
		this.maxLength = maxLength;
	}


	@Override
	public String toString()
	{
		
		StringBuilder sb = new StringBuilder();
		sb.append("<Record");
		
		if (this.getAction() != null)
		{
			sb.append(" action=\"" + this.getAction() + "\" ");
		}
		
		if (this.getMethod() != null)
		{
			sb.append(" method=\"" + this.getMethod() + "\" ");
		}
		
		if (this.getTimeout() != -1)
		{
			sb.append(" timeout=\"" + this.getTimeout() + "\" ");
		}
		
		if (this.getFinishOnKey() != null)
		{
			sb.append(" finishOnKey=\"" + this.getFinishOnKey() + "\" ");
		}
		
		if (this.getMaxLength() >= 0)
		{
			sb.append(" maxLength=\"" + this.getMaxLength() + "\" ");
		}
		
		sb.append(">\n");
		sb.append("</Record>\n");
		
		return sb.toString();
		
	}


}
