<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>장바구니</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
    <div id="wrap">
        <jsp:include page="header.jsp" />
        <div class="container">
            <section>
                <h2>장바구니</h2>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">이미지</th>
                            <th scope="col">상품명</th>
                            <th scope="col">가격</th>
                            <th scope="col">수량</th>
                            <th scope="col">합계</th>
                            <th scope="col">삭제</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="entry" items="${cartItems}">
                            <c:set var="item" value="${entry.value}" />
                            <tr id="row_${item.productId}">
                                <td><img src="https://picsum.photos/id/${item.imageUrl}/100" alt="Product Image"></td>
                                <td>${item.prodName}</td>
                                <td>${item.prodPrice}</td>
                                <td>
                                    <form id="updateForm_${item.productId}" action="ProductMarket" method="POST">
                                        <input type="hidden" name="command" value="update_cart">
                                        <input type="hidden" name="prodNo" value="${item.productId}">
                                        <input type="number" min="1" value="${item.quantity}" name="quantity_${item.productId}" id="quantity_${item.productId}">
                                        <button type="button" onclick="updateQuantity('${item.productId}', ${item.prodPrice})">수정</button>
                                        <span id="updated_${item.productId}" style="display: none;">수정 중...</span>
                                    </form>
                                </td>
                                <td id="total_${item.productId}">${item.quantity * item.prodPrice}</td>
                                <td>
                                    <a href="#" onclick="removeFromCart('${item.productId}'); return false;">삭제</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <!-- 여기서 총 합계 행 추가 -->
                        <tr>
                            <td colspan="4" align="right"><strong>총 합계:</strong></td>
                            <td colspan="2" align="center"><strong id="totalAmount">${totalAmount}</strong></td>
                        </tr>
                    </tbody>
                </table>
            </section>
            <footer>
                <!-- 푸터 내용 -->
            </footer>
        </div>
    </div>
    <script>
        function updateQuantity(prodNo, prodPrice) {
            var quantity = document.querySelector('input[name="quantity_' + prodNo + '"]').value;

            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'ProductMarket', true);
            xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

            xhr.onload = function() {
                if (xhr.status === 200) {
                    var response = JSON.parse(xhr.responseText);
                    var total = document.getElementById('total_' + prodNo);
                    total.textContent = response.newTotalPrice;

                    // 총 합계 업데이트
                    document.getElementById('totalAmount').textContent = response.totalAmount;
                } else {
                    alert('수정에 실패했습니다. 다시 시도해 주세요.');
                }
            };

            xhr.send('command=update_cart&prodNo=' + prodNo + '&quantity=' + quantity);
        }

        function removeFromCart(prodNo) {
            if (confirm('정말로 이 상품을 장바구니에서 삭제하시겠습니까?')) {
                var xhr = new XMLHttpRequest();
                xhr.open('GET', 'ProductMarket?command=remove_from_cart&prodNo=' + prodNo, true);

                xhr.onload = function() {
                    if (xhr.status === 200) {
                        var response = JSON.parse(xhr.responseText);
                        var row = document.getElementById('row_' + prodNo);
                        row.parentNode.removeChild(row); // 삭제된 행을 DOM에서 제거

                        // 총 합계 업데이트
                        document.getElementById('totalAmount').textContent = response.totalAmount;
                    } else {
                        alert('삭제에 실패했습니다. 다시 시도해 주세요.');
                    }
                };

                xhr.send();
            }
        }
    </script>

</body>
</html>
