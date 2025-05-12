// 내장 객체

// 특정 문자열 포함 여부 확인
const email = "jks2024@gmail.com";
if (!email.includes("@")) {
  console.log("올바른 이메일 형식이 아닙니다.");
}
if (email.indexOf("@") == -1) {
  console.log("올바른 이메일 형식이 아닙니다.");
}

console.log(email.indexOf("@"));

// 슬라이싱
const fruits = "Apple, Banana, Kiwi";
const subStr1 = fruits.slice(0, 2);
const subStr2 = fruits.substring(0, -2);
console.log(subStr1);
console.log(subStr2);

let str = "지구오락실, 이영지, 안유진, 미미, 이은지, 이은지";
let n = str.replace("이은지", "");
console.log(n);

// 문자열 결합
let text = "안녕하세요.";
text += "오늘은 ";
text += "날씨가 아주 별로에요. ";
text += "집에 가고 싶어요!!";
console.log(text);

const text1 = "안녕하세요.";
const text2 = text1.concat("오늘은 ", "날씨가 아주 별로에요.");
const text3 = text1.concat(text2, "집에 가고 싶어요!!");
console.log(text3);

// forEach : 배열의 각 요소에 대한 반복 수행
const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
numbers[1] = 100;
console.log(numbers);
numbers.forEach((num) => {
  console.log(num);
});

// map : 배열의 각 용소를변형하여 새로운 배열 생성
// const doubled = numbers.map((num) => num * 2);
const doubled = numbers.map((num) => num * 2);
console.log(doubled);

// filter : 조건에 맞는 요소만 추출하여 새로운 배열 생성
const even = numbers.filter((num) => num % 2 === 0);
console.log(even);

// reduce : 함수를 실행하여 하나의 결과값을 반환
const sum = numbers.reduce((a, b) => a + b, 0);
console.log(sum);
