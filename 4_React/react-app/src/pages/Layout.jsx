import { Outlet } from "react-router-dom";

const Layout = () => {
  return (
    <>
      <header style={{ background: "lightgray", padding: 16, fontSize: 24 }}>
        Header
      </header>
      <main>
        <Outlet />
      </main>
      <footer>여기는 풋터입니다.</footer>
    </>
  );
};

export default Layout;
