<%--
    @author Pavel Karpukhin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="dialogForm" title="Error" width="350" height="160">

    <table style="width: 100%">
        <tr> <td align="center"> <c:out value="${message}"/> </td> </tr>
        <tr> <td align="center"> <button onclick="$('#<c:out value="${dialogInfo.dialog}"/>').dialog('close');"> OK </button> </td> </tr>
    </table>
</div>