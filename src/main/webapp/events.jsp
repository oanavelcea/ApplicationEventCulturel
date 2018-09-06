<%@page language="java" isELIgnored="false" isErrorPage="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<h2>Liste des évènements</h2>

	<table border="1">
		<tr>
			<th>Titre</th>
			<th>Ville</th>
			<th>Date de début</th>
			<th>Date de fin</th>
		</tr>
		<c:forEach var="evt" items="${events}">
			<tr>
				<td>${evt.title}</td>
				<td>${evt.city}</td>
				<td>
					<fmt:formatDate value="${evt.dateStart}" pattern="dd/MM/yyyy" />
				</td>
				<td>
					<fmt:formatDate value="${evt.dateEnd}" pattern="dd/MM/yyyy" />
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
