
package twilio.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import junit.framework.TestCase;

abstract class AbstractTwilioTest extends TestCase
{
	private Properties props;
	
	static
	{
		System.getProperties().put("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
		System.getProperties().put("org.apache.commons.logging.simplelog.defaultlog", "trace");
	}

	protected Properties getTestProperties()
	{
		if (props == null)
		{
			InputStream input = this.getClass().getResourceAsStream("/twilio.properties");
			if (input == null)
			{
				File f = new File("twilio.properties");
				try
				{
					input = new FileInputStream(f);
				} 
				catch (FileNotFoundException e)
				{
					// ignore
				}
			}
			
			props = new Properties();
			
			if (input != null)
			{
				try
				{
					props.load(input);
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		return props;
	}
	
	protected String getAccountSid()
	{
		return getTestProperties().getProperty("account.sid");
	}
	
	protected String getCallFrom()
	{
		return getTestProperties().getProperty("call.from");
	}
	
	protected String getCallTo()
	{
		return getTestProperties().getProperty("call.to");
	}
	
	protected String getAuthToken()
	{
		return getTestProperties().getProperty("auth.token");
	}
	
	protected Client getClient() 
	{
		Client c = new Client();
		c.setCredentials(getAccountSid(), 
						getAuthToken());	
		return c;
	}
	
		
}
