<%--
  Created by IntelliJ IDEA.
  User: sorra
  Date: 28/10/2566
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>singup</title>
</head>
<body>
<h3>Sing Up</h3>
<c:if test="${message != null}"> <p style="color: red">${message}</p></c:if>
<form action="singup" method="post">
    Name:  <input type="text" name="Name"><br>
    Email:  <input type="email" name="Email"><br>
    Username:  <input type="text" name="Username"><br>
    Password:  <input type="password" name="Password"><br>
    <input type="submit" value="Sing Up">
</form>
</body>
</html>
