<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<%
		String ua=(String)request.getAttribute("AddUser");
		if(ua != null)
		{
			System.out.println(ua);
		}
		
		String lu=(String)request.getAttribute("login");
		if(lu != null)
		{
			System.out.println(lu);
		}		
		
		String fp=(String)request.getAttribute("ForgotPassword");
		if(fp != null)
		{
			System.out.println(fp);
		}		
		
%>

<body>
<form action="StudentServlet" method="post">
<input type="hidden" name="action" value="login">
<table align="center" border="1"cellpadding="5" cellspacing="5 style=width:40%" bgcolor="cornflowerblue">

<tr>
<th><label>UserName</label></th>
<td><input type="text" name="username"></td>
</tr>

<tr>
<th><label>Password</label></th>
<td><input type="text" name="password"></td>
</tr>

<tr>
<td> <input type="submit" value="login">
<td> <input type="reset" value="clear"></td>
<td> <a href="ForgotPassword.jsp">Forgot Password</a></td>
</tr>

</table>
</form>
</body>
</html>
