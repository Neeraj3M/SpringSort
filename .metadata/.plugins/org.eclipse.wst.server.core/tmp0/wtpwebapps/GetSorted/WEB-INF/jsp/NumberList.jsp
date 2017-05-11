<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Enter Number to be sorted</title>
   </head>

   <body>
      <h2>Numbers</h2>
      <form:form method = "POST" action = "/GetSorted/doSort">
         <table>
            <tr>
               <td><form:label path = "Numlist">Number</form:label></td>
               <td><form:input path = "Numlist" /></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
      <form:form method = "GET" action = "/GetSorted/NumberListView">
      <tr>
      <td colspan = "2">
                  <input type = "submit" value = "Back to View"/>
               </td>
               </tr>
      </form:form>
   </body>
   
</html>