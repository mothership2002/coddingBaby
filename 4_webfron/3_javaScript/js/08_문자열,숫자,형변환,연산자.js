document.getElementById("btn1").addEventListener("click",function(){
    //문자열.indexOf("문자열") : 문자열에서 "
    //              문자열"일치하는부분이 시작되는 인덱스를 반환
    //없으면-1반환
    const str1 = "Hellow world";
    console.log(str1.indexOf("e"))
    console.log(str1.indexOf("l"))
    //가장 먼저 검색된 인덱스만 반환

    // 문자열.substring(시작인덱스,종료인덱스(미포함))
    const str2 = "abcdefg";
    console.log(str2.substring(0,3))

    //문자열.split("구분자") : 문자열을 "구분자"로 잘라서 배열로 전환
    const str3 = "햄버거, 김밥, 비빔밥, 라면, 파스타,";
    const arr = str3.split(", ");
    for(let i=0;i<arr.length;i++){
        console.log(arr[i]);
    }
})  

document.getElementById("btn2").addEventListener("click",function(){
    console.log(5/0);
    if(5/0 == Infinity){
        console.log("무겐");
    }
    console.log("가"*20);

    // if("aaa" == NaN || 20 ==Na){
    //     console.log("숫자가 아님")
    // }
    if(isNaN("rrr"*20)){
        console.log("숫자가 아님");
    }
    // this.innerText = Math.random();
    
    //round(), ceil(), floor(), trunc();
    //반올림 , 올림 , 내림 , 절삭
    console.log(Math.round(10.5))
    console.log(Math.ceil(10.5))
    console.log(Math.floor(-10.5))
    console.log(Math.trunc(-10.5))
    
    const r = Math.random()*256+1;
    const g = Math.random()*256+1;
    const b = Math.random()*256+1;

    this.style.backgroundColor = "rgb("+r+","+g+","+b+")";
    //숫자.toFixed(자리수)
    console.log((1.45).toFixed(1));
})
document.getElementById("btn3").addEventListener("click",function(){
    console.log(parseInt(1.243));
    console.log(parseFloat(1.234));
    console.log(Number(1.234));
})