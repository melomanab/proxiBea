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

	</div>
	</nav> </header>

	<section>
	<div class="container-fluid">

		<!-- boucler chaque client sur la collection listeComptes  et les insérer dans un tableau -------------------------->
		<table class="table table-hover">
			<thead>
				<th>numéro de compte</th>
				<th>type de compte</th>
				<th>solde</th>


			</thead>

			<c:forEach var="compte" items="${listeComptes}">
				<tbody>
					<tr>
						<td><c:out value="${compte.idClient}" /></td>
						<td><c:out value="${compte.nom}" /></td>
						<td><c:out value="${compte.prenom}" /></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
	</section>

</body>
</html>