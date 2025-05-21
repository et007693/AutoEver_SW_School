import axios from "./axiosInstance";

export const useAuthApi = () => {
  const signup = async (email, pwd, name) => {
    return await axios.post("/auth/sighnup", { email, pwd, name });
  };
  const login = async (email, pwd) => {
    return await axios.post("/auth/login", { email, pwd, name });
  };

  const exists = async (email) => {
    return await axios.post(`/auth/exists/${email}`);
  };
  return { signup, login, exists };
};
