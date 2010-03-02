
package twilio.client;

import twilio.TestProperties;

import junit.framework.TestCase;

abstract class AbstractTwilioTest extends TestCase
{
	
	static
	{
		System.getProperties().put("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
		System.getProperties().put("org.apache.commons.logging.simplelog.defaultlog", "trace");
	}

	
	protected String getAccountSid()
	{
		return TestProperties.getAccountSid();
	}
	
	protected String getCallFrom()
	{
		return TestProperties.getCallFrom();
	}
	
	protected String getCallTo()
	{
		return TestProperties.getCallTo();
	}
	
	protected String getAuthToken()
	{
		return TestProperties.getAuthToken();
	}
	
	protected TwilioClient getClient() 
	{
		TwilioClient c = new twilio.client.TwilioClient(getAccountSid(), getAuthToken());
		return c;
	}
	
	protected void assertValid(Call c) throws Exception
	{
		assertNotNull(c);
		assertNotNull(c.getSid());
		assertNotNull(c.getCallSegmentSid());
		assertNotNull(c.getPhoneNumberSid());
		assertNotNull(c.getCaller());
		assertNotNull(c.getCalled());
	}

	protected void assertValid(Conference conf)
	{
		assertNotNull(conf);
		
		assertNotNull(conf.getSid());
		
		assertNotNull(conf.getAccountSid());
		assertNotNull(conf.getFriendlyName());
		
	}

}
