
package twilio.client;

import java.util.ArrayList;

public class TwilioList<E> extends ArrayList<E>
{
	private static final long serialVersionUID = 1L;
	
	private Integer page;
	private Integer numberOfPages;
	private Integer pageSize;
	private Integer total;
	private Integer start;
	private Integer end;
	
	
	public Integer getPage()
	{
		return page;
	}
	
	public void setPage(Integer page)
	{
		this.page = page;
	}
	
	public Integer getNumberOfPages()
	{
		return numberOfPages;
	}
	
	public void setNumberOfPages(Integer numberOfPages)
	{
		this.numberOfPages = numberOfPages;
	}
	
	public Integer getPageSize()
	{
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
	}
	
	public Integer getTotal()
	{
		return total;
	}
	
	public void setTotal(Integer total)
	{
		this.total = total;
	}
	
	public Integer getStart()
	{
		return start;
	}
	
	public void setStart(Integer start)
	{
		this.start = start;
	}
	
	public Integer getEnd()
	{
		return end;
	}
	
	public void setEnd(Integer end)
	{
		this.end = end;
	}
	
	
}
