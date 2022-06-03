console.log("updatePW.js loaded")

document.getElementById("submitBTN").addEventListener("click",function(e){
    const currentPW = document.getElementsByName("password")[0].value;
    const updatePW = document.getElementsByName("updatePW")[0].value;
    const checkPW = document.getElementsByName("updateChk")[0].value;
    const regExp = /^(\w|[!@#$_-]){6,30}$/;

    if(currentPW.trim().length == 0){
        alert("현재 비밀번호를 입력해주세요.")
        currentPW.focus();
        e.preventDefault();
        return;
    }
    if(updatePW.trim().length == 0){
        alert("새 비밀번호를 입력해주세요.")
        e.preventDefault();
        updatePW.focus();
        return;
    }
    if(!regExp.test(updatePW)){
        alert("영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.")
        e.preventDefault();
        updatePW.focus();
        return;
    }
    if(checkPW.trim().length == 0 ){
        alert("새 비밀번호 확인을 작성해주세요.")
        e.preventDefault();
        checkPW.focus();
        return;
    }
    if(updatePW != checkPW){
        alert("새 비밀번호가 일치하지 않습니다.");
        e.preventDefault();
        checkPW.focus();
        return;
    }
})