<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="web.*"%>
<%@page import="java.util.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
			<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	       	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	       	
			<title>My Blog</title>
		
			<link href="css/bootstrap.css" rel="stylesheet">
		
			<style type="text/css">
				body {
				  padding: 70px 0px;
				}
			</style>
	
</head>
<body>
<!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ -->	
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="posts.jsp">Home</a>
                </div>

                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="newpost.jsp">NewPost</a></li>
                        <li><a href="register.jsp">Register</a></li>
                        	<%if(request.getSession().getAttribute("user") != null) {%>
		                <li><a href="/PRJ321_TrinhVanHai_assign4/LogoutAPI">Logout</a></li>
							<%}else{%>
				    	<li><a href="login.jsp">Login</a></li>
	                   		<%}%> 
                    </ul>
               </div>
           </div>
	</nav>                        
<!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ -->	
		<div class="section">
		
                <div class="col-lg-8 col-md-8 col-xs-8 col-sm-8 
	                col-lg-offset-2 col-md-offset-2 col-xs-offset-2 col-sm-offset-2">
		
							<% DbManager db = new DbManager();
							
							int pages =1,fist=0,last=0,total=0;
							if(request.getParameter("pages")!=null){
		                    	pages = Integer.parseInt(request.getParameter("pages"));
		                    }
							total = db.GetPosts();
							if(total<4){
		                    	fist =0;
		                    	last = total;
		                    }else{
		                    	fist = (pages-1)*3;
		                    	last = 3;
		                    }
							ArrayList<Post> listPost = db.GetPostByNav(fist, last);             
							%>
							
		                    <% for (Post post:listPost) {
		                    %>
		                    <div>
		                        <h2><%= post.PostTitle%></h2>
		                        <p><%= post.PostDescription%></p>
		                        <p> Author : <strong> <%= post.PostAuthor %> </strong> </p>
		                        <p> Public : <strong> <%= post.PublishDate %> </strong> </p>
		                        <a href="postDetail.jsp?id=<%= post.ID%>" class="btn btn-primary">Read More...</a>
		                        <a href="edit.jsp?id=<%= post.ID%>" class="btn btn-success">Edit This Post!</a>
		                        
		                    </div>
		                    <%}%>
		                    <br>
		                    <br>
		                    
		                <div class="col-lg-8 col-md-8 col-xs-8 col-sm-8 
		                col-lg-offset-2 col-md-offset-2 col-xs-offset-2 col-sm-offset-2">
		                    <ul >
		                    	<% for(int i=1;i<=(total/3)+1;i++){%>
		                    		   <li style="display:inline-block; width:20px;"><a href = "posts.jsp?pages=<%=i%>"><%=i%></a></li>
		                    	<%}%>
		                    </ul>
		                </div>
               </div>
        </div>
<!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ -->	
		<div class="container col-lg-8 col-md-8 col-xs-8 col-sm-8
		  col-lg-offset-2 col-md-offset-2 col-xs-offset-2 col-sm-offset-2" >
	            <hr>
	            <footer>
	                <div class="row">
	                    <div class="col-lg-12">
	                        <p>Copyright &copy; VanHai2017</p>
	                    </div>
	                </div>
	            </footer>
        </div>
<!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ -->	
		<script src="js/jquery-1.10.2.js"></script>
        <script src="js/bootstrap.js"></script>
</body>
</html>