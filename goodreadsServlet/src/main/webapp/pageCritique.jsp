<%@page import="webApp.Livres"%>
<%@page import="webApp.Auteurs"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bonne Lecture</title>
<link rel='stylesheet' type='text/css' href='Style.css' />
</head>
<body>
	<div align="center">
	<h1>${titreLivre }</h1>
	<table border=1 id="customers">
		<caption><h2>LISTE DE CRITIQUES</h2></caption>	
		<tr>
			<th>Note</th>
			<th>Commentaire</th>
		</tr>
        <c:forEach var="critique" items="${listeCritiques}">
       	<tr>
	       <td>${critique.note }</td>
	       <td>${critique.commentaire }</td>
        </tr>
        </c:forEach>
	</table>
	</div>
	<br><br>
	<div style="display: inline">
		<h1>AJOUTER UNE CRITIQUE</h1>
		<form method='POST' action="ServletCritique">
		<h2>Commentaire</h2>
		<textarea id="comment" name="comment" rows="4" cols="50"></textarea>
  		<br><br>
  		<h2>Note(1-5)</h2>
		<input name='note' type='text' value='' />
		<br><br>
		<input name='btnSave' type='submit' value='Sauvegarder' />
		</form>
	</div>
	
</body>
</html>