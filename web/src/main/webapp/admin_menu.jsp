<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14.09.2019
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:out value="hello ${authUser.login} you role is ${authUser.role}"/><br>
    <a href="${pageContext.request.contextPath}/logout">logout</a><br><br>
    <a href="${pageContext.request.contextPath}/new_event/chose_league/">add new event</a><br><br>




</body>
</html>