<%--
    @author Pavel Karpukhin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title> Simple jsp page </title>
    </head>
    <body>
        <h1> Edit discipline </h1>
        <form:form action="${pageContext.request.contextPath}/disciplines/${discipline.id}.html" method="POST"
                   commandName="discipline">
            <form:hidden path="id"/>
            <table>
                <tr>
                    <td> <form:label path="name"> Name: </form:label> </td>
                    <td> <form:input path="name"/> </td>
                    <td> <form:errors path="name"/> </td>
                </tr> <tr>
                    <td colspan="3">
                        <table>
                            <tr>
                                <td></td>
                                <c:forEach var="category" items="${categories}">
                                    <td> <c:out value="${category.name}"/> </td>
                                </c:forEach>
                            </tr>
                            <c:forEach var="event" items="${events}">
                                <tr>
                                    <td> <c:out value="${event.name}"/> </td>
                                    <td> <form:checkboxes path="eventCategories[${event.id}]" items="${categories}"
                                                     itemValue="id" itemLabel="name" delimiter="</td><td>"/> </td>
                                    <%--<c:forEach var="category" items="${categories}">
                                        <td>

                                        </td>
                                    </c:forEach>--%>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
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
                location.href = "<c:url value="/disciplines.html"/>";
            }
        </script>
    </body>
</html>