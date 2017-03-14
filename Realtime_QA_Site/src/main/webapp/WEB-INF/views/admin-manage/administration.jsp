<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>Spring MVC + Bootstrap</title>        
    <link href="../resources/bootstrap.min.css" rel="stylesheet" />  
    <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
  }

  </style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Ansk</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Projects</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="log"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>


<div class="jumbotron" style="background-image:url('../resources/3.gif');">  
      <div class="container">  
        <h1>Ansk</h1>  
        <p>  
                Professional Q&A Platform 
        </p>  
        <p>  
        <a class="btn btn-primary btn-lg" href="home" role="button">Join us Now!</a>  
        </p>  
      </div>  
</div>  

<div class="container text-center">    
  <div class="row">
    <div class="col-sm-3 well">
      <div class="alert alert-success fade in">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
        <p><strong>Tip</strong></p>
        Want to get help? Log in!
      </div>
      <security:authorize access="hasRole('ROLE_USER')">
      	<p><button type="button" class="btn btn-primary btn-lg " onclick="location.href='questionsubmission'" >Submit Questions</button></p>
      </security:authorize>
      <div class="well" >
      	<security:authorize access="hasRole('ROLE_USER')">
      		 <b>Hi,<security:authentication property="name"/></b>
      	</security:authorize>
      </div>
      <div class="well" style="background:#FFCCCC">
        <p><b>Fields</b></p>
        <p>
          <span class="label label-default">Coding</span>
          <span class="label label-primary">Science</span>
          <span class="label label-success">Jobs</span>
          <span class="label label-info">Health</span>
          <span class="label label-warning">Games</span>
          <span class="label label-danger">Sports</span>
        </p>
      </div>
            <div class="well">
        <p><b>Contact</b></p>
	     	<p><a href="#">Facebook</a></p>
      		<p><a href="#">Instagram</a></p>
      		<p><a href="#">Whatsapp</a></p>
      		<p><a href="#">Wechat</a></p>
      </div>
    </div>
    <div class="col-sm-9">
			<table class="table">
  				<caption>User Information</caption>
  				<thead>
    				<tr>
      					<th>Username</th>
      					<th>Password</th>
    				</tr>
  				</thead>
  				<tbody>
  				<c:forEach items="${userList}" var="us">
    				<tr>
      					<td>${us.username}</td>
      					<td>${us.password}</td>
    				</tr>
    			</c:forEach>
  				</tbody>
			</table>
			
	<div class="panel panel-default text-left" style="background:#DDDDDD">
        <div class="panel-body">	
        <p><b>Please input the user name you want to delete</b></p>
			<form:form role="form" action="/realtime/admin-manage/administration" method="post">
  					<div class="form-group">
    						<label for="usern">Username:</label>
    						<input type="text" name="usern" />
  					</div>
  					<button type="submit" class="btn btn-primary">Delete</button>
			</form:form>
		</div>
	</div>
	
	<div class="panel panel-default text-left" style="background:#DDDDDD">
        <div class="panel-body">
        <p><b>Please input the user name you want to promote</b></p>
			<form:form role="form" action="/realtime/admin-manage/administration/auth" method="post">
  					<div class="form-group">
    						<label for="userna">Username:</label>
    						<input type="text" name="userna" />
  					</div>
  					<button type="submit" class="btn btn-primary">Promote</button>
			</form:form>
	   </div>
    </div>
</div>
	  <hr>
      <footer>  
        <p>Author:Zihan Zhang</p>  
      </footer>  

    <script type="text/javascript" src="../resources/jquery-3.1.1.js"></script>  
    <script type="text/javascript" src="../resources/bootstrap.min.js"></script>  
</body>