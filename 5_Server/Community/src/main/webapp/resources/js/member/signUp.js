const checkObj = {
	"memberEmail" : false,
	"memberPassword" : false,
	"memberPwConfirm" : false,
	"memberNickname" : false,
	"memberTel" : false
};
const memberTel = document.getElementById("memberTel");
const telMessage = document.getElementById("telMessage");

memberTel.addEventListener("input",function(){
  if(memberTel.value.length == 0){
    telMessage.innerText = "전화번호를 입력해주세요 (-제외)";
    telMessage.classList.remove("confirm");
    telMessage.classList.remove("error");
    checkObj.memberTel = false;
    return;
    }
    const regExp = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;
    if(regExp.test(memberTel.value)){
        telMessage.innerText = "올바른 전화번호 형식 입니다.";
        telMessage.classList.add("confirm");
        telMessage.classList.remove("error");
       	checkObj.memberTel = true;
    }else{
        telMessage.innerText = "전화번호 형식이 올바르지 않습니다. (-제외)";
        telMessage.classList.add("error");
        telMessage.classList.remove("confirm");
        checkObj.memberTel = false;
    }
})

const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.querySelector("#emailMessage");

memberEmail.addEventListener("input",function(){
    if(memberEmail.value.length == 0){
        emailMessage.innerText = "사용할 이메일을 작성해주세요.";
        emailMessage.classList.remove("confirm");
        emailMessage.classList.remove("error");
        checkObj.memberEmail = false;
        return;
    }
    const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

    if(regExp.test(memberEmail.value)){
        $.ajax({
            url : "emailDupCheck",//필수속성url
                                  //상대경로로 작성했음
            data : {"memberEmail" : memberEmail.value},
            //data 속성 : 비동기 통신 시 서버로 전달할 값을 작성
            type : "GET",
            success : function(result){
                //비동기 통신이 성공 했을 경우
                if(result ==1){
                    checkObj.memberEmail = false;
                    emailMessage.innerText = "이미 사용중인 이메일 입니다.";
                    emailMessage.classList.add("error");
                    emailMessage.classList.remove("confirm");
                }else{
                    emailMessage.innerText = "사용 가능한 이메일 입니다.";
                    emailMessage.classList.add("confirm");
                    emailMessage.classList.remove("error");
                    checkObj.memberEmail = true;
                }
            },
            error : function(result){
                //오류 발생 시
                console.log("에러");
            }
        })

    }else{
        emailMessage.innerText = "올바르지 않은 이메일 형식입니다.";
        emailMessage.classList.add("error");
        emailMessage.classList.remove("confirm");
    	checkObj.memberEmail = false;
    }
})

const memberNickname = document.getElementById("memberNickname");
const nicknameMessage = document.getElementById("nicknameMessage");

memberNickname.addEventListener("input",function(){
    if(memberNickname.value.length == 0 ){
        nicknameMessage.innerText = "영문/숫자/한글 2~10자 사이로 작성해주세요.";
        nicknameMessage.classList.remove("confirm");
        nicknameMessage.classList.remove("error");
        checkObj.memberNickname = false;
        return;
    }
    const regExp = /^(\w|[가-힣]){2,10}$/;
    if(regExp.test(memberNickname.value)){
        $.ajax({
            url : "nicknameDupCheck",
            data : {"nicknameDupCheck" : memberNickname.value},
            type : "GET",
            success : function(result){
                if(result == 0 ){
                    nicknameMessage.innerText = "사용 가능한 닉네임 입니다.";
                    nicknameMessage.classList.add("confirm");
                    nicknameMessage.classList.remove("error");
                    checkObj.memberNickname = true;
                }else{
                    nicknameMessage.innerText = "이미 사용중인 닉네임 입니다.";
                    nicknameMessage.classList.add("error");
                    nicknameMessage.classList.remove("confirm");
                    checkObj.memberNickname = false;
                }
            },
            error : function(result){
                console.log("error")
            }
        })
    }else{
        nicknameMessage.innerText = "적합하지 않은 닉네임 입니다.";
        nicknameMessage.classList.remove("confirm");
        nicknameMessage.classList.add("error");
        checkObj.memberNickname = false;
    }
})

const memberPw = document.getElementById("memberPassword");
const memberPwConfirm = document.getElementById("memberPwConfirm");
const pwMessage = document.getElementById("pwMessage");

memberPw.addEventListener("input",function(){
    if(memberPw.value.length == 0 ){
        pwMessage.innerText = "대소문자,숫자,특수문자(!,@,#,$,-,_)6~30글자 사이로 작성해주세요.";
        pwMessage.classList.remove("confirm");
        pwMessage.classList.remove("error");
        checkObj.memberPassword = false;
        return;
        }
    const regExp = /(\w|[!@#$_-]){6,30}/;
    if(regExp.test(memberPw)){
		checkObj.memberPassword = true;
        if(memberPwConfirm.value.length==0){
            pwMessage.innerText = "사용 가능한 비밀번호 입니다.";
            pwMessage.classList.add("confirm");
            pwMessage.classList.remove("error");
        }else{
            checkPwconfirm()
        }
    }else{
        pwMessage.innerText = "비밀번호가 적합하지 않습니다.(대소문자,숫자,특수문자(!,@,#,$,-,_) 6~30글자";
        pwMessage.classList.remove("confirm");
        pwMessage.classList.add("error");
        checkObj.memberPassword = false;
    }
    })

memberPwConfirm.addEventListener("input",checkPwconfirm);
    
function checkPwconfirm(){
    if(memberPw.value == memberPwConfirm.value){
        pwMessage.innerText = "비밀번호가 일치합니다.";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");
        checkObj.memberPwConfirm = true;
    }else{
        pwMessage.innerText = "비밀번호가 일치하지 않습니다.";
        pwMessage.classList.remove("confirm");
        pwMessage.classList.add("error");
        checkObj.memberPwConfirm = false;
    }
}

function signUpValidate(){
	for(let key in checkObj){
		if(!checkObj[key]){
			switch(key){
            case "memberEmail":     str="이메일이"; break;
            case "memberPw":        str="비밀번호가"; break;    
            case "memberPwConfirm": str="비밀번호 확인이"; break;
            case "memberNickname":  str="닉네임이"; break;
            case "memberTel":       str="전화번호가"; break;
            }
            str += "유효하지 않습니다. ";
            alert(str);
            document.getElementById(key).focus();
			return false;
		}
	}
	return true;
}