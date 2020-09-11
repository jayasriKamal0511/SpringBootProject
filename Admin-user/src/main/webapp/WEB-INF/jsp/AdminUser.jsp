<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>AdminUser Details</title>
</head>
<body>
<h1><spring:eval expression="@environment.getProperty('app.name')" />&nbsp;${var2}</h1>  

<form action="/filterAdminDetails">
<table>
<tr>
<td><spring:eval expression="@environment.getProperty('app.SearchByKeyword')" />&nbsp;${SearchByKeyword}</td>
<td><input type="text" name="keyword" id="keyword" size="50" placeholder="Enter text to search" th:value="${keyword}"/></td>
<td>Account Status</td>
<td><select name="AccountStatus" id="AccountStatus" th:value="${AccountStatus}" >
<option value="Select Category">Select Category</option>
<option value="Active">Active</option>
<option value="Pending">Pending</option>
<option value="Blocked">Blocked</option>
</select></td>
<td><button><spring:eval expression="@environment.getProperty('button.search')" />&nbsp;${search}</button></td>
</tr>
</table>
</form>
<br/>


<form action="ClearData">
<button><spring:eval expression="@environment.getProperty('showAll.search')" />&nbsp;${showAllSearch}</button>
</form>
<br/>
<table border="1" cellpadding="2" cellspacing="2" width="90%">  

<%if(request.getAttribute("adminUserDetails")!=null){ %>
<tr>
<th><spring:eval expression="@environment.getProperty('app.userId')" />&nbsp;${UserId}</th>
<th><spring:eval expression="@environment.getProperty('app.FirstUserName')" />&nbsp;${FirstUserName}</th>
<th><spring:eval expression="@environment.getProperty('app.LastUserName')" />&nbsp;${LastUserName}</th>
<th><spring:eval expression="@environment.getProperty('app.AccountStatus')" />&nbsp;${AccountStatus}</th> 
<th><spring:eval expression="@environment.getProperty('app.AccessDetails')" />&nbsp;${AccessDetails}</th>
<th><spring:eval expression="@environment.getProperty('app.Delete')" />&nbsp;${Delete}</th>
<th><spring:eval expression="@environment.getProperty('app.Edit')" />&nbsp;${Edit}</th>
</tr>
<c:forEach items="${adminUserDetails}" var="adminUser">  
<tr>

<td>${adminUser.userId}</td>
<td>${adminUser.userName.firstUserName}</td>
<td>${adminUser.userName.lastUserName}</td>  
<td>${adminUser.accountStatus}</td>
<td>${adminUser.accessDetails}</td> 
<td><a href="deleteAdminUser/${adminUser.userId}"><spring:eval expression="@environment.getProperty('app.Delete')" />&nbsp;${Delete}</a></td> 
<td><a href="editDetails/${adminUser.userId}"><spring:eval expression="@environment.getProperty('app.Edit')" />&nbsp;${Edit}</a></td> 
</tr>  
</c:forEach>
<%} else if(request.getAttribute("message")!=null){%>

 <p>This AccountStatus does not exit</p>

<%}%>
</table>  
</body>  
</html>  
