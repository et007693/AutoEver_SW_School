import { Link } from "react-router-dom";

export const Home = () => {
  const role = "backend";
  return (
    <>
      <h1>여기가 홈입니다.</h1>
      <p>가장 먼저 보여지는 페이지입니다.</p>
      <Link to="/about">소개페이지로 이동</Link>
      <Link to={`/profile/${role}`}></Link>
    </>
  );
};

export default Home;
