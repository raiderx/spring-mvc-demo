<%--
	@author Pavel Karpukhin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title> Users </title>
		<script type="text/javascript">
			function deleteUser(id) {

			}
		</script>
	</head>
	<body>
		<table>
			<tr>
				<td> First name </td>
				<td> Last name </td>
				<td> E-mail </td>
				<td> </td>
			</tr>
		<c:forEach var="user" items="${users}" varStatus="userStatus">
			<tr>
				<td> <c:out value="${user.firstName}"/> </td>
				<td> <c:out value="${user.lastName}"/> </td>
				<td> <c:out value="${user.email}"/> </td>
				<td> <button onclick="deleteUser(${userStatus.index});"> Delete </button> </td>
			</tr>
		</c:forEach>
		<c:if test="${empty users}">
			<tr>
				<td colspan="4"> No data that satisfy filter </td>
			</tr>
		</c:if>
		</table>
	</body>
</html>