

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
 * Servlet implementation class ApplicationServlet
 */
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationServlet() {
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
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String date=request.getParameter("date");
	    String qualification=request.getParameter("choice");
	    float percentage=Float.parseFloat(request.getParameter("percentage"));
	    String area=request.getParameter("area");
	    String gender=request.getParameter("value");
	    String status=request.getParameter("var");
	    int id=Integer.parseInt(request.getParameter("id"));
	    //String agree=request.getParameter("check");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","intiyaz@123");
	    PreparedStatement ps1=con.prepareStatement("insert into details values(?,?,?,?,?,?,?,?,?)");
	    ps1.setString(1, fname);
	    ps1.setString(2,lname);
	    ps1.setString(3, date);
	    ps1.setString(4, qualification);
	    ps1.setFloat(5, percentage);
	    ps1.setString(6, area);
	    ps1.setString(7, gender);
	    ps1.setString(8, status);
	    ps1.setInt(9, id);
	    
	    
	    PreparedStatement ps2=con.prepareStatement("select * from details where id=?");
	    
	   ps2.setInt(1, id);
	    ps1.executeUpdate();
	    ResultSet rs=ps2.executeQuery();
	    out.println("<style>h2{color:white;}</style>");
	    out.println("<h2>you have applied successfully<br><h2>Check your details</h2>");
	    while(rs.next())
			out.println("<html><body style='background-image:Linear-gradient(45deg,#f035be,blue);color:white'><h3><table border='1'><tr><td> "+rs.getString(1)+" </td><td> "+rs.getString(2)+" </td><td> "+rs.getString(3)+" </td><td> "+rs.getString(4)+" </td><td> "+rs.getFloat(5)+" </td><td> "+rs.getString(6)+" </td><td> "+rs.getString(7)+" </td><td> "+rs.getString(8)+" </td><td> "+rs.getInt(9) +"</td></tr></table>");
		
	    
		
		out.println("<a href='edit.jsp'><h2>Edit</h2></a>");
	    out.println("<a href='HomePage.html'><h2>LogOut</h2></a>");
		
	}
		
		catch(Exception e) {
			out.println("Incorrect Id");
		}
		//response.sendRedirect("EditServlet");
	}

}
