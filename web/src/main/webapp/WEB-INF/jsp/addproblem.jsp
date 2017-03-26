<%--
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
            &lt;%&ndash;<textarea class="form-control" rows="3"></textarea>&ndash;%&gt;
    </div>



    <button type="submit" class="btn btn-primary"><spring:message code="label.addProblem"/></button>
</form:form>

<div class="form-group">
    <form method="POST" action="uploadMultipleFile" enctype="multipart/form-data">
        OfficialSolution: <input type="file" name="file">


        <br>

        Input1: <input type="file" name="file">


        <br>

        Input2: <input type="file" name="file">



        <input type="submit" value="Upload"> Press here to upload the file!
    </form>
</div>

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ include file="../layout/taglib.jsp" %>
<form method="POST" action="/problems/addproblem/" enctype="multipart/form-data">

    <div class="form-group">
        <label><spring:message code="label.problemName"/></label>
        <input type="text" name="problemName">
    </div>


    <div class="form-group">
        <label><spring:message code="label.problemStatement"/></label>
        <input type="textarea" name="problemStatement" rows="5" cols="30"/>
        <%--<form:textarea path="problemStatement" rows="5" cols="30"/>--%>
            <%--<textarea class="form-control" rows="3"></textarea>--%>
    </div>


        OfficialSolution: <input type="file" name="file">


        <br>

        Input1: <input type="file" name="file">


        <br>

        Input2: <input type="file" name="file">




    <button type="submit" class="btn btn-primary">ValidateProblem</button>
</form>

