
package twilio.servlet;

import org.springframework.mock.web.MockHttpServletRequest;

import junit.framework.TestCase;


public class SecurityUtilTest extends TestCase
{
	public void test() throws Exception
	{
		MockHttpServletRequest req = new MockHttpServletRequest();
		
		req.addParameter("a", "a1");
		req.addParameter("b", "b1");
		
		req.setQueryString("foo=bar&color=green");
		
		boolean result = SecurityUtil.verifyRequest(req, "foo");
		
		assertTrue(result);
		
	}
}
