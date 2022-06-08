const inputImage = document.getElementsByClassName("input-img");
const preview = document.getElementsByClassName("preview");
const deleteImage = document.getElementsByClassName("delete-image");

const deleteList = document.getElementById("deleteList")
const deleteSet = new Set();


for(let i=0;i<inputImage.length;i++){
    inputImage[i].addEventListener("change",function(){
        if(this.files[0] != undefined){
            const reader = new FileReader();
            reader.readAsDataURL(this.files[0]);  // 파일 url따오기
            reader.onload = function(e){      // 적제 완료 시 
                preview[i].setAttribute("src",e.target.result);
                deleteSet.delete(i);
            }
        } else {
            preview[i].removeAttribute("src");
        }
    });
    deleteImage[i].addEventListener("click",function(){
        if(preview[i].getAttribute("src") != ""){
            inputImage[i].value = "";
            preview[i].removeAttribute("src");
            deleteSet.add(i);
        }
    });
}

const title = document.getElementsByName("boardTitle")[0];
const content = document.getElementsByName("boardContent")[0];

document.getElementById("writeBtn").addEventListener("click",function(e){
    if(title.value.trim() == ""){
        alert("글 제목을 작성해주세요.");
        title.value = ""
        title.focus();
        e.preventDefault();
        return;
    };
    if(content.value.trim() == ""){
        alert("글 내용을 작성해주세요.")
        content.value = ""
        content.focus();
        e.preventDefault();
        return;
    }
    //js배열은 html요소 또는 콘솔로 출력하면 문자열로 반환
    deleteList.value = Array.from(deleteSet);

})

