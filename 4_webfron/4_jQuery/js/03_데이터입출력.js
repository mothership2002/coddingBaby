
$("#btn1").on("click",function(){
    const input = $(this).prev().prev().val();
    $(this).prev().prev().prev().css("backgroundColor",input);
})

$("#btn2").on("click",function(){
    const inputList = $(".input2");
    for(let i=0;i<inputList.length;i++){
        $(inputList[i]).prev().css("backgroundColor",$(inputList[i]).val())
    }

})


$(".input3").on("input",function(){
    const list = $(".input3");
    for(let i=0;i<list.length;i++){
        $(list[i]).prev().css("backgroundColor",$(list[i]).val())
        $(list[i]).prev().css("transition-duration","240ms")
        $(list[i]).css("border","2px solid "+$(list[i]).val())
        $(list[i]).css("transition-duration","240ms")
    }
})