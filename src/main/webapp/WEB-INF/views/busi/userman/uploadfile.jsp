<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<title>上传图片</title>  
</head>
<body>  
<form action="${contextPath }/manuser/upload" method="post" enctype="multipart/form-data">  
<input type="file" name="file" /> <input type="submit" value="Submit" /></form>  
</body>  

</html>
