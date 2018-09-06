<%@page language="java" isELIgnored="false" isErrorPage="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<body>
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		crossorigin="anonymous">
	<title>Inscription</title>
</head>
<body>
	<h1>Inscription</h1>
	<form action="Inscription" method="post">
		<input type="text" id="firstName" name="firstName" value="" placeholder="Entrez votre prénom"/>
		<input type="text" id="lastName" name="lastName" value="" placeholder="Entrez votre prénom"/>
	</form>

</body>
</html>