package web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertAPI
 */
@WebServlet("/InsertAPI")
public class InsertAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/newpost.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		
		String txtTitle = request.getParameter("txtTitle");
		String txtDescription = request.getParameter("txtDescription");
		String txtContent = request.getParameter("editor1");
		String txtPublishDate = date.toString();
		String txtAuthor = (String) request.getSession().getAttribute("user");

        DbManager db = new DbManager();
        Post newPost = new Post();
        
        newPost.PostTitle = txtTitle;
        newPost.PostDescription = txtDescription;
        newPost.PostContent = txtContent;
        newPost.PublishDate = txtPublishDate;
        newPost.PostAuthor = txtAuthor;
        
        if(db.InsertPost(newPost)==1){
        	request.setAttribute("txtTitle",txtTitle);
        	request.setAttribute("txtDescription",txtDescription);

       	 request.setAttribute("message","Post success!");
       	 request.getRequestDispatcher("/newpost.jsp").forward(request, response);	
        }else{
        	 request.setAttribute("message","Post Error!");
           	 request.getRequestDispatcher("/newpost.jsp").forward(request, response);	
        }
        
	}

}
