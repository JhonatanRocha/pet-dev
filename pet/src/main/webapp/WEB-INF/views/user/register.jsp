<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:import url="../main/main.jsp" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Junte-se a nós</title>
</head>


<body onload="complementaFormulario();">

	<div class="container">
		<nav class="navbar navbar-inverse" role="navigation">
		 	<a	class="navbar-brand" href="#">4 Our Lives</a> 
		 </nav>
		<form name="register" action="registerUser" method="post">

			<fieldset>
				<legend>Junte-se a nós</legend>

				<div class="row">
					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="name">Nome</label> <input type="text" class="form-control" id="name" name="name">
						</div>
					</div>
					
					<div class="col-md-2 col-xs-12">
						<label for="birth">Data de Nascimento</label>
						<input type="text" class="form-control" id="birth" name="birth">
					</div>
				</div>

				<div class="row">
					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="email">E-mail</label> 
							<input type="text" class="form-control" id="email" name="email" value="${email}">
						</div>
					</div>

					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="confirmEmail">Confirmar E-mail</label> 
							<input type="text" class="form-control" id="confirmEmail" name="confirmEmail">
						</div>
					</div>

				</div>

				<div class="row">
					<div class="col-md-5 col-xs-12">
						<div class="form-group">
							<label for="password">Senha</label> 
							<input type="password" class="form-control" id="password" name="password" value="${password}">
						</div>
					</div>

					<div class="col-md-5 col-md-offset-1 col-xs-12">
						<div class="form-group">
							<label for="confirmPassword">Confirmar Senha</label>
							<input type="password" class="form-control" id="confirmPassword" name="confirmPassword">
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-2 col-xs-12">
						<div class="form-group">
							<label for="phone">Telefone</label>
							<input type="text" class="form-control" id="phone" name="phone">
						</div>
					</div>

					<div class="col-md-2 col-md-offset-	1 col-xs-12">
						<div class="form-group">
							<label for="cellphone">Celular</label>
							<input type="text" class="form-control" id="cellphone" name="cellphone">
						</div>
					</div>

					<div class="col-md-2 col-md-offset-2 col-xs-12">
						<div class="form-group">
							<label for="zipcode">CEP</label> 
						 	<input type="text" class="form-control" id="zipcode" name="zipcode">
						</div>
					</div>

					<div class="col-md-1 col-xs-12">
						<div class="form-group">
							<label for="state">UF</label>
							<input type="text" class="form-control" id="state" name="state">
						</div>
					</div>
				</div>

				<div class="row">

					<div class="col-md-6 col-xs-12">
						<label for="city">Cidade</label>
						<input type="text" class="form-control" id="city" name="city">
					</div>

					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="street">Endereço</label>
							<input type="text" id="street" name="street" class="form-control">
						</div>
					</div>
					
					<input type="hidden" id="isOwner" name="isOwner" value="${isOwner}">
					<input type="hidden" id="isOfPetShop" name="isOfPetShop" value="${isOfPetShop}">
					<input type="hidden" id="isOfNGO" name="isOfNGO" value="${isOfNGO}">
					
					
					<div class="row">
						<div class="col-md-2 col-xs-12">
							<div class="form-group">
								<input type="submit" class="form-control form-button btn btn-success" value="Cadastrar">
							</div>
						</div>
					</div>
				</div>
			</fieldset>
			
	
			<c:if test="${isOfPetShop || isOfNGO}">
			<fieldset id="dadoscomplecompany">
			
				<legend>Dados da Empresa</legend>

				<div class="row">
					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="company.name">Nome</label> <input type="text" class="form-control" id="company.name" name="company.name">
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="cnpj">CNPJ</label> 
							<input type="text" class="form-control" id="company.cnpj" name="cnpj">
						</div>
					</div>

					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="site">Site</label> 
							<input type="text" class="form-control" id="company.site" name="site">
						</div>
					</div>
				</div>
				
			</fieldset>	
			</c:if>
		</form>
	</div>
	
</body>
</html>
