<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-3 .col-md-push-4" bordered-collum>
	<div class="panel panel-default">
		<div class="panel-heading">Anúncios Para Você</div>
		<div class="panel-body">


			<c:forEach var="announcementItem" items="${loggedUser.announcement}">


				<div class="thumbnail">
					<img src="${announcementItem.product.linkPhoto}" width="100" height="100">
					<div class="caption">
						<h5 class="text-center">${announcementItem.product.name}</h5>
						
						<p class="text-center">Preço: R$${announcementItem.product.price}</p>
						<p class="text-center">Pontuação: ${announcementItem.product.score}!!!</p>
						<p class="text-center">
							<a
								href="${announcementItem.product.linkAnuncio}"
								target="_blank" class="btn btn-primary btn-xs" role="button">Ir a Loja</a>
						</p>
					</div>
				</div>

			</c:forEach>

		</div>
	</div>
</div>