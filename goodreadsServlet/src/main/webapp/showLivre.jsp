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
		<div class="formulaire">
			<h1>RECHERCHER UN LIVRE</h1>
			<form method='POST' action="Servlet">
			<label for='titre'>Titre </label>
			<input name='titre' type='text' value='' /><br/>
            <label for='auteur'>Auteur </label> 
            <input name='auteur' type='text' value='' /><br/>
            <label for='genre'>Genre </label> 
            <input name='genre' type='text' value='' /><br/>
            <br/><input name='btnConnect' type='submit' value='Rechecher' /><br/>
			</form>
		</div>
	</body>
</html>