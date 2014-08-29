<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../main/main.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				<div class="panel panel-primary">
			
					
					
					
					<c:forEach var="productItem" items="${products}">
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
									<li class="list-group-item"><label>Página do Anuncio: </label>
										${productItem.linkAnuncio}</li>
								</ul>
							</div>
							<div class="text-right">
								<form class="navbar-form navbar-left" action="editProduct">
									<button type="submit" class="btn btn-info">Editar</button>
								</form>
								<form class="navbar-form navbar-left" action="deleteProduct">
									<button type="submit" class="btn btn-info">Excluir</button>
								</form>
							</div>
						</div>
					</c:forEach>
					
					
				</div>
			</div>
			<jsp:include page="../anuncios/anuncios.jsp" />
		</div>
		
	</div>
</body>
</html>