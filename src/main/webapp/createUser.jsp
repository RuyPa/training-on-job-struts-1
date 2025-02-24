<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New User</title>
</head>
<body>
    <div class="container">
        <h2>Create New User</h2>



<html:form action="addUser.do" method="post">
    <label>Email:</label>
    <html:text property="email" name="userForm"></html:text>
        <label>Name:</label>
    <html:text property="name" name="userForm"></html:text>
        <label>Address:</label>
    <html:text property="address" name="userForm"></html:text>
        <label>Password:</label>
    <html:password property="password" name="userForm"></html:password>

    
	<html:submit>create User</html:submit>	

</html:form>

    </div>
</body>
</html>