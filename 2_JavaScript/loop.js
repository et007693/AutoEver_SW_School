// 반복문
// while, do ~ while

// const prompt = require("prompt-sync")();
// let num = Number(prompt("정수 입력 : "));
// let sum = 0;

// while (num) {
//   sum += num;
//   num--;
// }
// console.log(sum);

// let sum = 0;
// let i = 1;
// for (; i <= num; ) {
//   sum += i;
//   i++;
// }
// console.log(sum);

// while문 사용 예 : 반복 횟수를 알 수 없는 경우

// const prompt = require("prompt-sync")();
// let age = 0;

// while (true) {
//   let age = Number(prompt("나이를 입력하세요 : "));
//   if (age >= 0 && age <= 200) break;
//   console.log("나이를 잘못 입력 하셨습니다.");
// }
// console.log(`당신의 나이는 ${age}입니다.`);

// for문
const cars = ["테슬라 모델Y", "제네시스 G80", "그랜저", "산타페", "코나"];

for (let i = 0; i < cars.length; i++) {
  //   cars[i] += " 0000"; // 원본 데이터 변경
  console.log(cars[i]);
}

// for ..of : 이터러블 순회
for (let e of cars) {
  e += " 0000"; // 원본 데이터 변경 안됨
  console.log(e);
}
for (let e of cars) {
  console.log(e);
}
