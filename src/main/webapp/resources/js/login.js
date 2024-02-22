      
   
        
        // 아이디와 비밀번호 입력은 필수 입력값입니다 alert 창
		function validateForm() {
		    var id = document.getElementById('id').value;
		    var pw = document.getElementById('pw').value;
		
		    if (id.trim() === '') {
		        alert('아이디 항목은 필수 입력값입니다.');
		        return false;
		    }
		
		    if (pw.trim() === '') {
		        alert('비밀번호 항목은 필수 입력값입니다.');
		        return false;
		    }
		
		    return true;
		}
		
		//조인어스 버튼 클릭시 넘어가기
        function join() {
            // JOIN US 버튼 클릭 시 회원가입 페이지로 이동
            let link = "join/join.do";
        	window.open(link);
        }
        
   //수정 버튼 클릭시 넘어가기
        function main() {
            let link = "common/index.do";
        	window.open(link);
        }
             
        
    
        
        
        
        
        
 