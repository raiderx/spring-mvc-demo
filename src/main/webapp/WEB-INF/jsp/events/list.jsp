<%--
	@author Pavel Karpukhin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cus" tagdir="/WEB-INF/tags" %>

<html>
	<head>
		<title> Events </title>
        <link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.6.4.js"> </script>
		<script type="text/javascript">
			$(function() {
                $("#eventTable thead td[sortableColumn]").click(function() {
                    if ($("#sortColumn").val() != $(this).attr("sortableColumn")) {
                        $("#sortOrder").val("asc");
                        $("#sortColumn").val($(this).attr("sortableColumn"));
                    } else {
                        if ($("#sortOrder").val() == "asc") {
                            $("#sortOrder").val("desc");
                        } else {
                            $("#sortOrder").val("asc");
                        }
                    }
                    $("#filterForm").trigger("submit");
                });
                $("#eventTable .activityFilter").change(function() {
                    $("#example_active").val($(this).val());
                    $("#filterForm").trigger("submit");
                })
                <c:if test="${criteria.example.active != null}">
                $("#eventTable .activityFilter option[value='<c:out value="${criteria.example.active}"/>']").attr("selected", "selected");
                </c:if>
			});
		</script>
	</head>
	<body>
        <h1> <a href="<c:url value="/disciplines.html"/>"> Disciplines </a> &gt; Events  </h1>

        <form:form id="filterForm" method="post" commandName="criteria"
                   cssClass="filterForm">
			<form:hidden path="sortColumn"/>
            <form:hidden path="sortOrder"/>
            <form:hidden path="page"/>
            <form:hidden id="example_active" path="example.active"/>
			<table>
				<tr>
					<td> Name: </td>
					<td> <form:input path="example.name"/> </td>
					<td> &nbsp; </td>
					<td> &nbsp; </td>
				</tr>
				<tr>
					<td colspan="2"> </td>
					<td colspan="2" align="right">
                        <button type="reset"> Reset </button>
                        <button type="submit"> Apply </button>
                    </td>
				</tr>
			</table>
		</form:form>

		<div id="eventTable" class="contentTable">
			<table>
				<thead>
					<tr>
						<td sortableColumn="name"> Name </td>
						<td> </td>
					</tr>
				</thead>
			<c:forEach var="event" items="${events}" varStatus="eventStatus">
				<tr>
					<td> <c:out value="${event.name}"/> </td>
					<td align="right">
                        <c:if test="${event.active == true}">
                            <button onclick="deleteEvent(${event.id});"> Delete </button>
                        </c:if>
                        <c:if test="${event.active ==false}">
                            <button onclick="restoreEvent(${event.id});"> Restore </button>
                        </c:if>
                    </td>
				</tr>
			</c:forEach>
			<c:if test="${empty events}">
				<tr>
					<td colspan="2"> No data that satisfy filter </td>
				</tr>
			</c:if>
			</table>
            <table>
                <tr>
                    <td>
                        <cus:pager page="${criteria.page}" pageCount="${pageCount}" filterForm="filterForm"/>
                    </td>
                    <td style="text-align: right;">
                        <select class="activityFilter">
                            <option value=""> All </option>
                            <option value="true"> Active </option>
                            <option value="false"> Removed </option>
                        </select>
                    </td>
                </tr>
            </table>
		</div>

	</body>
</html>