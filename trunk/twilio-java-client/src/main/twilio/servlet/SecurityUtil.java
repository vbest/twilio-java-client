
package twilio.servlet;

import java.util.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class SecurityUtil
{
	private static final String CHARSET = "UTF-8";
	private static final String ALGORITHM = "HmacSHA1";

	static private byte[] getBytes(CharSequence seq)
	{
		String str;
		
		if (seq instanceof String)
		{
			str = (String) seq;
		}
		else
		{
			str = seq.toString();
		}
		
		try
		{
			return str.getBytes(CHARSET);
		} 
		catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	static public boolean verifyRequest(CharSequence data, String twilioSignature, String twilioAuthToken)
	{
		return Arrays.equals(getBytes(twilioSignature), calculateSignature(data, twilioAuthToken));
	}
	
	static public byte[] calculateSignature(CharSequence data, String twilioAuthToken)
	{
		
		try
		{
			SecretKeySpec key = new SecretKeySpec(twilioAuthToken.getBytes(CHARSET), ALGORITHM); 
			Mac mac = Mac.getInstance(ALGORITHM);
			mac.init(key);
			
			byte[] base64 = Base64.encodeBase64(mac.doFinal(getBytes(data)));
			
			return base64;
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
	
	static public boolean verifyRequest(TwilioRequest req, String twilioAuthToken)
	{
		StringBuffer data = req.getRequestURL();
		
		if (req.getMethod().equalsIgnoreCase("POST"))
		{
			// todo
		}
		
		return verifyRequest(data, req.getTwilioSignature(), twilioAuthToken);
		
	}
}
