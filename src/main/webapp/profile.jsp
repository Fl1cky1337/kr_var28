<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styleskursach.css">
</head>
<meta name="viewport">
<body style="margin: 0;padding: 0;overflow-x: hidden; overflow-y: auto; ">
<div class="sidebar">
    <c:set var="username" scope="session" value="${sessionScope.username}" />
    <h1 id="nickname">Hello,${username}! </h1>


    <h2 id = "buttonsetting">
        <a href="notecreator.jsp" class="buttons">Create a note</a></br>
        </br>
        <a href="index.jsp" class="buttons">Log out</a></br>
        </br>

    </h2>



</div>



    <div id="notelist">
        <h1 id="Nheading" style="position: fixed;left:685px; ">Your Notes:</h1>
        <div style="position:absolute;left:25px;top:100px;">
            <c:forEach var="note" items="${notelist}">
                <h3>Title: ${note[0][1]}</h3>
                <h4>Content: ${note[0][2]}</h4>
                <a style="text-decoration: none;font-family:Lucida Console, Courier New, monospace" href="${pageContext.request.contextPath}/note-creator-servlet?noteID=${note[0][0]}">Delete  </a>
                <a style="text-decoration: none;font-family:Lucida Console, Courier New, monospace" href="${pageContext.request.contextPath}/note-edit-servlet?noteID=${note[0][0]}">Edit  </a>
                <a style="text-decoration: none;font-family:Lucida Console, Courier New, monospace" href="${pageContext.request.contextPath}/user-note?noteID=${note[0][0]}">Copy a link</a>
            </c:forEach>
        </div>
    </div>



</body>


</html>


