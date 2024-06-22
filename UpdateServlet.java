

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		int id=Integer.parseInt(request.getParameter("id"));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String date=request.getParameter("date");
	    String qualification=request.getParameter("choice");
	    float percentage=Float.parseFloat(request.getParameter("percentage"));
	    String area=request.getParameter("area");
	    String gender=request.getParameter("value");
	    String status=request.getParameter("var");
	    String agree=request.getParameter("check");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","intiyaz@123");
	    PreparedStatement ps1=con.prepareStatement("update details set fname=?,lname=?,date=?,qualification=?,percentage=?,area=?,gender=?,status=?,id=? where id=?");
	    ps1.setString(1, fname);
	    ps1.setString(2,lname);
	    ps1.setString(3, date);
	    ps1.setString(4, qualification);
	    ps1.setFloat(5, percentage);
	    ps1.setString(6, area);
	    ps1.setString(7, gender);
	    ps1.setString(8, status);
	    ps1.setInt(9, id);
	    ps1.setInt(10, id);
        PreparedStatement ps2=con.prepareStatement("select * from details where id=?");
	    ps2.setInt(1, id);
	    ps1.executeUpdate();
	    ResultSet rs=ps2.executeQuery();
	    while(rs.next())
			out.println("<html><body style='background-image:Linear-gradient(45deg,#f035be,blue);color:white'><h3><table border='1'><tr><td> "+rs.getString(1)+" </td><td> "+rs.getString(2)+" </td><td> "+rs.getString(3)+" </td><td> "+rs.getString(4)+" </td><td> "+rs.getFloat(5)+" </td><td> "+rs.getString(6)+" </td><td> "+rs.getString(7)+" </td><td> "+rs.getString(8)+" </td></tr></table>");
		}
		catch(Exception e) {
			out.println(e);
		}
	    out.println("<body style='background-image:Linear-gradient(45deg,aqua,#f035be);color:white'><h2>You are applied succesfully!<br>");
		out.println("<a href='ApplicantLogin.html'><h2 style='color:white'>LogOut</h2></a>");
	
	}

}
