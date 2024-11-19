<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!doctype html>
  <html lang="en">

  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=11">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/05f6c81ac8.js" crossorigin="anonymous"></script>
  </head>
  <style>
    body {
      background-image: url("https://images.pexels.com/photos/18607759/pexels-photo-18607759/free-photo-of-balos-strand-in-greece.jpeg");
      background-repeat: no-repeat;
      background-size: cover;
    }
  </style>

  <body>
    <%@ include file="header.jsp" %>
      <div class="container">
        <c:if test="${error!=null}">
          <div class="alert alert-danger fs-7" role="alert">
            ${error}
          </div>
        </c:if>
        <form action="/update" method="POST">
          <h1 class="color-white">Welcome, ${loginDetails.firstName}</h1>
          <div class="mb-2">
            <label for="id" class="form-label h6">ID:</label>
            <input type="text" class="form-control" placeholder="${loginDetails.id}" id="id" name="id"
              value="${loginDetails.id}" readonly>
          </div>
          <div class="mb-2">
            <label for="firstName" class="form-label h6">First Name</label>
            <input type="text" class="form-control" placeholder="Enter your first name" id="firstName" name="firstName"
              value="${loginDetails.firstName}">
          </div>
          <div class="mb-2">
            <label for="lastName" class="form-label h6">Last Name</label>
            <input type="text" class="form-control" placeholder="Enter your last name" id="lastName" name="lastName"
              value="${loginDetails.lastName}">
          </div>
          <div class="mb-2">
            <label for="age" class="form-label h6">Age</label>
            <input type="number" class="form-control" placeholder="Enter your age" id="age" name="age"
              value="${loginDetails.age}">
          </div>
          <div class="mb-2">
            <label for="contact" class="form-label h6">Contact Number</label>
            <input type="text" class="form-control" placeholder="Enter your contact number" id="contact" name="contact"
              value="${loginDetails.contact}">
          </div>
          <div class="mb-2">
            <label for="email" class="form-label h6">Email address</label>
            <input type="email" class="form-control" placeholder="Enter your email address" id="email"
              value="${loginDetails.email}" aria-describedby="emailHelp" name="email" readonly>
          </div>
          <div class="mb-2">
            <label for="password" class="h6">Password</label>
            <input type="password" class="form-control" placeholder="Enter your password" id="password" name="password"
              value="${loginDetails.password}">
          </div>
          <button type="submit" class="btn btn-primary px-4 ">Update</button>
        </form>
      </div>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
  </body>

  </html>