<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

  int orderId = (Integer) request.getAttribute("orderId");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コーヒー豆注文完了</title>
</head>
<body>
　　　<h1>注文完了</h1>
　　　注文ID : <%= orderId %>
</body>
</html>