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

					<div class="well" style="max-width: 700px; margin: 0 auto 10px;">

						<div class="bs-example bs-example-type">
							<table class="table">
								<tbody>
									<tr>
										<td><h1>VOUCHER: ${voucher.number}</h1></td>
									</tr>
									<tr>
										<td><h2>GERADO PARA: ${loggedUser.name}</h2></td>
									</tr>
								</tbody>
							</table>
						</div>

						
						<button class="btn btn-sucess btn-lg" onclick="printFunction()">IMPRIMIR VOUCHER</button>

						<script>
							function printFunction() {
								window.print();
							}
						</script>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>