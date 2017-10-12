<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jobb Search</title>
    <script src="webjars/jquery/2.1.3/jquery.min.js"></script>
</head>
<body>
This will be a web app for searching and rating job adds provided by the API from Arbetsförmedlingen.
<br>
<button id="test-btn" onclick="test()">Test</button>

<script>
function test() {
    $.post("counties.jsp", function (data) {
        alert("Response: " + data);
    });

}
</script>
</body>

</html>
