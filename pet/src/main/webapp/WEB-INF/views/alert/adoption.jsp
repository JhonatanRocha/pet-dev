<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="well" style="width: 250px;">
	<div class="list-group">
		<div class="text-center">


			<c:forEach var="alert" items="${loggedNGO.alerts}">
				<c:if test="${alert.isActive}">
				<c:if test="${alert.voucher.tipo == 1}">
					<div class="alert alert-warning">
				
						<p>
							Alerta de <strong>adoção!</strong> <br>
							Esse animal: <h4><span class="label label-info"> ${alert.voucher.pet.name} </span> </h4><br>
							Foi <strong>adotado</strong> por: <h4><span class="label label-info"> ${alert.voucher.user.name} </span></h4>?
							<br><br>
																				
							<button data-toggle="modal" data-target="#myModalSim${alert.id}" class="btn btn-success">sim</button>
							<button data-toggle="modal" data-target="#myModalNao${alert.id}" class="btn btn-danger">Não</button>
							
						<p>
						
						
						
					<!-- Modal -->
					<div class="modal fade" id="myModalSim${alert.id}" tabindex="-1" 
					role="dialog" aria-labelledby="myModalLabelSim${alert.id}" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">
										<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
									</button>
									<h4 class="modal-title" id="myModalLabelSim${alert.id}">Atenção!</h4>
								</div>

								<div class="modal-body">
								<div class="alert alert-warning">
						
									<h1><span class="label label-danger">CONFIRMAR A ADOÇÃO?</span></h1>
									<br>
									
									<p>
									<form id="register" action="adoptionPet" method="post" enctype="multipart/form-data">
										<input type="hidden" name="id_voucher" value="${alert.voucher.id}">
										<input type="hidden" name="id_alert" value="${alert.id}">
										<input type="hidden" name="opcao" value="true"> 
										<button type="submit" class="btn btn-success btn-lg"">sim</button>
									</form>
									
										<button type="submit" data-dismiss="modal" class="btn btn-danger btn-lg">Não</button>
									<p>		
								</div>
								</div>


							</div>
						</div>
					</div><!-- fim modal -->						
						
					<!-- Modal -->
					<div class="modal fade" id="myModalNao${alert.id}" tabindex="-1" 
					role="dialog" aria-labelledby="myModalLabelNao${alert.id}" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">
										<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
									</button>
									<h4 class="modal-title" id="myModalLabelNao${alert.id}">Atenção!</h4>
								</div>

								<div class="modal-body">
								<div class="alert alert-danger">
						
									<h1><span class="label label-warning">TEM CERTEZA QUE ESSA </span><br><br>
									<span class="label label-warning">ADOÇÃO NÃO OCORREU?</span></h1>
									<br>
									
									<p>
									<form id="register" action="adoptionPet" method="post" enctype="multipart/form-data">
										<input type="hidden" name="id_voucher" value="${alert.voucher.id}">
										<input type="hidden" name="id_alert" value="${alert.id}">
										<input type="hidden" name="opcao" value="false"> 
										<button type="submit" class="btn btn-success btn-lg"">sim</button>
									</form>
									
										<button type="submit" data-dismiss="modal" class="btn btn-danger btn-lg">Não</button>
									<p>
								</div>				
								</div>


							</div>
						</div>
					</div><!-- fim modal -->	

				</div>
				</c:if>
			</c:if>
			</c:forEach>

		</div>


	</div>
</div>