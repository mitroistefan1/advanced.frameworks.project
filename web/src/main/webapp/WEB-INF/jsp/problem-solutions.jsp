<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table table-bordered table-hover">
    <thead>
    <tr>
        <th>user</th>
        <th>problem</th>
        <th>score</th>
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
            <p><a href="<spring:url value="/solution/${solution.id}" />"
                  class="btn ">view solution</a></p>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
