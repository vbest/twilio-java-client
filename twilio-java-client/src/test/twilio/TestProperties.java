
package twilio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties
{
	static private Properties props;
	
	static private Properties getTestProperties()
	{
		if (props == null)
		{
			InputStream input = TestProperties.class.getResourceAsStream("/twilio.properties");
			
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
	
	static public String getAccountSid()
	{
		return getTestProperties().getProperty("account.sid");
	}
	
	static public String getCallFrom()
	{
		return getTestProperties().getProperty("call.from");
	}
	
	static public String getCallTo()
	{
		return getTestProperties().getProperty("call.to");
	}
	
	static public String getAuthToken()
	{
		return getTestProperties().getProperty("auth.token");
	}
	
}
