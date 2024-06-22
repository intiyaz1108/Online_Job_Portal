

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		int value=Integer.parseInt(request.getParameter("id"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","intiyaz@123");
			PreparedStatement ps=con.prepareStatement("select * from details where id=?");
			ps.setInt(1, value);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				String fname=rs.getString(1);
				String lname=rs.getString(2);
				String date=rs.getString(3);
				String qualification=rs.getString(4);
				float percentage=rs.getFloat(5);
				String area=rs.getString(6);
				String gender=rs.getString(7);
				String status=rs.getString(8);
				int id=rs.getInt(9);
				//HttpSession session = request.getSession();
				//Applicant a=new Applicant(fname,lname,date,qualification,percentage,area,gender,status);
				//System.out.println(a.getFname());
				//HttpSession session=request.getSession();
				//session.setAttribute("a",a);
			    request.setAttribute("fname",fname);
				//session.setAttribute("lname", lname);
				//session.setAttribute("date", date);
				//session.setAttribute("qualification", qualification);
				//session.setAttribute("percentage",percentage);
				//session.setAttribute("area", area);
				//session.setAttribute("gender", gender);
				//session.setAttribute("status", status);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		RequestDispatcher dis=request.getRequestDispatcher("edit.jsp");
		dis.forward(request, response);
	}

}
