
package twilio.markup;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Redirect")
public class Redirect extends Verb
{
	private String url;

	@XStreamAlias("method")
	@XStreamAsAttribute
	private String httpMethod = Constants.DEFAULT_HTTP_METHOD;
	
	public Redirect()
	{
		super();
	}
	
	public Redirect(String url)
	{
		this.setUrl(url);
	}
	
	public String getHttpMethod()
	{
		return httpMethod;
	}


	public void setHttpMethod(String method)
	{
		this.httpMethod = method;
	}


	public String getUrl()
	{
		return url;
	}


	public void setUrl(String u)
	{
		this.url = u;
	}

}
