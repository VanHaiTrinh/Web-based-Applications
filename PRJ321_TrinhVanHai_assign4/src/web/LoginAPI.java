package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginAPI
 */
@WebServlet("/LoginAPI")
public class LoginAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtUsername = request.getParameter("txtUsername");
		String txtPassword = request.getParameter("txtPassword");
        DbManager db = new DbManager();
        
        
        if( db.Login(txtUsername,txtPassword)==1){
        	 HttpSession session = request.getSession();
			 session.setAttribute("user",txtUsername);
        	 request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        else{
        	request.setAttribute("txtUsername",txtUsername);
    		request.setAttribute("txtPassword",txtPassword);
        	request.setAttribute("message","Error: Invalid user or password");
        	request.getRequestDispatcher("/login.jsp").forward(request, response);	
        }
        
    
	}

}
