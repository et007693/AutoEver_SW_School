let productList = [
  {
    name: "레쓰비",
    price: 700,
  },
  {
    name: "티오피",
    price: 1000,
  },
  {
    name: "비타500",
    price: 800,
  },
  {
    name: "포카리스웨트",
    price: 1000,
  },
  {
    name: "파워에이드",
    price: 1200,
  },
];

const prompt = require("prompt-sync")();
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

// chaining method
productList
  .filter((e) => e.price <= inputCoin)
  .forEach((e) => console.log(e.name));

// Math.random, break
while (true) {
  const rand1 = parseInt(Math.random() * 6) + 1;
  const rand2 = parseInt(Math.random() * 6) + 1;
  console.log(`주사위 1번 : ${rand1}, 주사위 2번 : ${rand2}`);
  if (rand1 == rand2) break;
}
console.log("주사위 값이 같으므로 무인도를 탈출합니다.");

// for ..in : 객체의 키 값 기준 순회
const person = { name: "안유진", age: 23, isAdult: true };
for (const key in person) {
  console.log(person[key]);
}
