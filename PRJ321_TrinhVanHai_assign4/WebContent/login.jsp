<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
				<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		
				<title>Login</title>
		
				 <link href="css/bootstrap.css" rel="stylesheet">
				 
				 <style type="text/css">
					body {
					  padding: 70px 0px;
					}
				</style>
</head>
<body>
<% if(request.getSession().getAttribute("user") != null) {
				response.sendRedirect("posts.jsp");
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
	                </div>
	                <div class="navbar-header">
	                    <a class="navbar-brand" href="posts.jsp">Home</a>
	                </div>
	                <div class="collapse navbar-collapse">
	                    <ul class="nav navbar-nav navbar-right">
	                        <li><a href="register.jsp">Register</a></li>
	                    </ul>
	                </div>
	           </div>
	 	</nav>                        
<!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ -->	
        <div class="container">
            <div class="container center-block" style="width: 450px;">
                <form class="form-signin" action="/PRJ321_TrinhVanHai_assign4/LoginAPI" method="POST" >
                    <br>
                    <br>
                    <h2 class="form-signin-heading">Please Login</h2>
                    <br>
                    User: <input name="txtUsername" type="text" class="form-control" value="<%= request.getAttribute("txtUsername")%>">
                    <br>
                    Password: <input name="txtPassword" type="password" class="form-control" value="<%= request.getAttribute("txtPassword")%>">
                    <br>
                    <input type="Submit" value="OK">
                    <br>
                </form>
                <hr>
            </div> 
            
 			<% if(request.getAttribute("message")!=null){%>
			<h2 style = "color:red;"><%= request.getAttribute("message")%></h2>
			<%};%>
<!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ -->	
        <div class="container">
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