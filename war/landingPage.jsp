<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="triichat.OfyService" %>
<%--
  Created by IntelliJ IDEA.
  User: anoop
  Date: 2/9/16
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<div id="title">
    <p>Trii Chat</p>
</div>
<%

    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if(user != null){
%>
<p>Welcome, <%= user.getNickname() %></p>
<%
    	triichat.User triiUser = triichat.User.findUser(user);
    	if(triiUser != null){
    		//go to user page
    	}else{
%>
<p>You have not created an account with TriiChat. Would you like to create a TriiChat account?</p>
<form action="userPage.jsp">
    <input type="submit" value="Create TriiChat User">
</form>
<%	
    	}
%>
<a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">Sign out</a></p>
<%
    }else{
%>
<a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in</a>
<%
    }

%>




</body>
</html>
