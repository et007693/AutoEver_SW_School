import React, { useEffect, useRef, useState } from "react";

const RefCnt = () => {
  const cntRef = useRef(0);
  let cntTest = 0;
  const [flag, setFlag] = useState(false);

  const incrementCnt = () => {
    cntRef.current += 1;
    cntTest += 1;
    setFlag(!flag);
  };
  console.log("Ref cnt : ", cntRef.current);
  console.log("Let cnt : ", cntTest);

  useEffect(() => {
    const interval = setInterval(incrementCnt, 1000);
    return () => clearInterval(interval);
  });

  return (
    <>
      <h3>Counter 연습</h3>
      <p>콘솔에서 값 확인</p>
      <p>{cntRef.current}</p>
      <p>{cntTest}</p>
    </>
  );
};

export default RefCnt;
