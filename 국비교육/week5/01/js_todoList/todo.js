let itemBox = document.getElementById('item');
let addBtn = document.getElementById('add');
let ul = document.getElementById('itemList');

let itemList = []; // 빈배열

addBtn.addEventListener('click', addList);

function addList() {
  let itemTxt = itemBox.value;
  if (itemTxt != '' && itemTxt != null) {
    itemList.push(itemTxt);
    console.log(itemList);

    itemBox.value = '';
    itemBox.focus();
  }

  showList();
}

function removeBtn() {
  let indexNum = this.getAttribute('id');
  itemList.splice(indexNum, 1);
  console.log(itemList);

  showList();
}

function showList() {
  // 출력코드
  let li = '';

  for (i in itemList) {
    li +=
      '<li>' +
      itemList[i] +
      '<span class="close" id="' +
      i +
      '"> x <span>' +
      '</li>';
  }
  ul.innerHTML = li;

  let closeBtn = document.querySelectorAll('.close');
  for (let i = 0; i < closeBtn.length; i++) {
    closeBtn[i].addEventListener('click', removeBtn);
  }
}
