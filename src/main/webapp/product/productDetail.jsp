<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp"%>

<article>
    <h1>물품</h1>
    <div id="itemdetail">
        <form method="post" name="formm" id="productForm">
            <fieldset>
                <legend>상세정보</legend>
                <a href="ProductMarket?command=product_detail&prod_no=${productVO.prodNo}">
                    <span style="float: left;">
                        <img src="https://picsum.photos/id/${productVO.imageUrl}/300" />
                    </span>
                    <h2>${productVO.prodName}</h2>
                </a>
                <label> 가 격 : </label>
                <p>${productVO.prodPrice}원</p>

                <label> 수 량 : </label>
                <input type="text" name="quantity" id="quantity" size="2" value="1">
                <br>
                <input type="hidden" name="pseq" id="pseq" value="${productVO.prodNo}">
                <br>
            </fieldset>
            <div class="clear"></div>
            <div id="buttons">
                <c:choose>
                    <c:when test="${empty sessionScope.loginUser}">
                        <input type="button" value="장바구니에 담기" class="submit" onclick="requireLogin()">
                    </c:when>
                    <c:otherwise>
                        <input type="button" value="장바구니에 담기" class="submit" onclick="addToCart()">
                    </c:otherwise>
                </c:choose>
                <input type="button" value="즉시 구매" class="submit" onclick="go_order()">
                <input type="reset" value="취소" class="cancel">
            </div>
        </form>
    </div>
</article>

<script>
    function requireLogin() {
        alert("로그인이 필요합니다.");
        location.href = "ProductMarket?command=login_form"; // 로그인 페이지로 이동
    }

    function addToCart() {
        var prodNo = document.getElementById("pseq").value;
        var quantity = document.getElementById("quantity").value;

        // AJAX 요청 보내기
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "ProductMarket?command=add_to_cart", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    // 성공적으로 처리된 경우
                    alert("장바구니에 상품이 추가되었습니다.");
                } else {
                    // 오류 처리
                    alert("장바구니 추가에 실패했습니다. 다시 시도해주세요.");
                }
            }
        };
        xhr.send("prodNo=" + encodeURIComponent(prodNo) + "&quantity=" + encodeURIComponent(quantity));
    }

    function go_order() {
        // 즉시 구매 기능 구현
        alert("즉시 구매 기능은 준비 중입니다.");
    }
</script>

<%@ include file="../footer.jsp"%>
