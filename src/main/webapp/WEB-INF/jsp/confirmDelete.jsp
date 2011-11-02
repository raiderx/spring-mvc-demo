<%--
	@author Pavel Karpukhin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="dialogForm" width="350" height="160">
    <table style="width: 100%">
        <tr> <td align="center">
            Are you sure want to delete <c:out value="${entityName}"/> ?
        </td> </tr>
        <tr> <td align="center">
            <button onclick="submit();"> Yes </button>
            <button onclick="close<c:out value="${dialogInfo.dialog}"/>();"> No </button>
        </td> </tr>
    </table>
</div>

<script type="text/javascript">
    function close<c:out value="${dialogInfo.dialog}"/>() {
        $('#<c:out value="${dialogInfo.dialog}"/>').dialog('close');
    }
    function submit() {
        function onError(xhr, textStatus, errorThrown) {
            alert("Error processing server request: " + xhr.status);
        }
        $.ajax({
            url: "<c:url value="${dialogInfo.action}"/>",
            type: "DELETE",
            success: close<c:out value="${dialogInfo.dialog}"/>,
            error: onError
        });
    }
</script>