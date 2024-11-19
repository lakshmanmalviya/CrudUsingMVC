<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

      <!doctype html>
      <html lang="en">

      <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=11">
        <meta http-equiv="x-ua-compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Signup</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <style>
          body {
            background-image: url("https://images.pexels.com/photos/18607759/pexels-photo-18607759/free-photo-of-balos-strand-in-greece.jpeg");
            background-repeat: no-repeat;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
          }
        </style>
      </head>

      <body>
        <form action="/signup" method="POST">
          <h1 class="color-white">Signup Now</h1>
          <c:if test="${error!=null}">
            <div class="alert alert-danger fs-7" role="alert">
              ${error}
            </div>
          </c:if>
          <c:if test="${success!=null}">
            <div class="alert alert-success fs-7" role="alert">
              ${success}
            </div>
          </c:if>
          <div class="mb-2">
            <label for="name" class="form-label h6">First Name</label>
            <input type="text" class="form-control" placeholder="Enter your name" id="name" name="firstName" value="">
          </div>
          <div class="mb-2">
            <label for="name" class="form-label h6">Last Name</label>
            <input type="text" class="form-control" placeholder="Enter your last name" id="name" name="lastName">
          </div>
          <div class="mb-2">
            <label for="name" class="form-label h6">Age</label>
            <input type="number" class="form-control" placeholder="Enter your age" id="name" name="age">
          </div>
          <div class="mb-2">
            <label for="contact" class="form-label h6">Mobile Number</label>
            <input type="text" class="form-control" placeholder="Enter your contact number" id="contact" name="contact">
          </div>
          <div class="mb-2">
            <label for="email" class="form-label h6">Email address</label>
            <input type="email" class="form-control" placeholder="Enter your email address" id="email"
              aria-describedby="emailHelp" name="email">
          </div>
          <div class="mb-2">
            <label for="password" class="h6">Password</label>
            <input type="password" class="form-control" placeholder="Enter your password" id="password" name="password">
          </div>
          <button type="submit" class="btn btn-primary px-4 ">Signup</button>
          <a class="btn btn-secondary px-4" href="/">Login</a>
        </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
          crossorigin="anonymous"></script>
      </body>
      </html>