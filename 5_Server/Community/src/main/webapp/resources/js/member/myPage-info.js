console.log("myPage-info.js loaded")

document.getElementById("info-update-btn").addEventListener("click",function(e){
    const nickname = document.getElementsByName("memberNickname")[0].value
    if(nickname.trim().length == 0){
        alert("닉네임을 입력해주세요.");
        e.preventDefault();
        nickname.focus();
        return;
    }

    let regExNick = /^(\w|[가-힣]){2,10}/;
    if(!regExNick.test(nickname)){
        alert("닉네임은 영어/숫자/한글 2~10글자 사이로 작성해주세요");
        e.preventDefault();
        nickname.focus();
        return;
    }

    const memberTel = document.getElementsByName("memberTel")[0].value
    if(memberTel.trim().length == 0){
        alert("전화번호를 입력해주세요.(- 제외)")
        e.preventDefault();
        memberTel.focus();
        return;
    }

    let regExTel = /^0{1}1{1}\d{1}\d{4}\d{4}$/;
    if(!regExTel.test(memberTel)){
        alert("올바른 전화번호 형식이 아닙니다.")
        e.preventDefault();
        memberTel.focus();
        return;
    }
})


