<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../main/main.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<style>
#map_canvas {
	width: 300px;
	height: 300px;
}
</style>
<script src="https://maps.googleapis.com/maps/api/js"></script>
<script>
	function initialize() {
		var mapCanvas = document.getElementById('map_canvas');
		var mapOptions = {
			center : new google.maps.LatLng(44.5403, -78.5463),
			zoom : 8,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		}
		var map = new google.maps.Map(mapCanvas, mapOptions)
	}
	google.maps.event.addDomListener(window, 'load', initialize);
</script>


<title>Lista Animais Para Adoção</title>
</head>
<body>

	<c:import url="../main/navbar.jsp" />
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-3">
				<jsp:include page="../menu/menuLateralEsquerdo.jsp" />
			</div>

			<div id="painelDeAnimais" class="col-md-6 bordered-collum">

				<c:forEach var="ngoItem" items="${ngos}">

					<c:forEach var="petItem" items="${ngoItem.pets}">


						<div class="panel panel-primary">

							<div class="panel-heading">
								<strong>${petItem.name}</strong>
							</div>

							<div class="panel-body">

								<div class="row">
									<div class="col-md-4">
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

									<div class="col-md-4">
										<ul class="list-group">
											<li class="list-group-item"><label>Idade: </label>
												${petItem.stage}</li>
											<li class="list-group-item"><label>Raça: </label>
												${petItem.race.description}</li>
											<li class="list-group-item"><label>Cor: </label>
												${petItem.color.description}</li>
										</ul>
									</div>
									<div class="col-md-4">
										<ul class="list-group">
											<li class="list-group-item"><label>Sexo: </label>
												${petItem.gender}</li>
											<li class="list-group-item"><label>Castrado: </label>
												${petItem.isNeutered}</li>
											<li class="list-group-item"><label>Deficiencia:</label>
												${petItem.deficiency}</li>
										</ul>
									</div>

									<div class="col-md-4">
										<h4>
											<span class="label label-warning">Quer Apadrinhar ou</span>
										</h4>
										<h4>
											<span class="label label-warning">Adotar esse Pet??</span>
										</h4>
									</div>


									<div class="col-md-4">

										<!-- Button trigger modal -->
										<button class="btn btn-success btn-lg btn-block"
											data-toggle="modal" data-target="#myModal${ngoItem.id}">Fale
											com a ONG!</button>
									</div>

								</div>

							</div>

						</div>
					</c:forEach>


					<c:set var="toedit" value="${ngoItem}" scope="request"></c:set>

					<!-- Modal -->
					<div class="modal fade" id="myModal${ngoItem.id}" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel${ngoItem.id}"
						aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">
										<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
									</button>
									<h4 class="modal-title" id="myModalLabel${ngoItem.id}">${ngoItem.name}</h4>
								</div>

								<div class="modal-body">

									<div class="row">

										<fieldset>
											<legend>Informações da ${ngoItem.name}:</legend>
										</fieldset>

										<div class="col-md-5 form-group">

											<ul class="list-group">
												<li class="list-group-item"><label>Site:</label>
													${ngoItem.site}</li>
												<li class="list-group-item"><label>Email:</label>
													${ngoItem.administrator.email}</li>
												<li class="list-group-item"><label>Tel.:</label>
													${ngoItem.administrator.phone}</li>
												<li class="list-group-item"><label>CEP.:</label>
													${ngoItem.administrator.address.zipcode}</li>
											</ul>


											<fieldset>
												<legend>Envie um email sobre:</legend>
											</fieldset>

											<div class="well" style="max-width: 200px; margin: 0 auto 10px;">
												<button type="button" class="btn btn-success">Sobre
													Adoção</button>
												<button type="button" class="btn btn-success">Sobre
													Apadrinhamento</button>
												<button type="button" class="btn btn-primary">Sobre
													Doações</button>
											</div>


										</div>

										<div class="col-md-6 form-group">
											<div id="map_canvas"></div>
											<h5>${ngoItem.administrator.address.street}-
												${ngoItem.administrator.address.city} -
												${ngoItem.administrator.address.state}</h5>

										</div>

									</div>

								</div>


							</div>
						</div>
					</div>

				</c:forEach>

			</div>
			<jsp:include page="../anuncios/anuncios.jsp" />
		</div>

	</div>

	<script type="text/javascript">
		//Altera estilo do botao type file
		$('input[type=file]').bootstrapFileInput();
		$('.file-inputs').bootstrapFileInput();
	</script>
</body>
</html>