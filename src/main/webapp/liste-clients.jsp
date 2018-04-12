<!-- Directive JSP nécessaire pour permettre l'utilisation des balises JSTL de la bibliothèque Core  -->
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Liste clients 

</br></br>
Login conseiller: <c:out value="${login}"/> </br></br>
Psw conseiller: <c:out value="${password}"/> </br></br>

<c:forEach items="${listeClients}" var="client" >
</br></br>
						
							<c:out value="${client.idClient}" />
							<c:out value="${client.nom}" />
							<c:out value="${client.prenom}" />
					</c:forEach>
	
</body>
</html>