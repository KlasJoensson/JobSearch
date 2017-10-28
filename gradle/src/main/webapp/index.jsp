<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jobb Search</title>
    <script src="webjars/jquery/2.1.3/jquery.min.js"></script>
</head>
<body>
This will be a web app for searching and rating job adds provided by the API from Arbetsförmedlingen.
<br>
Sök efter: <input type="text" id="searchFor"><br>
<button id="test-btn" onclick="search()">Sök</button>
<table id="result" border="1px solid black"></table>
<script src="js/index.js"></script>
</body>

</html>
