<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ include file="../layout/taglib.jsp" %>
<form:form commandName="problem">
    <div class="form-group">
        <label>problemName</label>
        <form:input path="problemName" class="form-control" value="${problem.problemName}"/>
    </div>


    <div class="form-group">
        <label>problemStatement</label>
        <form:textarea path="problemStatement" rows="5" cols="30" value="${problem.problemStatement}"/>
    </div>

    <button type="submit" class="btn btn-primary">Save</button>
</form:form>

