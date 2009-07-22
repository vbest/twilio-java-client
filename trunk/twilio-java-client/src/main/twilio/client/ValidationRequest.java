
package twilio.client;

public class ValidationRequest
{
	private String accountSid;
	private String phoneNumber;
	private String validationCode;
	
	public String getAccountSid()
	{
		return accountSid;
	}
	
	public void setAccountSid(String accountSid)
	{
		this.accountSid = accountSid;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public String getValidationCode()
	{
		return validationCode;
	}
	
	public void setValidationCode(String validationCode)
	{
		this.validationCode = validationCode;
	}
	

	public String toString()
	{
		// return ToStringBuilder.build(this);
		return "";
	}
}
