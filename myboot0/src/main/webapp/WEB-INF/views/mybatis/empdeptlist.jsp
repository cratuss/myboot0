<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here/</title>


</head>
<body>

<h1>선택한 부서번호는</h1>
<c:forEach items="${paramValues.id }" var="ido">
<h3>${ido }</h3>
</c:forEach>

<%=request.getAttribute("pw") %>
${param.pw }

<c:forEach items="${empone }" var="emp">
<h3>이름 : ${emp.last_name } ${emp.first_name } 부서코드 : ${emp.department_id } 급여정보 : ${emp.salary }</h3>
</c:forEach>

</body>
</html>