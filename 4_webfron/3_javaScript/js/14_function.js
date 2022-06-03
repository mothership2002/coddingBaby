function clickCount(btn){
    btn.innerText = Number(btn.innerText) + 1;
}

function test1(){
    console.log("기본 함수");
}
test1();

(function(){
    console.log("즉시 실행 함수")
})();

const str = "전역 변수";

(function(){
    const str = "abc";    
    console.log(str)
})()
console.log(str);


document.getElementById("btn2-1").addEventListener("click",()=>{
    alert("화살표 함수")
})
document.getElementById("btn2-2").addEventListener("click",e=>{
    alert("매개변수 하나 : "+e)
    e.target.style.backgroundColor = "yellow";
})
document.getElementById("btn2-4").addEventListener("click",()=>{
    printConsole(function(num){return num*10});
    printConsole(num=>num*6)
    printConsole(num=>{return {price : num * 1000, n : num}})
})

function printConsole(fn){
    console.log(fn(3));
}

