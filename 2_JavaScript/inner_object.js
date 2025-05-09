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
