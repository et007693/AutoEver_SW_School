# 05023 React

## React 세팅

```
npm create vite@latest {appname} --template react
```

## React vs Vue

```
Life Cycle

생성(mount) - useEfect
갱신(rendering) - useState, useReduce : watch
소멸(unmount) -

성능

computed : 값이 바뀌었을때만 재실행 - useMemo, useCallback
react - hook, vue - composition api

상태관리

ref, reactive
useRef
```

## React 문법

```
props
<component value1="String" value2={integer}

조건부 렌더링
(condition && (
    <div>
        {content}
    </div>
))

{name === "리액트" && <h1>리액트 입니다.</h1>}

인라인 스타일링
리액트에서 DOM요소에 스타일을 적용할 때는 문자열 형태로 넣는 것이 아니라 객체 형태로 넣어 주어야 합니다.
<div style={display:flex}></div>

```

## 생명주기

```
마운트 : DOM이 생성되고 웹 브라우저 상에 나타나는 것
업데이트
    - props가 바뀔 때
    - state가 바뀔 때
    - 부모 컴포넌트가 리렌더링될 때
    - this.forceUpdate로 강제 렌더링할 때
언마운트 : 컴포넌트를 DOM에서 제거하는 것
```

## 컴포넌트 반복

```
map 1
    const numbers = [1, 2, 3, 4, 5];
    const listItems = numbers.map((number) => <li>{number}</li>);
    return (
            <ul>{listItems}</ul>
        );

```

## Hook

```
useState - 상태관리
    const [{변수명}, set{변수명}] = useState()
    const onChange = (e) => set{변수명}({e})

useEffect - 생명주기 메소드

    useEffect에 빈 배열을 넣어주면 mount 될 때 한번만 실행
    useEffect(() => {

    }, [])

    배열에 특정 변수를 전달하면, 상태가 변경될때마다 실행
    useEffect(() => {
        console.log(name);
    }, [name]);

useMemo

useReducer

useCallback

useRef
```

# 0526 - React

## 컴포넌트 성능 최적화

|                        |        State         |     생명주기     |       성능관련       |  etc   |   Router   | 비동기 |
| :--------------------: | :------------------: | :--------------: | :------------------: | :----: | :--------: | :----: |
|  <Strong>Vue</Strong>  |    ref, reactive     | onMounted, watch |       computed       |   X    | vue-router | Axios  |
| <Strong>React</Strong> | useState, useReducer |    useEffect     | useMemo, useCallback | useRef |   outlet   | Axios  |

```

useCallback
    React에서는 컴포넌트가 렌더링될 때마다 함수가 다시 생성됨 -> 성능에 영향
    usecallback을 사용하면 함수가 불필요하게 재정의되는 것을 방지
    useEffect에 의존성 배열이 있다면 계속실행됨 -> usecallback을 사용하면, 값이 변경될 때만 새롭게 함수를 실행함

React.memo
    컴포넌트가 같은 props로 렌더링될 때, 불필요한 리렌더링을 방지해주는 컴포넌트
    React.memo(component)로 감싸서 사용

```

## Ref

useRef는 React Hook 중 하나로, 함수형 컴포넌트에서도 DOM 노드나 클래스 컴포넌트에서의 인스턴스 변수를 사용할 수 있게 해줍니다.

1. 포커스를 설정해야 하는 경우
2. 컴포넌트의 크기나 위치를 가져와야 하는 경우
3. 컴포넌트 인스턴스에 직접 접근해야 하는 경우
4. 자식 컴포넌트에 접근해야 하는 경우
5. 애니메이션을 제어해야 하는 경우
6. 렌더링을 바로 해야 할 때

let은 새로 렌더링 될 때마다 값이 초기화 됨됨

## style component

yarn add styled-components

```
import styled, { css } from 'styled-components';

const Box = styled.div`
    /* props로 넣어 준 값을 직접 전달해 줄 수 있습니다. */
    background: ${props => props.color || 'blue'};
    padding: 1rem;
    display: flex;
    width: 1024px;
    margin: 0 auto;
    @media (max-width: 1024px) {
        width: 768px;
    }
    @media (max-width: 768px) {
        width: 90%;
    }
`;

const Button = styled.button`
    background: white;
    color: black;
    border-radius: 4px;
    padding: .5rem;
    box-sizing: border-box;
    font-size: 1rem;
    font-weight: 600;
    &:hover {
        background: rgba(255,255,255,0.5);
    }
    ${(props => props.inverted && css`
        background: none;
        border: 2px solid white;
        color: white;
        &:hover {
            background: white;
            color: black;
        }
    `)};
    & + button {
        margin-left : 1rem;
    }
`;

const StyledComponent = () => {
    return(
        <Box color="orangered">
            <Button>안녕하세요.</Button>
            <Button inverted={true}>테두리만</Button>
        </Box>
    );
};
```

## router

```
yarn add react-router-dom

App.jsx
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/articles/:id" element={<Article />} />
        </Routes>
      </Router>

Component.jsx
    <Link to="/"><Link>
```

## 알게된 것

1. let은 렌더링 될 때마다 초기화 됨, 따라서 값을 유지하고 싶으면 ref 사용
2. React env는 REACT*APP*으로 시작해야 함
3. vite는 VITE\_ 접두사를 붙이고, import.meta.env.{value}
4. 뒤로가기를 했을 때 링크가 사라진다면, Link를 사용해서 새 창을 열거나, local storage에 저장
5. 의존성 배열에 값을 할당하고, 버튼에 따라 값을 바꿀 때는 onClick={() => setName("{name}")} 과 같이 콜백 함수로 감싸야 함
