<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../main/main.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<nav class="navbar navbar-inverse" role="navigation">
	<div class="container">
	<div class="navbar-header">
			<a class="navbar-brand" href="index.html"> <img
				class="logo-image" src="../pet/res/images/4OurLives-Logo.png"> 
			</a>
		</div>
		<div class="pull-right">

			<form class="navbar-form navbar-left" action="efetuaLogin"
				role="search">
				<div class="form-group">
					<input type="text" name="email" class="form-control"
						placeholder="login"> <input type="password"
						name="password" class="form-control" placeholder="Senha">
				</div>
				<button type="submit" class="btn btn-primary">Login</button>
			</form>
		</div>
	</div>

	</nav>
	<div class="container">

		<div class="row">
			<div class="col-xs-6">
				<fieldset>
					<legend>Quem Somos</legend>
				</fieldset>
				Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam
				nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat
				volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation
				ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo
				consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate
				velit esse molestie consequat, vel illum dolore eu feugiat nulla
				facilisis at vero eros et accumsan et iusto odio dignissim qui
				blandit praesent luptatum zzril delenit augue duis dolore te feugait
				nulla facilisi. Nam liber tempor cum soluta nobis eleifend option
				congue nihil imperdiet doming id quod mazim placerat facer possim
				assum. Typi non habent claritatem insitam; est usus legentis in iis
				qui facit eorum claritatem. Investigationes demonstraverunt lectores
				legere me lius quod ii legunt saepius. Claritas est etiam processus
				dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est
				notare quam littera gothica, quam nunc putamus parum claram,
				anteposuerit litterarum formas humanitatis per seacula quarta decima
				et quinta decima. Eodem modo typi, qui nunc nobis videntur parum
				clari, fiant sollemnes in futurum.
			</div>

			<div class="col-xs-4 col-xs-offset-2">
				<form action="novoUsuario" method="post">
					<fieldset>
						<legend> Abra uma conta e junte-se a nós</legend>

						<div class="row">

							<div class="col-xs-12">
								<div class="form-group">
									<label for="email">E-mail</label> <input type="text"
										class="form-control" id="email" name="email">
								</div>
							</div>

						</div>

						<div class="row">

							<div class="col-xs-12">
								<div class="form-group">
									<label for="password">Senha</label> <input type="password"
										class="form-control" id="password" name="password">
								</div>
							</div>

							<div class="row">
								<div class="col-xs-4">
									<div class="form-group">
										<input type="submit"
											class="form-control form-button btn btn-success"
											value="Cadastrar">
									</div>
								</div>
							</div>

						</div>
					</fieldset>
				</form>
			</div>

		</div>

	</div>
</body>
</html>