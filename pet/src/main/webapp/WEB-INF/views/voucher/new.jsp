<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../main/main.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/res/js/lightbox.js"></script>
<title>Voucher</title>

</head>
<body>

	<div class="container-fluid">

		<div class="row">
			<div id="voucherOptions" class="col-md-6 bordered-collum">

				<div class="bs-example">
					<div class="well" style="max-width: 400px; margin: 0 auto 10px;">
						<form action="generateVoucherAnimal" method="post" enctype="multipart/form-data">
							<input type="hidden" name="id" value="${id_animal}"> <input type="hidden" name="tipo" value="1">
							<button class="btn btn-primary btn-lg btn-block" type="submit">VOUCHER PARA ADOÇÃO</button>
						</form>

						<form action="generateVoucherAnimal" method="post" enctype="multipart/form-data">
							<input type="hidden" name="id" value="${id_animal}"> <input type="hidden" name="tipo" value="2">
							<button class="btn btn-primary btn-lg btn-block" type="submit">VOUCHER PARA APADRINHAMENTO</button>
						</form>

						<form action="generateVoucherAnimal" method="post" enctype="multipart/form-data">
							<input type="hidden" name="id" value="${id_animal}"> <input type="hidden" name="tipo" value="3">
							<button class="btn btn-primary btn-lg btn-block" type="submit">VOUCHER PARA DOAÇÃO</button>
						</form>


					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>