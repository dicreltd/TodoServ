<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除の確認</title>
</head>
<body>

<h1>削除の確認</h1>

<p>タイトル：${todo.title}</p>

<p>日付：${todo.atime}</p>

<p>状態：${todo.status}</p>


<form action="tododel" method="post">
<input type="hidden" name="tid" value="${todo.tid}">
<input type="submit" value="削除">
</form>
</body>
</html>