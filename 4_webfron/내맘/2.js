// $("#id").on("change",function(){
//     console.log($(this.value))
//     const regExp = /^[a-z]+[\w_-]{5,14}$/;

// })
document.getElementById("id").addEventListener("change",function(){
    const regExp = /^[a-z]{1}[\w_-]{5,13}$/;
    if(this.value.length != 0){
        if(regExp.test(this.value)){
            this.style.backgroundColor = "springgreen";
            this.style.color = "black";
        }else{
            this.style.backgroundColor = "red";
            this.style.color = "white";
        }
    }else{
        this.style.backgroundColor = "white";
        this.style.color = "black";
    }
})

document.getElementById("passChk").addEventListener("keyup",function(){
    const a = document.getElementById("pass");
    const b = document.getElementById("confirm");
    if(a.value.trim()==""){
        alert("비밀번호 먼저 입력해주세요.")
        this.value = "";
        a.focus();
    }else{
        if(a.value==this.value){
            b.innerText = "비밀번호 일치.";
            b.style.color = "green";
        }else{
            b.innerHTML = "비밀번호 불일치";
            b.style.color = "red";
        }
    }
})
document.getElementById("name").addEventListener("change",function(){
    const regExp = /^[가-힣]{2,5}$/;
    if(regExp.test(this.value)){
        this.parentElement.nextElementSibling.innerText = "정상입력";
        this.parentElement.nextElementSibling.style.color = "green";
    }else{
        this.parentElement.nextElementSibling.innerText = "한글만 입력하세요.";
        this.parentElement.nextElementSibling.style.color = "red";
    }
    if(this.value == ""){
        this.parentElement.nextElementSibling.innerText = "";
    }
})

// function act(){
//     const man = document.getElementById("m");
//     const weman = document.getElementById("w");
//     if(man.checked==false && weman.checked==false){
//         alert("성별을 선택해주세요.");
//         return false;
//     }
//     const regExp = /^[0][0-9]{1,2}-[0-9]{3,4}-[0-9]{4}/;
//     const tel = document.getElementById("tel")
//     if(!regExp.test(tel.value)){
//         alert("전화번호의 형식이 올바르지 않습니다.");
//         return false;
//     }
// }

document.getElementById("submit").addEventListener("click",function(event){
    const man = document.getElementById("m");
    const weman = document.getElementById("w");
    if(man.checked==false && weman.checked==false){
        alert("성별을 선택해주세요.");
        event.preventDefault();
        return;
    }
    const regExp = /^[0][0-9]{1,2}-[0-9]{3,4}-[0-9]{4}/;
    const tel = document.getElementById("tel")
    if(!regExp.test(tel.value)){
        alert("전화번호의 형식이 올바르지 않습니다.");
        event.preventDefault();
        return;
    }
})