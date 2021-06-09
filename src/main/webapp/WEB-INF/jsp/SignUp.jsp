<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">
        <link href="/assets/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="/assets/css/login.css">
        <title>SignUp Page</title>1
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
    </head>

    <body class="text-center">
        <main class="form-signin">
            <c:if test="${not empty error}">
                <div>
                    <h2>
                        <script>alert("${error}")</script>
                    </h2>
                </div>
            </c:if>
            <!-- radios -->
            <form action="/insertdata-signup" method="POST">
                <img class="mb-4" src="/assets/images/gnu_logo.png" alt="" width="100" height="100"><br>
                <h1 class="h3 mb-3 fw-normal">SignUp As</h1>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="role" id="inlineRadio1"
                        value="student" onclick="text(0)">
                    <label class="form-check-label" for="inlineRadio1">Student</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="role" id="inlineRadio2"
                        value="faculty" onclick="text(1)" checked>
                    <label class="form-check-label" for="inlineRadio2">Faculty</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="role" id="inlineRadio2"
                        value="guardian" onclick="text(2)">
                    <label class="form-check-label" for="inlineRadio2">Guardian</label>
                </div>
                <!-- main fields -->
                <h1 class="h3 mb-3 fw-normal">Please SignUp</h1>
                <div class="form-floating" id="stuname">
                    <input name="username" type="text" class="form-control" id="floatingPassword" placeholder="Username">
                    <label for="floatingPassword">Username</label>
                </div>
                <div class="form-floating" id="email">
                    <input name="mailid" type="email" class="form-control" id="floatingInput"
                        placeholder="name@example.com">
                    <label for="floatingInput">Email Address</label>
                </div>
                <div class="form-floating" id="pass">
                    <input name="pass" type="password" class="form-control" id="floatingPassword"
                        placeholder="Password">
                    <label for="floatingPassword">Password</label>
                </div>
                <div class="form-floating" id="sem">
                    <input name="confpass" type="password" class="form-control" id="floatingPassword"
                        placeholder="Re-Type same password">
                    <label for="floatingPassword">Confirm Password</label>
                </div>
                <br>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Sign Up</button><br><br>
                <a href="/index" class="link-primary">Already have an account? Login here</a>
            </form>

            <c:if test="${not empty successmsg}">
                <div>
                    <h2>
                        <script>alert("${successmsg}")</script>
                    </h2>
                </div>
            </c:if>
        </main>
        </script>
    </body>

    </html>