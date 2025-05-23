import { useEffect, useState } from "react";

const TableMap = () => {
  const fetchData = [
    { id: 100, name: "카즈하", age: 23 },
    { id: 200, name: "유나", age: 23 },
    { id: 300, name: "안유진", age: 23 },
    { id: 400, name: "장원영", age: 22 },
    { id: 500, name: "가을", age: 24 },
  ];

  const [members, setMembers] = useState();

  useEffect(() => {
    // 비동기 통신 호출 후 await로 대기
    setMembers(fetchData);
  }, []); // [] 의존성 배열, 비어있으면 마운트 시점에 호출 됨, onMounted()

  const memberSelect = (member) => {
    console.log(member);
  };
  return (
    <table>
      <tr>
        <th>ID</th>
        <th>이름</th>
        <th>나이</th>
      </tr>
      {members &&
        members.map((member) => (
          <tr key={member.id} onClick={() => memberSelect(member.name)}>
            <td>{member.id}</td>
            <td>{member.name}</td>
            <td>{member.age}</td>
          </tr>
        ))}
    </table>
  );
};

export default TableMap;
