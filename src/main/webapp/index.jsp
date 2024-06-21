<%@ include file="../header.jsp"%>

<div id="front">
	<h2>New Item</h2>
	<div id="bestProduct">
		<c:forEach items="${newProductList}" var="product">
			<div id="item">
				<a href="ProductMarket?command=product_detail&prod_no=${product.prodNo}" class="product-link">
					<img src="https://picsum.photos/id/${product.imageUrl}/300" />
					<h3>${product.prodName}</h3>
					<p>${product.prodPrice}</p>
				</a>
			</div>
		</c:forEach>
	</div>
</div>

<%@ include file="../footer.jsp"%>
