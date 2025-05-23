import { useState } from "react";

const Say = () => {
  // 값을 읽는 변수, 값을 변경하는 함수(렌더링 발생)
  const [message, setMessage] = useState("");
  const onClickEnter = () => setMessage("안녕하세요!!");
  const onClickLeave = () => setMessage("안녕히 가세요!!");
  const [val, setColor] = useState("black");
  return (
    <div>
      <button onClick={onClickEnter}>입장</button>
      <button onClick={onClickLeave}>퇴장</button>
      <h1 style={{ color: val }}>{message}</h1>
      <button stytle={{ color: "red" }} onClick={() => setColor("red")}>
        빨강
      </button>
      <button stytle={{ color: "green" }} onClick={() => setColor("green")}>
        초록
      </button>
      <button stytle={{ color: "blue" }} onClick={() => setColor("blue")}>
        파랑
      </button>
    </div>
  );
};
export default Say;
