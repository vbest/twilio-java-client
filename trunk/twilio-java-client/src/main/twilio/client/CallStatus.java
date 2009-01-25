
package twilio.client;

public enum CallStatus
{
	/*
	 
	An integer representing the status of the call
	
	0 = Not Yet Dialed
	1 = In Progress
	2 = Complete
	3 = Failed - Busy
	4 = Failed - Application Error
	5 = Failed - No Answer
	
	*/
	NOT_YET_DIALED(0, "Not yet dialed"),
	IN_PROGRESS(1, "In progress"),
	COMPLETE(2, "Complete"),
	FAILED_BUSY(3, "Failed - busy"),
	FAILED_APPLICATION_ERROR(4, "Failed - application error"),
	FAILED_NO_ANSWER(5, "No answer");
	
	private int code;
	private String description;
	
	CallStatus(int code, String description)
	{
		this.code = code;
		this.description = description;
	}
	
	public String getDescription()
	{
		return this.description;
	}

	public int getCode()
	{
		return this.code;
	}
	
}
