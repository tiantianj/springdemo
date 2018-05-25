<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="#">新增图片</a>
    <c:forEach items="${pictureList}" var="p">
        <img src="${p.url}" title="${p.name}"><br>
    </c:forEach>
</body>
</html>
