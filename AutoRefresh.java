import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */

@WebServlet("/AutoRefresh")
public class AutoRefresh extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoRefresh() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setHeader("refresh","5");
		response.setContentType("text/html;chs=arset-UTF-8");
		PrintWriter out=response.getWriter();
		Date d = new Date();
		out.print(d.getDate());
		Calendar cal=new GregorianCalendar();
		String  noon;
		int hour=cal.get(Calendar.HOUR);
		int min=cal.get(Calendar.MINUTE);
		int sec=cal.get(Calendar.SECOND);
        if(cal.get(Calendar.AM_PM)==0)
        	noon="AM";
        else
        	noon="PM";
        String currtime=hour+":"+min+":"+sec+" "+noon;
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Refresh</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center><h2>WELCOME</h2></center>");
        //out.println("<p><center>The page refreshes automatically after every 5 seconds</center></p>");
        out.print("<center>Current date and time is  :  "+currtime+ "</center>");
		//Date d = new Date();
		//d.getDate();
		//out.print(d);
        out.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}