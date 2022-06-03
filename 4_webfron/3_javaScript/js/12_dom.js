document.getElementById("btn1").addEventListener("click",function(){
    const nodes = document.getElementById("test").childNodes;
    console.log(nodes)

    //1_ parentNode
    const li1 = document.getElementById("li1");
    console.log(li1.parentNode);

    li1.parentNode.append('asdf');
    //2_ firstChild
    console.log(document.getElementById("test").firstChild);
    //3_ lastChild
    console.log(document.getElementById("test").lastChild);
    //4_ childNodes[index]
    console.log(document.getElementById("test").childNodes[11]);
    console.log(document.getElementById("test").childNodes[8]);
    //5_ 이전 형제 노드 : previousSibling
    ///  다음 형제 노드 : nextSibling
    console.log(document.getElementById("test").childNodes[8].previousSibling)
    console.log(document.getElementById("test").childNodes[8].nextSibling)
})

document.getElementById("btn2").addEventListener("click",function(){
    const list = document.getElementById("test");
    console.log(list.children);
    list.firstElementChild.style.backgroundColor = "red";
    list.lastElementChild.style.backgroundColor = "blue";
    list.children[2].previousElementSibling.addEventListener("click",function(){
        alert("2-1")
    })
    list.children[2].nextElementSibling.addEventListener("click",function(){
        alert("2+1")
    })
})

function prevEl(el){
    return el.previousElementSibling;
}
function nextEl(el){
    return el.nextElementSibling;
}
let count1 = 1;
document.getElementById("btn3-1").addEventListener("click",function(){
    const div = document.getElementById("div3-1");
    if(count1<11){
        div.innerHTML += "<div>"+count1+"</div>";
        count1++;
    }
})
let count2 = 1;
document.getElementById("btn3-2").addEventListener("click",function(){
    const div = document.getElementById("div3-2");
    if(count2<11){
    const child = document.createElement("div");
    child.innerText = count2;
    div.append(child);        
    count2++;
    }
})