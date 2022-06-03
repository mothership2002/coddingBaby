document.getElementById("btn1").addEventListener("click",function(){
    const arr1 = new Array(3);
    const arr2 = new Array()
    
    arr1[0] = "김밥";
    arr1[1] = 123;
    arr1[2] = true;
    console.log(arr1);

    arr2[0] = "김밥";
    arr2[1] = 123;
    arr2[2] = true;
    console.log(arr2);

    const arr3 = [];
    const arr4 = ["사과","딸기","바나나"];

    for(let item of arr4){
        console.log(item);
    }
})
document.getElementById("btn2").addEventListener("click",function(){
    const arr = [];
    arr.push("삼겹살");
    arr.push("쌀국수");
    arr.push("초밥");
    arr.push("곱창");
    console.log(arr)
    arr.pop();
    console.log(arr)
    console.log(arr.indexOf("초밥"))
    const arr2 = [5,3,1,6,2,10,3,2412];
    console.log(arr.sort())
    console.log(arr2.sort())
    console.log(arr2.sort(function(a,b){
        return a-b;
    }))
    console.log(arr.toString());
    console.log(arr.join("/"));
})