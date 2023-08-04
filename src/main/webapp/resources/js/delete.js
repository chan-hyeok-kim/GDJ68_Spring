
let del = document.getElementById("del");
const c1 = document.getElementsByClassName("c1");

const frm = document.getElementById("frm");


for(c of c1){
c.addEventListener("click",function(){
	let url=this.getAttribute("data-url");
	if(url=='delete'){
	   let result = confirm("삭제하시겠습니까");
	   if(!result){
		  return;
	   }
		frm.method = "post";
	}
	frm.action = url;
	frm.submit();	
})
}

// del.addEventListener("click",function(){
// 	let result = confirm("삭제하시겠습니까");
// 	if(result){
// 	   frm.action = './'+del.id;
// 	   frm.method="post";
//     //    let안쓰면 전역변수됨
// let parameterName = del.getAttribute("data-delete-name");
// bookNum = del.getAttribute("data-delete-num");
// 	}
// 	location.href=frm.action+parameterName+"="+bookNum;
// })

