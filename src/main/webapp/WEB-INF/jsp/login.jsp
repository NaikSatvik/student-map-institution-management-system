<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="assets/images/graduateicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">
    <link href="/assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/assets/css/login.css">
    <title>Login Page</title>
    <style>
        .bd-placeholder-img {
          font-size: 1.125rem;
          text-anchor: middle;
          -webkit-user-select: none;
          -moz-user-select: none;
          user-select: none;
        }
  
        @media (min-width: 768px) {
          .bd-placeholder-img-lg {
            font-size: 3.5rem;
          }
        }
    </style>
    <script>
      window.onload = function loaded() {
        document.getElementById("sem").style.display = "none";
        document.getElementById("stuname").style.display = "none";
      }

      function text(x) {
          if (x == 0) document.getElementById("sem").style.display = "block";
          else document.getElementById("sem").style.display = "none";
          if (x == 2) document.getElementById("stuname").style.display = "block";
          else document.getElementById("stuname").style.display = "none";
          return;
      }
    </script>
</head>
<body class="text-center">
  <main class="form-signin">
      <c:if test="${not empty error}">
        <div><h2><script>alert("${error}")</script></h2></div>
      </c:if>
      <form action="/login" method="POST">
        <img class="mb-4" src="/assets/images/logo-sm-light.png" alt="" width="80" height="80"><br>
        <h1 class="h3 mb-3 fw-normal">You Are</h1>
        <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
          <input type="radio" class="btn-check" name="role" id="btnradio0" autocomplete="off" value="admin">
          <label class="btn btn-outline-primary" for="btnradio0">Admin</label>

          <input type="radio" class="btn-check" name="role" id="btnradio1" autocomplete="off" value="student">
          <label class="btn btn-outline-primary" for="btnradio1">Student</label>

          <input type="radio" class="btn-check" name="role" id="btnradio2" autocomplete="off" value="faculty">
          <label class="btn btn-outline-primary" for="btnradio2">Faculty</label>

          <input type="radio" class="btn-check" name="role" id="btnradio3" autocomplete="off" value="guardian">
          <label class="btn btn-outline-primary" for="btnradio3">Guardian</label>
        </div>
        <br><br>

        <h1 class="h3 mb-3 fw-normal">Please Login</h1>
        <div class="form-floating" id="email">
          <input name="mail" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
          <label for="floatingInput">Email Address</label>
        </div>
        <div class="form-floating" id="pass">
          <input name="pass" type="password" class="form-control" id="floatingPassword" placeholder="Password">
          <label for="floatingPassword">Password</label>
        </div>
        <br>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Login</button><br><br>
        <a class="w-100 btn btn-lg btn-primary" href="/signup">SignUp</a>
      </form>
    </main>
</script>
</body>
</html>