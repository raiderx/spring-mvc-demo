<%--
    @author Pavel Karpukhin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title> Simple jsp page </title>
    </head>
    <body>
        <h1> Edit event </h1>
        <form:form action="" method="POST" commandName="event">
            <form:hidden path=""/>

            <table>
                <tr>
                    <td> <form:label path="name"> Name: </form:label> </td>
                    <td> <form:input path="name"/> </td>
                    <td> <form:errors path="name"/> </td>
                </tr> <tr>
                    <td> Discipline </td>
                    <td> <input type="text" value="<c:out value="${discipline.name}"/>" </td>
                    <td> </td>
                </tr> <tr>
                    <td>  </td>
                    <td>  </td>
                    <td>  </td>
                </tr> <tr>
                    <td colspan="3">
                        <button type="submit"> Confirm </button>
                    </td>
                </tr>
            </table>

        </form:form>
    </body>
</html>