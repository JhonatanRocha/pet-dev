<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../main/main.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página Inicial</title>
</head>
<body>

	<c:import url="../main/navbar.jsp" />
	
	<div class="container-fluid">

		<div class="row">
		
			<div class="col-md-3">
				<c:choose>
				    <c:when test="${loggedUser.isOfPetShop}">
				       <jsp:include page="../menu/menuLateralEsquerdoPetShop.jsp" />
				    </c:when>
				    <c:when test="${loggedUser.isOfNGO}">
				         <jsp:include page="../menu/menuLateralEsquerdoNGO.jsp" />
				    </c:when>
				    <c:otherwise>
				        <jsp:include page="../menu/menuLateralEsquerdo.jsp" />
				    </c:otherwise>
				</c:choose>
			</div>
			
			<div class="col-md-6 bordered-collum">
				<h2>Eventos/Notícias</h2>
					Evento X<br> Evento Y<br>
					
					<jsp:include page="carousel.jsp" />
			</div>
			
			<jsp:include page="../anuncios/anuncios.jsp" />
		</div>
	</div>
		
</body>
</html>