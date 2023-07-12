<%@page import="jp.hit.coffeebeans.bean.Item"%>
<%@page import="java.util.List" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

    @SuppressWarnings("unchecked")
    List<Item> items = (List<Item>) request.getAttribute("items");

%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コーヒー豆検索結果</title>
</head>
<body>
     <table border="1">
         <tr bgcolor="#8eafed">
             <th>商品名</th>
             <th>原産地域</th>
             <th>原産国</th>
             <th>価格</th>
             </tr>
             
             <% for(Item item : items) { %>
             <tr>
                <td><%= item.getName() %></td>
                <td><%= item.getArea() %></td>
                <td><%= item.getOriginalHome() %></td>
                <td><%= item.getPrice() %></td>
             <% } %>
     </table>

</body>
</html>