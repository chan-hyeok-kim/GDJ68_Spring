let op = document.getElementsByClassName("op");
const frm = document.getElementById("frm");
const input1 = document.getElementById("input1");
const se1 = document.getElementById("se1");

let data = se1.getAttribute("data-kind");
// jsp에서 el사용
// 1. 함수 사용
// 2. 속성값 data이용. 엘리먼트에서 속성값 가져오기 

for(opt of op){
    if(opt.value==data){
        opt.selected=true;
        break;
    }
}

const move = document.getElementsByClassName("move");
const page = document.getElementById("page");

for(m of move){
    m.addEventListener("click", function(){
      page.value = this.getAttribute("data-num");
      
    
      frm.submit();
    })
}

