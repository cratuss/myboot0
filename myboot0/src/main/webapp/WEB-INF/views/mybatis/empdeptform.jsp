<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here/</title>
<script src="/multi/resources/jquery-3.2.1.min.js"></script>
<script>
/* $(document).ready(function(){
	$("checkbox").one("click", function(){
		$.ajax({
			
			
			
			
		});
		
	});
	
	
}); */
</script>


</head>
<body>

<h1>사원 번호</h1>
<form action="/empdeptlist" method="post">
<% for(int i=1; i<=10; i++){ %>
	<input type="checkbox" name="id" value="<%=i*10%>"> <%=i*10 %> <br>
<%} %>
	<input type="text" name="pw">
	<input type="submit" value="검색">
</form>	



</body>
</html>