function test1(btn){
    btn.style.backgroundColor = "black";
    btn.style.color = "red";
}
//고전 이벤트 모델
document.getElementById("test2-1").onclick = function(){
    this.style.backgroundColor = "green";
    this.style.color = "yellow";
    alert("고전 이벤트 모델");
}

document.getElementById("test2-2").onclick = function(){
    document.getElementById("test2-1").onclick = null;
    alert("이벤트 제거")
}

document.getElementById("test2-3").onclick = function(event){
    // document.getElementById("test2-3").style.backgroundColor = "pink";
    // 고전 이벤트 모델
    // 이벤트 헨들러에 e또는 event를 작성 
    // - 해당 이벤트와 관련된 모든 정보가 담긴 이벤트 객체가 반환됨
    event.target.style.backgroundColor = "pink";
    //this

}
// document.getElementById("test2-3").onclick = function(){
//     document.getElementById("test2-3").style.fontSize = "30px";
// }

// 표준이벤트모델
document.getElementById("test3").addEventListener("click",function(){
    this.style.width = this.clientWidth+3+"px";
})
document.getElementById("test3").addEventListener("click",function(){
    this.style.height = this.clientHeight+3+"px";
})

document.getElementById("changeBtn1").addEventListener("click",function(){
    document.getElementById("div1").style.backgroundColor =
         document.getElementById("inputColor").value;
})

document.getElementById("inputColor").addEventListener("change",function(){
    document.getElementById("div1").style.backgroundColor =
    document.getElementById("inputColor").value;
})
document.getElementById("linkedNaver").addEventListener("click",function(e){
    e.preventDefault();
})
//1방법
document.getElementById("testBtn1").addEventListener("click",function(){
    const in1 = document.getElementById("in1").value;
    if(in1 == "제출"){
        document.testForm1.submit();
    }
})

function checkIn2(){
    let result;
    if(document.getElementById("in2").value == "제출"){
        result = true;
    } else {
        result = false;
    }
    return result;
}