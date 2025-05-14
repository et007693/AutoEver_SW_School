# 0514 - Vue

## 프레임워크 vs 라이브러리

```
프레임워크 : 정해진 규칙 내에서 프로그래밍
라이브러리 : 기본적인 기능만 제공
```

## Vue - 템플릿 문법

```
ref : 원시 값을 감싸는 반응형 래퍼
v-if : 조건부 렌더링
v-for : 반복 렌더링
reactive : 객체나 배열을 반응형으로
    const member = reactive({
        name: "장원영",
        age: 22,
        addr: "서울시 강남구 역삼동",
        position: "센터",
    });
computed : 값 계산, 상태 변화할 때마다
    computed(() => num0.value + num1.value + num2.value);
wattch
    watch(search, (newVal, oldVal) => {
        console.log(`검색어 변경 : ${oldVal} -> ${newVal}`);
        recent.value = "검색중입니다.";
    });
ounMounted : 화면을 나타낼 때 값 받아올 때 사용

데이터 바인딩
    <h1>{{ dataName }}</h1>
클래스 바인딩
    <div :class="{ dataName:className }"></div>
조건 렌더링
    <h1>{{ 조건 ? true 값 : false 값}}</h1>
```

## 알게된 것

1. ref를 사용한 객체는 .value를 사용하여 값을 받아옴
