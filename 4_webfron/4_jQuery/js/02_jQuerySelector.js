document.getElementById("btn1").addEventListener("click",function(){
    const a = document.getElementsByClassName("test");
    const b = $(".test");
    for(let li of a){
        li.style.backgroundColor = "yellow";
    }
    b.css("fontSize","25px");
})