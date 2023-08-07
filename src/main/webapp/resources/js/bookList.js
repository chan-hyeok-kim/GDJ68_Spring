const list = document.getElementById("list");

list.addEventListener("click", function(){
     let xhttp = new XMLHttpRequest();

     console.log("list");
     
     //open("method","url")
     xhttp.open("GET", "list?page=1");
     
     xhttp.send();


     //상태번호가 바뀔때
     //이벤트 발생 시 실행함수->콜백함수
     xhttp.onreadystatechange=function(){
          if(this.readyState==4 && this.status==200){
              console.log(this.responseText);
          }
     }


})


