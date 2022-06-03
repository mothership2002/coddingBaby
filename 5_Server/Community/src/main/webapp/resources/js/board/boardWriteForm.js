const inputImage = document.getElementsByClassName("input-img");
const preview = document.getElementsByClassName("preview");
const deleteImage = document.getElementsByClassName("delete-image");

for(let i=0;i<inputImage.length;i++){
    inputImage[i].addEventListener("change",function(){
        if(this.files[0] != undefined){
            const reader = new FileReader();
            reader.readAsDataURL(this.files[0]);  // 파일 url따오기
            reader.onload = function(e){      // 적제 완료 시 
                preview[i].setAttribute("src",e.target.result);
            }
        } else {
            preview[i].removeAttribute("src");
        }
    });
    deleteImage[i].addEventListener("click",function(){
        inputImage[i].value = "";
        preview[i].removeAttribute("src");
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
})