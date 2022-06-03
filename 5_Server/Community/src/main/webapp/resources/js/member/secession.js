console.log("secession.js loaded")

function checked(){
    const result = document.getElementById("agree").checked;
    return result;
}

document.getElementById("info-update-btn").addEventListener("click",function(e){
    const pw = document.getElementsByName("memberPw")[0].value;

    if(pw.trim()==""){
        alert("비밀번호를 입력해주세요.")
        pw.focus();
        e.preventDefault();
        return;
    }
    if(!checked()){
        alert("약관 동의 후 탈퇴 버튼을 클릭해주세요.")
        e.preventDefault();
        return;
    }
    const a = confirm("“정말 탈퇴 하시겠습니까?”")
    if(!a){
        e.preventDefault();
        return;
    }
    
})