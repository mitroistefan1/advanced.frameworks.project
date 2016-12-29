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
       class="btn btn-primary">Add problem</a>

<%--<form:form commandName="problem" cssClass="form-horizontal">
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">problemName:</label>
                        <div class="col-sm-10">
                            <form:input path="problemName" cssClass="form-control"/>
                            <form:errors path="problemName"/>
                        </div>
                    </div>
                    <div class="form-group">

                        <label class="col-sm-2 control-label">problemStatement:</label>
                        <div class="col-sm-10">

                            <form:input path="problemStatement" cssClass="form-control"/>

                            <form:errors path="problemStatement"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </div>
            </div>
        </div>
    </div>
</form:form>--%>

<table class="table table-bordered table-hover">
    <thead>
    <tr>
        <th>problem name</th>
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
