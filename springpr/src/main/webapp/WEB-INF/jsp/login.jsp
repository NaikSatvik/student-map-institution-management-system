<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">
    <link href="/assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/login.css">
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
        <form action="/login" method="POST">
          <img class="mb-4" src="img/gnu_logo.png" alt="" width="100" height="100"><br>
          <h1 class="h3 mb-3 fw-normal">You Are</h1>
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="student" onclick="text(0)">
            <label class="form-check-label" for="inlineRadio1">Student</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="faculty" onclick="text(1)" checked>
            <label class="form-check-label" for="inlineRadio2">Faculty</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="guardian" onclick="text(2)">
            <label class="form-check-label" for="inlineRadio2">Guardian</label>
          </div>

          <h1 class="h3 mb-3 fw-normal">Please Login</h1>
          <div class="form-floating" id="email">
            <input name="stuEmail" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
            <label for="floatingInput">Email Address</label>
          </div>
          <div class="form-floating" id="pass">
            <input name="stuPass" type="password" class="form-control" id="floatingPassword" placeholder="Password">
            <label for="floatingPassword">Password</label>
          </div>
          <div class="form-floating" id="sem">  
            <input name="stuSem" type="text" class="form-control" id="floatingPassword" placeholder="Current Semester">
            <label for="floatingPassword">Semester</label>
          </div>
          <div class="form-floating" id="stuname">
            <input name="stuName" type="email" class="form-control" id="floatingPassword" placeholder="Student Name">
            <label for="floatingPassword">Student Email Address</label>
          </div>
          <br>
          <button class="w-100 btn btn-lg btn-primary" type="submit">Login</button><br><br>
          <button class="w-100 btn btn-lg btn-primary" href="#">SignUp</button>
        </form>
      </main>
</script>
</body>
</html>