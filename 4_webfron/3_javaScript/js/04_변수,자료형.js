console.log("js 코드를 함수 내부가 아닌 js파일 or script태그 밑에 작성 시 html랜더링 시 실행");

var num1 = 1;
num2 = 2;

console.log(num1);
console.log(num2);

function test(){
    var num3 = 33;
    num4 = 44;
    if(true){
        var num5 = 5;
        num6 = 6;
    }
    console.log(num5);
}
test();
// console.log(num3); 지역변수 에러 
console.log(num4);
// console.log(num5); 지역변수 에러
console.log(num6);

function typeTest(){
    const typeBox = document.getElementById("typeBox");
    let temp;
    typeBox.innerHTML = temp;
    const name = "홍길동";
    typeBox.innerHTML += "<br>"+ name + "/" + typeof name;
    const gender = 'M';
    typeBox.innerHTML += "<br>"+gender+"/"+ typeof gender;
    const age = 20;
    const height = 178.9;
    typeBox.innerHTML += "<br>" + age + "/" + typeof age;
    typeBox.innerHTML += "<br>" + height + "/" + typeof height;
    const isTrue = true;
    typeBox.innerHTML += "<br>" + isTrue + "/" + typeof isTrue;

    const arr = [13,452,64,23,58];
    typeBox.innerHTML += "<br>" + arr + "/" + typeof arr;
    for(let i=0;i<arr.length;i++){
        typeBox.innerHTML += "<br> arr[" + i + "] : " + arr[i] + " / " +typeof arr[i];
    }
    const user = { "id" : "user01", "pw" : "pass01"} 
    typeBox.innerHTML += "<br>" + user + "/" + typeof user;
    typeBox.innerHTML += "<br>"+user.id+"/"+ typeof user.id;
    typeBox.innerHTML += "<br>"+user.pw+"/"+ typeof user.pw;

    for(let key in user){
        typeBox.innerHTML += "<br>"+user[key]+"/"+typeof user[key];
    }   

    const sumFn = function(n1,n2){ //익명함수
        return n1+n2;
    }

    typeBox.innerHTML += "<br>"+sumFn+"/"+ typeof sumFn;
    typeBox.innerHTML += "<br>"+sumFn(10,20)+"/"+ typeof sumFn(10,20);
    typeBox.innerHTML += "<br>"+tempFn(30,sumFn)+"/"+ typeof tempFn(30,sumFn);
}
function tempFn(n3,fn){
    return n3+fn(10,20);
}