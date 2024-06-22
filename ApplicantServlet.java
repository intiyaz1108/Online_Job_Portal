

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicantServlet
 */
public class ApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			boolean flag=false;
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String email,password;
		email=request.getParameter("email");
		password=request.getParameter("password");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","intiyaz@123");
		Statement stmt=con.createStatement();
		String q="select * from register"; 
		ResultSet rs=stmt.executeQuery(q);
		while(rs.next()) {
			if(rs.getString(1).equals(email) && rs.getString(2).equals(password))
			{
				flag=true;
				break;
			}
			}
			if (flag==true){
				RequestDispatcher dis=request.getRequestDispatcher("ApplicationForm.html");
		        dis.forward(request,response);
				
			}
			else {
				out.println("<style>a{color:white}</style>");
				out.println("<body style='background-image:Linear-gradient(90deg,blue,red);color:white'><h2>Invalid Login</h2>");
				out.println("<h3 style='color:white'>Don't have account? <a href='Register.html'>Register</a>");
			}
	}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
