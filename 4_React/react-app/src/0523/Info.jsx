import { useEffect, useState } from "react";

const Info = () => {
  const [name, setName] = useState("");
  const [nickName, setNickName] = useState("");

  useEffect(() => {
    console.log("렌더링이 완료되었습니다.");
    console.log(name, nickName);
  }, [name]);
  const onChangeName = (e) => {
    setName(e.target.value);
  };
  const onChangeNickName = (e) => {
    setNickName(e.target.value);
  };
  return (
    <>
      <input value={name} onChange={onChangeName} />
      <br />
      <input value={nickName} onChange={onChangeNickName} />
      <p>이름 : {name}</p>
      <p>닉네임 : {nickName}</p>
    </>
  );
};

export default Info;
