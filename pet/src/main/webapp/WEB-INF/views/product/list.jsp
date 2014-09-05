<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../main/main.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/res/js/lightbox.js"></script>
<title>Lista Produtos</title>
</head>
<body>

	<c:import url="../main/navbar.jsp" />


	<div class="container-fluid">

		<div class="row">
			<div class="col-md-3">
				<jsp:include page="../menu/menuLateralEsquerdoPetShop.jsp" />
			</div>

			<div id="painelDeProdutos" class="col-md-6 bordered-collum">


				<c:forEach var="productItem" items="${products}">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<strong>${productItem.name}</strong>
						</div>
						<div class="panel-body">


							<div class="text-center">
								<c:choose>
									<c:when test="${fn:length(productItem.linkPhoto) == 0}">
										<img id="uploadPreview"
											src="../pet/res/images/noImagemAnimal.jpg" width="200"
											height="200" />
									</c:when>
									<c:otherwise>
										<img id="uploadPreview" src="${productItem.linkPhoto}"
											width="200" height="200" />
									</c:otherwise>
								</c:choose>
							</div>


							<div class="text-center">
								<ul class="list-group">
									<li class="list-group-item"><label>Porte: </label>
										${productItem.size}</li>
									<li class="list-group-item"><label>Tipo: </label>
										${productItem.type.description}</li>
									<li class="list-group-item"><label>Raça: </label>
										${productItem.race.description}</li>
									<li class="list-group-item"><label>Pontos: </label>
										${productItem.score}</li>
									<li class="list-group-item"><label>Preço: </label>
										${productItem.price}</li>
									<li class="list-group-item"><label>Stage: </label>
										${productItem.stage}</li>
									<li class="list-group-item"><label>Página do
											Anuncio: </label> ${productItem.linkAnuncio}</li>
									<li class="list-group-item"><label>ATIVADO: </label>
										${productItem.isActive}</li>
								</ul>
							</div>
							<div class="text-right">


								<!-- 	<button onclick="startLightBox('editar-form','${pageContext.request.contextPath}')" 
									class="btn btn-info">Editar</button>
								
								 -->

								<c:set var="toedit" value="${productItem}" scope="request"></c:set>

								<!-- Button trigger modal -->
								<button class="btn btn-info" data-toggle="modal"
									data-target="#myModal${productItem.id}">Editar</button>

								<!-- <form class="navbar-form navbar-left" action="deleteProduct">
									<button type="submit" class="btn btn-info">Excluir</button>
								</form>-->
							</div>
						</div>


						<!-- Modal -->
						<div class="modal fade" id="myModal${productItem.id}"
							tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel${productItem.id}"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">
											<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
										</button>
										<h4 class="modal-title" id="myModalLabel${productItem.id}">Editar
											${productItem.name}</h4>
									</div>


									<form action="updateProduct" method="post"
										enctype="multipart/form-data">

										<input type="hidden" name="id" value="${productItem.id}">


										<div class="modal-body">


											<div class="row">

												<div class="col-md-8 form-group">
													<label for="name">Nome</label> <input type="text"
														name="name" class="form-control"
														value="${productItem.name}">
												</div>

												<div class="col-md-4 form-group">
													<label for="price">Preço</label>
													<div class="input-group">
														<input type="text" class="form-control" name="price"
															value="${productItem.price}"> <span
															class="input-group-addon">Price</span>
													</div>
												</div>

											</div>


											<fieldset>
												<legend>Perfil</legend>
											</fieldset>

											<div class="row">

												<div class="form-group col-md-3">
													<label for="type">Tipo</label> <select name="type.id"
														class="form-control">
														<c:forEach var="typeItem" items="${types}">
															<option value="<c:out value='${typeItem.id}' />">
																<c:out value="${typeItem.description}" />
															</option>
														</c:forEach>
													</select>
												</div>



												<div class="form-group col-md-3">
													<label for="race">Raça</label> <select name="race.id"
														class="form-control">
														<c:forEach var="raceItem" items="${races}">
															<option value="<c:out value='${raceItem.id}' />">
																<c:out value="${raceItem.description}" />
															</option>
														</c:forEach>
													</select>
												</div>



												<div class="form-group col-md-3">
													<label for="size">Porte</label> <select name="size"
														class="form-control">
														<option value="SMALL">Pequeno</option>
														<option value="MID">Médio</option>
														<option value="BIG">Grande</option>
													</select>
												</div>

												<div class="form-group col-md-3">
													<label for="stage">Idade</label> <select name="stage"
														class="form-control">
														<option>Todos</option>
														<option>Filhote</option>
														<option>Adulto</option>
													</select>
												</div>

											</div>


											<div class="row">

												<div class="col-md-3 form-group">
													<label for="score">Pontos</label> <input type="text"
														name="score" class="form-control"
														value="${productItem.score}">
												</div>

												<div class="col-md-4 form-group">
													<label for="linkPhoto">Link Foto</label> <input type="text"
														name="linkPhoto" class="form-control"
														value="${productItem.linkPhoto}">
												</div>

												<div class="col-md-4 form-group">
													<label for="linkAnuncio">Link Anuncio</label> <input
														type="text" name="linkAnuncio" class="form-control"
														value="${productItem.linkAnuncio}">
												</div>
											</div>

											<div class="row">
												<div class="checkbox col-md-2">
													<label> <input type="checkbox" name="isActive"
														value="true"> ATIVADO
													</label>
												</div>
											</div>

										</div>

										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
											<button type="submit" class="btn btn-primary">Save
												changes</button>
										</div>

									</form>



								</div>
							</div>
						</div>
					</div>
				</c:forEach>



			</div>
			<jsp:include page="../anuncios/anuncios.jsp" />
		</div>

	</div>

</body>
</html>