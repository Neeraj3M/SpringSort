<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Get Sorted</title>
   </head>

   <body>
   <form:form method = "GET" action = "/GetSorted/NumberList">
      <h2>Results</h2>
      <table>
         <tr>
            <td>Number List</td>
            <td>${Numlist}</td>
         </tr>
         <tr>
            <td>Sorted Numbers</td>
            <td>${SortedNumlist}</td>
         </tr>
         <tr>
            <td>Number of Changes Required</td>
            <td>${ChangeNo}</td>
         </tr>
         <tr>
            <td>TimeTaken</td>
            <td>${TimeTaken}</td>
         </tr>
         <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Back"/>
               </td>
            </tr>
      </table>  
       </form:form>
   </body>
   
</html>