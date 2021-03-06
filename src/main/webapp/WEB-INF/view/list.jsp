<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="resource/css/list.css">
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/My97DatePicker/WdatePicker.js"></script>

</head>
<body>

	<table>
		
		<tr>
			<td>编号</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>已售百分比</td>
		</tr>
		<c:forEach items="${list}" var="l">
		
			<tr>
				<td>${l.id}</td>
				<td>${l.name}</td>
				<td>${l.price}</td>
				<td>${l.baifen}</td>
			</tr>
		
		</c:forEach>
		<tr>
		<td>
		
			<a href="${pageContext.request.contextPath}/findAll?page=${prePage}">上一页</a>
			<a href="${pageContext.request.contextPath}/findAll?page=${nextPage}">下一页</a>
		</td>
		</tr>
	</table>



</body>
</html>