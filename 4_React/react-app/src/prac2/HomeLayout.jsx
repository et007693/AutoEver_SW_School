import React, { useContext } from "react";
import { Outlet } from "react-router-dom";
import { PracContext } from "../store/pracStore";

const HomeLayout = () => {
  const { name, email } = useContext(PracContext);

  return (
    <div style={styles.layout}>
      <header style={styles.header}>
        <h1>My App</h1>
        <div style={styles.userInfo}>
          {name && email ? (
            <>
              <span>{name} 님</span>
              <span style={{ fontSize: "12px", marginLeft: "8px" }}>
                ({email})
              </span>
            </>
          ) : (
            <span>로그인 필요</span>
          )}
        </div>
      </header>

      <main style={styles.main}>
        <Outlet />
      </main>

      <footer style={styles.footer}>ⓒ 2025 My App. All rights reserved.</footer>
    </div>
  );
};

const styles = {
  layout: {
    position: "relative",
    display: "flex",
    flexDirection: "column",
    minHeight: "100vh",
    width: "100vw",
  },
  header: {
    position: "relative",
    backgroundColor: "#333",
    color: "white",
    padding: "16px",
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
    width: "100%",
  },
  userInfo: {
    display: "flex",
    alignItems: "center",
  },
  main: {
    flex: 1,
    padding: "20px",
  },
  footer: {
    backgroundColor: "#eee",
    textAlign: "center",
    padding: "10px",
    width: "100%",
  },
};

export default HomeLayout;
