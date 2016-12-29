<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form:form method="post" action="save">
    <table>
        <tr>
            <td>UserName :</td>
            <td><form:input path="userName"/></td>
        </tr>
        <tr>
            <td>email :</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Password :</td>
            <td><form:input path="password" type="password"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Save"/></td>
        </tr>
    </table>
</form:form>