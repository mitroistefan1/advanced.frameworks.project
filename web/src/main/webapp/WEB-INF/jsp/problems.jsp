<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp" %>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
        integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>
<!-- Button trigger modal -->

<!-- Button trigger modal -->

</button>
    <a href="<spring:url value="/problems/addproblem/${problem.problemName}" />"
       class="btn btn-primary"><spring:message code="label.addProblem"/></a>

<table class="table table-bordered table-hover">
    <thead>
    <tr>
        <th><spring:message code="label.problemName"/></th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${problems}" var="problem">
        <tr>
            <td>
                <a href="<spring:url value="/problems/${problem.problemName}" />">
                        ${problem.problemName}
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
