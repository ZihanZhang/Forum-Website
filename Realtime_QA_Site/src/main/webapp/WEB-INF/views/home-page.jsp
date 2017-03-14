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
      <security:authorize access="hasRole('ROLE_ADMIN')">
      You are an administrator!
      </security:authorize>
      <div class="alert alert-success fade in">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
        <p><strong>Tip</strong></p>
        Want to get help? Log in!
      </div>
      <security:authorize access="hasRole('ROLE_ADMIN')">
      	<p><button type="button" class="btn btn-primary btn-lg " onclick="location.href='/realtime/admin-manage/administration'" >Administration</button></p>
      </security:authorize>
      <security:authorize access="hasRole('ROLE_USER')">
      	<p><button type="button" class="btn btn-primary btn-lg " onclick="location.href='questionsubmission'" >Submit Questions</button></p>
      </security:authorize>
      <security:authorize access="hasRole('ROLE_USER')">
      	<p><button type="button" class="btn btn-primary btn-lg " onclick="location.href='<c:url value="/j_spring_security_logout" />'" >Logout</button></p>
      </security:authorize>
      <div class="well" >
      	<security:authorize access="hasRole('ROLE_USER')">
      		  Hi, <security:authentication property="name"/>
      	</security:authorize>
      </div>
      
      <security:authorize access="hasRole('ROLE_USER')">
       <p><b>Exp:${curuser.exp}</b></p>
      </security:authorize>
      
      <security:authorize access="hasRole('ROLE_USER')">
       <p><b>LV:${curuser.exp/100+1}</b></p>
      </security:authorize>
      
      <security:authorize access="hasRole('ROLE_USER')">
	  <div class="progress">
			<div class="progress-bar" role="progressbar" aria-valuenow="60"
		 	aria-valuemin="0" aria-valuemax="100" style="width: ${(curuser.exp)%100}%;">
			<span class="sr-only">40%</span>
	        </div>
	  </div>
	  </security:authorize>
      
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
    
              <c:if test="${!empty questionList}">
				<c:forEach items="${questionList}" var="qt">
      <div class="row">
        <div class="col-sm-12">
          <div class="panel panel-default text-left" style="background:#DDDDDD">
            <div class="panel-body">
            	

						<b><big>${qt.question}</big></b><br>
						<button type="button" class="btn btn-default btn-sm">
                			<span class="glyphicon glyphicon-thumbs-up"></span> Like
              			</button>    
             			<button type="button" class="btn btn-default btn-sm">
                			<span class="glyphicon glyphicon-thumbs-up"></span> Dislike
              			</button>  
              			<c:forEach items="${answerList}" var="as">
           					 <c:if test="${((as.question.question == qt.question)&&(as.answer != null))}">
              			<div class="row">
        					<div class="col-sm-12">
         				 		<div class="well">

           					 				<b>${as.answer}</b>
         				 		</div>
        					</div>
      					</div>   
      					     </c:if>
           				</c:forEach>
      					<form:form role="form" modelAttribute="answer" action="submission" method="post">
  							<div class="form-group">
    							<label for="name">Answer:</label>
    							<form:input path="answer" class="form-control" /><form:errors path="question" />
    							<input type="hidden" name="questionid" value="${qt.id }">
  							</div>
  							<button type="submit" class="btn btn-primary">Submit</button>
						</form:form>

      			
            </div>
          </div>
        </div>
      </div>
				</c:forEach>
          </c:if> 
   
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