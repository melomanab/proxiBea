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

	<header> <!-- bloc header --> <nav
		class="navbar navbar-default">
	<div class="container-fluid">

		<!-- menu de navigation -->
		<div class="navbar-header">
			<a class="navbar-brand">Proxibanque</a>

	</nav> </header>

	<section>
	<div class="container-fluid">
		<div class="row">
			<!-- afficher "Mise à jour des informations du client" -->
			<div class="row">

				<div class="col-sm-4"></div>

				<div class="col-sm-4">
					<form method="POST" action="ServletEdition">
						<div class="form-group">
							<input type="text" class="form-control" id="inputNom"
								placeholder="nom" name="nom" required="true">
						</div>

						<div class="form-group">
							<input type="text" class="form-control" id="inputPrenom"
								placeholder="prenom" name="prenom" required="true">
						</div>

						<div class="form-group">
							<input type="email" class="form-control" id="inputEmail"
								placeholder="email" name="email" required="true">
						</div>

						<div class="form-group">
							<input type="text" class="form-control" id="inputNumVoie"
								placeholder="numVoie"name="numeroVoie" required="true" maxlength="5">
						</div>

						<div class="form-group">
							<input type="text" class="form-control" id="inputNomVoie"
								placeholder="nomVoie" name="voie" required="true">
						</div>

						<div class="form-group">
							<input type="text" class="form-control"
								id="inputCodePostal" placeholder="codePostal" name="codePostal" required="true">
						</div>

						<div class="form-group">
							<input type="text" class="form-control" id="inputVille"
								placeholder="ville" name="ville" required="true">
						</div>
						<br>
						<button type="submit" class="btn" class="active">mettre à
							jour</button>
					</form>
				</div>

				<div class="col-sm-4"></div>
			</div>
		</div>
	</div>
	</section>
</body>
</html>