package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditAPI
 */
@WebServlet("/EditAPI")
public class EditAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        DbManager db = new DbManager();
        Post p = new Post();
         p.PostTitle = request.getParameter("txtTitle");
         p.PostDescription = request.getParameter("txtDescription");
         p.PostContent = request.getParameter("ckeditor");
        if (db.EditPost(id,p) == 1) {
        	 request.setAttribute("message","Edit success!");
        	 request.setAttribute("id",id);
           	 request.getRequestDispatcher("/edit.jsp").forward(request, response);
        } else {
        	 request.setAttribute("message","Error Edit!");
        	 request.setAttribute("id",id);
           	 request.getRequestDispatcher("/edit.jsp").forward(request, response);
        }	}

}
