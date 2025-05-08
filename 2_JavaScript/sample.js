// prompt 입력 받기 : 자바스크립트는 기본적으로 웹기반의 언어이므로 콘솔 입력이 없음

// for (let i = 1; i <= 9; i++) {
//   console.log(`2 x ${i} = ${2 * i}`);
// }

// const num = Number(prompt("숫자 입력 : "));
// const resultElement = document.querySelector(".result");

// if (num >= 0) {
//   console.log(`${num}은 양수입니다.`);
//   resultElement.textContent = `${num}은 양수입니다.`;
// } else {
//   console.log(`${num}은 음수입니다.`);
//   resultElement.textContent = `${num}은 dma수입니다.`;
// }

// const PI = 3.14;
// console.log(PI * 20);

// const names = prompt("이름을 입력하세요.");
// const greeting = document.getElementById("greeting");

// console.log(names + "님. 안녕하세요.");
// resultElement.textContent = `${names}님 ${greeting.textContent}`;

// if (names) {
//   greeting.innerText = `${names}님 ${greeting.innerText}`;
// } else {
//   greeting.innerText = "이름을 입력하지 않으셨습니다.";
// }

const greeting = document.getElementById("greeting");

document.getElementById("submit-btn").addEventListener("click", function () {
  const names = document.getElementById("name").value;
  greeting.innerText = `${names}님 환영합니다`;
});
