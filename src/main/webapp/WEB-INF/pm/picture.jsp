<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        enctype="multipart/form-data" 设置表单内容以多部分提交，普通表单元素依然是字符串，文件对象使用二进制形式提交
    --%>
    <sf:form modelAttribute="picture" method="post" enctype="multipart/form-data" >
        <sf:label path="name">名称</sf:label><sf:input path="name"/><br>
        <label for="file">图片</label>
        <input type="file" name="file" id="file">
        <button type="submit">上传图片</button>
    </sf:form>



</body>
</html>
