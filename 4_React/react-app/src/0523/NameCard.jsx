import { useState } from "react";

const NameCard = () => {
  const [nameCards, setNameCard] = useState({
    name: "",
    position: "",
    company: "",
    addr: "",
    email: "",
    phone: "",
  });
  const [submit, setSubmit] = useState(false);
  const onChange = (key, value) => {
    setNameCard({ ...nameCards, [key]: value });
  };

  return (
    <div style={{ display: "flex", flexDirection: "column", gap: "10px" }}>
      <input
        type="text"
        value={nameCards.name}
        placeholder="이름을 입력해주세요"
        onChange={(e) => onChange("name", e.target.value)}
      />
      <input
        type="text"
        value={nameCards.position}
        placeholder="직급을 입력해주세요"
        onChange={(e) => onChange("position", e.target.value)}
      />
      <input
        type="text"
        value={nameCards.company}
        placeholder="회사를 입력해주세요"
        onChange={(e) => onChange("company", e.target.value)}
      />
      <input
        type="text"
        value={nameCards.addr}
        placeholder="주소를 입력해주세요"
        onChange={(e) => onChange("addr", e.target.value)}
      />
      <input
        type="text"
        value={nameCards.email}
        placeholder="이메일을 입력해주세요"
        onChange={(e) => onChange("email", e.target.value)}
      />
      <input
        type="text"
        value={nameCards.phone}
        placeholder="연락처를 입력해주세요"
        onChange={(e) => onChange("phone", e.target.value)}
      />
      <button onClick={() => setSubmit(true)}>제출</button>
      {submit && (
        <div>
          <h3>{nameCards.name} 인적사항</h3>
          <p>{nameCards.position}</p>
          <p>{nameCards.company}</p>
          <p>{nameCards.addr}</p>
          <p>{nameCards.email}</p>
          <p>{nameCards.phone}</p>
        </div>
      )}
    </div>
  );
};

export default NameCard;
