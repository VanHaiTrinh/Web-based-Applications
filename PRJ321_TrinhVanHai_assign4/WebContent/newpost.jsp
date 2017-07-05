<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="web.*"%>
<%@page import="java.util.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
				<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		
				<title>New Post</title>
		
				 <link href="css/bootstrap.css" rel="stylesheet">
				 
				 <style type="text/css">
					body {
					  padding: 70px 0px;
					}
				</style>
				<script src="ckeditor/ckeditor.js"></script>
</head>

    <body>
		<% if(request.getSession().getAttribute("user") == null) {
				response.sendRedirect("login.jsp");
			}else{ %>
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

	            <div class="collapse navbar-collapse">
	                    <ul class="nav navbar-nav navbar-right">
	                        <li><a href="/PRJ321_TrinhVanHai_assign4/LogoutAPI">Logout</a></li>
	                    </ul>
	                </div>
	           </div>
	</nav>           
<!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ -->	
        <div class="container">
            <div class="container center-block" >
                <form class="form-signin" action="/PRJ321_TrinhVanHai_assign4/InsertAPI" method="POST">
                    <br>
                    <h2 class="form-signin-heading">Write a new Post : </h2>
                    <br>
                    <p><strong>Title : </strong></p>
                    <input name="txtTitle" type="text" class="form-control" value="<%= request.getAttribute("txtTitle")%>">
                    <br>
                    <p><strong>Description: </strong></p>
                    <input name="txtDescription" type="text" class="form-control" value="<%= request.getAttribute("txtDescription")%>">
                    <br>
                    <p><strong>Content : </strong></p>
                    <textarea class="ckeditor" name="editor1"  rows="15" cols="8"> </textarea>
                    <br>
                    <br>
                    <input type="Submit" value="Publish">
                    <br>
                </form>
           </div> 
			<% if(request.getAttribute("message")!=null){%>
				<h2 style = "color:red;"><%= request.getAttribute("message")%></h2>
			<%};%>
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
<% }%>
    </body>
</html>
