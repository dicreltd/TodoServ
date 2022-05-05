<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo変更</title>
</head>
<body>
<h1>Todo変更</h1>

<form action="todo" method="post">
<input type="hidden" name="tid" value="${todo.tid}">
タイトル：<input type="text" name="title" value="${todo.title}"><br>
状態：
<select name="tcheck">
	<c:if test="${todo.tcheck==0}">
		<option value="0" selected>未</option>
		<option value="1">済み</option>
	</c:if>
	<c:if test="${todo.tcheck==1}">
		<option value="0">未</option>
		<option value="1" selected>済み</option>
	</c:if>
</select><br>
<input type="submit" value="変更">
</form>

<form action="tododel" method="get">
<input type="hidden" name="tid" value="${todo.tid}">
<input type="submit" value="削除">
</form>


</body>
</html>