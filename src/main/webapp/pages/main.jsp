<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page import="java.sql.ResultSet" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Here I'm, I'm written with HTML 5.
<br/>

Now I'm going to loop through the list that I put in session in a Controller Servlet
<c:forEach items='<%=session.getAttribute("myListSession") %>' var="dbObject">
    <div><c:out value="${dbObject }" /></div>
</c:forEach>
<p/>

Here is another way:
<c:forEach items='${sessionScope.myListSession}' var="dbObject">
    <div><c:out value="${dbObject }" /></div>
</c:forEach>

<div style="padding:5px;">
Here is reading a request attribute, look at the styles I used:
<span style="color:red;"><c:out value="${requestScope.myListRequest}" /></span>
</div>
<div>
Here is a link to jstl (Java Standard Tag library) tutorial:
<a href="http://docs.oracle.com/javaee/5/tutorial/doc/bnakc.html">http://docs.oracle.com/javaee/5/tutorial/doc/bnakc.html</a>
</div>
<p/>
Using jstl tags helps while displaying data that are coming from a servlet.

<div>
Here I'm reading from a database
<%
 ResultSet rs = (ResultSet)session.getAttribute("resultSet");
while(rs.next()) {

%>
    <div>
    	ActivityId: <c:out value='<%=rs.getInt("activity_id")%>' /> <br/>
    	Activity Title: <c:out value='<%=rs.getString("title")%>' /> <br/>
    </div>
</div>
<%
}
%>
</body>
</html>