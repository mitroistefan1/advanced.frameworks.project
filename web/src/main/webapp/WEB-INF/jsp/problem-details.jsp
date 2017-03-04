<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../layout/taglib.jsp" %>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
        integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>

<ul class="nav nav-pills pull-right">
    <li><a href="<spring:url value="/problems/addtest/${problem.problemName}" />"
           class="btn">add test</a></li>
    <li><a href="<spring:url value="/problems/edit/${problem.problemName}" />"
           class="btn"><spring:message code="label.editProblem"/></a></li>

    <li><a href="<spring:url value="/problems/remove/${problem.problemName}" />"
           class="btn btn-danger triggerRemove"><spring:message code="label.removeProblem"/></a></li>
    <li><a href="<spring:url value="/problems/solutions/${problem.problemName}" />"
           class="btn "><spring:message code="label.showSolutions"/></a></li>
</ul>
<br>
<br>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">${problem.problemName}</h3>
    </div>
    <div class="panel-body">
        ${problem.problemStatement}
    </div>
</div>

<br>
<br>
<form:form commandName="solution">

    <div class="form-group">
        <label><spring:message code="label.solution"/></label>
        <form:textarea path="text" rows="5" cols="30"/>
    </div>

    <button type="submit" class="btn btn-primary"><spring:message code="label.sendSolution"/></button>
</form:form>


<br>
<br>

<div class="panel panel-default">

    <div class="panel-heading"><spring:message code="label.comments"/>:</div>


    <ul class="list-group">
        <c:forEach items="${comments}" var="comment">
            <li class="list-group-item">${comment.body} <p align="right">${comment.author}</p>
                <p><a href="<spring:url value="/problems/${problem.problemName}/remove_comment/${comment.id}" />"
                      class="btn btn-danger triggerRemove"><spring:message code="label.removeComment"/></a></p></li>
        </c:forEach>
    </ul>
</div>


<form:form commandName="comment">

    <div class="form-group">
        <label><spring:message code="label.comment"/></label>
        <form:textarea path="body" rows="5" cols="30"/>
    </div>

    <button type="submit" class="btn btn-primary"><spring:message code="label.addComment"/></button>
</form:form>
