<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="page" required="true" %>
<%@ attribute name="pageCount" required="true" %>
<%@ attribute name="filterForm" required="true" %>

<c:choose>
    <c:when test="${page > 0}">
        <img id="prevPage" src="<c:url value="/img/prev_page.png"/>" class="imgLink"
             onclick="$('#<c:out value="${filterForm}"/> #page').val(<c:out value="${page - 1}" />); $('#<c:out value="${filterForm}"/>').trigger('submit');"/>
    </c:when>
    <c:otherwise>
        <img src="<c:url value="/img/disabled_prev_page.png"/>" class="disabledImgLink"/>
    </c:otherwise>
</c:choose>
<c:set var="pagesToDisplay" value="0,${page - 2},${page - 1},${page},${page + 1},${page + 2},${pageCount - 1}"/>
<c:set var="lastValidPage" value="-1"/>
<c:forEach var="p" items="${pagesToDisplay}">
    <c:if test="${p > lastValidPage && p < pageCount}">
        <c:if test="${p > (lastValidPage + 1)}">
            <span>&nbsp;...&nbsp;</span>
        </c:if>
        <c:choose>
            <c:when test="${p == page}">
                <a class="currentPageLink"> <c:out value="${p + 1}"/> </a>
            </c:when>
            <c:otherwise>
                <a href="javascript:" class="pageLink<c:if test="${p == (pageCount - 1)}"> lastPageLink</c:if>"
                   onclick="$('#<c:out value="${filterForm}"/> #page').val(<c:out value="${p}" />); $('#<c:out value="${filterForm}"/>').trigger('submit');"> <c:out value="${p + 1}"/> </a>
            </c:otherwise>
        </c:choose>
        <c:set var="lastValidPage" value="${p}"/>
    </c:if>
</c:forEach>
<c:choose>
    <c:when test="${page < (pageCount - 1)}">
        <img id="nextPage" src="<c:url value="/img/next_page.png"/>" class="imgLink"
             onclick="$('#<c:out value="${filterForm}"/> #page').val(<c:out value="${page + 1}" />); $('#<c:out value="${filterForm}"/>').trigger('submit');"/>
    </c:when>
    <c:otherwise>
        <img src="<c:url value="/img/disabled_next_page.png"/>" class="disabledImgLink"/>
    </c:otherwise>
</c:choose>
