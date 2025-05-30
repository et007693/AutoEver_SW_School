# 0508 JavaScript

## JavaScript 기초

```
인터프리터 기반의 스크립트 언어
인터프리터 : 코드를 한 줄씩 실행하는 프로그램 <-> 컴파일러
호이스팅 : 변수를 먼저 생성해도 오류 발생X
```

## JavaScript 문법

```
템플릿 문자열 : `${변수명}`
데이터 타입
    원시 타입(값으로 저장)
        String
        Number
        Boolean
        undefined
        null
    참조 타입(주소로 저장)
        Object
        Array - 자바와 달리 모든 자료형 가능
        Function

연산자
    산술 연산자 : +, -, *, /, %, **
    증감 연산자(전위, 후위) : ++, --
    대입 연산자 : =, +=, -=. *=, /=, %=, **=
    비교 연산자 : == (값이 같은지 판단), === (동등 비교 연산자, 값과 타입까지 비교), !=, !==
    3항 연산자(묵시적, 명시적) : 참과 거짓을 구분하는 조건 연산자
    논리 연산자 : &&, ||. !
    삼항 연산자 : x ? y : z
    형변환 : 정해진 타입을 다른 타입으로 변경하는 것
```

# 0509 JavaScript

## 조건문

```
1. if : 조건이 참일 때 코드 실행
    if (조건1) {
        실행 코드
    } else if (조건2) {
        실행 코드
    } else {
        실행 코드
    }

2. switch : 하나의 표현식을 여러 값과 비교하여 실행
    switch(값) {
        case 값1:
            값 1과 일치할 때 실행
        case 값2:
            값 2와 일치할 때 실행
        default:
            모든 경우에 해당되지 않을 때 실행
    }
```

## 반복문

```
1. for : 반복 횟수를 알 때
    for (let i = 0; i < 10; i++) {
        실행 코드
    }

2. for ..in : 객체의 모든 키 반복
    let array = {key1 : value1, key2 : value2, key3 : value3}
    for (let key in array) {
        실행 코드
    }

3. for ..of : 배열 객체의 요소 순회
    let array = {value1, value2, value3}
    for let(value of array) {
        실행 코드
    }

4. while : 조건이 참일 동안 코드 반복
    while (조건식) {
        실행 코드
    }

5. do..while : 코드를 한 번 실행 후 조건 검사
    do {
        우선 실행할 코드
    } while {
        조건 검사 후 실행할 코드
    }
```

## 함수

```
함수 작성 방식
    1. 함수 표현식
        function name(param) {
            return param
        }

    2. 화살표 함수
        const name = (a, b) => {
            return a/b
        }

    3. 즉시 실행 함수
        (function() {
            즉시 실행 코드
        })

매개변수 : 함수 파라미터 값
인수 : 함수 호출 시 전달하는 값

콜백 함수 : 함수의 인자로 다른 함수를 전달 그 함수가 실행될 때 같이 실행되는 함수
```

## 객체

```
객체 : 원시타입을 제외한 모든 값
let obj = {
    p1 : v1,
    p2 : {
        pp1 : vv1,
    }
    m1 : fucntion1() {
        ...
    }
}

생성자
function obj(v1, v2) {
    this.v1 = v1;
    this.v2 = v2;
    this.func1 = function() {
        ...
    }
}

let obj1 = new obj("new", 1)

내장 객체(내장 함수)
    문자
        length : 문자열 길이 확인
        includes("s"), string.indexOf("s") : 특정 문자 포함 여부 확인
        slice(start, end) : 시작 위치와 종료 위치만큼
        substring(start, end) : slice와 동일하지만 파라미터로 음수 X
        replace("target", "replace") : target을 replace로 변경
        concat("string1", "string2") : 2개 이상의 문자열을 하나의 문자열로 합침
        charAt(num) : 특정 인덱스의 문자 하나를 반환
        split("-") : 특정 값을 기준으로 문자열 분할할
    배열
        forEach() : 배열 순회
            const arr = [v1, v2, v3]
            arr.forEach(e => {
                ...
            })
        filter() : 특정 조건을 만족하는 요소를 새로운 배열로 반환환
            let ex = exs.filter(ex -> ex.value >= num)
        map() : 수식 적용
            const nums = [1, 2, 3]
            const arr = nums.map(function (num) {
                return num * num
            })

```

## 알게된 것

    1. for ..of로 값을 바꿀 때, 원본 데이터는 바뀌지 않음
    2. 코드가 한줄일 때 {} 사용 안 해도 됨 ex) break, function()

# 0512 JavaScript

## DOM(Document Object Model)

```
노드 선택
    document.getElementById : ID로 선택
    document.getElementsByClassName : class로 선택
    document.getElementsByTagName : tag로 선택
    documnet.querySelector : CSS 선택자

노드 조작
    textContent
    innerText
    innerHTML

    element.style.{css속성] = 변경값
    element.classList.add : 속성 추가
    element.classList.remove : 속성 삭제
    element.classList.toggle
    child.remove : 노드 삭제

    element.addEventListener("{동작}", {Callback})
```

## event

```
이벤트 종류
    onclick : 클릭
    ondblclick : 더블클릭
    onmouseover : hover
    onmouseset : 마우스 빠져나갈 때
    onmousemove : 포인터가 움직일 때
    onwhell : 휠을 움직일 때
    onkeypress : 키보드를 누르고 있는동안
    onkeydown : 키보드를 누른 순간
    onkeyon : 눌렀다가 뗀 순간
    onfocus : hover
    onblur : 포커스를 잃을 때
    onsubmit : 폼이 전송될 때
    onload : 리소스 로드가 끝날 때

이벤트 등록
    1. 인라인 방식
    <button onclick="{함수명}"></button>
    function 함수명() {
        ...
    }

    2. 리스너 방식
    const btn = document.querySelector("button")
    btn.onclick = () => {
        ...
    }

    3. 이벤트 등록 베서드 방식
    const btn = document.querySelector("button")
    btn.addEventListener("click", function() {
        ...
    })
```

## 정규표현식

```
사용법
    var {name} = /sss/;

메소드
    test : 문자열에 패턴이 있는지 검사하고, Bool 값으로 반환
    exec : 패턴이 일치하는 첫 번째 결과를 반환, 없으면 null
    match : 패턴이 일치하는 모든 결과를 배열로 반환

패턴 예시
    g는 문자열 전체에서 모든 일치 항목을 찾도록 설정
    ^는 부정 문자 클래스(not)
    1. 숫자 찾기 : /[0-9]/
    2. 알파벳 찾기 : /[a-zA-Z]/g
    3. 숫자가 아닌 것 찾기 : /^[0-9]/g
    4. 전화번호 형식 검사 : /\d{2,3}-\d{3,4}-\d{4}/
```

## 알게된 것

1. const 객체의 값을 바꿀 수 있는 이유 : const는 주소만 변경이 불가능한 것이므로, 값은 변경 가능
2. 요소 생성은 documnet.createElement, 요소 삭제는 element.delete()
3. input에서 text를 가져오려면 input.value

# 0513 - JavaScript

## JSON

```
직렬화
    const json = JSON.stringify(object)

역직렬화
    const object = JSON.parse(json)
```

## 알게된 것
