<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加回帖</title>
</head>
<body>
    <%--Spring表单标签通过命令对象以及路径的方式，将表单元素与控制器中的模型对象相绑定--%>
    <%--使用modelAttribute绑定控制器传回的对象名称--%>
    <sf:form  method="post" modelAttribute="reply">
        <%--
            相当于HTML中input：type=hidden
            path:相当于id，name属性，并且属性名必须是form标签中commandName对象的属性名
        --%>
        <sf:hidden path="postId"/>
        <%--相当于HTML中的input，并且默认的type为text--%>
        <sf:label path="content">回复内容</sf:label><sf:input path="content"/><sf:errors path="content"/><br/>
        <sf:label path="author">昵称</sf:label><sf:input path="author"/><sf:errors path="author"/><br/>
        <input type="submit" value="提交"/><input type="reset" value="重置"/>
    </sf:form>

    <script src="${pageContext.request.contextPath}/js/jquery.js" ></script>
    <%--<script src="${pageContext.request.contextPath}/js/validateReply.js" ></script>--%>
</body>
</html>
