<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Edit AdminDetails</h1>  
       <form:form method="POST" action="/editAdminDetailsSave">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="userId" /></td>  
         </tr>   
         <tr>    
          <td>FirstUserName : </td>   
          <td><form:input path="userName.firstUserName"  /></td>  
         </tr>    
         <tr>    
          <td>LastUserName :</td>    
          <td><form:input path="userName.lastUserName" /></td>  
         </tr>   
         <tr>    
          <td>AccountStatus :</td>    
          <td><form:input path="AccountStatus" /></td>  
         </tr>  
          <tr>    
          <td>AccessDetails :</td>    
          <td><form:input path="AccessDetails" /></td>  
         </tr>   
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    