
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.Student;
import web.StudentDAOImpl;


/**
 * Servlet implementation class UserServlet
 */


public class StudentServlet extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;

	Student u=new Student();
	StudentDAOImpl ui=new StudentDAOImpl();
	RequestDispatcher rd;
	boolean flag;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() 
    {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String operation = request.getParameter("action");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		HttpSession session = request.getSession();
		 session.setAttribute("username", username);
		 session.setAttribute("password", password);
		 

		
		
		if(operation != null && operation.equals("addUser"))
		{
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
			String contact=request.getParameter("contact");
			
			u.setName(name);
			u.setEmail(email);
			u.setAddress(address);
			u.setContact(contact);
			u.setUsername(username);
			u.setPassword(password);
			
			
			
			flag = ui.addUser(u);
			
			if(flag==true)
			{
				request.setAttribute("AddUser","User Added SuccessFully");
				rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("AddUser1","User Not Added SuccessFully");
				rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		}
		
		
		else if(operation.equals("login"))
		{
			 String username1= (String)session.getAttribute(username);
			 String password1 =(String)session.getAttribute(password);
			 session.setMaxInactiveInterval(5);
		
			flag=ui.login(username, password);
			
			if(flag==true)
			{
				request.setAttribute("login","Welcome " +username);
				rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("Wrong Input :");
			}
		}
		
		else if(operation.equals("login"))
		{
			
			flag=ui.login(username, password);
			
			if(flag==true)
			{
				request.setAttribute("login","Welcome " +username);
				rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("Wrong Input :");
			}
		}
		
		else if(operation.equals("forgotpassword"))
		{
			String username1=request.getParameter("username");
			String newpassword=request.getParameter("newpassword");
			
			flag = ui.forgotPassword(username1,newpassword);
			
			if(flag==true)
			{
				request.setAttribute("ForgotPassword","Change Password Successfully "+username);
				rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("Password Not Match");
			}
		}
	}

}