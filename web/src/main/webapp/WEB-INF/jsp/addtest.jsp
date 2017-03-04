<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp" %>

<form:form commandName="test">
    <div class="form-group">
        <label>InputData</label>
        <form:textarea path="inputData" rows="5" cols="30"/>
    </div>



    <div class="form-group">
        <label>OutputData</label>
        <form:textarea path="outputData" rows="5" cols="30"/>
    </div>

    <button type="submit" class="btn btn-primary">addTest</button>
</form:form>
