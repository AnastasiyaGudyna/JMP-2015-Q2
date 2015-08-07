<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h2>Mentoring Page</h2>
    <form:form method="POST" commandName="file"  enctype="multipart/form-data" action="/springmvctask/uploadFile">
        Upload your file please:
        <input type="file" name="file" />
        <input type="submit" value="upload" />
        <form:errors path="file" cssStyle="color: #ff0000;" />
    </form:form>
</body>
</html>
