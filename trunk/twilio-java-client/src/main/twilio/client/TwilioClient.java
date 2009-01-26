
package twilio.client;

import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.params.AllClientPNames;
import org.apache.http.impl.client.*;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.thoughtworks.xstream.XStream;

import twilio.client.internal.xstream.XStreamFactory;
import twilio.client.internal.httpclient.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

public class TwilioClient
{
	private HttpClient httpClient;
	
	private boolean compressionEnabled = false;
	private String accountSid;
	private String authToken;
	
	public TwilioClient()
	{
		this(new DefaultHttpClient());
	}
	
	public TwilioClient(HttpClient hClient)
	{
		this.httpClient = hClient;
		
		setUserAgent("twilio-java-client");
		setConnectionTimeout( 10 * 1000);
		setSocketTimeout(25 * 1000);
		
	}
	
	public void setCredentials(String accountSid, String authToken)
	{
		this.accountSid = accountSid;
		this.authToken = authToken;
	}
	
	public String getAccountSid()
	{
		return this.accountSid;
	}
	
	public String getAuthToken()
	{
		return this.authToken;
	}
	
	public void setUserAgent(String ua)
	{
		this.httpClient.getParams().setParameter(AllClientPNames.USER_AGENT, ua);
	}
	
	public void setConnectionTimeout(int milliseconds)
	{
		httpClient.getParams().setIntParameter(AllClientPNames.CONNECTION_TIMEOUT, milliseconds);
	}
	
	public void setSocketTimeout(int milliseconds)
	{
		httpClient.getParams().setIntParameter(AllClientPNames.SO_TIMEOUT, milliseconds);
	}
	
	
	
	protected TwilioResponse sendTwilioRequest(String httpMethod, CharSequence url, Map<String, String> params) throws TwilioException
	{
		
		String xmlResponse = sendHttpRequest(httpMethod, url, params);
		
		TwilioResponse r = fromXml(xmlResponse);
		
		r.setXml(xmlResponse);
		
		if (r.getTwilioException() != null)
		{
			throw r.getTwilioException();
		}
		
		return r;
	}
	
	
	protected TwilioResponse fromXml(String xml)
	{
		XStream xstream = XStreamFactory.createXStream();
		
		TwilioResponse r = (TwilioResponse) xstream.fromXML(xml);
		
		return r;
	}
	
	protected String sendHttpRequest(String httpMethod, CharSequence url, Map<String, String> params)
	{
		HttpClient c = getHttpClient();
		
		HttpUriRequest request = null;
		
		if ("GET".equalsIgnoreCase(httpMethod))
		{
			String queryString = buildQueryString(params);
			
			url = url + queryString;
			
			request = new HttpGet(url.toString());
			
		}
		else if ("POST".equalsIgnoreCase(httpMethod))
		{
			HttpPost post = new HttpPost(url.toString());

			try
			{
				post.setEntity(new UrlEncodedFormEntity(buildNameValuePairList(params)));
			} 
			catch (UnsupportedEncodingException e)
			{
				throw new RuntimeException(e);
			}
			
			request = post;
			
		}
		else if ("DELETE".equalsIgnoreCase(httpMethod))
		{
			request = new HttpDelete(url.toString());
		}
		else if ("PUT".equalsIgnoreCase(httpMethod))
		{
			request = new HttpPut(url.toString());
		}
		else
		{
			throw new RuntimeException("unsupported method: " + httpMethod);
		}

		// set credentials for HTTP Basic Authentication
		DefaultHttpClient defaultClient = (DefaultHttpClient) httpClient;
		defaultClient.getCredentialsProvider().setCredentials(
					AuthScope.ANY, 
					new UsernamePasswordCredentials(this.getAccountSid(), this.getAuthToken()));
		
		HttpResponse response = null;
		HttpEntity entity = null;
		
		try
		{
			response = c.execute(request);

			StatusLine status = response.getStatusLine();
			
			if ( (status.getStatusCode() < 200) || (status.getStatusCode() > 299) )
			{
				throw new RuntimeException(
								"HTTP " 
								+ httpMethod 
								+ " response status code = " 
								+ status.getStatusCode());
			}
			
			entity = response.getEntity();
			
			return EntityUtils.toString(entity);
		}
		catch (RuntimeException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
		finally
		{
			// todo : 
		}
		
	}
	
	private String buildQueryString(Map<String, String> params)
	{
		StringBuffer query = new StringBuffer();
		
		if (params.size() > 0)
		{
			query.append("?");
			
			for (String key : params.keySet())
			{
				query.append(key);
				query.append("=");
				query.append(encodeParameter(params.get(key)));
				query.append("&");
			}
			
			if (query.charAt(query.length() - 1) == '&')
			{
				query.deleteCharAt(query.length() - 1);
			}
		}			
		
		return query.toString();
	}

	protected String encodeParameter(String s)
	{
		try
		{
			return URLEncoder.encode(s, "UTF-8");
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}

	protected HttpClient getHttpClient()
	{
		
		if (this.httpClient instanceof DefaultHttpClient)
		{
			DefaultHttpClient defaultClient = (DefaultHttpClient) httpClient;
			
			defaultClient.removeRequestInterceptorByClass(GzipRequestInterceptor.class);
			defaultClient.removeResponseInterceptorByClass(GzipResponseInterceptor.class);
			
			if (this.isCompressionEnabled())
			{
				defaultClient.addRequestInterceptor(GzipRequestInterceptor.getInstance());
				defaultClient.addResponseInterceptor(GzipResponseInterceptor.getInstance());
			}
			
		}

		return this.httpClient;
	}
	
	
	public boolean isCompressionEnabled()
	{
		return compressionEnabled;
	}

	public void setCompressionEnabled(boolean b)
	{
		this.compressionEnabled = b;
	}

	
	/**
	 * 
	 * 
	 *   send HTTP GET
	 *   
	 *   This method can be used to retrieve images  (JPEG, PNG, GIF)
	 *   or any other file type (MP3, WAV, etc)
	 *   
	 *   @return byte array
	 *  
	 */
	public byte[] getBytesFromUrl(String url)
	{
		try
		{
			HttpGet get = new HttpGet(url);
			
			HttpResponse response = this.getHttpClient().execute(get);
			
			HttpEntity entity = response.getEntity();
			
			if (entity == null)
			{
				throw new RuntimeException("response body was empty");
			}
			
			return EntityUtils.toByteArray(entity);
		}
		catch (RuntimeException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * 
	 * send HTTP GET
	 * 
	 */
	public String get(String url) 
	{
		try
		{
			HttpGet get = new HttpGet(url);
			
			HttpResponse response = this.getHttpClient().execute(get);
			
			HttpEntity entity = response.getEntity();
			
			if (entity == null)
			{
				throw new RuntimeException("response body was empty");
			}
			
			return EntityUtils.toString(entity);
		}
		catch (RuntimeException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}

	
	public void shutdown()
	{
		try
		{
			this.getHttpClient().getConnectionManager().shutdown();
		}
		catch (Exception ignore)
		{
			// ignored
		}
	}
	
	protected StringBuilder buildRequestUrl(String path, Map<String, String> urlParameters)
	{
		StringBuilder requestUrl = getTwilioEndpoint();
		
		// todo : code here
		
		return requestUrl;
	}
	
	protected StringBuilder getTwilioEndpoint()
	{
		
		StringBuilder endpoint = new StringBuilder();
		endpoint.append("https://api.twilio.com/2008-08-01/");

		return endpoint;
	}

	protected void checkCredentials()
	{
		if (this.getAccountSid() == null)
		{
			throw new IllegalStateException(
					  "Twilio account SID is null. You may need to call setCredentials(String, String)");
		}
		
		if (this.getAuthToken() == null)
		{
			throw new IllegalStateException(
					  "Twilio auth token is null. You may need to call setCredentials(String, String)");
		}
	}

	public Call call(String accountSid, String from, String to, String callbackUrl)
	{
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("Caller", from);
		params.put("Called", to);
		params.put("Url", callbackUrl);
		
		TwilioResponse r = sendTwilioRequest("POST", 
								this.getTwilioEndpoint() 
									.append("Accounts/")
									.append(accountSid)
									.append("/Calls"),
								params);

		return r.getCall();
		
	}

	public Calls getCalls(String accountSid)
	{
		return getCalls(accountSid, null);
	}
	
	public Calls getCalls(String accountSid, String startTime)
	{
		Map<String, String> params = new HashMap<String, String>();
		
		if (startTime != null)
		{
			params.put("StartTime", startTime);
		}
		
		TwilioResponse r = sendTwilioRequest("GET", 
								this.getTwilioEndpoint() 
									.append("Accounts/")
									.append(accountSid)
									.append("/Calls"),
								params);

		return r.getCalls();
		
	}
	
	public IncomingPhoneNumbers getIncomingPhoneNumbers(String accountSid)
	{
		Map<String, String> params = new HashMap<String, String>();
		
		
		TwilioResponse r = sendTwilioRequest("GET", 
								this.getTwilioEndpoint() 
									.append("Accounts/")
									.append(accountSid)
									.append("/IncomingPhoneNumbers"),
								params);

		return r.getIncomingPhoneNumbers();
		
	}
	
	protected List<NameValuePair> buildNameValuePairList(Map<String, String> m)
	{
		List<NameValuePair> l = new ArrayList<NameValuePair>();
		
		for (String key : m.keySet())
		{
			NameValuePair nvp = new BasicNameValuePair(key, m.get(key));
			l.add(nvp);
		}
		
		return l;
	}

	public OutgoingCallerIds getOutgoingCallerIds(String accountSid)
	{

		/*
		 
		    /2008-08-01/Accounts/{YourAccountSid}/OutgoingCallerIds
		     
		 */
		
		Map<String, String> params = new HashMap<String, String>();
		
		TwilioResponse r = sendTwilioRequest("GET", 
								this.getTwilioEndpoint() 
									.append("Accounts/")
									.append(accountSid)
									.append("/OutgoingCallerIds"),
								params);

		return r.getOutgoingCallerIds();
		
	}

	public Account getAccount(String accountSid)
	{

		/*
		 
		    /2008-08-01/Accounts/{YourAccountSid}
		     
		 */
		
		Map<String, String> params = new HashMap<String, String>();
		
		TwilioResponse r = sendTwilioRequest("GET", 
								this.getTwilioEndpoint() 
									.append("Accounts/")
									.append(accountSid),
								params);

		return r.getAccount();
		
	}

}
