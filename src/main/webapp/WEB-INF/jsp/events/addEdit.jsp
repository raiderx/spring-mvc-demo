<%--
    @author Pavel Karpukhin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="/WEB-INF/tags/funcs.tld" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title> Simple jsp page </title>
    </head>
    <body>
        <h1> Edit event </h1>
        <form:form action="${pageContext.request.contextPath}/events/${event.id}.html" method="POST" commandName="event">
            <form:hidden path="id"/>
            <form:hidden path="disciplineId"/>

            <table>
                <tr>
                    <td> <form:label path="name"> Name: </form:label> </td>
                    <td> <form:input path="name"/> </td>
                    <td> <form:errors path="name"/> </td>
                </tr> <tr>
                    <td> Discipline </td>
                    <td> <input type="text" value="<c:out value="${discipline.name}"/>" disabled="disabled" /> </td>
                    <td> </td>
                </tr> <tr>
                    <td> Categories </td>
                    <td>
                        <%--<form:checkboxes path="categoryIds" items="${categories}"
                                         itemValue="id" itemLabel="name"/>--%>
                        <table>
                            <tr>
                                <c:forEach var="c" items="${categories}">
                                    <td> <c:out value="${c.name}"/> </td>
                                </c:forEach>
                            </tr> <tr>
                                <c:forEach var="c" items="${categories}">
                                    <c:choose>
                                        <c:when test="${fn:contains(event.categoryIds, c.id)}">
                                            <c:set var="attrs">checked="checked"</c:set>
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="attrs"></c:set>
                                        </c:otherwise>
                                    </c:choose>
                                    <td> <input type="checkbox" name="categoryIds" value="${c.id}" <c:out value="${attrs}"/>/> </td>
                                </c:forEach>
                            </tr>
                        </table>
                    </td>
                    <td> </td>
                </tr> <tr>
                    <td colspan="3">
                        <button type="submit"> Confirm </button>
                        <button type="button" onclick="cancel();"> Cancel </button>
                    </td>
                </tr>
            </table>
        </form:form>
        <script type="text/javascript">
            function cancel() {
                location.href = "<c:url value="/disciplines/${event.disciplineId}/events.html"/>";
            }
        </script>
    </body>
</html>