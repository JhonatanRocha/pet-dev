<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../main/main.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo Produto</title>
</head>
<body>

	<c:import url="../main/navbar.jsp" />

	
	<form action="registerProducts" method="POST">
	<div class="container">
		<fieldset>
			<legend>Novo Produto</legend>
		</fieldset>

		<div class="row">
			<div class="col-md-4 form-group">
				<label for="name">Nome</label> 
				<input type="text" name="name" class="form-control">
			</div>

			<div class="col-md-2 form-group">
				<label for="price">Preço</label>
				<div class="input-group">
					<span class="input-group-addon">R$</span>
					<input type="text" class="form-control" name="price">
				</div>
			</div>
			
			<div class="col-md-3 form-group">
					<label for="score">Pontos</label> 
					<div class="input-group">
						<input type="text" name="score" class="form-control">
						<span class="input-group-addon">pts.</span>
					</div>
			</div>
		</div>

		<div class="row">												
			<div class="col-md-6 form-group">
				<label for="linkPhoto">Link Foto</label> 
				<input type="text" name="linkPhoto" class="form-control">
			</div>
			
			<div class="col-md-6 form-group">
				<label for="linkAnuncio">Link Anuncio</label> 
				<input type="text" name="linkAnuncio" class="form-control">
			</div>
		</div>


		<fieldset>
			<legend>Perfil</legend>
		</fieldset>
		<div class="row">

			<div class="form-group col-md-2">
				<label for="type">Tipo</label> 
				<select name="type.id" class="form-control">
			    	<c:forEach var="typeItem" items="${types}">
			        	<option value="<c:out value='${typeItem.id}' />">
			             	<c:out value="${typeItem.description}" />
			        	</option>
				    </c:forEach>
				</select>
			</div>

			<div class="form-group col-md-3">
				<label for="race">Raça</label> 
				<select name="race.id" class="form-control">
			    	<c:forEach var="raceItem" items="${races}">
			        	<option value="<c:out value='${raceItem.id}' />">
			            	<c:out value="${raceItem.description}" />
			        	</option>
				    </c:forEach>
				</select>
			</div>

			<div class="form-group col-md-2">
				<label for="size">Porte</label> 
				<select name="size" class="form-control">
					<option>Todos</option>
					<option>Pequeno</option>
					<option>Médio</option>
					<option>Grande</option>
				</select>
			</div>

			<div class="form-group col-md-2">
				<label for="stage">Idade</label> 
				<select name="stage" class="form-control">
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
	</form>

	<script type="text/javascript">
		//Altera estilo do botao type file
		$('input[type=file]').bootstrapFileInput();
		$('.file-inputs').bootstrapFileInput();
	</script>

</body>
</html>