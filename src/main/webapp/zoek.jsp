<%--
  Created by IntelliJ IDEA.
  User: robbe
  Date: 2/27/2021
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>zoek</title>
</head>
<body>
<h1>Zoek hier de info</h1>
<form action="StudentInfo" method="get">
    <p><label for="achterNaam">Achternaam:</label>
        <input type="text" id="achterNaam" name="naam"></p>
    <p><label for="voorNaam">Voornaam:</label>
        <input type="text" id="voorNaam" name="voornaam"></p>
    <p><input type="submit"></p>
</form>


</body>
</html>
