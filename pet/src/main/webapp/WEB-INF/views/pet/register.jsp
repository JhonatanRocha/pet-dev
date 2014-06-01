<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../main/main.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:import url="../main/navbar.jsp" />

	<div class="container">

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
			<div class="form-group col-md-2">
				<label for="name">Nome</label> <input type="text" id="name"
					name="name" class="form-control">
			</div>

			<div class="form-group col-md-2">
				<label for="size">Porte</label> <select id="size" name="size"
					class="form-control">
					<option>Pequeno</option>
					<option>Médio</option>
					<option>Grande</option>
				</select>
			</div>

			<div class="form-group col-md-2">
				<label for="type">Tipo</label> <select id="type" name="type"
					class="form-control">
					<option>Cachorro</option>
					<option>Gato</option>
				</select>
			</div>

			<div class="form-group col-md-2">
				<label for="breed">Raça</label> <select id="breed" name="breed"
					class="form-control">
					<option>Dálmata</option>
					<option>Pitbull</option>
				</select>
			</div>

			<div class="form-group col-md-2">
				<label for="color">Cor</label> <select id="color" name="color"
					class="form-control">
					<option>Branco</option>
					<option>Preto</option>
					<option>Verde</option>
				</select>
			</div>

			<div class="checkbox col-md-2">
				<label> <input type="checkbox" name="neutered" value="true">É
					castrado?
				</label>
			</div>
		</div>

		<div class="row">

			<div class="checkbox col-md-2">
				<label> <input type="checkbox" name="dicient" value="true">Possui
					alguma deficiência?
				</label>
			</div>

			<div class="form-group col-md-4">
				<label for="deficiency">Qual? </label> <input type="text"
					class="form-control" id="deficiency" name="deficiency">
			</div>

			<div class="form-group col-md-2">
				<label for="gender">Gênero</label>
				<div class="checkbox">
					<div class="pull-left">
						<label> <input type="radio" name="gender" value="M">Macho
							<input type="radio" name="gender" value="F">Fêmea
						</label>
					</div>
				</div>
			</div>
		</div>

	<div class="row">
		<input type="submit" class="btn btn-primary" value="Cadastrar">
	</div>

	</div>
	<script type="text/javascript">
		//Altera estilo do botao type file
		$('input[type=file]').bootstrapFileInput();
		$('.file-inputs').bootstrapFileInput();
	</script>
	</script>
</body>
</html>