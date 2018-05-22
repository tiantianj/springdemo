<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>回帖列表</title>
</head>
<body>
<h1>回帖列表</h1>
<table>
    <tr>
        <td>回复内容</td>
        <td>回复昵称</td>
        <td>发布时间</td>
    </tr>
    <c:forEach items="${replies}" var="reply">
        <tr>
            <td>${reply.content}</td>
            <td>${reply.author}</td>
            <td>
                <fmt:formatDate value="${reply.createDate}" pattern="yyyy-MM-dd" />
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
