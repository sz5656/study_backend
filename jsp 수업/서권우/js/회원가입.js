let id = document.querySelector('#user-id');
let pwd = document.querySelector('#user-pw1');
let cpwd = document.querySelector('#user-pw2');

id.onchange = function() {
  if(id.value.length < 4 || id.value.length > 15) {
    alert("아이디는 4글자 이상 15자리 이하입니다");
    id.select();
  }

}
pwd.onchange = function() {
  if(pwd.value.length < 8) {
    alert("비밀번호는 8자리 이상입니다");
    pwd.value = '';
    pwd.focus();
  }
}
cpwd.onchange = function() {
  if(cpwd.value != pwd.value) {
    alert("비밀번호가 일치하지 않습니다");
    cpwd.value = '';
    cpwd.focus();
  }
}