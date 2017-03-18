<%@ include file="../layout/taglib.jsp" %>

<style>
    .form-signin {
        max-width: 330px;
        padding: 15px;
        margin: 0 auto;
    }

    .form-signin .form-signin-heading,
    .form-signin .checkbox {
        margin-bottom: 10px;
    }

    .form-signin .checkbox {
        font-weight: normal;
    }

    .form-signin .form-control {
        position: relative;
        height: auto;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        padding: 10px;
        font-size: 16px;
    }

    .form-signin .form-control:focus {
        z-index: 2;
    }

    .form-signin input[type="email"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }

    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }
</style>
<form action="../../j_spring_security_check" method="post">
    <p>
        <label for="j_username">Username</label>
        <input id="j_username" name="j_username" type="text"/>
    </p>
    <p>
        <label for="j_password">Password</label>
        <input id="j_password" name="j_password" type="password"/>
    </p><input type="submit" value="Login"/>
    <tr>
        <td>Remember Me:</td>
        <td><input type="checkbox" name="remember-me"/></td>
    </tr>
</form>

${error}

