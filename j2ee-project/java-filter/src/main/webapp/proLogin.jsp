<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> 登录页面 </title>
	<meta name="website" content="http://blog.longjiazuo.com/" />
</head>
<body>
<h2>登录页面</h2>
<%
session.setAttribute("user" 
	, request.getParameter("name"));
%>
登录成功，可以访问该应用的其他页面
</body>
</html>