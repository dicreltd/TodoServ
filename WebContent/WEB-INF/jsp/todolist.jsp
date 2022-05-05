<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todoリスト</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Todoリスト</h1>

<form action="todoadd" method="get">
内容：<input type="text" name="title" required>
<input type="submit" value="追加">
</form>

<table>
<tr><th>状態</th><th>内容</th><th>日付</th></tr>
<c:forEach items="${list}" var="t">
	<tr>
		<td>
			${t.status}
		</td>
		<td><a href="todo?tid=${t.tid}">${t.title}</a></td>
		<td>${t.atime}</td>
	</tr>
</c:forEach>
</table>

</body>
</html>