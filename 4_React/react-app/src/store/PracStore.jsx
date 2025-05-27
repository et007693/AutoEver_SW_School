import React, { createContext, useEffect } from "react";
import { useState } from "react";
export const PracContext = createContext(null);

const PracStore = (props) => {
  const [members, setMembers] = useState(() => {
    const stored = localStorage.getItem("members");
    return stored ? JSON.parse(stored) : [];
  });

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [pwd, setPwd] = useState("");

  useEffect(() => {
    localStorage.setItem("members", JSON.stringify(members));
  });

  return (
    <PracContext.Provider
      value={{
        members,
        setMembers,
        name,
        setName,
        email,
        setEmail,
        pwd,
        setPwd,
      }}
    >
      {props.children}
    </PracContext.Provider>
  );
};

export default PracStore;
