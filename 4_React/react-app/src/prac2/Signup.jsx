import React, { useContext, useState } from "react";
import { PracContext } from "../store/pracStore";
import { useNavigate } from "react-router-dom";

const Signup = () => {
  const { members, setMembers } = useContext(PracContext);
  const [isModal, setisModal] = useState(false);
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: "",
  });
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setisModal(true);
  };

  const clickModal = () => {
    const Member = {
      name: formData.name,
      email: formData.email,
      password: formData.password,
    };
    setMembers([...members, Member]);
    setisModal(false);
    navigate("/");
  };

  return (
    <div style={styles.container}>
      <form onSubmit={handleSubmit} style={styles.form}>
        <input
          type="text"
          name="name"
          placeholder="이름을 입력해주세요."
          value={formData.name}
          onChange={handleChange}
          style={styles.input}
          required
        />
        <input
          type="email"
          name="email"
          placeholder="이메일"
          value={formData.email}
          onChange={handleChange}
          style={styles.input}
          required
        />
        <input
          type="password"
          name="password"
          placeholder="비밀번호"
          value={formData.password}
          onChange={handleChange}
          style={styles.input}
          required
        />
        <button type="submit" style={styles.button}>
          회원가입
        </button>
      </form>

      {isModal && (
        <div style={styles.modalOverlay}>
          <div style={styles.modalContent}>
            <p>✅ 회원가입이 완료되었습니다!</p>
            <button onClick={() => clickModal()} style={styles.closeButton}>
              확인
            </button>
          </div>
        </div>
      )}
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
    backgroundColor: "#4CAF50",
    color: "white",
    border: "none",
    cursor: "pointer",
  },
};

export default Signup;
