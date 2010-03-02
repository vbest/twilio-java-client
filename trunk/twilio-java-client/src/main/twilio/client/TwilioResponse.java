
package twilio.client;

public class TwilioResponse implements java.io.Serializable
{
	
	private TwilioException exception;
	
	private Account account;
	private OutgoingCallerIds outgoingCallerIds;
	private OutgoingCallerId outgoingCallerId;
	private IncomingPhoneNumbers incomingPhoneNumbers;
	private IncomingPhoneNumber incomingPhoneNumber;
	private ValidationRequest validationRequest;
	private Calls calls;
	private Conferences conferences;
	private Call call;
	private SMSMessage sMSMessage;
	private Recordings recordings;
	private Recording recording;
	
	transient private String xml;

	

	public String toString()
	{
		// return ToStringBuilder.build(this);
		return "";
	}


	public SMSMessage getSMSMessage()
	{
		return sMSMessage;
	}
	
	public void setSMSMessage(SMSMessage msg)
	{
		this.sMSMessage = msg;
	}
	public void setXml(String xmlResponse)
	{
		this.xml = xmlResponse;
	}



	public TwilioException getTwilioException()
	{
		return this.exception;
	}



	public Account getAccount()
	{
		return account;
	}



	public void setAccount(Account a)
	{
		this.account = a;
	}



	public Calls getCalls()
	{
		return calls;
	}



	public void setCalls(Calls calls)
	{
		this.calls = calls;
	}



	public Call getCall()
	{
		return call;
	}



	public void setCall(Call c)
	{
		this.call = c;
	}



	public TwilioException getException()
	{
		return exception;
	}



	public void setException(TwilioException exception)
	{
		this.exception = exception;
	}



	public OutgoingCallerIds getOutgoingCallerIds()
	{
		return outgoingCallerIds;
	}



	public void setOutgoingCallerIds(OutgoingCallerIds outgoingCallerIds)
	{
		this.outgoingCallerIds = outgoingCallerIds;
	}



	public OutgoingCallerId getOutgoingCallerId()
	{
		return outgoingCallerId;
	}



	public void setOutgoingCallerId(OutgoingCallerId outgoingCallerId)
	{
		this.outgoingCallerId = outgoingCallerId;
	}



	public IncomingPhoneNumbers getIncomingPhoneNumbers()
	{
		return incomingPhoneNumbers;
	}



	public void setIncomingPhoneNumbers(IncomingPhoneNumbers incomingPhoneNumbers)
	{
		this.incomingPhoneNumbers = incomingPhoneNumbers;
	}



	public IncomingPhoneNumber getIncomingPhoneNumber()
	{
		return incomingPhoneNumber;
	}



	public void setIncomingPhoneNumber(IncomingPhoneNumber incomingPhoneNumber)
	{
		this.incomingPhoneNumber = incomingPhoneNumber;
	}



	public ValidationRequest getValidationRequest()
	{
		return validationRequest;
	}



	public void setValidationRequest(ValidationRequest validationRequest)
	{
		this.validationRequest = validationRequest;
	}



	public Recordings getRecordings()
	{
		return recordings;
	}



	public void setRecordings(Recordings recs)
	{
		this.recordings = recs;
	}



	public Recording getRecording()
	{
		return recording;
	}



	public void setRecording(Recording r)
	{
		this.recording = r;
	}



	public Conferences getConferences()
	{
		return conferences;
	}



	public void setConferences(Conferences c)
	{
		this.conferences = c;
	}

	
}
