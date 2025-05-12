// test : 문자열 패턴이 있는지 검사하고, Bool값으로 반환
const regExp = /World/;
console.log(regExp.test("Hello World"));

// exec : 문자열에서 패턴과 일치하는 첫 번째 결과를 반환
const result = /가장+/.exec("가장 큰 실수는 포기입니다");
console.log(result); // ["가장"]

// match : 문자열에서 패턴과 일치하는 모든 결과를 배열로 반환
const phone = "010-5006-4146 010-5006-4146 002789433333";
const regNumber = phone.match(/\d{3}-\d{4}-\d{4}/g);
console.log(regNumber); // "010-5006-4146"

// 웹사이트 주소 찾기
const regex = /https?:\/\/[\w\-\.]+/g;

const urls = "https://naver.com https://www.google.com asdkfljasdf";
console.log(urls.match(regex));

// 이메일 주소 검사
const regex_email = /^([a-z]+\d*)+(\.?\w+)+@\w+(\.\w{2,3})+$/;
console.log(regex_email.test("example@gmail.co.kr"));
