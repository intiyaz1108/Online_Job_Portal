

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		switch(action) {
		case "action1":RequestDispatcher dis1=request.getRequestDispatcher("ApplicantLogin.html");
		               dis1.forward(request,response);
		               break;
		case "action2":
		RequestDispatcher dis2=request.getRequestDispatcher("AdminLogin.html");
		dis2.forward(request,response);
		break;
		case "action3":
		RequestDispatcher dis3=request.getRequestDispatcher("Register.html");
		dis3.forward(request,response);
		break;
		default:break;
	}
	}

}
