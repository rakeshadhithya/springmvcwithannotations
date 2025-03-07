<%@ page import="entity.Employee" %> <%@ page import="java.util.List" %>

<html>
  <body>
    <center>
      <pre style="font-size: 18px">
      <%  Employee employee = (Employee) request.getAttribute("employeeFound"); 
          String id = String.valueOf(employee.getId());
          String name = employee.getName();
          String department = employee.getDepartment();
          String salary = employee.getSalary();
      %>
      <%= String.format("%-20s%-20s%-20s%-20s", "id", "name", "department", "salary")
      %>
      <br>
      <%=   String.format("%-20s%-20s%-20s%-20s", id, name, department, salary)
      %>
      <br>
    </pre>
    </center>
  </body>
</html>
