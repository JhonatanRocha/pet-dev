<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../main/main.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página Inicial</title>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/res/css/jcarousel.responsive.css">
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/res/js/jquery.jcarousel.min.js" ></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/res/js/jcarousel.responsive.js" ></script>
</head>
<body>
	<div class="wrapper">
            <h2>Painel de adoção</h2>
            <p></p>

            <div class="jcarousel-wrapper">
                <div class="jcarousel">
                    <ul>
                        <li><img src="${pageContext.servletContext.contextPath}/res/img/images.jpg" id="img1" alt="Image 1" onclick="clickImage(this);"></li>
                        <li><img src="${pageContext.servletContext.contextPath}/res/img/images1.jpg" id="img2" alt="Image 2"  onclick="clickImage(this);"></li>
                        <li><img src="${pageContext.servletContext.contextPath}/res/img/img4.jpg" id="img3" alt="Image 3" onclick="clickImage(this);"></li>
                        <li><img src="${pageContext.servletContext.contextPath}/res/img/img2.jpg" id="img4" alt="Image 4" onclick="clickImage(this);"></li>
                    </ul>
                </div>

                <a href="#" class="jcarousel-control-prev">&lsaquo;</a>
                <a href="#" class="jcarousel-control-next">&rsaquo;</a>

                <p class="jcarousel-pagination"></p>
            </div>
        </div>    
</body>

<script>

	function clickImage() {
	    alert(document.getElementById("img1"));
	}
</script>
</html>