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

    if(thumbnail.length > 0){ 
        // 목록에 썸네일 이미지가 있을 경우에만 이벤트 추가
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
(function(){
    const deleteBtn = document.getElementById("removeBtn");
    if(deleteBtn != null){
        deleteBtn.addEventListener("click",function(){
            if(confirm("삭제 하시겠습니까?")){
                let url = "delete";
                const params = new URL(location.href).searchParams;
                const no = params.get("no");
                const type = params.get("type");
                location.href = url+"?type="+type+"&no="+no;
                //get방식
            };
        });
    }
})();

(function(){
    const select = document.getElementsByName("key")[0];
    const option = select.children;
    const searchValue = document.getElementById("search-query");
    if(select != null){
        const params = new URL(location.href).searchParams;
        const key = params.get("key");
        const query = params.get("query");
        searchValue.value = query;

        for(let op of option){
            if(op.value == key){
                op.select = true;
            }
        }
    }
})();
