<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table table-bordered table-hover">
    <thead>
    <tr>
        <th><spring:message code="label.user"/></th>
        <th><spring:message code="label.problem"/></th>
        <th><spring:message code="label.score"/></th>
        <th></th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${solutions}" var="solution">
        <tr>
            <td>
                    ${solution.user.userName}
            </td>


            <td>
                    ${solution.problem.problemName}
            </td>


            <td>
                    ${solution.score}
            </td>
            <td>
                    ${solution.message}
            </td>
            <td>
            <p><a href="<spring:url value="/solution/${solution.id}" />"
                  class="btn "><spring:message code="label.viewSolution"/></a></p>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
