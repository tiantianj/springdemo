<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>帖子列表</title>
</head>
<body>
    <h1>帖子列表</h1>
    <table>
        <tr>
            <td>标题</td>
            <td>内容摘要</td>
            <td>作者</td>
            <td>发布时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${post}" var="post">
            <tr>
                <td>${post.title}</td>
                <td>${post.summary}</td>
                <td>${post.author}</td>
                <td>
                    <fmt:formatDate value="${post.createDate}" pattern="yyyy-MM-dd" />
                </td>
                <td>
                    <a href="post/${post.id}/replies">查看回复</a>|
                    <a href="#">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
