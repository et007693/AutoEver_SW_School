const Members = (props) => {
  const { name, age, addr, isAdult } = props;

  return (
    <>
      <h3>이름 : {name}</h3>
      <p>나이 : {age}</p>
      <p>주소 : {addr}</p>
      <p>성인여부 : {isAdult ? "true" : "false"}</p>
    </>
  );
};

export default Members;
