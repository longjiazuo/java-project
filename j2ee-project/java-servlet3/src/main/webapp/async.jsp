<%@ page contentType="text/html; charset=GBK" language="java"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul>
	<c:forEach items="${books}" var="book">
		<li>${book}</li>
	</c:forEach>
</ul>
<%
	out.println("业务调用结束的时间：" + new java.util.Date());
	//完成异步调用
	//request.getAsyncContext().complete();
%>
