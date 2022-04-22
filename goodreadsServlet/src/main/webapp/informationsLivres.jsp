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
	<link rel='stylesheet' type='text/css' href='StyleCritiquePage.css' />
</head>
<body>
<div class="scroll">
	<div >
	<table border=1 class="tableContent" id="customers">
		<h1>VOICI LES LIVRES QUI CORRESPONDENT A VOTRE RECHERCHE</h1>
		<caption><h2>LISTE DE LIVRES</h2></caption>	
		
		<tr>
			<th>ISBN</th>
			<th>Titre</th>
			<th>Auteur</th>
			<th>Biographie de l'auteur</th>
			<th>Année</th>
			<th>Note moyenne</th>
			<th>Nombre de page</th>
			<th>Genre</th>
			<th>Description</th>
			<th>Critiques</th>
		</tr>
        <c:forEach var="livre" items="${listeLivres}">
       	<tr>
	       <td>${livre.isbn }</td>
	       <td>${livre.titre }</td>
	       <td>${livre.auteur.nom }</td>
	       <td>${livre.auteur.bio }</td>
	       <td>${livre.annee }</td>
	       <td>${livre.note_moyenne }</td>
	       <td>${livre.nombre_de_page }</td>
	       <td>${livre.genre }</td>
	       <td>${livre.description }</td> 
	       <td><form method='POST' action="ServletCritique">
			<input class="default" name='btnCritique' type='submit' value=${livre.idLivre } text="Critiques"/></form></td>
        </tr>
        </c:forEach>
        
	</table>
	<div>
	<!-- <div class="title">Voulez-vous voir les critiques d'un de ces livres ? Mettez le titre du livre dans le champ ci-dessous.</div>
	<form method='POST' action="ServletCritique">
		<label for='critique'>Titre du livre </label>
		<input name='critique' type='text' value='' /><br/>
		<input name='btnConnect' type='submit' value='Rechecher' />
	</form>
	</div>
	-->
	</div>
</div>
</body>
</html>