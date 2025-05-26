import React from "react";
import { Link } from "react-router-dom";
import styled, { keyframes } from "styled-components";

// 부드럽게 등장하는 애니메이션
const fadeInUp = keyframes`
  from {
    opacity: 0;
    transform: translateY(15px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
`;

const NewsList = styled.ul`
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
  gap: 24px;
  padding: 0;
  margin: 0 auto;
  max-width: 1200px;
  list-style: none;
`;

const NewsItemWrapper = styled.li`
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
  padding: 24px 28px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  animation: ${fadeInUp} 0.4s ease forwards;
  transition: transform 0.25s ease, box-shadow 0.25s ease;

  &:hover {
    transform: translateY(-6px);
    box-shadow: 0 20px 40px rgba(0, 0, 0, 0.15);
  }
`;

const Title = styled.h3`
  font-size: 1.3rem;
  color: #222;
  margin: 0 0 12px;
  font-weight: 700;
  line-height: 1.3;
`;

const Description = styled.p`
  font-size: 1rem;
  color: #555;
  flex-grow: 1;
  margin: 0 0 20px;
  line-height: 1.5;
`;

const StyledLink = styled(Link)`
  align-self: flex-start;
  background-color: #0077cc;
  color: white;
  font-weight: 600;
  padding: 10px 18px;
  border-radius: 6px;
  text-decoration: none;
  box-shadow: 0 4px 10px rgba(0, 119, 204, 0.3);
  transition: background-color 0.3s ease, box-shadow 0.3s ease;

  &:hover {
    background-color: #005fa3;
    box-shadow: 0 6px 15px rgba(0, 95, 163, 0.5);
  }
`;

const LoadingText = styled.p`
  font-size: 1.2rem;
  color: #888;
  text-align: center;
  margin-top: 60px;
`;

const NewsItem = ({ news }) => {
  return (
    <>
      {news ? (
        <NewsList>
          {news.articles.map((article, index) => (
            <NewsItemWrapper key={index}>
              <img src={article.urlToImage} alt="" />
              <Title>{article.title}</Title>
              <Description>{article.description}</Description>
              <StyledLink
                to={article.url}
                target="_blank"
                rel="noopener noreferrer"
              >
                Read more
              </StyledLink>
            </NewsItemWrapper>
          ))}
        </NewsList>
      ) : (
        <LoadingText>Loading...</LoadingText>
      )}
    </>
  );
};

export default NewsItem;
