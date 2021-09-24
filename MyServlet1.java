package lab5a;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			response.setContentType("text/html");
			PrintWriter pwriter = response.getWriter();
			//take data from Html file
			String first = request.getParameter("first");
			String last = request.getParameter("last");
			HttpSession session = request.getSession();
			pwriter.println("Hello First Name is "+ first);
			pwriter.println("Last Name: "+last);

			//Creating two cookies
			Cookie c1=new Cookie("First",first);
			Cookie c2=new Cookie("Last",last);


			//Adding the cookies to response header
			response.addCookie(c1);
			response.addCookie(c2);
			boolean f=false;
			String id = "";
			Long lastAccessedTime=0l;
			Integer maxInactiveInterval=0;
			Long creationTime=0l;
			String fname="";
			String lname="";
			Cookie[] cookies = request.getCookies();
			if(cookies==null)
			{
				pwriter.println("You are new");
			}
			else
			{
				for(Cookie c:cookies)
				{
					f=true;
					id = session.getId();
					lastAccessedTime=session.getLastAccessedTime();
					maxInactiveInterval=session.getMaxInactiveInterval();
					creationTime=session.getCreationTime();
					fname=c1.getValue();
					lname=c2.getValue();
				}

			}
			if(f)
			{   
				pwriter.println("<br> Seession Last Accessed Time:"+lastAccessedTime);
				pwriter.print("<br>Session Max Inactive Interval:"+maxInactiveInterval);
				pwriter.println("<br> Session Creation Time:"+creationTime);
				pwriter.println("<br> Cookies-1 : <br> First Name:"+fname);
				pwriter.println("<br> Cookies-2  : <br> Last Name:"+lname);
			}
		}
		catch(Exception exp)
		{
			System.out.println(exp);
		}
	}
} 