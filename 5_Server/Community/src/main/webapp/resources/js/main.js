/**
 * 
 */

console.log("main.js loaded")

function loginValidate(){
    const email = document.getElementsByName("inputEmail")[0]
    const pw = document.getElementsByName("inputPW")[0] 
    if(email.value.trim().length == 0){
        alert("이메일을 입력해주세요.")
        email.focus();
        return false;
    }
    if(pw.value.trim() == ""){
        alert("비밀번호를 입력해주세요.")
        pw.focus();
        return false;
    }
    return true;
}

if(document.getElementById("check")){
    document.getElementById("check").addEventListener("change",function(){
        const str = "개인 정보 보호를 위해 개인 PC에서의 사용을 권장합니다. 개인 PC가 아닌 경우 취소를 눌러주세요.";
        if(this.checked){
            const a = confirm(str);
            if(!a){
                this.checked = false;
            }
        }
    })
}

document.getElementById("select1").addEventListener("click",function(){
    const input = document.getElementById("in1");
    const div = document.getElementById("result1");
    $.ajax({
        url : "member/selectOne",
        data : {"memberEmail":input.value},
        type : "POST",
        dataType : "JSON",
        success : function(member){
            console.log(member);
            // console.log(JSON.parse(member));
            div.innerHTML = "";
            if(member != null){
                const ul = document.createElement("ul");
                const li = [ , , , , ,];
                for(let i=0;i<li.length;i++){
                    li[i] = document.createElement("li");
                }
                li[0].innerText = "이메일 : "+member.memberEmail;
                li[1].innerText = "닉네임 : "+member.memberNickname;
                li[2].innerText = "전화번호 : "+member.memberTel;
                li[3].innerText = "주소 : "+member.memberAddress;
                li[4].innerText = "가입일 : "+member.enrollDate;
                for(let i=0;i<li.length;i++){
                    ul.append(li[i]);
                }
                div.append(ul);
            }else{
                const h4 = document.createElement("h4");
                h4.innerText = "일치하는 회원이 없습니다.";
                h4.style.color = "red";
                div.append(h4);
            }
        },
        error : function(requst,status,error){
            console.log("ajax error");
            console.log("상태코드 : " + requst.status);
        }

    })
})

function selectAll(){
    $.ajax({
        url:"member/selectAll",
        dataType:"JSON",
        success:function(result){
            const memberList = document.getElementById("memberList");
            memberList.innerHTML = "";
            for(let item of result){
                const tr = document.createElement("tr");
                const td1 = document.createElement("td")
                const td2 = document.createElement("td")
                const td3 = document.createElement("td")
                td1.innerText = item.memberNo;
                td2.innerText = item.memberEmail;
                td3.innerText = item.memberNickname;
                tr.append(td1,td2,td3);
                memberList.append(tr);
            }
        },
        error : function(requst,status,error){
            console.log("ajax error");
            console.log("상태코드 : " + requst.status);
        }

    })
}

(function(){
    selectAll();
    window.setInterval(selectAll,1000);
})()