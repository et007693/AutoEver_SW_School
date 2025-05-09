// 객체
const person = {
  title: "지구오락실",
  name: "안유진",
  age: 23,
  job: "Singer",
};

console.log(person);

const member = {
  id: "jks2024",
  pwd: "sphb8250",
  addr: {
    home: "겅기도 수원시",
    company: "서울시 금천구 가산동",
  },
  name: "정경수",
  func1: () => {
    console.log("함수 호출입니다.");
  },
};

console.log(member.func1());

const members = [
  { id: "ive1", pwd: "1234", addr: "서울시 강남구", name: "안유진" },
  { id: "ive2", pwd: "1234", addr: "서울시 강남구", name: "장원영" },
  { id: "ive3", pwd: "1234", addr: "서울시 강남구", name: "가을" },
  { id: "ive4", pwd: "1234", addr: "서울시 강남구", name: "레이" },
  { id: "ive5", pwd: "1234", addr: "서울시 강남구", name: "리즈" },
  { id: "aespa1", pwd: "1234", addr: "서울시 강남구", name: "카리나" },
  { id: "aespa2", pwd: "1234", addr: "서울시 강남구", name: "윈터" },
  { id: "aespa3", pwd: "1234", addr: "서울시 강남구", name: "지젤" },
];

members.map((member) => {
  console.log("아이디 : " + member.id);
  console.log("비밀번호 : " + member.pwd);
  console.log("주소 : " + member.addr);
  console.log("이름 : " + member.name);
  console.log("------------------------");
});
