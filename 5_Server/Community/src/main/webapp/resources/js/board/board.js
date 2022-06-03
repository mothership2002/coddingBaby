
(function(){
    const goToListBtn = document.getElementById("goToListBtn");
    if(goToListBtn != null){
        goToListBtn.addEventListener("click",function(){
            const pathName = location.pathname;
            let a = pathName.substring(0,pathName.indexOf("/",1));
            a += '/board/list?';
            const params = new URL(location.href).searchParams;
            const type = "type=" + params.get("type");
            let cp;
            if(params.get("cp")!=null){
                cp = "cp=" + params.get("cp");
            }else{
                cp = "cp=1";
            }
            location.href = a+type+"&"+cp;
        });
    }
})();

(function(){
    const thumbnail = document.getElementsByClassName("list-thumbnail");

    if(thumbnail.length > 0){ // 목록에 썸네일 이미지가 있을 경우에만 이벤트 추가
        const modal = document.querySelector('.modal');
        const modalImage = document.getElementById("modal-image");
        const modalClose = document.getElementById("modal-close");

        for(let th of thumbnail){
            th.addEventListener("click", function(){
                modalImage.setAttribute("src", th.getAttribute("src") );
                modal.classList.toggle('show');
            });
        }

        modalClose.addEventListener("click", function(){
            
            modal.classList.toggle('hide');

            setTimeout(function(){
                modal.classList.toggle('hide');
                modal.classList.toggle('show');
            },450);
        });


    }

})();