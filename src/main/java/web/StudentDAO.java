package web;


public interface StudentDAO 
{
	boolean addUser(Student u);
	boolean login(String username,String password);
	boolean forgotPassword(String username,String password);

}