<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../layout/taglib.jsp" %>

<ul class="nav nav-pills pull-right">
    <li>
    <li><a href="<spring:url value="/problems/edit/${problem.problemName}" />"
           class="btn">edit problem</a></li>

    <li><a href="<spring:url value="/problems/remove/${problem.problemName}" />"
           class="btn btn-danger triggerRemove">remove problem</a></li>
</ul>


<table class="table table-bordered table-hover">
    <thead>
    <tr>


    </tr>
    </thead>
    <tbody>
    <tr>

    </tr>
    ${problem.problemName}
    <tr>
        <h4>${problem.problemStatement}</h4>
    </tr>
    </tbody>

</table>