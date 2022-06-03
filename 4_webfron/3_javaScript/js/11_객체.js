document.getElementById("btn1").addEventListener("click",function(){
    const div1 = document.getElementsByClassName("area")[0];
    const product = {
        "pName" : "텀블러",
        'brand' : "스타벅스",
        color : ["white","silver","black"],
        price : 35000,
        mix : function(){
            console.log("섞기 시작합니다.")
        },
        infomation : function(){
            console.log(this.brand);
        }
    }
    div1.innerHTML = "";
    div1.innerHTML += "product.pName : " + product.pName + "<br>"
                      +"product.brand : " + product.brand + "<br>"
                      +"product.color : " + product.color + "<br>"
                      +"product.price : " + product.price + "<br>";
    div1.innerHTML += "<hr>";
    for(let key in product){
        div1.innerHTML += product[key] + "<br>"
    }
    div1.innerHTML += "<hr>";
    product.mix();
    product.infomation();
})
function Student(name,grade,ban){
    this.name = name;
    this.grade = grade;
    this.ban = ban;

    this.intro = function(){
        console.log(grade+"학년 "+ban+"반 "+name+" 입니다. ");
    }
}

document.getElementById("btn2").addEventListener("click",function(){
    const std1 = new Student("홍",3,2);
    console.log(std1);
    std1.intro();
})