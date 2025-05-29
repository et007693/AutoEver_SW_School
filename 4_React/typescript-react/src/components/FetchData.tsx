import React, { useState, useEffect } from "react";
import styled from "styled-components";

interface Data {
  id: number;
  title: string;
}

const FetchDataComponent: React.FC = () => {
  const [data, setData] = useState<Data | null>(null);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true);
        const response = await fetch(
          "https://jsonplaceholder.typicode.com/todos/1"
        );
        const result: Data = await response.json();
        setData(result);
        setLoading(false);
      } catch (err) {
        setError("데이터를 불러오는데 실패 했습니다.");
        setLoading(false);
      }
    };
    fetchData();
  }, []);

  return (
    <Container>
      <Title>데이터 가져오기</Title>
      {loading && <Message>로딩 중...</Message>}
      {error && <Message>{error}</Message>}
      {data && (
        <DataContainer>
          <DataItem>ID: {data.id}</DataItem>
          <DataItem>Title: {data.title}</DataItem>
        </DataContainer>
      )}
    </Container>
  );
};

const Container = styled.div`
  text-align: center;
  margin-top: 50px;
`;

const Title = styled.h1`
  font-size: 24px;
  margin-bottom: 20px;
`;

const Message = styled.p`
  font-size: 18px;
  margin-top: 20px;
`;

const DataContainer = styled.div`
  margin-top: 20px;
`;

const DataItem = styled.p`
  font-size: 16px;
`;

export default FetchDataComponent;
