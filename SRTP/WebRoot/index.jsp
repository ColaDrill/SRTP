<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title><s:text name=" Login in SRTP" /></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<div class="jumbotron">
		<h1>Hello, world!</h1>
		<p>Businesses like to have memorable telephone numbers. One way to
			make a telephone number memorable is to have it spell a memorable
			word or phrase. For example, you can call the University of Waterloo
			by dialing the memorable TUT-GLOP. Sometimes only part of the number
			is used to spell a word. When you get back to your hotel tonight you
			can order a pizza from Gino's by dialing 310-GINO. Another way to
			make a telephone number memorable is to group the digits in a
			memorable way. You could order your pizza from Pizza Hut by calling
			their ``three tens'' number 3-10-10-10. The standard form of a
			telephone number is seven decimal digits with a hyphen between the
			third and fourth digits (e.g. 888-1200). The keypad of a phone
			supplies the mapping of letters to numbers, as follows:</p>
		<p>
			<a class="btn btn-primary btn-lg" href="login.html" role="button">Learn more</a>
		</p>
	</div>
	
	<footer class="footer">
	<div class="container">
		<p class="text-muted">Place sticky footer content here.</p>
	</div>
	</footer>

<script type="text/javascript"	src="http://libs.baidu.com/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript"  src="lib\bootstrap\bootstrap.min.js"></script>
<link rel="stylesheet" href="lib\css\bootstrap.min.css">

</body>

</html>
