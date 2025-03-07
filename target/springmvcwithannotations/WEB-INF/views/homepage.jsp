<html>
  <head>
    <title>HomePage</title>
  </head>
  <body>
    <center>
      <h3><%= request.getAttribute("message") %></h3>
      <br />
      <h4><a href="./findAll">Find All Employees</a></h4>
      <h4><a href="./static/find-by-id-form.html">Find Employee By Id</a></h4>
      <h4><a href="./static/save-employee-form.html">Save Employee</a></h4>
      <h4><a href="./static/update-employee-form.html">Update Employee</a></h4>
      <h4><a href="./static/delete-employee-form.html">Delete Employee</a></h4>
    </center>
  </body>
</html>
