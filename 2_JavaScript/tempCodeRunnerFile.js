st prompt = require("prompt-sync")();
const inputCoin = Number(prompt("금액 입력 : "));

let len = productList.length;
let outputList = []; // 빈 배열 생성
for (let i = 0; i < len; i++) {
  if (productList[i].price <= inputCoin) {
    outputList.push(productList[i]); // 배열의 끝에 새로운 요소 추가
  }
}
console.log(outputList);
for (let i = 0; i < productList.length; i++) {
  if (productList[i].price <= inputCoin) {
    console.log(productList[i].name);
  }
}

for (const e of productList) {
  if (e.price <= inputCoin) console.log(e.name);
}