<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h1>Meals</h1>
<table border="1" cellpadding="1">
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th></th>
        <th></th>
    </tr>
    <jsp:useBean id="mealTos" scope="request" type="java.util.List"/>
    <c:forEach var="meal" items="${mealTos}">
        <tr>
            <td>${meal.dateTime}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td>update</td>
            <td>delete</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
