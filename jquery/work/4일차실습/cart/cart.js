let basket = {
  changePNum : function(n) {
    let inputValue = event.target.closest('.updown').children[0].value;
  //부모안에 input태그의 value 값을 1 증가
    if(event.target.classList.contains('up')) {
      event.target.closest('.updown').children[0].value = Number(inputValue) + Number(1);
    }
    //부모안에 input태그의 value 값을 1 감소
    if(event.target.classList.contains('down')) {
      if(event.target.closest('.updown').children[0].value > 0) {
        event.target.closest('.updown').children[0].value = Number(inputValue) - Number(1);
      }
    }
    this.reCalc();
  },
  //합계계산
  reCalc: function() {
    //수량, 금액 합계 계산
    //합계 자리에 출력
    let cnt = event.target.closest('.updown').children[0].value;
    let price = event.target.closest('.subdiv').children[0].children[0].value;
    let sum = (Number(price) * Number(cnt)).toLocaleString();
    event.target.closest('.subdiv').children[2].innerHTML = sum + '원';
    let totalCnt = 0;
    document.querySelectorAll('.p_num').forEach(ele => {
      totalCnt = Number(totalCnt) + Number(ele.value);
    });
    let totalSum = 0;
    let total = document.querySelectorAll('.sum')
    for(let i = 1; i < total.length; i++) {
      totalSum = Number(totalSum) + parseInt(total[i].innerHTML.replace(',',''))
    }
    let localSum = totalSum.toLocaleString();
    document.querySelector('#sum_p_num').innerHTML = `상품갯수: ${totalCnt}개`;
    document.querySelector('#sum_p_price').innerHTML = `합계금액: ${localSum}원`;
  },
  //삭제 버튼, remove()
  //선택 삭제 버튼 .row
  delCheckedItem: function() {
    document.querySelectorAll('[name="buy"]').forEach(ele => {
      if(ele.checked) {
        ele.closest('.row.data').remove();
      }
    })

  }
    
}
