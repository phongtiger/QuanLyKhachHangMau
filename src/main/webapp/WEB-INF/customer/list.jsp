<%--
  Created by IntelliJ IDEA.
  User: phongtiger
  Date: 26/09/2019
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="${pageContext.request.contextPath}/create">Create new customer</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["customers"]}' var="customer">
        <tr>
            <td><a href="/view/${customer.getId()}">${customer.getName()}</a></td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="/edit/${customer.getId()}">edit</a></td>
            <td><a href="${pageContext.request.contextPath}/delete/${customer.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
