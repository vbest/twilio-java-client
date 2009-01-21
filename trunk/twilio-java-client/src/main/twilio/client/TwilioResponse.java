
package twilio.client;

public class TwilioResponse
{
	
	private TwilioException exception;
	
	private Account account;
	private OutgoingCallerIds outgoingCallerIds;
	private OutgoingCallerId outgoingCallerId;
	private IncomingPhoneNumbers incomingPhoneNumbers;
	private IncomingPhoneNumber incomingPhoneNumber;
	private ValidationRequest validationRequest;
	private Calls calls;
	private Call call;
	
	transient private String xml;

	

	public String toString()
	{
		return "todo";
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


	
}
