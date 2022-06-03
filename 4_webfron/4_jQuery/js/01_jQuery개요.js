document.getElementById("jsBtn").addEventListener("click",function(){
    this.style.backgroundColor = "black";
    this.style.color = "yellow";
    this.style.fontSize = "20px";
})

$("#jqueryBtn").on("click",function(){
    $(this).css("backgroundColor","black").css("color","yellow").css("fontSize","20px")
})
window.onload = function(){
    console.log("1");
}
console.log("2");
$(document).ready(function(){
    $("#readyTest").text("ready()확인")
    $("#readyTest").on("click",function(){
        alert("hi")
    })
})
$(document).ready(function(){
    $("#readyTest").css("color","pink");
})

$(function(){
    console.log("ready()");
});

$(()=>{
    console.log("줄인거");
});