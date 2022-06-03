console.log("loaded");
const board = document.getElementById("bingoBoard");
board.style.padding = "50px";
let c = 0;
const arr = [];
for(let i=0;i<25;i++){
    if(arr[i] == Math.ceil(Math.random()*(25))){
        i--;
    }else{
        arr[i] = Math.ceil(Math.random()*(25));
    }
}
for(let i=0;i<5;i++){
    const a = document.createElement("div");
    a.style.display = "flex";
    a.style.justifyContent = "center";
    a.style.alignItems = "center";
    for(let j=0;j<5;j++){
        const b = document.createElement("div");
        b.style.width = "50px";
        b.style.height = "50px";
        b.style.margin = "2px";
        b.style.border = "1px solid black";
        b.style.fontSize = "20px";
        b.style.textAlign = "center";
        b.style.lineHeight = "50px";
        b.innerText = arr[c];
        c++;
        b.addEventListener("mouseenter",enter);
        b.addEventListener("mouseleave",leave);
        b.addEventListener("click",hoho);
        a.append(b);
    }
    board.append(a)
}

function enter(){
    this.style.backgroundColor = "yellow";
}
function leave(){
    this.style.backgroundColor = "white";
}
function hoho(){
    if(this.style.backgroundColor == 'white'
        || this.style.backgroundColor== "yellow"){
        this.style.backgroundColor = "orange";
        this.removeEventListener("mouseleave",leave);
        this.removeEventListener("mouseenter",enter);
    }else{
        this.style.backgroundColor = "white";
        this.addEventListener("mouseenter",enter);
        this.addEventListener("mouseleave",leave);
    }
}