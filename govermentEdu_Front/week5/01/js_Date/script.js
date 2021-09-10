let pointDay = prompt('계산할 날짜를 입력해주세요', '2021-07-20');
// let days = prompt('계산할 D-day 일자를 입력해주세요', '100');

let now = new Date(); // 현재 시간을 가진 객체를 생성
let dDay = new Date(pointDay); // 인자로 정해진 시간을 가진 객체를 생성

let toNow = now.getTime();
let todDay = dDay.getTime();

console.log(toNow, todDay);

let passTime = toNow - todDay;
console.log('지난시간: ' + passTime);

let passDay = Math.trunc(passTime / (1000 * 60 * 60 * 24));
console.log('지난일자: ' + passDay);

document.getElementById('accent').innerHTML = passDay + '일 경과';
document.getElementById('firstday').innerHTML = pointDay;

// 100일 이후 날짜
function calcDate(days) {
  let itemDate = document.getElementsByClassName('item-date');
  let itemPoint = document.getElementById('pointDay');

  let theTime = days * (24 * 60 * 60 * 1000); // 100일 지난 날짜 시간으로 환산
  let futureTime = todDay + theTime; // 시작일 + 100일 -> 100일 후의 시간
  let someDay = new Date(futureTime); // 지난 시간을 개로운 날짜 객체로 생성
  console.log(typeof someDay, someDay);

  let year = someDay.getFullYear();
  let month = someDay.getMonth() + 1;
  let date = someDay.getDate();
  console.log(year, month, date);

  let dateId = 'date' + days;

  if (itemDate) {
    document.getElementById(dateId).innerHTML =
      year + '년 ' + month + '월 ' + date + '일';
  }
}
calcDate(100);
calcDate(200);
calcDate(500);
calcDate(365);
