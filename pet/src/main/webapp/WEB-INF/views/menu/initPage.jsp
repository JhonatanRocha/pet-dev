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
	<div class="container">

		<div class="row">
			<div class="col-md-3">
				<h4>${loggedUser.name }</h4>
				<div class="form-group">

					<c:choose>
						<c:when test="${fn:length(loggedUser.foto) == 0}">
							<img id="uploadPreview" src="../pet/res/images/imageDefault.jpg"
								width="100" height="100" />
						</c:when>
						<c:otherwise>
							<img id="uploadPreview" src="getImageUser/${loggedUser.id}"
								width="100" height="100" />
						</c:otherwise>
					</c:choose>

				</div>

				<H4>Pontos: ${loggedUser.score }</H4>

				<h4>
					<a href="listPets">Meus animais</a><br>
					<a href="editarUsuario">Alterar Meus dados</a>
				</h4>


			</div>

			<div class="col-md-6 bordered-collum">
				<h4>Eventos/Notícias</h4>
				Evento X<br> Evento Y<br>
			</div>

			<jsp:include page="../anuncios/anuncios.jsp" />
		</div>
	</div>
</body>
</html>