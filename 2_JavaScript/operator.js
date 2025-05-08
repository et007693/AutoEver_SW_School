// 연산자 : 수학적인 계산을 위해 사용되거나, 참과 거짓을 판별할 때 사용
// 증감연산자
// 비교연산자
// 논리연산자
// 3항연산자
// 비트연산자
// 전개연산자

// 산술연산자 : +, -, *, /, %, **
let a = 10;
let b = 4;
console.log(a + b);
console.log(a - b);
console.log(a * b);
console.log(a / b);
console.log(parseInt(a / b)); // 몫
console.log(Math.floor(a / b)); // 소숫점 이하를 삭제
console.log(a % b);
console.log(a ** 3);

// 증감연산자
console.log(a);
console.log(++a);
console.log(a++);
console.log(a);

// 대입연산자 : =, +=, -=. *=, /=, %=, **=
let c = 0;
console.log((c += 2));
console.log((c -= 2));
console.log((c *= 2));
console.log((c /= 2));
console.log((c %= 2));

// 비교연산자 : == (값이 같은지 판단), === (동등 비교 연산자, 값과 타입까지 비교)
console.log(100 == "100");
console.log(100 === "100");

// 3항 연산자 : 참과 거짓을 구분하는 조건 연산자
const age = 18;
console.log(`당신은 ${age >= 19 ? "성인" : "미성년자"}`);

// 형변환 : 정해진 타입을 다른 타입으로 변경하는 것(묵시적, 명시적)
console.log(100 + 3.14);
console.log(10 + 10 + "10");
console.log(100 + Number("3.14"));

// 윤년 계산하기
// 1. 연도가 4로 나누어 떨어짐
// 2. 100으로 나누어 떨어지면 윤년이 아님
// 3. 400으로 나누어지면 윤년

// const prompt = require("prompt-sync")();
// let num = parseInt(prompt("연도 입력 : "));
let num = 4;

if (num % 400 === 0) {
  console.log("윤년입니다.");
} else if (num % 100 === 0) {
  console.log("윤년이 아닙니다.");
} else if (num % 4 === 0) {
  console.log("윤년입니다.");
} else {
  console.log("윤년이 아닙니다.");
}

const prompt = require("prompt-sync")();
// const num2 = prompt("주민번호 입력 : ");

const num2 = "970919-1234567";
var s = "";
const birth = num2.slice(0, 6);
var birth_year = parseInt(birth.slice(0, 2));
const year = new Date().getFullYear();

if ((num2[7] == 1) | (num2[7] == 3)) {
  s = "남성";
} else {
  s = "여성";
}

if ((num2[7] == 1) | (num2[7] == 2)) {
  birth_year += 1900;
} else {
  birth_year += 2000;
}

const age2 = year - birth_year;
console.log(`성별 : ${s}, 나이 : ${age2}, 생년월일 : ${birth}`);
