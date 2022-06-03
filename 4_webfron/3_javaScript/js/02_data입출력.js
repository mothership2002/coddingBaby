function getInnerText(){
    const test1 = document.getElementById("test1")
    console.log(test1.innerText);
}

function setInnerText(){
    const test1 = document.getElementById("test1");
    test1.innerText = "변경된 내용 <br> hello world";
}

function getInnerHTML1(){
    const test2 = document.getElementById("test2");
    console.log(test2.innerHTML);
}

function setInnerHTML1(){
    const test2 = document.getElementById("test2");
    test2.innerHTML = "<b>innerHTML로 변경된 내용</b><br> HELLO WORLD";
}

function add(){
    const area1 = document.getElementById("area1");
    //const content = area1.innerHTML;
    //area1.innerHTML = content + "<div class='box2'></div>";
    area1.innerHTML += "<div class='box2'></div>";
}
function fnAlert(){
    alert("버튼 확인됨");
}
function fnConfirm(){
    if(confirm("yes or yes")){
        document.getElementById("confirmBtn").style.backgroundColor = "blue";
    }else{
        document.getElementById("confirmBtn").style.backgroundColor = "#efefef";
    }
}
function fnPrompt(){

    const input = prompt("이름 ")
    const promptRusult = document.getElementById("promptRusult");
    if(input != null){
        promptRusult.innerText = input + " 하이";
    }else{
        promptRusult.innerText = "이름 입력";
    }

}