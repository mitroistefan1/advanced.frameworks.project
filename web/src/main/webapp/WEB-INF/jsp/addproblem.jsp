<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ include file="../layout/taglib.jsp" %>
<form:form commandName="problem">
    <div class="form-group">
        <label><spring:message code="label.problemName"/></label>
        <form:input path="problemName" class="form-control"></form:input>
    </div>


    <div class="form-group">
        <label><spring:message code="label.problemStatement"/></label>
        <form:textarea path="problemStatement" rows="5" cols="30"/>
            <%--<textarea class="form-control" rows="3"></textarea>--%>
    </div>

    <button type="submit" class="btn btn-primary"><spring:message code="label.addProblem"/></button>
</form:form>

