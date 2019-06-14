<%--
  Created by IntelliJ IDEA.
  User: sanjaya
  Date: 6/13/2019
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login Form</title>
  </head>
  <body>
    <form action="login" method="post" >
      <fieldset>
        <legend style="font-size: 30px; text-align: center">Login Form</legend>

      Username: <input type="text" name="userName" value="${cookie.user.value}" /><br /><br />
      Password: <input type="password" name="password"/><br /><br/>
      <input type="submit" value="Login"/><br />
     <label> <input type="checkbox" name="remember"
        ${cookie.user.value != null ? "checked": null}/> Remember Me </label>
      </fieldset>
    </form>
  <div>

  </div>
  </body>
</html>
