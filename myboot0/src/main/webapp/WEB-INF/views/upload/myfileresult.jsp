<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${name }</h3>
<c:forEach items="${vo }" var="vo">
<h3><a href='/upload/${vo.filename1}'>${vo.filename1}</a></h3>
<h3><a href='/upload/${vo.filename2}'>${vo.filename2}</a></h3>
</c:forEach>
</body>
</html>