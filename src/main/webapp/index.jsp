<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../header.jsp"%>

<!--메인 이미지 들어가는 곳 시작 --->
<hr>
<br>
<div id="main_img">
	<img src="images/main_img.png" class="half-size">
</div>

<br>
<!--메인 이미지 들어가는 곳 끝--->

<div class="clear"></div>

<body>
	<div id="front">
		<h2>New Item</h2>
		<div id="bestProduct">
			<c:forEach items="${newProductList}" var="product">
				<div id="item">
					<a href="ProductMarket?command=product_detail&prod_no=${product.prodNo}"  class="product-link">
						<img src="https://picsum.photos/id/${product.imageUrl}/300" />
						<h3>${product.prodName}</h3>
						<p>${product.prodPrice}</p>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>

	<br>
	<!-- 페이지네이션 링크 추가 -->
	<div id="pagination">
		<c:choose>
			<c:when test="${currentPage > 1}">
				<a href="ProductMarket?command=index&page=${currentPage - 1}&pageSize=${pageSize}"><</a>
			</c:when>
			<c:otherwise>
				<span><</span>
			</c:otherwise>
		</c:choose>

		<!-- JSTL을 사용하여 계산된 값 설정 -->
		<c:set var="startPage" value="${currentPage - 2}" />
		<c:set var="endPage" value="${currentPage + 2}" />

		<!-- 시작 페이지와 끝 페이지의 범위 조정 -->
		<c:if test="${startPage < 1}">
			<c:set var="startPage" value="1" />
			<c:set var="endPage" value="5" />
		</c:if>
		<c:if test="${endPage > totalPages}">
			<c:set var="endPage" value="${totalPages}" />
			<c:set var="startPage" value="${endPage - 4}" />
		</c:if>
		<c:if test="${totalPages < 5}">
			<c:set var="endPage" value="${totalPages}" />
			<c:set var="startPage" value="1" />
		</c:if>

		<!-- 현재 페이지를 중심으로 앞뒤로 2페이지 표시 -->
		<c:forEach begin="${startPage}" end="${endPage}" var="i">
			<c:choose>
				<c:when test="${i == currentPage}">
					<strong>${i}</strong>
				</c:when>
				<c:otherwise>
					<a href="ProductMarket?command=index&page=${i}&pageSize=${pageSize}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${currentPage < totalPages}">
				<a href="ProductMarket?command=index&page=${currentPage + 1}&pageSize=${pageSize}">></a>
			</c:when>
			<c:otherwise>
				<span>></span>
			</c:otherwise>
		</c:choose>
	</div>

	<%@ include file="../footer.jsp"%>