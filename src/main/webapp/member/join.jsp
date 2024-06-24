<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<article>
	<h2>회원가입</h2>
	<form id="join" action="ProductMarket?command=join" method="post" name="formm" onsubmit="return validateForm()">
		<fieldset>
			<legend>필수정보</legend>
			<label>아이디</label> 
			<input type="text" name="id" id="id" size="12"> 
			<input type="hidden" name="reid">
			<input type="button" value="중복 체크" class="dup" onclick="idcheck()"><br>
			<label>비밀번호</label>
			<input type="password" name="pwd" id="pwd"><br>
			<label>비밀번호 확인</label>
			<input type="password" name="pwdCheck" id="pwdCheck"><br>
			<label>이름</label>
			<input type="text" name="name" id="name"><br>
			<label>이메일</label>
			<input type="text" name="email" id="email"><br>
		</fieldset>
		<hr></hr>
		<fieldset>
			<legend>선택정보</legend>
			<label>우편번호</label>
			<input type="text" name="zipNum" id="zipNum" size="10">
			<input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br>
			<label>주소</label>
			<input type="text" name="addr1" id="addr1" size="50">
			<input type="text" name="addr2" id="addr2" size="25"> <br>
			<label>전화번호</label>
			<input type="text" name="phone" id="phone"><br>
		</fieldset>
		<div class="clear"></div>
		<div id="buttons">
			<input type="submit" value="회원가입" class="submit"> 
			<input type="reset" value="취소" class="cancel">
		</div>
	</form>
</article>
<%@ include file="../footer.jsp"%>
<script>
	function idcheck() {
		if (document.formm.id.value === "") {
			alert('사용자 ID를 입력하세요.');
			document.formm.id.focus();
			return;
		}
		var url = "ProductMarket?command=id_check_form&id=" + document.formm.id.value;
		window.open(url, "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=330, height=200");
	}
	
	function post_zip() {
	    var url = "ProductMarket?command=find_zip_num";
	    window.open(url, "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300");
	}
	
	function validateForm() {
		var id = document.getElementById("id").value.trim();
		var pwd = document.getElementById("pwd").value.trim();
		var pwdCheck = document.getElementById("pwdCheck").value.trim();
		var name = document.getElementById("name").value.trim();
		var email = document.getElementById("email").value.trim();
		var zipNum = document.getElementById("zipNum").value.trim();
		var addr1 = document.getElementById("addr1").value.trim();
		var phone = document.getElementById("phone").value.trim();
		
		if (id === "" || pwd === "" || pwdCheck === "" || name === "" || email === "" || zipNum === "" || addr1 === "" || phone === "") {
			alert("모든 필수 입력 필드를 작성해주세요.");
			return false;
		}
		
		if (pwd !== pwdCheck) {
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			document.getElementById("pwd").value = "";
			document.getElementById("pwdCheck").value = "";
			document.getElementById("pwd").focus();
			return false;
		}
		
		return true;
	}
</script>
