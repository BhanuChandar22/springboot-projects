<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>    

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Employee Management App</title>
    <link rel="stylesheet" href="css/style.css">
    <script lang="javascript" src="javascript/validations.js"></script>
    <style>
      #f-container1 {
        display: flex;
        justify-content: center;
        align-items: center;
      }
      #fitem1 {
        height: 500px;
        width: 460px;
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: rgb(70, 159, 155);
        box-shadow: 3px 3px 1px grey;
      }
    </style>
  </head>
  <body>
  <%@ include file="header.html" %>
    <div id="f-container1" class="mt-2">
      <div id="fitem1">
        <div id="f-container2">
          <div>
            <h1>Register Employee</h1>
          </div>
          <f:form action="register" method="post" modelAttribute="emp" onsubmit="return validate()">
            <p>Employee Name <f:input path="ename" id="name" class="form-control"  /></p>
            <span id="nameError" class="text-danger"></span>
            <p>
              Job
              <f:select path="job" class="form-select" >
                <f:option value="--select--"></f:option>
                <f:option value="CLERK"></f:option>
                <f:option value="SALESMAN"></f:option>
                <f:option value="MANAGER"></f:option>
                <f:option value="ANALYST"></f:option>
                <f:option value="PRESIDENT"></f:option>
              </f:select>
            </p>
            <p>Hiredate <f:input type="date" path="hiredate" id="hiredate" class="form-control" /></p>
            <span id="hiredateError" class="text-danger"></span>
            <p>Salary <f:input path="salary" id="salary" class="form-control"  /></p>
            <span id="salaryError" class="text-danger"></span>
            <p>
              <button class="btn btn-secondary">register</button> &nbsp;&nbsp;
              <button type="reset" class="btn btn-secondary">reset</button>
            </p>
          </f:form>
        </div>
      </div>
    </div>
  </body>
</html>
