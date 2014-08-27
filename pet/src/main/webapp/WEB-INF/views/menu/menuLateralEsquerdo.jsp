<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="well" style="width: 250px;">
	<div class="list-group">
		<li class="sidebar-brand">${loggedUser.name }</li>
			<div class="text-center">
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
				<h4 class="sidebar-brand">Pontos: ${loggedUser.score }</h4>
			</div>
		
		<a href="listPets" class="list-group-item">Meus animais</a>
		<a href="novoAnimal" class="list-group-item"> Cadastrar Animal </a>
		<a href="#"	class="list-group-item">Alterar meus animais</a> 
		<a href="editarUsuario" class="list-group-item">Alterar meus dados</a>
		<a href="deactivateUser" class="list-group-item">Desativar conta</a>
		<a href="#"	class="list-group-item">Adotar</a> 
		<a href="#"	class="list-group-item">Opção 1</a>
		<a href="#"	class="list-group-item">Opção 2</a>
	</div>
</div>