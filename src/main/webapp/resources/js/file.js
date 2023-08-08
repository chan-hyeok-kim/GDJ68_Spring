{/* <div class="input-group">
<input type="file" name="files" class="form-control" id="bankfile" aria-label="Upload">
</div> */}

const btn1 = document.getElementById("btn1");

let max = 5;
let count = 0;


let idx = 0;
const fileList = document.getElementById("fileList");
const deletes = document.getElementsByClassName("deletes");

if(deletes != null){
    count= deletes.length;
   
}

for(d of deletes){
    d.addEventListener("click", function(){
    
      
      let num = this.getAttribute("data-delete-num");
     
      let check = confirm("삭제시 복구 불가")
      if(check){
        fetch("./fileDelete?fileNum="+num, {method:"get"})
        .then((result)=>{return result.text()})
        .then((r)=>{
            if(r.trim()=='1'){
                this.previousSibling.remove();
                this.remove();
                count--;
            }});
        

// post로 해야될때가 있음. 주소창이용해서 삭제할수도있으므로
// get이면 지우려고하는애가 작성자가맞는지 체크해야함        
      }
    
    })
}





fileList.addEventListener("click",function(event){
    let cl = event.target.classList;
    if(event.target.classList.contains("df")){
        let deleteId = event.target.getAttribute("data-id");
        document.getElementById(deleteId).remove();
        count--;
        
       }
    
})

  btn1.addEventListener("click", function(){
    
  if(count>=max){
    alert("최대 업로드 수는 5개입니다");
    return;
  }
    count++;
   
    let d2 = document.createElement("div");
    let a = document.createAttribute("class");
    a.value= "input-group";
    d2.setAttributeNode(a);

    a = document.createAttribute("id");
    a.value = "file"+idx;
    d2.setAttributeNode(a);

    let f2 = document.createElement("input");
    let f1 = document.createAttribute("type");
    f1.value = "file";
    f2.setAttributeNode(f1);
    
    f1 = document.createAttribute("name");
    f1.value = "photos";
    f2.setAttributeNode(f1);

    f1 = document.createAttribute("id")
    f1.value="photos";
    f2.setAttributeNode(f1);

    f1 = document.createAttribute("class");
    f1.value = "form-control";
    f2.setAttributeNode(f1);

    f1 = document.createAttribute("aria-lable");
    f1.value = "upload";
    f2.setAttributeNode(f1);
    
    d2.appendChild(f2);
    btn1.after(d2);

    
  
    let s = document.createElement("span");
    let t = document.createTextNode("삭제");
    f1 = document.createAttribute("class");
    f1.value = "df";
    s.setAttributeNode(f1);

    f1 = document.createAttribute("data-id");
    f1.value="file"+idx;
    s.setAttributeNode(f1);
    
    s.appendChild(t);
    d2.appendChild(s);
    
    idx++;

})



