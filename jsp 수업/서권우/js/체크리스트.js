let item = document.querySelector('#item');
let add = document.querySelector('#add');

let itemList = [];
add.onclick = function() {
  let itemName = item.value;

  if(itemName == '') {
    alert("값을 입력하세요");
  } else {
    if(itemList.indexOf(itemName) != -1) {
      alert("중복된 값입니다");
    } else {
      itemList.push(itemName);
      item.value = '';
      item.focus();
    }
  }
  show();
  
}

function show() {
  let layout = '';
  for(idx in itemList) {
    layout += `<ul><li>${itemList[idx]}<span class = "close" id="${idx}">X</span></li>
    </ul>`;
  }
  document.querySelector('#itemList').innerHTML = layout;
  
  let drop = document.querySelectorAll('.close');
  for(let ele of drop) {
    console.log("실행됨");
    ele.onclick = dropList;
  }
}

function dropList() {
  let itemNum = this.getAttribute('id');
  itemList.splice(itemNum,1);
  show();
}


