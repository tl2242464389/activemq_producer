<%--
  User: tl
  Date: 2019-06-07
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/sendMessage" method="post">
        收件人：<input type="text" name="to"/><br>
        主题：<input type="text" name="subject"/><br>
        正文：<textarea name="content" cols="20" rows="3"></textarea><br>
        发送：<input type="submit" value="发送"/>
    </form>
</body>
</html>
