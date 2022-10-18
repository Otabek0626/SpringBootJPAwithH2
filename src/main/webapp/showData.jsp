<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="alien" items="${aliens}">
                    <tr>
                        <td>${alien.id}</td>
                        <td>${alien.name}</td>
                        <td>${alien.age}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>