/**
 * 
 */
 
      //비밀번호는 필수 입력값입니다
      //$(document).ready(function() {
    //$(".btn").click(function() {
        // 비밀번호 입력 확인
        //var pwValue = $("#pw").val();
       // if (!pwValue) {
            //alert("비밀번호는 필수 입력값입니다.");
            //return false;
       // }
    //});
//});

//회원정보 수정이 완료되었습니다
function ok() {
    // 확인 메시지 표시
    var confirmJoin = confirm("회원정보 수정이 완료되었습니다");

    // 확인이 되었다면
    if (confirmJoin) {
        // 일정 시간 후에 새 페이지로 이동
        setTimeout(function () {
            location.href = "../main/index.jsp";
        }, 1000); // 1000 밀리초(1초) 후에 이동하도록 설정
    }
}

//회원탈퇴를 하시겠습니까?
function no() {
    // 확인 메시지 표시
    var confirmJoin = confirm("회원탈퇴를 하시겠습니까?");

    // 확인이 되었다면
    if (confirmJoin) {
        // 일정 시간 후에 새 페이지로 이동
        setTimeout(function () {
            location.href = "../main/index.jsp";
        }, 1000); // 1000 밀리초(1초) 후에 이동하도록 설정
    }
}
	
	
		
 
 
 