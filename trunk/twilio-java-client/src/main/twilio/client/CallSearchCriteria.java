
package twilio.client;

// import java.text.SimpleDateFormat;
import java.util.*;

public class CallSearchCriteria implements java.io.Serializable
{
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private String called;
	private String caller;
	private CallStatus status;
	private String startTime;
	private String endTime;
	
	
	public String getCalled()
	{
		return called;
	}



	public void setCalled(String called)
	{
		this.called = called;
	}


	/*
	private static String format(Calendar c)
	{
		SimpleDateFormat f = new SimpleDateFormat(DATE_FORMAT);
		return f.format(c.getTime());
	} */
	
	public String getCaller()
	{
		return caller;
	}



	public void setCaller(String caller)
	{
		this.caller = caller;
	}



	public CallStatus getStatus()
	{
		return status;
	}



	public void setStatus(CallStatus status)
	{
		this.status = status;
	}



	public String getStartTime()
	{
		return startTime;
	}


/*
	public void setStartTime(Calendar c)
	{
		setStartTime(format(c));
	} */
	
	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}



	public String getEndTime()
	{
		return endTime;
	}

/*
	public void setEndTime(Calendar c)
	{
		setEndTime(format(c));
	} */
	
	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}



	public Map<String, String> getParameterMap()
	{
		Map<String, String> params = new HashMap<String, String>();
		
		if (getCalled() != null)
		{
			params.put("Called", getCalled());
		}
		
		if (getCaller() != null)
		{
			params.put("Caller", getCaller());
		}
		
		if (getStatus() != null)
		{
			params.put("Status", "" + getStatus().getCode());
		}
		
		if (getStartTime() != null)
		{
			params.put("StartTime", getStartTime());
		}
		
		if (getEndTime() != null)
		{
			params.put("EndTime", getEndTime());
		}
		
		return params;
	}

}
