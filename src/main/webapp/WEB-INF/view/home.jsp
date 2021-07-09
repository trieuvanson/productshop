<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>View API</title>
</head>
<body>
<table>
    <tbody>
    <c:forEach items="${links}" var="link">
        <tr>
            <td><a href="${url}${link}/">${link}-api</a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>