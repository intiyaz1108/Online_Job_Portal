

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flag=false;
		String name="";
		int id;
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","intiyaz@123");
				Statement stmt=con.createStatement();
				String q="select * from admins";
				ResultSet rs1=stmt.executeQuery(q);
				while(rs1.next()) {
					if(rs1.getString(2).equals(request.getParameter("email")) && rs1.getString(3).equals(request.getParameter("password")))
					{
						flag=true;
						name=rs1.getString(1);
				
						break;
					}
					else {
						continue;
					}
				}
				ResultSet rs2=stmt.executeQuery("select * from details");
				if(flag==true) {
					out.println("<body style='background-image:Linear-gradient(50deg,skyblue,#f035be)'><h2 style='color:white'>Welcome "+name+"</h2>");
					out.println("<h2>Check The Data</h2>");
					//RequestDispatcher dis=request.getRequestDispatcher("DetailsServlet");
					//dis.include(request, response);
					
					out.println("<body style='background-image:Linear-gradient(45deg,yellow,white);color:white'><table border='2'><tr style='color:red;font-size:20px'><th>FirstName</th><th>LastName</th><th>DateOfBirth</th><th>Qualification</th><th>Percentage</th><th>Location</th><th>Gender</th><th>MaritalStatus</th><th>id</th><th>Selection</th><th>Rejection</th><tr>");
					out.println("<style>");
					out.println("table{table-layout:fixed;width:100%}</style>");
					while(rs2.next()) {
						int value=rs2.getInt(9);
						out.println("<html><table border='2'><tr style='color:white;font-size:20px'><td> "+rs2.getString(1)+" </td><td> "+rs2.getString(2)+" </td><td> "+rs2.getString(3)+" </td><td> "+rs2.getString(4)+" </td><td> "+rs2.getFloat(5)+" </td><td> "+rs2.getString(6)+" </td><td> "+rs2.getString(7)+" </td><td> "+rs2.getString(8)+" </td><td> "+rs2.getInt(9)+" </td> <td><form action='SelectServlet'><button type='submit' name='select' value="+value+"> select </button></form> </td> <td><form action='RejectServlet'><button type='submit' name='reject' value="+value+"> Reject </button></form> </td></tr></table>"); 
					}
					
					out.println("<a href='HomePage.html'><h2 style='color:white'>HomePage</a>");
		
					}
				else {
					out.println("<h2 style='color:red'>Invalid Login </h2>");
					out.println("<body style='background-image:Linear-gradient(50deg,skyblue,#f035be)'><a href='HomePage.html'><h2 style='color:white'>HomePage</a>");
				}
			}
			
			catch(Exception e) {
				out.println(e);
			}
		}

	
	}


