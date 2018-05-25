<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/pictures/add">新增图片</a>
    <c:forEach items="${pictureList}" var="p">
        <img src="${pageContext.request.contextPath}/${p.url}" title="${p.name}"><br>
    </c:forEach>
    <br>
    <button>获取图片</button>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script>
        $(function(){
           $("button").click(function(){
               $.get("${pageContext.request.contextPath}/pictures/1",function(data){
                   alert(data.name);
               },"json");
           });
        });
    </script>
</body>
</html>
