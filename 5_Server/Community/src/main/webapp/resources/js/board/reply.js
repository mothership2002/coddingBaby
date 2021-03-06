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
                    updateBtn.innerText = "??????";
                    updateBtn.setAttribute("onclick","showUpdateReply("+reply.replyNo+",this)")
                    const deleteBtn = document.createElement("button");
                    deleteBtn.innerText = "??????";
                    deleteBtn.setAttribute("onclick","deleteReply("+reply.replyNo+")")
                    btnArea.append(updateBtn,deleteBtn);
                    replyRow.append(btnArea);
                }
                
                replyList.append(replyRow);
            }
        },
        //??????????????? ????????? ?????? ?????? ????????? ??????
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
        alert("????????? ??? ??????????????????");
        return;
    }
    if(replyContent.value.trim().length == 0 ){
        alert("?????? ????????? ??????????????????.")
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
                alert("????????? ?????????????????????.");
                replyContent.value = "";
                selectReplyList();
            }else{
                alert("?????? ????????? ???????????? ???????????????. ?????? ??????????????????.")
            }
        },
        error : function(req,status,error){
            console.log("?????? ?????? ??????");
            console.log(req.responseText);
        }
    })
})

function deleteReply(replyNo){
    if(confirm("?????? ?????????????????????????")){
        $.ajax({
            url: contextPath+"/reply/replyDelete",
            data: {"replyNo" : replyNo},
            type: "GET",
            success: function(result){
                if(result>0){
                    alert("?????????????????????.")
                    selectReplyList();
                }else{
                    alert("?????? ??????????????????.")
                }
            },
            error: function(req,status,error){
                console.log("?????? ?????? ??????");
                console.log(req.reponseText);
            }
        })
    }
}

let beforeReplyRow;
function showUpdateReply(replyNo,eventTarget){
    const temp = document.getElementsByClassName("update-textarea");
    if(temp.length>0){
        // alert("????????? ???????????? ??????????????????.");
        // return;
        if(confirm("?????? ????????? ?????? ????????????. \n?????? ?????? ????????? ???????????? ?????? ????????? ?????????????????????????")){
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
    updateBtn.innerText = "??????";
    cancelBtn.innerText = "??????";
    updateBtn.setAttribute("onclick","updateReply("+replyNo+",this)");
    cancelBtn.setAttribute("onclick","updatecancel(this)");

    replyBtnArea.append(updateBtn,cancelBtn);
    replyRow.append(replyBtnArea);
}
function updatecancel(eventTarget){
    if(confirm("?????? ????????? ?????????????????????????")){
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
                alert("?????? ????????? ?????????????????????.")
                selectReplyList();
            }else{
                alert("?????? ????????? ?????????.")
            }
        },
        error : function(req,status,error){
            console.log("?????? ?????? ??????");
            console.log(req.reponseText);
        }
    })
}