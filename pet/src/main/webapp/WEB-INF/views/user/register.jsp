<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../main/main.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Junte-se a nós</title>
</head>


<body>


	<nav class="navbar navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.html"> <img
				class="logo-image" src="../pet/res/images/4OurLives-Logo.png">
			</a>
		</div>
	</div>
	</nav>
	<div class="container">
		<form id="register" name="register" action="registerUser"
			method="post" enctype="multipart/form-data">

			<fieldset>
				<legend>Junte-se a nós</legend>
				<div class="row">

					<div class="col-md-10 col-sm-12">
						<div class="form-group">
							<img id="uploadPreview" src="../pet/res/images/imageDefault.jpg"
								width="100" height="100" />
						</div>
						<div class="form-group">
							<input type="file" id="file" name="file" title="Adicionar foto"
								onchange="check_file(); previewImage();" class="btn btn-primary">
						</div>
					</div>
					<div class="col-md-6 col-sm-12">
						<div class="form-group">
							<label for="name">Nome*</label> <input type="text"
								class="form-control" id="user.name" name="user.name"
								placeholder="Digite seu nome completo...">
						</div>
					</div>

					<div class="col-md-2 col-sm-12">
						<label for="birth">Data de Nascimento</label> <input type="date"
							class="form-control" id="birth" name="user.birth">
					</div>

					<div class="col-md-2 col-sm-12">
						<div class="form-group">
							<label for="phone">Telefone</label> <input type="text"
								class="form-control" id="phone" name="user.phone">
						</div>
					</div>

					<div class="col-md-2 col-sm-12">
						<div class="form-group">
							<label for="cellphone">Celular</label> <input type="text"
								class="form-control" id="cellphone" name="user.cellphone">
						</div>
					</div>

				</div>

				<div class="row">
					<div class="col-md-3 col-sm-12">
						<div class="form-group">
							<label for="email">E-mail*</label> <input type="text"
								class="form-control" id="user.email" name="user.email"
								placeholder="Digite seu email..." value="${email}">
						</div>
					</div>

					<div class="col-md-3 col-sm-12">
						<div class="form-group">
							<label for="confirmEmail">Confirmar E-mail*</label> <input
								type="text" class="form-control" id="confirmEmail"
								name="confirmEmail" placeholder="Digite seu email...">
						</div>
					</div>

					<div class="col-md-2 col-sm-12">
						<div class="form-group">
							<label for="password">Senha*</label> <input type="password"
								class="form-control" id="user.password" name="user.password"
								placeholder="Informe sua senha..." value="${password}">
						</div>
					</div>

					<div class="col-md-2 col-sm-12">
						<div class="form-group">
							<label for="confirmPassword">Confirmar Senha*</label> <input
								type="password" class="form-control" id="confirmPassword"
								placeholder="Confirme sua senha..." name="confirmPassword">
						</div>
					</div>


				</div>


				<div class="row">

					<div class="col-md-2 col-sm-12">
						<div class="form-group">
							<label for="zipcode">CEP</label> <input type="text"
								class="form-control" id="zipcode" name="user.address.zipcode">
						</div>
					</div>

					<div class="col-md-1 col-sm-12">
						<div class="form-group">
							<label for="state">UF</label> <input type="text"
								class="form-control" id="state" name="user.address.state">
						</div>
					</div>

					<div class="col-md-3 col-sm-12">
						<label for="city">Cidade</label> <input type="text"
							class="form-control" id="city" name="user.address.city">
					</div>

					<div class="col-md-5 col-sm-12">
						<div class="form-group">
							<label for="street">Endereço</label> <input type="text"
								id="street" name="user.address.street" class="form-control">
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-2">
						<label> <input name="radioGroup" id="isOwner"
							value="option1" checked="checked" type="radio"> Dono de
							animal
						</label>
					</div>
					<div class="col-md-1">
						<label> <input name="radioGroup" id="isOfNGO"
							value="option2" type="radio"> ONG
						</label>
					</div>
					<div class="col-md-2">
						<label> <input name="radioGroup" id="isOfPetShop"
							value="option3" type="radio"> Pet Shop
						</label>
					</div>
				</div>
				<br />
			</fieldset>

			<fieldset id="company" class="companyHidden" style="display: none;">

				<legend>Dados da Empresa</legend>

				<div class="row">
					<div class="col-md-6 col-sm-12">
						<div class="form-group">
							<label for="company.name">Nome/Razão Social</label> <input
								type="text" class="form-control" id="company.name"
								name="company.name">
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-5 col-sm-12">
						<div class="form-group">
							<label for="cnpj">CNPJ</label> <input type="text"
								class="form-control" id="cnpj" name="company.cnpj">
						</div>
					</div>

					<div class="col-md-5 col-sm-12">
						<div class="form-group">
							<label for="site">Site</label> <input type="text"
								class="form-control" id="company.site" name="company.site">
						</div>
					</div>
				</div>

			</fieldset>

			<c:if test="${existeUser}">
			   <p style="font-size:17px; color: red;">Usuário já cadastrado em nosso sistema !!!</p>
			</c:if>
			
			<div class="row" id="Cadastrar">
				<div class="row">
					<div class="col-md-2 col-sm-12">
						<div class="form-group">
							<input type="submit"
								class="form-control form-button btn btn-success"
								id="btnCadastrar" value="Cadastrar">
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
