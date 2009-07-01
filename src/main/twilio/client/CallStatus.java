
package twilio.client;

public class CallStatus
{
	private int code = 1; // todo : fix this class
	
	/*
	 
	An integer representing the status of the call
	
	0 = Not Yet Dialed
	1 = In Progress
	2 = Complete
	3 = Failed - Busy
	4 = Failed - Application Error
	5 = Failed - No Answer
	
	*/
	
	static public boolean isNotYetDialed(int code)
	{
		return code == 0;
	}
	
	static public boolean isInProgress(int code)
	{
		return code == 1;
	}
	
	static public boolean isComplete(int code)
	{
		return code == 2;
	}
	
	static public boolean isFailure(int code)
	{
		return isBusy(code) || isApplicationError(code) || isNoAnswer(code);
	}
	
	static public boolean isBusy(int code)
	{
		return code == 3;
	}
	
	static public boolean isApplicationError(int code)
	{
		return code == 4;
	}
	
	static public boolean isNoAnswer(int code)
	{
		return code == 5;
	}

	public int getCode()
	{
		return code;
	}
}
