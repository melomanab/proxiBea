<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- librairies JSP et JSTL -->
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

	<!-- bloc header -->
	<header> <!-- bloc navigation --> <nav
		class="navbar navbar-default">
	<div class="container-fluid">

		<!-- menu de navigation -->
		<div class="navbar-header">
			<a class="navbar-brand">Proxibanque</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="index.html">Accueil</a></li>
		</ul>
	</div>
	</nav> </header>


	<section>
	<div class="container-fluid">


		<div class="row">

			<table class="table table-hover">
				<thead>
					<th>nom</th>
					<th>prenom</th>
					<th>email</th>
					<th>code postal</th>
					<th>ville</th>

				</thead>
				<!-- boucler chaque client sur la collection listeClients -->
				<c:forEach var="client" items="${listeClients}">
					<tbody>
						<tr>
							<td><c:out value="${client.nom}" /></td>
							<td><c:out value="${client.prenom}" /></td>
							<td><c:out value="${client.email}" /></td>
							<td><c:out value="${client.codePostal}" /></td>
							<td><c:out value="${client.ville}" /></td>

							<!-- méthode GET pour diriger vers la page cible avec le paramètres compte = numCompte à affiche -->
							<td><a
								href="/ServletEditionClient?idClient=<c:out value="{$client.idClient}"/>">mettre
									à jour</a></td>
							<td><a
								href="/ServletComptesClient?idClient=<c:out value="{$client.idClient}"/>">liste
									comptes</a></td>
							<td><a
								href="/ServletVirementClient?idClient=<c:out value="{$client.idClient}"/>">virement</a></td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>

	</div>

	</section>

</body>
</html>