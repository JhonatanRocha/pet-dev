<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../main/main.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Meus Vouchers</title>
</head>
<body>

	<c:import url="../main/navbar.jsp" />
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-3">
				<jsp:include page="../menu/menuLateralEsquerdo.jsp" />
			</div>

			<div class="col-md-6 bordered-collum">

				<c:forEach var="voucher" items="${loggedUser.vouchers}">

						<div class="panel panel-primary">

							<div class="panel-heading">
								<strong>VOUCHER: ${voucher.number}</strong>
							</div>

							<div class="panel-body">

									<div class="col-md-4">
										<ul class="list-group">
										<c:if test="${not empty voucher.ngo}">
											<li class="list-group-item"><label>ONG: </label>
												${voucher.ngo.name}</li>
										</c:if>
										<c:if test="${not empty voucher.petShop}">
											<li class="list-group-item"><label>PetShop: </label>
												${voucher.petShop.name}</li>
										</c:if>
										
										<li class="list-group-item">
											<label>Voucher de: </label>
											<c:if test="${voucher.tipo == 1 }">
												Adoção
											</c:if>
											<c:if test="${voucher.tipo == 2 }">
												Apadrinhamento
											</c:if>
											<c:if test="${voucher.tipo == 3 }">
												Doação
											</c:if>
										</li>
														
										<li class="list-group-item"><label>Você aind apode usar mais: </label>
												${5 - voucher.usado} vezes</li>
																				
										</ul>
									</div>
									<div class="col-md-4">

									<form action="getVoucherAnimal" method="post" enctype="multipart/form-data" target="_blank">
											<input type="hidden" name="id" value="${voucher.id}"> 
											<button class="btn btn-primary btn-lg btn-block" type="submit">VISUALIZAR</button>
									</form>
									<br><br><br>
									<c:if test="${voucher.usado <= 4}">
										<form action="sendVoucherAnimal" method="post" enctype="multipart/form-data">
											<input type="hidden" name="id" value="${voucher.id}"> 
											<button class="btn btn-primary btn-lg btn-block" type="submit">USAR VOUCHER</button>
										</form>	
									</c:if>
										
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