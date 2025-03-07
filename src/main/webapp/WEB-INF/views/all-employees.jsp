
<%@ page import="entity.Employee" %>
<%@ page import="java.util.List" %>

<html>
  <body>
    <center>
    <pre style="font-size: 18px">
      <%  List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList"); %>
      <%= String.format("%-20s%-20s%-20s%-20s", "id", "name", "department", "salary")
      %>
      <br>
      <% for(Employee e : employeeList){
            String id=String.valueOf(e.getId());
            String name=e.getName(); 
            String department=e.getDepartment();
            String salary=e.getSalary();
      %>
      <%=   String.format("%-20s%-20s%-20s%-20s", id, name, department, salary)
      %>
      <br>
      <%    }
      %>
    </pre>
    </center>
  </body>
</html>
