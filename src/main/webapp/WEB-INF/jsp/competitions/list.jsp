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
		<title> Competitions </title>
        <link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.6.4.js"> </script>
		<script type="text/javascript">
			$(function() {
				$("#competitionTable thead td[sortableColumn]").click(function() {
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
                $("#competitionTable .activityFilter").change(function() {
                    $("#example_active").val($(this).val());
                    $("#filterForm").trigger("submit");
                })
                <c:if test="${criteria.example.active != null}">
                $("#competitionTable .activityFilter option[value='<c:out value="${criteria.example.active}"/>']").attr("selected", "selected");
                </c:if>
			});
		</script>
	</head>
	<body>
        <h1> Competitions </h1>

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
					<td> Classification: </td>
					<td>
						<form:select path="example.classificationId">
							<form:option value=""> </form:option>
							<form:options items="${classifications}"
										  itemLabel="name" itemValue="id"/>
					  	</form:select>
					</td>
				</tr>
				<tr>
					<td> Start date: </td>
					<td> <form:input path="fromStartDate"/> - <form:input path="toStartDate"/> </td>
					<td> End date: </td>
					<td> <form:input path="fromEndDate"/> - <form:input path="toEndDate"/> </td>
				</tr>
				<tr>
					<td> Disciplines: </td>
					<td>
						<form:checkboxes path="disciplineIds" items="${disciplines}"
										 itemLabel="name" itemValue="id" delimiter="<br/>"/>
					</td>
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

		<div id="competitionTable" class="contentTable">
			<table>
				<thead>
					<tr>
						<td sortableColumn="name"> Name </td>
						<td> Dates </td>
						<td> </td>
					</tr>
				</thead>
			<c:forEach var="competition" items="${competitions}" varStatus="competitionStatus">
				<tr>
					<td> <c:out value="${competition.name}"/> </td>
					<td>
						<fmt:formatDate value="${competition.startDate}" pattern="dd.MM.yyyy"/> -
						<fmt:formatDate value="${competition.endDate}" pattern="dd.MM.yyyy"/>
					</td>
					<td align="right">
                        <c:if test="${competition.active == true}">
                            <button onclick="deleteCompetition(${competition.id});"> Delete </button>
                        </c:if>
                        <c:if test="${competition.active ==false}">
                            <button onclick="restoreCompetition(${competition.id});"> Restore </button>
                        </c:if>
                    </td>
				</tr>
			</c:forEach>
			<c:if test="${empty competitions}">
				<tr>
					<td colspan="3"> No data that satisfy filter </td>
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