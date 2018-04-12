<!-- Directive JSP nécessaire pour permettre l'utilisation des balises JSTL de la bibliothèque Core  -->
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Erreur</title>
</head>
<body>

Erreur authentification 

</br></br>
Login: <c:out value="${login}"/> </br></br>
Password: <c:out value="${password}"/> </br></br>


</body>
</html>