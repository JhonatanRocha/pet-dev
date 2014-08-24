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
				<h4 class="text-center">${loggedUser.name }</h4>
				<div class="text-center">
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
				<h4 class="text-center">Pontos: ${loggedUser.score }</h4>
				<jsp:include page="../menu/menuLateralEsquerdo.jsp" />
			</div>

			<div id="painelDeAnimais" class="col-md-6 bordered-collum">
				<div class="panel panel-primary">
					<c:forEach var="petItem" items="${pets}">
						<div class="panel-heading">
							<strong>${petItem.name}</strong>
						</div>
						<div class="panel-body">
							<div class="text-center">
								<c:choose>
									<c:when test="${fn:length(petItem.foto) == 0}">
										<img id="uploadPreview"
											src="../pet/res/images/noImagemAnimal.jpg" width="200"
											height="200" />
									</c:when>
									<c:otherwise>
										<img id="uploadPreview" src="getImagePet/${petItem.id}"
											width="200" height="200" />
									</c:otherwise>
								</c:choose>
							</div>
							<div class="text-center">
								<ul class="list-group">
									<li class="list-group-item"><label>Porte: </label>
										${petItem.size}</li>
									<li class="list-group-item"><label>Tipo: </label>
										${petItem.type.description}</li>
									<li class="list-group-item"><label>Raça: </label>
										${petItem.race.description}</li>
									<li class="list-group-item"><label>Cor: </label>
										${petItem.color.description}</li>
									<li class="list-group-item"><label>Sexo: </label>
										${petItem.gender}</li>
									<li class="list-group-item"><label>Castrado: </label>
										${petItem.isNeutered}</li>
									<li class="list-group-item"><label>Deficiencia: </label>
										${petItem.deficiency}</li>
								</ul>
							</div>
							<div class="text-right">
								<button type="button" class="btn btn-info">Editar</button>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<jsp:include page="../anuncios/anuncios.jsp" />
	</div>
</body>
</html>