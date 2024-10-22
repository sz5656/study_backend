// 수1 id : num1
// 수2 id : num2
// 결과 id : result
// + - * / : add sub multy divid
let btnAd = document.querySelector('#add');
let btnSu = document.querySelector('#sub');
let btnMu = document.querySelector('#multy');
let btnDi = document.querySelector('#divid');

let num1 = document.querySelector('#num1');
let num2 = document.querySelector('#num2');
btnAd.onclick = addCalc;
btnSu.onclick = subCalc;
btnMu.onclick = mulCalc;
btnDi.onclick = divCalc;

function addCalc() {
  let calResult = Number(num1.value) + Number(num2.value);
  return document.querySelector('#result').value = calResult;
}
function subCalc() {
  let calResult = Number(num1.value) - Number(num2.value);
  return document.querySelector('#result').value = calResult;
}
function mulCalc() {
  let calResult = Number(num1.value) * Number(num2.value);
  return document.querySelector('#result').value = calResult;
}
function divCalc() {
  let calResult = Number(num1.value) / Number(num2.value);
  return document.querySelector('#result').value = calResult;
}
// function calc() {
//   let func = btn1;
  // let num1 = document.querySelector('#num1');
  // let num2 = document.querySelector('#num2');
//   console.log(`${num1} / ${num2} / ${func}`)
//   let calResult = 0;
//   switch(func) {
//     case 'add' :
//       calResult = Number(num1.value) + Number(num2.value);
//       break;
//     case 'sub' :
//       calResult = Number(num1.value) - Number(num2.value);
//       break;
//     case 'multy' :
//       calResult = Number(num1.value) * Number(num2.value);
//       break;
//     case 'divid' :
//       calResult = Number(num1.value) / Number(num2.value);
//       break;
//     default :
//       calResult = 0;
//       break;
//   }
//   return document.querySelector('#result').value = calResult;
// }