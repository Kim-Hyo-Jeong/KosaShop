<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<article>
	<h2>회원가입</h2>
	<form id="join" action="ProductMarket?command=join" method="post" name="formm">
		<fieldset>
			<legend>필수정보</legend>
			<label>아이디</label> <input type="text" name="id" size="12"> <input type="hidden" name="reid"><input type="button" value="중복 체크" class="dup" onclick="idcheck()"><br>
			<label>비밀번호</label><input type="password" name="pwd"><br>
			<label>비밀번호 확인</label> <input type="password" name="pwdCheck"><br>
			<label>이름</label> <input type="text" name="name"><br>
			<label>이메일</label> <input type="text" name="email"><br>

		</fieldset>
		<fieldset>
			<legend>추가정보</legend>
			<label>Zip Code</label> <input type="text" name="zipNum" size="10"> <input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br> <label>Address</label> <input type="text" name="addr1" size="50"> <input type="text" name="addr2" size="25"> <br> <label>Phone Number</label> <input type="text" name="phone"><br>
		</fieldset>
		<div class="clear"></div>
		<div id="buttons">
			<input type="button" value="회원가입" class="submit" onclick="go_save()"> <input type="reset" value="취소" class="cancel">
		</div>
	</form>
</article>
<%@ include file="../footer.jsp"%>
<script>
	function idcheck() {
		if (document.formm.id.value == "") {
			alert('사용자 ID를 입력하세요.');
			document.formm.id.focus();
			return;
		}
		var url = "ProductMarket?command=id_check_form&id="
				+ document.formm.id.value;
		window
				.open(url, "_blank",
						"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=330, height=200");
	}
</script>