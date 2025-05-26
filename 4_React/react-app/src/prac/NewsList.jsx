import axios from "axios";
import React, { useCallback, useEffect, useState } from "react";
import NewsItem from "./NewsItem";
import styled from "styled-components";

const NewsList = () => {
  const [data, setData] = useState(null);
  const [category, setCategory] = useState("");
  const fetchData = useCallback(async () => {
    const apiKey = import.meta.env.VITE_REACT_APP_API_KEY;
    try {
      const response = await axios.get(
        category
          ? `https://newsapi.org/v2/top-headlines?country=us&category=${category}&apiKey=${apiKey}`
          : `https://newsapi.org/v2/top-headlines?country=us&apiKey=${apiKey}`
      );
      setData(response.data);
    } catch (e) {
      console.log(e);
    }
  }, [category]);

  useEffect(() => {
    fetchData();
  }, [fetchData]);

  const NavBar = styled.nav`
    width: 100%
    display: flex;
    gap : 10px
    position: sticky;
    top: 0;
    background-color: white;
    z-index: 1000;
    padding: 12px 16px;
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
  `;

  const NavBtn = styled.button`
    background-color: gray;
  `;

  return (
    <>
      <NavBar>
        <NavBtn onClick={() => setCategory("")}>All</NavBtn>
        <NavBtn onClick={() => setCategory("general")}>general</NavBtn>
        <NavBtn onClick={() => setCategory("business")}>business</NavBtn>
        <NavBtn onClick={() => setCategory("entertainment")}>
          entertainment
        </NavBtn>
        <NavBtn onClick={() => setCategory("health")}>health</NavBtn>
        <NavBtn onClick={() => setCategory("science")}>science</NavBtn>
        <NavBtn onClick={() => setCategory("technology")}>technology</NavBtn>
      </NavBar>
      <h3>NewsList</h3>
      <NewsItem news={data} />
    </>
  );
};

export default NewsList;
