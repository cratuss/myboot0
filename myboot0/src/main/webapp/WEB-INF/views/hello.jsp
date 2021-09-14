<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery-3.2.1.min.js"></script>
<script>



$(document).ready(function(){
	$("#ajax_btn").on("click", function(){
		$.ajax({
			url : '/helloajax',
			type : 'get',
			success : function(serverdata){
					for(var i=0; i<serverdata.length; i++){
						$("#result").append("<h3>" + serverdata[i] + "</h3>");
					}
			}
		});
		
	});
});

</script>
</head>
<body>

<h1>전달받은 모델: ${insa }</h1>
<c:forEach items="${list }" var="subject">
	<h1>${subject }</h1>
</c:forEach>


<button type="button" id="ajax_btn">ajax로 요청한 결과를 출력합니다.</button>
<div id="result"></div>

<img src="/images/americano.jpg">

<img src="/upload/images/americano.jpg">



</body>
</html>