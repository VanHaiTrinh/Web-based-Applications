package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterAPI
 */
@WebServlet("/RegisterAPI")
public class RegisterAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String txtUsername = request.getParameter("txtUsername");
			String txtPassword = request.getParameter("txtPassword");
	       
	        if(txtUsername==""||txtPassword==""){
	        	 request.setAttribute("txtUsername",txtUsername);
	    		 request.setAttribute("txtPassword",txtPassword);
	        	 request.setAttribute("message","User and Password must be not empty!");
	        	 request.getRequestDispatcher("/register.jsp").forward(request, response);	
	        }else{
	        	DbManager db = new DbManager();
	 	        User user = new User();
	 	        user.Username= txtUsername;
	 	        user.Password = txtPassword;
			        if( db.Register(user)==1){
			        	 request.setAttribute("txtUsername",txtUsername);
			    		 request.setAttribute("txtPassword",txtPassword);
			        	 request.setAttribute("message","Register success!");
			        	 request.getRequestDispatcher("/register.jsp").forward(request, response);	
			        }else{
			        	request.setAttribute("txtUsername",txtUsername);
			    		request.setAttribute("txtPassword",txtPassword);
			        	request.setAttribute("message","Error: Cann't Register this User , it may be already exist...!");
			        	request.getRequestDispatcher("/register.jsp").forward(request, response);	
			        }
	        }
	    
	}

}
