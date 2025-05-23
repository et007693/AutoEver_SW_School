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
