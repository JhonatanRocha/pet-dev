<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../main/main.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Junte-se a nós</title>
</head>
<body>

	<div class="container">
		<nav class="navbar navbar-inverse" role="navigation"> <a
			class="navbar-brand" href="#">Pet*</a> </nav>
		<form action="registerUser">


			<fieldset>
				<legend>Junte-se a nós</legend>

				<div class="row">
					<div class="col-xs-6">
						<div class="form-group">
							<label for="name">Nome</label> <input type="text"
								class="form-control" id="name" name="name">
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-xs-6">
						<div class="form-group">
							<label for="email">E-mail</label> <input type="text"
								class="form-control" id="email" name="email">
						</div>
					</div>

					<div class="col-xs-6">
						<div class="form-group">
							<label for="confirmEmail">Confirmar E-mail</label> <input
								type="text" class="form-control" id="confirmEmail"
								name="confirmEmail">
						</div>
					</div>

				</div>

				<div class="row">
					<div class="col-xs-5">
						<div class="form-group">
							<label for="password">Senha</label> <input type="password"
								class="form-control" id="password" name="password">
						</div>
					</div>

					<div class="col-xs-5 col-xs-offset-1">
						<div class="form-group">
							<label for="confirmPassword">Confirmar Senha</label> <input
								type="password" class="form-control" id="confirmPassword"
								name="confirmPassword">
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-xs-2">
						<div class="form-group">
							<label for="phone">Telefone</label> <input type="text"
								class="form-control" id="phone" name="phone">
						</div>
					</div>

					<div class="col-xs-2">
						<div class="form-group">
							<label for="celphone">Celular</label> <input type="text"
								class="form-control" id="celphone" name="celphone">
						</div>
					</div>

				</div>

				<div class="row">
					<div class="col-xs-2">
						<div class="form-group">
							<label for="zipcode">CEP</label> <input type="text"
								class="form-control" id="zipcode" name="zipcode">
						</div>
					</div>

					<div class="col-xs-1">
						<div class="form-group">
							<label for="state">UF</label> <input type="text"
								class="form-control" id="state" name="state">
						</div>
					</div>

					<div class="col-xs-4 col-xs-offset-1">
						<label for="city">Cidade</label> <input type="text"
							class="form-control" id="city" name="city">
					</div>

				</div>

			</fieldset>
		</form>

	</div>


</body>
</html>