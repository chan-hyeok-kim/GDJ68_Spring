
	
const idtest = document.getElementById("idtest");
const id1 = document.getElementById("id1");
const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const frm = document.getElementById("frm");
const name1 = document.getElementById("name1");
const email = document.getElementById("email");
const birth = document.getElementById("birth");
const btn = document.getElementById("btn");
const control = document.getElementsByClassName("form-control"); 

const msg1 = document.getElementById("msg1");
const msg2 = document.getElementById("msg2");
const msg3 = document.getElementById("msg3");
const msg4 = document.getElementById("msg4");
const msg5 = document.getElementById("msg5");
const msg6 = document.getElementById("msg6");

//Check결과
let checkResult = [false, false, false, false, false,false,false];

const idList = document.getElementById("idList");

idtest.addEventListener("blur",function(){

   

   fetch("/member/idCheck?id=" + idtest.value, {
       method: "get"
   }) 
        .then((response)=>{ return response.text()})
        .then((r)=>{
          if(r.trim()=='1'){
            alert("중복이 아닙니다");
            if(idtest.value.length==0){
              msg1.innerText="id를 반드시 입력해주세요";
              msg1.className="f";
              checkResult[0]=false;
              checkResult[6]=false;
            }else if (idtest.value.length>10){
              msg1.innerText="id가 너무 깁니다";
              msg1.className="f";
              checkResult[0]=false;
              checkResult[6]=false;
            }else{
              msg1.innerText="id가 양호합니다";
              msg1.className="s";
              checkResult[0]=true;
              checkResult[6]=true;
            }
          }else{
            msg1.innerHTML="이미 사용중인 ID입니다";
            msg1.className="f"
            checkResult[0]=false;
            checkResult[6]=false;
          }
      } )
});




pw.addEventListener("blur",function(){
   if(pw.value==''){
    msg2.innerText="pw를 반드시 입력해주세요";
    msg2.className="f";
    checkResult[1]=false;
   }else if(pw.value.length<6 || pw.value.length>=12){
    msg2.innerText="비밀번호는 6글자 이상 12글자 미만입니다"
    msg2.className="f";   
    checkResult[1]=false;
   }else{
    msg2.innerText="비밀번호가 양호합니다";
    msg2.className="s";
    checkResult[1]=true;
   }
})

pw.addEventListener("change",function(){
   pw2.value="";
   checkResult[2]=false;
   msg3.innerHTML="";
})

pw2.addEventListener("keyup",function(){
   if(pw.value!=pw2.value){
     msg3.innerText="비밀번호가 일치하지 않습니다";
     msg3.className="f"; 
     checkResult[2]=false;
   }else{
     msg3.innerText="비밀번호가 일치합니다";
     msg3.className="s";
     checkResult[2]=true;
   }

})

function emptyCheck(element){
    if(element.value==''){
      return true;  
    }else{
      return false;
    }
}

name1.addEventListener("blur",function(){
    let check = emptyCheck(name1);
    msg4.innerHTML="이름을 반드시 입력해주세요";
    msg4.className="f";
    checkResult[3]=false;
    if(!check){
      msg4.innerText="OK";
      msg4.className="s";
      checkResult[3]=true;
    }
})
		
email.addEventListener("blur",function(){
    if(email.value==''){
        msg5.innerText="이메일을 반드시 입력해주세요";
        checkResult[4]=false;
       }else{
        msg5.innerText="ok";
        checkResult[4]=true;
       }
})



birth.addEventListener("change",function(){
    if(birth.value==''){
        msg6.innerText="생일을 반드시 입력해주세요";
        checkResult[5]=false;
    } else{
      msg6.innerText="ok";
      checkResult[5]=true;
    } 
  }) 
  

    
btn.addEventListener("click",function(){
    if(checkResult.includes(false)){
        alert("필수 항목은 입력해주세요")
        // 반복문 쓰면 포커스 가능
    }else{
        
       frm.submit();
    }
  })