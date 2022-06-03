function accessId(){
    const div1 = document.getElementById("div1");
    const bgColor = div1.style.backgroundColor;
    if(bgColor=="red"){
        div1.style.backgroundColor = "yellow";
    }else{
        div1.style.backgroundColor = "red";
    }
}
function accessClass(){
    const arr = document.getElementsByClassName("div2");

    arr[0].style.backgroundColor = "pink";
    arr[1].style.backgroundColor = "tomato";
    arr[2].style.backgroundColor = "blue";
}

function accessTagName(){
    const arr = document.getElementsByTagName("li");
    for(let i=0;i<arr.length;i++){
        const num = arr[i].innerText
        arr[i].style.backgroundColor = "rgb(42,155,"+(50*num)+")"
    }
}

function inputTest(){
    const input = document.getElementById("input-test");
    console.log(input.value);
    input.value = "";
    input.focus();
}

function accessName(){
    const hobbylist = document.getElementsByName("hobby");
    let str = ""
    let count = 0;
    for(let i=0;i<hobbylist.length;i++){
        if(hobbylist[i].checked){
            str += hobbylist[i].value + " ";
            count++;
        }
    }
    document.getElementById("name-div").innerText = str;
    document.getElementById("name-div").innerHTML += "<br><b>취미 개수</b> : "+count;
}
function accessCss(){
    document.querySelector("#css-div").style.border = "3px solid red";
    document.querySelector("#css-div>div").style.fontSize = "30px";
    const arr = document.querySelectorAll("#css-div>div");
    for(let i=0;i<arr.length;i++){
        arr[i].style.backgroundColor = "rgb("+(66*i)+","+(123*i)+","+(9*i)+")";
    }
        
}
function readValue(){
    const bg = document.getElementById("chatting-bg");
    const input = document.querySelector("#chatting-input");
        if(input.value.trim() != 0 ){
        bg.innerHTML += "<p><span>"+input.value+"</span></p>";
        //elemental.scrolltop : 현재 스크롤위치
        //elemental.scrolltop = 숫자 : 해당 위치로 이동
        //elemental.scrollheight : 스크롤 전체크기
        bg.scrollTop = bg.scrollHeight ;
        }else{
            alert("내용을 입력해주세요.")
        }
    input.value = "";
    input.focus();
}
function inputEnter(){
    if(window.event.key=="Enter"){
        readValue();
    }
}