<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jobb Search</title>
    <script src="webjars/jquery/2.1.3/jquery.min.js"></script>
</head>
<body>
Nyckel ord 1:
<input type="text" id="key1">
<select id="rate1">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
</select>
<br>
Nyckel ord 2:
<input type="text" id="key2">
<select id="rate2">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
</select>
<br>
Nyckel ord 3:
<input type="text" id="key3">
<select id="rate3">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
</select>
<br>
Nyckel ord 4:
<input type="text" id="key4">
<select id="rate4">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
</select>
<br>
<br>
Sök efter: <input type="text" id="searchFor"><br>
<button id="test-btn" onclick="search()">Sök</button>
<table id="result" border="1px solid black"></table>
<script src="js/index.js"></script>
</body>

</html>
