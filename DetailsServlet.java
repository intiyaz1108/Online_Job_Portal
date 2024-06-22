

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailsServlet
 */
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsServlet() {
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
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","intiyaz@123");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from details");
			out.println("<body style='background-image:Linear-gradient(45deg,yellow,white);color:red'><table border='2'><tr style='color:red;font-size:25px'><th>FirstName</th><th>LastName</th><th>DateOfBirth</th><th>Qualification</th><th>Percentage</th><th>Location</th><th>Gender</th><th>MaritalStatus</th><tr>");
			
			out.println("<style>");
			out.println("table{table-layout:fixed;width:100%}</style>");
			while(rs.next()) {
				out.println("<html><table border='2'><tr style='color:red;font-size:20px'><td> "+rs.getInt(9)+"</td><td> "+ rs.getString(1)+" </td><td> "+rs.getString(2)+" </td><td> "+rs.getString(3)+" </td><td> "+rs.getString(4)+" </td><td> "+rs.getFloat(5)+" </td><td> "+rs.getString(6)+" </td><td> "+rs.getString(7)+" </td><td> "+rs.getString(8)+" </td></tr></table>");
				
			}
			
			out.println("<a href='AdminLogin.html'><h2>LogOut</h2></a>");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
