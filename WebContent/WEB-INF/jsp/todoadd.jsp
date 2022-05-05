<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>追加の確認</title>
</head>
<body>
<h1>追加の確認</h1>

<p>内容：${title}</p>

<p>追加しますか？</p>

<form action="todolist" method="post">
<input type="hidden" name="title" value="${title}">
<input type="submit" value="追加">
</form>

</body>
</html>