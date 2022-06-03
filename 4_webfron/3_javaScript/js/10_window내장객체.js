document.getElementById("btn1").addEventListener("click",function(){
    setTimeout(function(){
        alert("timeOut");
    },620)
})

//new Date();
//new Date().getHours,getMinutes,second()

let interval;
function clockFn(){
    const clock = document.getElementById("clock");
    clock.innerText = currentTime();
    interval = setInterval(function(){
        clock.innerText = currentTime();
    },1000)
}
function currentTime(){
    const now = new Date();
    let hour = now.getHours();
    let min = now.getMinutes();
    let sec = now.getSeconds();

    if(hour<10) hour = "0" + hour;
    if(min<10)  min = "0" + min;
    if(sec<10)  sec = "0" + sec;
    return hour + ":" + min + ":" + sec;
}

document.getElementById("stop").addEventListener("click",function(){
    clearInterval(interval)
})

clockFn();