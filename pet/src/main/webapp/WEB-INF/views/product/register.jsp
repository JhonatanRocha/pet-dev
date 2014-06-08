<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../main/main.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo Produto</title>
</head>
<body>

	<c:import url="../main/navbar.jsp" />

	<div class="container">
		<fieldset>
			<legend>Novo Produto</legend>
		</fieldset>

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
		</div>

		<div class="row">
			<div class="col-md-4 form-group">
				<label for="name">Nome</label> <input type="text" id="name"
					name="name" class="form-control">
			</div>

			<div class="col-md-2 form-group">
				<label for="price">Preço</label>
				<div class="input-group">
					<input type="text" class="form-control" name="price" id="price"><span
						class="input-group-addon">pts.</span>
				</div>
			</div>
		</div>


		<fieldset>
			<legend>Perfil</legend>
		</fieldset>
		<div class="row">

			<div class="form-group col-md-2">
				<label for="type">Tipo</label> <select id="type" name="type"
					class="form-control">
					<option>Todos</option>
					<option>Cachorro</option>
					<option>Gato</option>
				</select>
			</div>

			<div class="form-group col-md-2">
				<label for="breed">Raça</label> <select id="breed" name="breed"
					class="form-control">
					<option>Todas</option>
					<option>Dálmata</option>
					<option>Pitbull</option>
				</select>
			</div>

			<div class="form-group col-md-2">
				<label for="size">Porte</label> <select id="size" name="size"
					class="form-control">
					<option>Todos</option>
					<option>Pequeno</option>
					<option>Médio</option>
					<option>Grande</option>
				</select>
			</div>

			<div class="form-group col-md-2">
				<label for="stage">Idade</label> <select id="stage" name="stage"
					class="form-control">
					<option>Todos</option>
					<option>Filhote</option>
					<option>Adulto</option>
				</select>
			</div>

		</div>

		<div class="row">
			<div class="col-md-2">
				<input type="submit" class="btn btn-success" value="Cadastrar">
			</div>
		</div>
	</div>

	<script type="text/javascript">
		//Altera estilo do botao type file
		$('input[type=file]').bootstrapFileInput();
		$('.file-inputs').bootstrapFileInput();
	</script>

</body>
</html>