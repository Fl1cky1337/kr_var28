
<html>
<head><title>Note Creator</title></head>
<body style="background: #242433;">


<h1 style="position:absolute;left:44%;top:18%;font-family:Lucida Console, Courier New, monospace; color: #e7e6e2;">Note Creator</h1>

<div style="position:absolute;left:35%;top:30%;background-color: #e7e6e2;border-radius: 0%;width: 500px;border: 6px solid white;">

    <center><h2>Create a note</h2>
        <form action="${pageContext.request.contextPath}/note-edit-servlet" method="post" style="font-family:Lucida Console, Courier New, monospace;">
            <label for="heading">Change a heading for your note:</label><br>
            <input type="text" id="heading" name="heading" value="${noteData[0][0]}"><br>
            <label for="maintext">Change your main text:</label><br>
            <textarea id="maintext" name="maintext" rows="4" cols="50">${noteData[0][1]}</textarea><br>
            <input type="hidden" name="noteID" value="${noteID}">
            <button type="submit">Submit</button>
        </form></center>

</div>
</body>
</html>



