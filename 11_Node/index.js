const express = require("express");
const app = express();
const port = 3000;

app.use(express.json());

// Sequelize ORM 연결
const { Sequelize } = require("sequelize");
const MemberModel = require("./models/member");

const sequelize = new Sequelize("node_memberdb", "root", "1234", {
  host: "localhost",
  dialect: "mysql",
});

const Member = MemberModel(sequelize, Sequelize.DataTypes);
sequelize
  .sync({ force: false })
  .then(() => console.log("DB 연결 및 테이블 동기화 완료!"))
  .catch((err) => console.error("❌ DB 연결 실패:", err));

// let members = [
//   {
//     id: 1,
//     name: "안유진",
//     email: "yujin@ive.com",
//     password: "1234",
//     address: "서울시 강남구",
//   },
//   {
//     id: 2,
//     name: "장원영",
//     email: "wonyoung@ive.com",
//     password: "abcd",
//     address: "서울시 서초구",
//   },
// ];

app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});

app.get("/", (req, res) => {
  res.send("안녕하세요. 여기는 nod+express 홈입니다.");
});

// 전체 조회
app.get("/members", async (req, res) => {
  const members = await Member.findAll();
  res.json(members);
});

// 단건 조회
app.get("/members/:id", (req, res) => {
  const member = members.find((m) => m.id === parseInt(req.params.id));
  if (!member) return res.status(404).json({ error: "Not found error" });
  res.json(member);
});

// 회원 등록, post
app.post("/members", (req, res) => {
  const { name, email, pwd, address } = req.body;
  const newMember = {
    id: members.length + 1,
    name,
    email,
    pwd,
    address,
  };
  //   members.push(newMember); // 파괴적 메소드
  members = [...members, newMember]; // 불변성 원칙 유지, 새 배열로 할당
  res.status(201).json(newMember);
});
