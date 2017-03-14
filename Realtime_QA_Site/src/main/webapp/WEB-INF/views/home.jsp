<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>Spring MVC + Bootstrap</title>        
    <link href="./resources/bootstrap.min.css" rel="stylesheet" />  
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
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="log"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>


<div class="jumbotron" style="background-image:url('./resources/3.gif');">  
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
      <div class="well">
        <p><a href="#">My Profile</a></p>
        <img src="bird.jpg" class="img-circle" height="65" width="65" alt="Avatar">
      </div>
      <div class="well">
        <p><a href="#">Interests</a></p>
        <p>
          <span class="label label-default">News</span>
          <span class="label label-primary">W3Schools</span>
          <span class="label label-success">Labels</span>
          <span class="label label-info">Football</span>
          <span class="label label-warning">Gaming</span>
          <span class="label label-danger">Friends</span>
        </p>
      </div>
      <div class="alert alert-success fade in">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
        <p><strong>Ey!</strong></p>
        People are looking at your profile. Find out who.
      </div>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    <div class="col-sm-9">
    
      <div class="row">
        <div class="col-sm-12">
          <div class="panel panel-default text-left">
            <div class="panel-body">
            	
<form:form class="form-horizontal" role="form" modelAttribute="user" action="home-page" method="post">
  <div class="form-group">
    <form:label class="col-sm-2 control-label" for="username" path="username">Username:</form:label>
    <div class="col-sm-10">
      <form:input path="username" class="form-control" id="username" type="text" /><form:errors path="username" />
    </div>
  </div>
    <div class="form-group">
    <form:label class="col-sm-2 control-label" for="password" path="password">Password:</form:label>
    <div class="col-sm-10">
      <form:input path="password"  class="form-control" id="focusedInput" type="password" /><form:errors path="password" />
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</form:form>
            	   
            </div>
          </div>
        </div>
      </div>
   
    </div>
    
    
    <!-- 
    <div class="col-sm-2 well">
      <div class="thumbnail">
        <p>Upcoming Events:</p>
        <img src="paris.jpg" alt="Paris" width="400" height="300">
        <p><strong>Paris</strong></p>
        <p>Fri. 27 November 2015</p>
        <button class="btn btn-primary">Info</button>
      </div>      
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div>
     -->
  </div>
</div>
      
<!--   
<div class="container">


<c:if test="${!empty questionList}">
			<table>
				<c:forEach items="${questionList}" var="qt">
					<tr>
						<td>${qt.question}</td>
					</tr>
				</c:forEach>
			</table>
</c:if>

<c:if test="${!empty answerList}">
			<table>
				<c:forEach items="${answerList}" var="as">
					<tr>
						<td>${as.answer}</td>
					</tr>
				</c:forEach>
			</table>
</c:if> --> 

	  <hr>
      <footer>  
        <p>Author:Zihan Zhang</p>  
      </footer>  

    <script type="text/javascript" src="./resources/jquery-3.1.1.js"></script>  
    <script type="text/javascript" src="./resources/bootstrap.min.js"></script>  
</body>
</html>