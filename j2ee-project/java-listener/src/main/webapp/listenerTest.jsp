<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> ����ServletContextListener </title>
	<meta name="website" content="http://blog.longjiazuo.com/" />
</head>
<body>
������ֱ�Ӵ�application��ȡ�����ݿ����ӣ�<br/>
��ִ�в�ѯ��Ľ��<br/>
<%
Connection conn = (Connection)application.getAttribute("conn");
//����Statement����
Statement stmt = conn.createStatement();
//ִ�в�ѯ
ResultSet rs = stmt.executeQuery("select * from news_inf");
%>
<table bgcolor="#9999dd" border="1" width="300">
<%
//���������
while(rs.next())
{
%>
<tr>
<td><%=rs.getString(1)%></td>
<td><%=rs.getString(2)%></td>
</tr>
<%
}
%>
<table>
</body>
</html>