
package twilio.servlet;


import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ServletUtil
{
	
	static public String toString(HttpServletRequest req)
	{
		StringBuffer sb = new StringBuffer();

		StringBuffer requestUrl = req.getRequestURL();
		if (req.getQueryString() != null)
		{
			requestUrl.append("?");
			requestUrl.append(req.getQueryString());
		}
		
		sb.append("HTTP request URL:  " + requestUrl);
		sb.append("\n");
		sb.append("HTTP request method:  " + req.getMethod()); 
		sb.append("\n");
		
		Enumeration headers = req.getHeaderNames();
		while (headers.hasMoreElements())
		{
			String headerName = (String) headers.nextElement();
			sb.append("HTTP request header: " + headerName + "=" + req.getHeader(headerName) + "\n");
		}
		
		Enumeration parameters = req.getParameterNames();
		while (parameters.hasMoreElements())
		{
			String paramName = (String) parameters.nextElement();
			sb.append("HTTP request parameter: " + paramName + "=" + req.getParameter(paramName) + "\n");
		}

		HttpSession session = req.getSession(false);
		if (session != null)
		{
			sb.append("HTTP session id=" + session.getId());
			sb.append("\n");
			Enumeration attributes = session.getAttributeNames();
			while (attributes.hasMoreElements())
			{
				String attr = (String) attributes.nextElement();
				sb.append("HTTP session: " + attr + "=" + attributes.nextElement());
				sb.append("\n");
			}
		}
		
		Cookie[] cookies = req.getCookies();
		if (cookies != null)
		{
			for (int i = 0; i < cookies.length; i++)
			{
				if (cookies[i] != null)
				{
					sb.append("HTTP request cookie ");
					sb.append(toString(cookies[i]));
					sb.append("\n");
				}
			}
		}
		
		return sb.toString();
	}
	
	static public String toString(Cookie c)
	{
		if (c == null)
		{
			return "";
		}
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(c.getName());
		sb.append("=");
		sb.append(c.getValue());
		
		return sb.toString();
	}
}
