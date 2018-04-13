<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- declaration bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- liaison vers feuille de styles CSS -->
<link rel="stylesheet" style="text/css" href="styles.css" media="screen" />
<title>Proxibanque</title>
</head>

<body>

	<!-- bloc header -------------------------------------------------------------------------------->
	<header> 
	<!-- bloc navigation -----------------------------> 
		<nav class="navbar navbar-default">
		<div class="container-fluid">
		<!-- menu de navigation -->
			<div class="navbar-header">
				<a class="navbar-brand">Proxibanque</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.html">Accueil</a></li>
			</ul>
		</div>
		</nav> 
	</header>


	<!-- bloc section --------------------------------------------------------------------------------->
	<section>
	<div class="container-fluid">
		<!-- premiere ligne ------------------------------------------->
		<div class="row">

			<!-- colonne 1 -->
			<div class="col-sm-4"></div>

			<!-- colonne 2 -->
			<div class="col-sm-4" id="form">
				<form method="POST" action="ServletLogin">
					<div class="form-group">
						<label for="inputIdentifiant"></label><input type="text"
							class="form-control" id="inputIdentifiant"
							placeholder="identifiant" name="login" required="true">
					</div>
					<div class="form-group">
						<label for="inputMotDePasse"></label><input type="password"
							class="form-control" id="inputMotDePasse"
							placeholder="mot de passe" name="password" required="true">
					</div>
	<button type="submit" class="btn" class="active">Connexion</button>
				</form>
			</div>
		</div>
	</div>

	</section>

</body>
</html>