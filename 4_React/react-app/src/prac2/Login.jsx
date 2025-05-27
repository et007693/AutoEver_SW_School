import React, { useContext, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { PracContext } from "../store/pracStore";

const Login = () => {
  const { members, setName, setEmail } = useContext(PracContext);
  const [InputEmail, setInputEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errorMsg, setErrorMsg] = useState("");
  const navigate = useNavigate();

  const setUser = ({ name, email }) => {
    setName(name);
    setEmail(email);
  };

  const handleSubmit = (e) => {
    console.log(members);

    e.preventDefault();
    const matchUser = members.find(
      (user) => user.email === InputEmail && user.password === password
    );

    if (matchUser) {
      setUser({ name: matchUser.name, email: matchUser.email });
      setErrorMsg("");
      navigate("/home");
    } else {
      setErrorMsg("이메일 또는 비밀번호가 일치하지 않습니다.");
    }
  };

  return (
    <div style={styles.container}>
      <h2>로그인</h2>
      <form onSubmit={handleSubmit} style={styles.form}>
        <input
          type="email"
          placeholder="이메일"
          value={InputEmail}
          onChange={(e) => setInputEmail(e.target.value)}
          style={styles.input}
          required
        />
        <input
          type="password"
          placeholder="비밀번호"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          style={styles.input}
          required
        />
        {errorMsg && <p style={styles.error}>{errorMsg}</p>}
        <button type="submit" style={styles.button}>
          로그인
        </button>
      </form>
      <Link to="/signup">회원가입</Link>
    </div>
  );
};

const styles = {
  container: {
    width: "300px",
    margin: "50px auto",
    textAlign: "center",
    fontFamily: "sans-serif",
  },
  form: {
    display: "flex",
    flexDirection: "column",
    gap: "12px",
  },
  input: {
    padding: "10px",
    fontSize: "16px",
  },
  button: {
    padding: "10px",
    fontSize: "16px",
    backgroundColor: "#2196F3",
    color: "white",
    border: "none",
    cursor: "pointer",
  },
  error: {
    color: "red",
    fontSize: "14px",
  },
};

export default Login;
