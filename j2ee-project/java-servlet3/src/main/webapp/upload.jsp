<%@ page contentType="text/html; charset=GBK" language="java"
	errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>文件上传</title>
<meta name="website" content="http://blog.longjiazuo.com/" />
</head>
<body>
	<form method="post" action="upload" enctype="multipart/form-data">
		文件名：<input type="text" id="name" name="name" /><br /> 选择文件：<input
			type="file" id="file" name="file" /><br /> <input type="submit"
			value="上传" /><br />
	</form>
</body>
</html>