<%--
	@author Pavel Karpukhin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cus" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title> Disciplines </title>
        <link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.6.4.js"> </script>
	</head>
	<body>
        <h1> Disciplines </h1>
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

		<div id="disciplineTable" class="contentTable">
			<table>
				<thead>
					<tr>
						<td sortableColumn="name"> Name </td>
                        <td> </td>
						<td> </td>
					</tr>
				</thead>
			<c:forEach var="discipline" items="${disciplines}" varStatus="disciplineStatus">
				<tr>
					<td> <c:out value="${discipline.name}"/> </td>
                    <td>
                         <a href="<c:url value="/disciplines/${discipline.id}/events.html"/>">
                             Events
                         </a>
                    </td>
					<td align="right">
                        <c:if test="${discipline.active == true}">
                            <button onclick="editDiscipline(${discipline.id});"> Edit </button>
                            <button onclick="deleteDiscipline(${discipline.id});"> Delete </button>
                        </c:if>
                        <c:if test="${discipline.active ==false}">
                            <button onclick="restoreDiscipline(${discipline.id});"> Restore </button>
                        </c:if>
                    </td>
				</tr>
			</c:forEach>
			<c:if test="${empty disciplines}">
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

        <script type="text/javascript">
            $(function() {
                $("#disciplineTable thead td[sortableColumn]").click(function() {
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
                $("#disciplineTable .activityFilter").change(function() {
                    $("#example_active").val($(this).val());
                    $("#filterForm").trigger("submit");
                })
                <c:if test="${criteria.example.active != null}">
                $("#disciplineTable .activityFilter option[value='<c:out value="${criteria.example.active}"/>']").attr("selected", "selected");
                </c:if>
            });
            function editDiscipline(id) {
                location.href = "<c:url value="/disciplines/"/>" + id + "/edit.html";
            }
        </script>
	</body>
</html>