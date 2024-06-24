<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>우편 번호 검색</title>
    <link href="CSS/subpage.css" rel="stylesheet">
    <style type="text/css">
        body {
            background-color: rgb(246, 245, 242);
            font-family: D2Coding;
        }

        #popup {
            padding: 0 10px;
        }

        #popup h2 {
            font-family: "D2Coding", Times, serif;
            font-size: 30px;
            color: black;
            font-weight: normal;
        }

        table#zipcode {
            border-collapse: collapse;    /* border 사이의 간격 없앰 */
            border-top: 3px solid #fff;
            border-bottom: 3px solid #fff;
            width: 100%;
            margin-top: 15px;
        }

        table#zipcode th, table#zipcode td {
            text-align: center;
            border-bottom: 1px dotted #fff;
            color: black;
        }

        table th, td {
            padding: 10px;
        }

        table#zipcode a {
            display: block;
            height: 20px;
            text-decoration: none;
            color: #fff;
            padding: 10px;
        }

        table#zipcode a:hover {
            color: #F90;
            font-weight: bold;
        }

        /* 숨김 처리 */
        .hidden {
            display: none;
        }
    </style>
</head>
<body>
<div id="popup">
    <h2>우편번호검색</h2>
    <!-- 주소 찾기 버튼 대신 Daum 우편번호 서비스 팝업 호출 스크립트 -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script type="text/javascript">
        // Daum 우편번호 서비스 팝업 호출 함수
        function openDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    // 우편번호와 주소 정보를 부모 창의 폼 필드에 입력
                    opener.document.formm.zipNum.value = data.zonecode; // 우편번호
                    opener.document.formm.addr1.value = data.address; // 주소

                    // 부모 창의 addr2 필드에 포커스를 줌
                    opener.document.formm.addr2.focus();
                    self.close(); // 우편번호 검색 창 닫기
                }
            }).open();
        }
        
        // 페이지 로딩 시 Daum 우편번호 서비스 팝업 호출 함수를 호출
        window.onload = function() {
            openDaumPostcode();
        };
    </script>
</div>
</body>
</html>
