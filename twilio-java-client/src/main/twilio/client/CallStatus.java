
package twilio.client;

public enum CallStatus
{
	NOT_YET_DIALED(0),
	IN_PROGRESS(1),
	COMPLETE(2),
	FAILED_BUSY(3),
	FAILED_APPLICATION_ERROR(4),
	FAILED_NO_ANSWER(5),
	UNKNOWN(-1);
	
	private int code = 1; // todo : fix this class
	
	CallStatus(int statusCode)
	{
		code = statusCode;
	}
	

	static public CallStatus getCallStatus(Integer code)
	{
		CallStatus result = null;
		
		if (code == null)
		{
			result = CallStatus.UNKNOWN;
		}
		else
		{
			for (CallStatus cs : CallStatus.values())
			{
				if (cs.getCode() == code)
				{
					result = cs;
					break;
				}
			}
			
			if (result == null)
			{
				result = CallStatus.UNKNOWN;
			}
		}
		
		return result;
		
		
	}
	
	public int getCode()
	{
		return code;
	}
}
