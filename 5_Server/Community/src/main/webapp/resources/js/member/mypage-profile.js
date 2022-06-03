
const inputImage = document.getElementById("input-image");
if(inputImage != null){
    inputImage.addEventListener("change",function(){
        if(this.files[0] != undefined){
            const reader = new FileReader();
            reader.readAsDataURL(this.files[0]);
            reader.onload = function(e){
                const profileImage = document.getElementById("profile-image");
                profileImage.setAttribute("src",e.target.result);
                document.getElementById("delete").value = 0;
            }
        }
    })
}

function profileValidate(){
    const image = document.getElementById("input-image");
    const del = document.getElementById("delete");
    if(image.value == ''&& del.value == 0){
        alert("이미지를 선택한 후 변경 버튼을 클릭해주세요.")
        return false;
    }
    return true;
}

document.getElementById("delete-img").addEventListener("click",function(){
    const deleteBtn = document.getElementById("delete");
    if(deleteBtn.value == 0){
        document.getElementById("profile-image").setAttribute("src",contextPath + "/resources/images/user.png")
        document.getElementById("input-image").value = "";
        deleteBtn.value = 1;
    }
})