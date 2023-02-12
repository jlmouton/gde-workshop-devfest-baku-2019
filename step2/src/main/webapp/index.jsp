<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.example.landingpage.Contact" %>
<%@ page import="com.googlecode.objectify.Key" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>

<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Sign up for Awesome Stuff Beta</title>
</head>

<body>

<%
    String email = request.getParameter("email");
    if (email != null) {
        Contact contact = new Contact(email);
        ObjectifyService.ofy().save().entity(contact).now();
%>
<h1>Thank you for Signing up!</h1>
<h2>We will send you an invite for the Beta as soon as possible.</h2>
<%
    } else {
%>
<form action="/" method="post">
    <div><input type="text" name="email" /></div>
    <div><input type="submit" value="SIGN ME UP"/></div>
</form>
<% } %>

</body>
</html>
