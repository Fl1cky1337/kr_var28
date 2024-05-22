
<html>
<head><title>Registration Form</title></head>
<body style="background: #1a1918;">


<h1 style="position:absolute;left:44%;top:18%;font-family:Lucida Console, Courier New, monospace; color: #e7e6e2;">Note Creator</h1>

<div style="position:absolute;left:35%;top:30%;background-color: #f5e1bf;border-radius: 0%;width: 500px;border: 6px solid white;">

    <center><h2>Create an account</h2>
        <form action="${pageContext.request.contextPath}/new-user-servlet" method="post" style="font-family:Lucida Console, Courier New, monospace;">
            <label for="username">Enter your login:</label><br>
            <input type="text" id="username" name="username" required><br>
            <label for="password">Enter your password:</label><br>
            <input type="password" id="password" name="password" required><br><br>
            <button type="submit">Sign up</button>
            <h6> ${RedAlert} </h6>
        </form></center>

</div>
</body>
</html>



