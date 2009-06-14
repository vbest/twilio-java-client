
package twilio.servlet;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

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
		
		for (String headerName : getHeaderNames(req))
		{
			sb.append("HTTP request header: " + headerName + "=" + req.getHeader(headerName) + "\n");
		}
		
		for (String paramName : getParameterNames(req))
		{
			sb.append("HTTP request parameter: " + paramName + "=" + req.getParameter(paramName) + "\n");
		}

		Cookie[] cookies = req.getCookies();
		if (cookies != null)
		{
			for (int i = 0; i < cookies.length; i++)
			{
				if (cookies[i] != null)
				{
					sb.append("HTTP request cookie: ");
					sb.append(toString(cookies[i]));
					sb.append("\n");
				}
			}
		}
		
		HttpSession session = req.getSession(false);
		if (session != null)
		{
			sb.append("HTTP session id=" + session.getId());
			sb.append("\n");
			for (String attrName : getAttributeNames(session))
			{
				sb.append("HTTP session: " + attrName + "=" + session.getAttribute(attrName));
				sb.append("\n");
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
	
	private static List<String> getParameterNames(HttpServletRequest req)
	{
		return toList(req.getParameterNames());
	}
	
	private static List<String> getHeaderNames(HttpServletRequest req)
	{
		return toList(req.getHeaderNames());
	}
	
	private static List<String> getAttributeNames(HttpSession s)
	{
		return toList(s.getAttributeNames());
	}
	
	private static List<String> toList(Enumeration en)
	{
		List<String> list = new ArrayList<String>();
		
		while (en.hasMoreElements())
		{
			list.add( (String) en.nextElement());
		}
		
		Collections.sort(list);
		
		return list;
	}
	
}
