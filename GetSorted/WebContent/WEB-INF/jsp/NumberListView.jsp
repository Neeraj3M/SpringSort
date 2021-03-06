<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
   <head>
      <title>Get sorted</title>
   </head>
	<body bgcolor="white">
    Previous Sorts
    <table border="">
    <tr>  
      <TH>Numbers</TH>
      <TH>Sorted Numbers</TH>
      <TH>Number of changes</TH>
      <TH>TimeTaken</TH>
    </tr>   
      <c:forEach items="${sortlist}" var="current">
        <tr>
          <td><c:out value="${fn:trim(current.numlist)}" />
          <td><c:out value="${fn:trim(current.sortedNumlist)}" />	
          <td><c:out value="${fn:trim(current.changeNo)}" />
          <td><c:out value="${fn:trim(current.timeTaken)}" />
        </tr>
      </c:forEach>
    </table>
         <form:form method = "GET" action = "/GetSorted/NumberList"> 
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Sort New"/>
               </td>
            </tr>
          
      </form:form>
   </body>
   
</html>