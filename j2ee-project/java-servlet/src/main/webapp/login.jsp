<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> 用户登录 </title>
	<meta name="website" content="http://blog.longjiazuo.com/" />
</head>
<body>
<!-- 输出出错提示 -->
<span style="color:red;font-weight:bold">
<%
if (request.getAttribute("err") != null)
{
	out.println(request.getAttribute("err") + "<br/>");
}
%>
</span>
请输入用户名和密码：
<!-- 登录表单，该表单提交到一个Servlet -->
<form id="login" method="post" action="login">
用户名：<input type="text" name="username"/><br/>
密&nbsp;&nbsp码：<input type="password" name="pass"/><br/>
<input type="submit" value="登录"/><br/>
</form>
</body>
</html>