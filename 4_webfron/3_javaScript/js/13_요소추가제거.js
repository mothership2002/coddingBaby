document.getElementById("add").addEventListener("click",function(){
    const div = document.createElement("div");
    div.classList.add("row");
    const input = document.createElement("input");
    input.classList.add("in");
    input.setAttribute("type","nubmer");
    const span = document.createElement("span");
    span.classList.add("remove");
    span.innerText = "X"
    span.addEventListener('click',function(){
        span.parentElement.remove();
    })

    div.append(input);
    div.append(span);

    document.getElementById("container").append(div);
})
document.getElementById("calc").addEventListener("click",function(){
    let sum = 0 ;
    const list = document.getElementsByClassName("in");
    for(let input of list){
        sum += Number(input.value);
    }
    alert("합계 : "+sum);
})
