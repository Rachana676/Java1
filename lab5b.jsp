<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
              pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>

<body>

	<%!
	class MyException extends Exception
	{
		String message;
		MyException(String message)
        {
			this.message=message;
		}

		public String toString()
		{
			return "Custom Exception: Please try again  " +message;
		}
	}
	%>

	<%
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");

		String age =request.getParameter("age");

	%>

    <%-- conditional statements --%>

    <%
		if (fname.isBlank() || lname.isBlank() || age.isBlank()) 
		{
			try
			{
				throw new MyException(" fields are empty");
			}
			catch(MyException e)
			{
				out.print(e);
				
			}

		} 
		else 
		{
	%>
			First Name:<%=fname%><br>
			Last Name:<%=lname%><br>
			Age:<%=age%><br>
			<%
		}

	%>

 	</body>

</html>

