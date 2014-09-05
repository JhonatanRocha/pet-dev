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
<title>Painel de Rregras</title>
</head>
<body>

	<c:import url="../main/navbar.jsp" />

	<div class="container-fluid">

		<div class="row">
			<div class="col-md-3">
				<jsp:include page="../menu/menuLateralEsquerdoPetShop.jsp" />
			</div>

			<div id="painelDeProdutos" class="col-md-6 bordered-collum">




				<c:forEach var="ruleItem" items="${rules}">
					<div class="well well-lg">

						<div class="container-fluid">
							<div class="row">

								<div class="col-md-2">
									<c:choose>
										<c:when test="${fn:length(ruleItem.product.linkPhoto) == 0}">
											<img id="uploadPreview"
												src="../pet/res/images/noImagemAnimal.jpg" width="80"
												height="80" />
										</c:when>
										<c:otherwise>
											<img id="uploadPreview" src="${ruleItem.product.linkPhoto}"
												width="80" height="80" />
										</c:otherwise>
									</c:choose>
								</div>


								<div class="col-md-5">
									<ul class="list-group">
										<li class="list-group-item"><label>Tipo: </label>
											${ruleItem.product.type.description}</li>
										<li class="list-group-item"><label>Porte: </label>
											${ruleItem.product.size}</li>
										<li class="list-group-item"><label>Raça: </label>	
											${ruleItem.product.race.description}</li>
										<li class="list-group-item"><label>Stage: </label>
											${ruleItem.product.stage}</li>
										<li class="list-group-item"><label>Pontos: </label>
											${ruleItem.product.score}</li>
										<li class="list-group-item"><label>Preço: </label>

									</ul>
								</div>
								
											
								<form action="updateRule" method="post" enctype="multipart/form-data">
								
									<input type="hidden" name="product.id" value="${ruleItem.product.id}">
									<input type="hidden" name="id" value="${ruleItem.id}">
													
									<div class="col-md-5">
										<ul class="list-group">
											<li class="list-group-item">
												<label> 
													<input type="checkbox" name="type" value="true"
														<c:if test="${ruleItem.type}">checked</c:if>>
													Usar Tipo?
												</label>
											</li>
											
											<li class="list-group-item">
												<label> 
													<input type="checkbox" name="race" value="true"
													<c:if test="${ruleItem.race}">checked</c:if>>
													Usar Raça?
												</label>
											</li>
											
											<li class="list-group-item">
												<label> 
													<input type="checkbox" name="stage" value="true"
													<c:if test="${ruleItem.stage}">checked</c:if>>
													Usar Idade?
												</label>
											</li>
											
											<li class="list-group-item">
												<label> 
													<input type="checkbox" name="size" value="true"
													<c:if test="${ruleItem.size}">checked</c:if>>
													Usar Porte?
												</label>
											</li>
											
											<li class="list-group-item">
												<label> 
													<input type="checkbox" name="score" value="true"
													<c:if test="${ruleItem.score}">checked</c:if>>
													Usar Pontos do Usuário?
												</label>
											</li>
											
										
										
										</ul>
									</div>
								
									<button type="submit" class="btn btn-primary">Save changes</button>
								</form>
								
								
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