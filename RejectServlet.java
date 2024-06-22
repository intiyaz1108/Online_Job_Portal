

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RejectServlet
 */
public class RejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RejectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("reject"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","intiyaz@123");
			PreparedStatement ps=con.prepareStatement("delete from details where id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
			out.println("<body style='background-image:Linear-Gradient(45deg,blue,#f035be);color:white'</body><h2>This Applicant Is Rejected<br>");
			out.println("<a href='DetailsServlet'><h2 style='color:white'>CheckData</h2></a>");
			out.println("<a href='AdminLogin.html'><h2 style='color:white'>LogOut</h2></a>");
			
		}
		catch(Exception e) {
			out.println(e);
		}
	}

}
