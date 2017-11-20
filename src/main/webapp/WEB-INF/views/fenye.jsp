<%--
  Created by IntelliJ IDEA.
  User: zzy
  Date: 2017/10/9
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${userList}" var="user" begin="${(pageNos-1)*2 }"
           end="${pageNos*2-1}">
    <center>
        <div>${user.username}</div>
    </center>
    <center>
        <div>${user.password}</div>
    </center>
</c:forEach>
<center>
    <c:if test="${pageNos>1 }">
        <a href="pageServlet?pageNos=1" >首页</a>
        <a href="pageServlet?pageNos=${pageNos-1 }">上一页</a>
    </c:if>
    <c:if test="${pageNos <countPage }">
        <a href="pageServlet?pageNos=${pageNos+1 }">下一页</a>
        <a href="pageServlet?pageNos=${countPage }">末页</a>
    </c:if>
</center>
<form action="pageServlet">
    <h4 align="center">共${countPage}页
        <input type="text" value="${pageNos}" name="pageNos" size="1">页
        <input type="submit" value="go">
    </h4>
</form>
</body>
</html>
