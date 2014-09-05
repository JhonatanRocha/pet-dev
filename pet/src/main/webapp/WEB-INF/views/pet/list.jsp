<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../main/main.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Animais</title>
</head>
<body>

	<c:import url="../main/navbar.jsp" />
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-3">
				<jsp:include page="../menu/menuLateralEsquerdo.jsp" />
			</div>

			<div id="painelDeAnimais" class="col-md-6 bordered-collum">




				<c:forEach var="petItem" items="${pets}">

					<div class="panel panel-primary">

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
									<li class="list-group-item"><label>Idade: </label>
										${petItem.stage}</li>
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
									<li class="list-group-item"><label>Ativo: </label>
										${petItem.isActive}</li>
								</ul>

							</div>



							<div class="text-right">
								<c:set var="toedit" value="${petItem}" scope="request"></c:set>
								<!-- Button trigger modal -->
								<button class="btn btn-info" data-toggle="modal"
									data-target="#myModal${petItem.id}">Editar</button>
							</div>


							<!-- Modal -->
							<div class="modal fade" id="myModal${petItem.id}" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel${petItem.id}"
								aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">
												<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
											</button>
											<h4 class="modal-title" id="myModalLabel${petItem.id}">Editar
												${petItem.name}</h4>
										</div>


										<form action="updatePet" method="post"
											enctype="multipart/form-data">

											<input type="hidden" name="id" value="${petItem.id}">

											<div class="modal-body">

												<div class="row">
													<div class="col-md-10 col-sm-12">
														<div class="form-group">
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
														<div class="form-group">
															<input type="file" id="file" name="file"
																title="Adicionar foto"
																onchange="check_file(); previewImage();"
																class="btn btn-primary">
														</div>
													</div>
												</div>



												<div class="row">

													<div class="col-md-6 form-group">
														<label for="name">Nome</label> <input type="text"
															name="name" class="form-control" value="${petItem.name}">
													</div>


													<div class="form-group col-md-3">
														<label for="stage">Idade</label> <select name="stage"
															class="form-control">
															<option>Todos</option>
															<option>Filhote</option>
															<option>Adulto</option>
														</select>
													</div>

													<div class="form-group col-md-2">
														<label for="gender">Gênero</label>
														<div class="radio">
															<div class="radio-inline">
																<label> <input type="radio" name="gender"
																	value="M"
																	<c:if test="${fn:contains(petItem.gender,'M')}">checked</c:if>>
																	Macho
																</label>
															</div>
															<div class="radio-inline">
																<label> <input type="radio" name="gender"
																	value="F"
																	<c:if test="${fn:contains(petItem.gender,'F')}">checked</c:if>>
																	Fêmea
																</label>
															</div>
														</div>
													</div>
												</div>


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
														<label for="color">Cor</label> <select name="color.id"
															class="form-control">
															<c:forEach var="colorItem" items="${colors}">
																<option value="<c:out value='${colorItem.id}' />">
																	<c:out value="${colorItem.description}" />
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


												</div>


												<div class="row">

													<div class="col-md-3 form-group">
														<label for="isNeutered">É castrado? <input
															type="checkbox" name="isNeutered" value="true"
															<c:if test="${petItem.isNeutered}">checked</c:if>>
														</label>
													</div>

													<div class="col-md-3 form-group">
														<label for="isDeficient">Possui alguma
															deficiência? <input type="checkbox" name="isDeficient"
															value="true"
															<c:if test="${petItem.isDeficient}">checked</c:if>>
														</label>
													</div>

													<div class="col-md-4 form-group">
														<label for="deficiency">Qual?</label> <input type="text"
															name="deficiency" class="form-control"
															value="${petItem.deficiency}">
													</div>

												</div>

												<div class="row">
													<div class="checkbox col-md-2">
														<label> <input type="checkbox" name="isActive"
															value="true"
															<c:if test="${petItem.isActive}">checked</c:if>>
															ATIVADO
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