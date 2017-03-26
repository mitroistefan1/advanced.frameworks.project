<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ include file="../layout/taglib.jsp" %>
${problem.problemName}

<form:form commandName="problem">
    <div class="form-group">

        <form:input type="hidden" path="problemName" class="form-control" value="${problem.problemName}"/>
    </div>


    <div class="form-group">
        <label><spring:message code="label.problemStatement"/>t</label>
        <form:textarea path="problemStatement" rows="5" cols="30" value="${problem.problemStatement}"/>
    </div>

    <button type="submit" class="btn btn-primary"><spring:message code="label.save"/></button>
</form:form>

