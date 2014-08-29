<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../main/main.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>


<body>


	<nav class="navbar navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.servletContext.contextPath}"> <img
				class="logo-image" src="../pet/res/images/4OurLives-Logo.png">
			</a>
		</div>
	</div>
	</nav>
	<div class="container">
		<form id="register" name="register" action="alterUser"
			method="post" enctype="multipart/form-data">

			<fieldset>
				<div class="row">

					<div class="col-md-10 col-sm-12">
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
						<br><br>
						<div class="form-group">
							<input type="file" id="file" name="file" title="Alterar foto"
								onchange="check_file(); previewImage();" class="btn btn-primary">
						</div>
					</div>
					<div class="col-md-6 col-sm-12">
						<div class="form-group">
							<label for="name">Nome*</label> 
							<input type="text"
								class="form-control" id="user.name" name="user.name"
								value="${loggedUser.name }">
						</div>
					</div>

					<div class="col-md-2 col-sm-12">
						<label for="birth">Data de Nascimento</label> 
						<input type="date"
							class="form-control" id="birth" name="user.birth"
							value="${loggedUser.birth }">
					</div>

					<div class="col-md-2 col-sm-12">
						<div class="form-group">
							<label for="phone">Telefone</label>
							<input type="text"
								class="form-control" id="phone" name="user.phone"
								value="${loggedUser.phone }">
						</div>
					</div>

					<div class="col-md-2 col-sm-12">
						<div class="form-group">
							<label for="cellphone">Celular</label> 
							<input type="text"
								class="form-control" id="cellphone" name="user.cellphone"
								value="${loggedUser.cellphone }">
						</div>
					</div>

				</div>

				<div class="row">
					<div class="col-md-3 col-sm-12">
						<div class="form-group">
							<label for="email">E-mail*</label> 
							<input type="text"
								class="form-control" id="user.email" 
								name="user.email"
								value="${loggedUser.email}">
						</div>
					</div>

					<div class="col-md-2 col-sm-12">
						<div class="form-group">
							<label for="password">Senha*</label> <input type="password"
								class="form-control" id="user.password" name="user.password"
								placeholder="Digite sua nova senha..." value="${password}">
						</div>
					</div>

				</div>


				<div class="row">

					<div class="col-md-2 col-sm-12">
						<div class="form-group">
							<label for="zipcode">CEP</label> <input type="text"
								class="form-control" id="zipcode" name="user.address.zipcode"
								value="${loggedUser.address.zipcode}">
						</div>
					</div>

					<div class="col-md-1 col-sm-12">
						<div class="form-group">
							<label for="state">UF</label> <input type="text"
								class="form-control" id="state" name="user.address.state"
								value="${loggedUser.address.state}">
						</div>
					</div>

					<div class="col-md-3 col-sm-12">
						<label for="city">Cidade</label> <input type="text"
							class="form-control" id="city" name="user.address.city"
							value="${loggedUser.address.city}">
					</div>

					<div class="col-md-5 col-sm-12">
						<div class="form-group">
							<label for="street">Endereço</label> <input type="text"
								id="street" name="user.address.street" class="form-control"
								value="${loggedUser.address.street}">
						</div>
					</div>
				</div>

			</fieldset>

			
			<c:if test="${(loggedUser.isOfPetShop) || (loggedUser.isOfNGO)}">
				<fieldset id="company" class="companyHidden" style="display: block;">
	
					<legend>Dados da Empresa</legend>
	
					<div class="row">
						<div class="col-md-6 col-sm-12">
							<div class="form-group">
								<label for="company.name">Nome/Razão Social</label> <input
									type="text" class="form-control" id="company.name"
									value="${loggedPetShop.name}"
									name="company.name">
							</div>
						</div>
					</div>
	
					<div class="row">
						<div class="col-md-5 col-sm-12">
							<div class="form-group">
								<label for="cnpj">CNPJ</label> <input type="text"
									class="form-control" id="cnpj" name="company.cnpj"
									value="${loggedPetShop.cnpj}">
							</div>
						</div>
	
						<div class="col-md-5 col-sm-12">
							<div class="form-group">
								<label for="site">Site</label> <input type="text"
									class="form-control" id="company.site" name="company.site"
									value="${loggedPetShop.site}">
							</div>
						</div>
					</div>
	
				</fieldset>
			</c:if>
			
			<div class="row" id="Cadastrar">
				<div class="row">
					<div class="col-md-2 col-sm-12">
						<div class="form-group">
							<input type="submit"
								class="form-control form-button btn btn-success"
								id="btnCadastrar" value="Alterar">
						</div>
					</div>
				</div>
			</div>

		</form>
	</div>

</body>

<script>
	// Altera estilo do botao type file
	$('input[type=file]').bootstrapFileInput();
	$('.file-inputs').bootstrapFileInput();
</script>

</html>
