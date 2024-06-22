

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
 * Servlet implementation class SelectServlet
 */
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
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
		int id=Integer.parseInt(request.getParameter("select"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","intiyaz@123");
			PreparedStatement ps=con.prepareStatement("select * from details where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			out.println("<style>");
			out.println("table{table-layout:fixed;width:100%}</style>");
			out.println("<body style='background-image:Linear-gradient(30deg,aqua,#f035be);color:white'><table border='2'><tr style='color:white';font-size:25px'> <th>Id</th> <th>FirstName</th><th>LastName</th><th>DateOfBirth</th><th>Qualification</th><th>Percentage</th><th>Location</th><th>Gender</th><th>MaritalStatus</th><tr>");
			out.println("<h2>This Applicant Is Selected</h2>");
			while(rs.next()) {
				out.println("<table border='2'><tr style='color:white;font-size:25px'><td> "+ rs.getInt((9)) +" </td><td>"+rs.getString(1)+" </td><td> "+rs.getString(2)+" </td><td> "+rs.getString(3)+" </td><td> "+rs.getString(4)+" </td><td> "+rs.getFloat(5)+" </td><td> "+rs.getString(6)+" </td><td> "+rs.getString(7)+" </td><td> "+rs.getString(8)+" </td></tr></table>");
				
			}
			//out.print("<a href='AdminLogin.html'><h2 style>GoBack</h2></a>");
			out.println("<a href='AdminLogin.html'><h2 style='color:white'>LogOut</h2></a>");
		}
		catch(Exception e) {
			out.println(e);
		}
	}

}
