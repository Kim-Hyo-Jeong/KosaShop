<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product List</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
<div id="wrap">
	<div class="container">
		<!--헤더파일 들어가는 곳 시작 -->
		<header class="row">
			<!--로고 들어가는 곳 시작--->
			<div id="logo" class="col-md-3 text-center my-4">
				<a href="ProductMarket?command=index">
					<img src="images/logo.png" width="100" height="100" alt="Book Market">
				</a>
			</div>
			<!--로고 들어가는 곳 끝-->
			<div class="col-md-9">
				<nav id="catagory_menu" class="mb-4">
					<ul class="nav justify-content-center">
						<c:choose>
							<c:when test="${empty sessionScope.loginUser}">
								<li class="nav-item"><a class="nav-link" href="ProductMarket?command=login_form">LOGIN(CUSTOMER</a></li>
								<li class="nav-item"><a class="nav-link" href="NonageServlet?command=admin_login_form">| ADMIN)</a></li>
								<li class="nav-item">/</li>
								<li class="nav-item"><a class="nav-link" href="ProductMarket?command=contract">JOIN</a></li>
							</c:when>
							<c:otherwise>
								<li class="nav-item text-warning">${sessionScope.loginUser.name}(${sessionScope.loginUser.id})</li>
								<li class="nav-item"><a class="nav-link" href="ProductMarket?command=logout">LOGOUT</a></li>
							</c:otherwise>
						</c:choose>
						<li class="nav-item">/</li>
						<li class="nav-item"><a class="nav-link" href="ProductMarket?command=cart_list">CART</a></li>
						<li class="nav-item">/</li>
						<li class="nav-item"><a class="nav-link" href="ProductMarket?command=mypage">MY PAGE</a></li>
						<li class="nav-item">/</li>
						<li class="nav-item"><a class="nav-link" href="ProductMarket?command=qna_list">Q&amp;A(1:1)</a></li>
					</ul>
				</nav>

				<nav id="top_menu" class="mb-4">
					<ul class="nav justify-content-center">
						<li class="nav-item"><a class="nav-link h5" href="ProductMarket?command=catagory&kind=1">Heels</a></li>
						<li class="nav-item"><a class="nav-link h5" href="ProductMarket?command=catagory&kind=2">Boots</a></li>
						<li class="nav-item"><a class="nav-link h5" href="ProductMarket?command=catagory&kind=3">Sandals</a></li>
						<li class="nav-item"><a class="nav-link h5" href="ProductMarket?command=catagory&kind=4">Sneakers</a></li>
						<li class="nav-item"><a class="nav-link h5" href="ProductMarket?command=catagory&kind=5">On Sale</a></li>
					</ul>
				</nav>
			</div>
			<div class="clearfix"></div>
			<hr>
		</header>
		<!--헤더파일 들어가는 곳 끝 -->
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
