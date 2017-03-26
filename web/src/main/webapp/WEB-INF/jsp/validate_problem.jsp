<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

${problem.problemName}
<br>
<br>
${problem.problemStatement
}
<table class="table table-bordered table-hover">
    <thead>
    <tr>

    </tr>
    </thead>
    <tbody>

    <c:forEach items="${inputs}" var="input">
        <tr>
            <td>
                        ${input}

            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>

<table class="table table-bordered table-hover">
    <thead>
    <tr>

    </tr>
    </thead>
    <tbody>

    <c:forEach items="${outputs}" var="output">
        <tr>
            <td>
                    ${output}

            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>

<br>
<br>


<ul class="nav nav-pills pull-right">
    <li><a href="<spring:url value="/problems" />"
           class="btn">add Problem</a></li>

    <li><a href="<spring:url value="/problems/remove/${problem.problemName}" />"
           class="btn btn-danger triggerRemove">RemoveProblem</a></li>

</ul>



