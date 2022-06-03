document.getElementById("check1").addEventListener("click",function(){

    const regExp1 = new RegExp("script");
    const regExp2 = /java/;

    const str1 = "javascript";
    const str2 = "servlet/jsp(java server page)";
    const str3 = "java,java,java";
    console.log("regExp1.test(str1) : "+regExp1.test(str1));
    console.log(regExp1.exec(str1))

    console.log("regExp2.test(str1) : "+regExp2.test(str1));
    console.log(regExp2.exec(str1))

    console.log("regExp2.test(str2) : "+regExp2.test(str2));
    console.log(regExp2.exec(str2))

    console.log("regExp1.test(str2) : "+regExp1.test(str2));
    console.log(regExp1.exec(str2))

    console.log("reqExp1.test(str3) : "+regExp1.test(str3))
    console.log(regExp1.exec(str3))
});
document.getElementById("btn1").addEventListener("click",function(){
    const div1 = document.getElementById("div1");
    div1.innerHTML = "";

    const regExp1 = /a/;
    div1.innerHTML += "/a/ , apple : " + regExp1.test("apple") + "<br>";
    div1.innerHTML += "/a/ , price : " + regExp1.test("price") + "<br>";
    
    const regExp2 = /[abcd]/;
    div1.innerHTML += "/[abcd]/ , apple : " + regExp2.test("apple") + "<br>";
    div1.innerHTML += "/[abcd]/ , ssbss : " + regExp2.test("ssbss") + "<br>";
    div1.innerHTML += "/[abcd]/ , qwerty : " + regExp2.test("qwerty") + "<br>";

    const regExp3 = /^group/;
    div1.innerHTML += "/^group/ , group100 : " + regExp3.test("group100") + "<br>";
    div1.innerHTML += "/^group/ , 111group : " + regExp3.test("111group") + "<br>";

    const regExp4 = /group$/;
    div1.innerHTML += "/$group/ , group100 : " + regExp4.test("group100") + "<br>";
    div1.innerHTML += "/$group/ , 111group : " + regExp4.test("111group") + "<br>";
    
});

document.getElementById("inputName").addEventListener("keyup",function(){
    const span = document.getElementById("inputNameResult");
    const regExp = /^[가-힣]{2,5}$/
    span.style.fontSize = "14px";
    span.style.letterSpacing = "-1.5px"
    
    if(this.value.trim()==""){
        span.innerText = ""
        return;
    }

    if(regExp.test(this.value)){
        span.innerText = "유효한 형식 입니다.";
        span.style.color = "green";
    }else{
        span.innerText = "유효하지 않은 형식입니다."
        span.style.color = "red";
    }
});

document.getElementsByName("inputPno")[0].addEventListener("keyup",function(){
    const span = document.getElementById("inputPnoResult");
    const regExp3 = /^\d{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[01])\-[1-4]\d{6}$/;
    //(0[1-9]|1[0-2])
    if(this.value.length ==0){
        span.innerText = "주민번호를 작성해주세요";
        span.classList.remove("error");
        span.classList.remove("confirm");
        return;
    }
    //span.classList.toggle()
    if(regExp3.test(this.value)){
        span.innerText = "주민번호 형식이 옳바릅니다.";
        span.classList.remove("error");
        span.classList.add("confirm");
    }else{
        span.innerText = "주민번호 형식이 올바르지 않습니다";
        span.classList.remove("confirm");
        span.classList.add("error");
    }
});

