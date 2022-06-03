function selectReplyList(){
    $.ajax({
        url : contextPath+"/reply/selectReplyList",
        data : {"boardNo" : boardNo},
        type : "GET",
        dataType : "JSON",
        success : function(rList){
            console.log(rList);
            const replyList = document.getElementById("reply-list");
            replyList.innerHTML = "";
            for(let reply of rList){
                const replyRow = document.createElement("li");
                replyRow.classList.add("reply-row");
                const replyWriter = document.createElement("p")
                replyWriter.classList.add("reply-writer")

                const aTag = document.createElement("a");
                const bTag = document.createElement("a");
                
                const profileImage = document.createElement("img");
                const nickname = document.createElement("span")
                const replyDate = document.createElement("span")

                if(reply.profileImage != null){
                    profileImage.setAttribute("src",contextPath+reply.profileImage);
                }else{
                    profileImage.setAttribute("src",contextPath+"/resources/images/user.png");
                }

                nickname.innerText = reply.memberNickname;

                replyDate.classList.add("reply-date");
                replyDate.innerText = "("+reply.createDate+")";

                aTag.append(profileImage);
                bTag.append(nickname);
                aTag.setAttribute("href","#")
                bTag.setAttribute("href","#")
                replyWriter.append(aTag,bTag,replyDate);

                const replyContent = document.createElement("p");
                replyContent.classList.add("reply-content")
                replyContent.innerHTML = reply.replyContent;
                replyRow.append(replyWriter,replyContent);
                
                if(reply.memberNo == loginMember){
                    const btnArea = document.createElement("div");
                    btnArea.classList.add("reply-btn-area");
                    const updateBtn = document.createElement("button");
                    updateBtn.innerText = "수정";
                    updateBtn.setAttribute("onclick","showUpdateReply("+reply.replyNo+",this)")
                    const deleteBtn = document.createElement("button");
                    deleteBtn.innerText = "삭제";
                    deleteBtn.setAttribute("onclick","deleteReply("+reply.replyNo+")")
                    btnArea.append(updateBtn,deleteBtn);
                    replyRow.append(btnArea);
                }
                
                replyList.append(replyRow);
            }
        },
        //매개변수의 갯수에 따른 에러 변수로 사용
        error : function(req,status,error){
            console.log("error");
            console.log(req.reponseText);
        }
    });
}

const addReply = document.getElementById("addReply");
const replyContent = document.getElementById("replyContent");

addReply.addEventListener("click",function(){
    if(loginMember == ""){
        alert("로그인 후 이용해주세요");
        return;
    }
    if(replyContent.value.trim().length == 0 ){
        alert("댓글 내용을 입력해주세요.")
        replyContent.value = "";
        replyContent.focus();
        return;
    }

    $.ajax({
        url: contextPath+"/reply/replyInsert",
        data: {"replyContent" : replyContent.value,
                "memberNo" : loginMember,
                "boardNo" : boardNo},
        type: "POST",
        success : function(result){
            if(result>0){
                alert("댓글이 등록되었습니다.");
                replyContent.value = "";
                selectReplyList();
            }else{
                alert("댓글 등록이 완료되지 않았습니다. 다시 시도해주세요.")
            }
        },
        error : function(req,status,error){
            console.log("댓글 등록 실패");
            console.log(req.responseText);
        }
    })
})

function deleteReply(replyNo){
    if(confirm("정말 삭제하시겠습니까?")){
        $.ajax({
            url: contextPath+"/reply/replyDelete",
            data: {"replyNo" : replyNo},
            type: "GET",
            success: function(result){
                if(result>0){
                    alert("삭제되었습니다.")
                    selectReplyList();
                }else{
                    alert("다시 시도해주세요.")
                }
            },
            error: function(req,status,error){
                console.log("댓글 등록 실패");
                console.log(req.reponseText);
            }
        })
    }
}

let beforeReplyRow;
function showUpdateReply(replyNo,eventTarget){
    const temp = document.getElementsByClassName("update-textarea");
    if(temp.length>0){
        // alert("수정을 완료하고 시도해주세요.");
        // return;
        if(confirm("다른 댓글을 수정 중입니다. \n다른 댓글 수정을 취소하고 현재 댓글을 수정하시겠습니까?")){
            temp[0].parentElement.innerHTML = beforeReplyRow;
        }else{
            return;
        }
    }
    const replyRow = eventTarget.parentElement.parentElement;
    beforeReplyRow = replyRow.innerHTML;

    // replyRow.children[1].innerHTML;
    let preReplyContent = replyRow.children[1].innerHTML;
    replyRow.innerHTML = "";

    const textArea = document.createElement("textarea");
    textArea.classList.add("update-textarea");

    preReplyContent = preReplyContent.replaceAll("&amp;","&");
    preReplyContent = preReplyContent.replaceAll("&lt;","<");
    preReplyContent = preReplyContent.replaceAll("&gt;",">");
    preReplyContent = preReplyContent.replaceAll("&quot;","\"");
    preReplyContent = preReplyContent.replaceAll("<br>","\n");

    textArea.value = preReplyContent;
    replyRow.append(textArea);

    const replyBtnArea = document.createElement("div");
    replyBtnArea.classList.add("reply-btn-area");

    const updateBtn = document.createElement("button")
    const cancelBtn = document.createElement("button")
    updateBtn.innerText = "수정";
    cancelBtn.innerText = "취소";
    updateBtn.setAttribute("onclick","updateReply("+replyNo+",this)");
    cancelBtn.setAttribute("onclick","updatecancel(this)");

    replyBtnArea.append(updateBtn,cancelBtn);
    replyRow.append(replyBtnArea);
}
function updatecancel(eventTarget){
    if(confirm("댓글 수정을 취소하시겠습니까?")){
        eventTarget.parentElement.parentElement.innerHTML = beforeReplyRow;
    }
}
function updateReply(replyNo,eventTarget){
    const replyContent = eventTarget.parentElement.previousElementSibling.value;
    $.ajax({
        url: contextPath+"/reply/replyUpdate",
        data: { "replyNo":replyNo,
                "replyContent":replyContent},
        type: "POST",
        success : function(result){
            if(result>0){
                alert("댓글 수정이 완료되었습니다.")
                selectReplyList();
            }else{
                alert("다시 시도해 주세요.")
            }
        },
        error : function(req,status,error){
            console.log("댓글 수정 실패");
            console.log(req.reponseText);
        }
    })
}