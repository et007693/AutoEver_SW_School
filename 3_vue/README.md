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
watch
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

# 0515 - Vue

## prop

```
parent
    <childComponent :{자식 변수명}="{현재 변수명}" />

child
    const prop = defineProps({
        num : Number,
        str : String,
        obj : Object,
        arr : Array
})
```

## emit

```
parent
    <childComponent @{emit-name}="{callback-function}"

    function {callback-function}() {
        ...
    }

child
    const emit = defineEmits(['{emit-name}'])

    const {함수명} = (parma) => {
        emit('{emit-name}', 전달 값)
    }
```

## 알게된 것

    1. computed 사용 이유 : 불필요한 함수의 호출을 방지, 리렌더링 시 함수 호출이 일어나지 않는 경우는 이전 값을 유지해줌
    2. 리렌더링 시 컴포넌트가 다시 호출 됨 -> 함수가 다시 재시작 됨

# 0516 - Vue

## local storage

```
값 저장
localStorage.setItem("{key}", JSON.stringify(value));


값 불러오기
    const store = localStorage.getItem("{object_name}")
    const object = ref(
        store
            ? JSON.parse(store)
            : 데이터 선언
    )
```

## 알게된 것

    1. index가 필요할 경우
        <li v-for="(example, <strong>index</strong>) for examples" :key="index">
    2. 위의 index를 받아 삭제하기 위해서 splice() 사용
        array.splice(startIdx, deleteCnt)
    3. filter는 배열을 반환, find는 객체를 반환

# 0519 - Vue

## router

```
3가지 설정해주어야 함
main.js
    import router from "./router"

    app.use(router)

router / index.js
    import { craeteRouter, createWebHistory } from "vue-router"

    const router = createRouter({
        history : createWebHistory(""),
        routes: [
            {
                path: "/",
                name: "{name}",
                component: () => import("../components/{c_name}"),
                children : [
                    {path : "/{path1}", component : {C_name1}},
                    {path : "/{path2}", component : {C_name2}},
                ]
            }
        ]
    })

App.vue
    <router-link to="/{name}"
    <router-view></router-view>

    or

    import { useRouter } from 'vue-router';

    const router = useRouter();
    function goToHome() {
        router.push('/home');
    }

```

## tailwind

```
tailwind 세팅
    yarn create vite vite-tailwind-app --template vue
    cd vite-tailwind-app
    yarn install

    yarn add -D tailwindcss@3 postcss autoprefixer
    npx tailwindcss init -p

postcss.config.js
    module.exports = {
    plugins: {
        tailwindcss: {},
        autoprefixer: {},
    },
    }

src/assets/tailwind.css
    @tailwind base;
    @tailwind components;
    @tailwind utilities;

main.js
    import './assets/tailwind.css'

tailwind.config.js
    module.exports = {
    content: [
        "./index.html",
        "./src/**/*.{vue,js,ts,jsx,tsx}"
    ],
    theme: {
        extend: {},
    },
    plugins: [],
    }

```

# 0520 - Vue

## pinia

```
설치
yarn add pinia
yarn add pinia-plugin-persistedstate


store / {store.js}
    import { defineStore } from 'pinia';
    export const useState = defineStore("{name}", {
        state: () => ({
            value1 : "{defaultValue}",
            value2 : "",
        }),
        actions: {
            func1({param}) : {
                this.value2 = param
            }
        }
    })

.vue
    import { useState } from '@/stores/{storeName}'
    const {name} = useState();

    <div @click="name.func1"></div>
```

## modal

```
stores / modal.js
    import { defineStore } from "pinia";
    export const { statename } = defineStore("{name}", {
        state: () => ({
            "속성1" : value1,
            "속성2" : value2,
            "속성3" : []
        }),
        actions: {
            callback1({ param1, param2, array }) {
                this.속성1 = param1;
                this.array = array
            }
        }
    })

components / modal.vue
    <div v-if="modal.isOpen" class="background">
        <div class="modal">

        </div>
    </div>

    import { useModalState } from "@/stores/Modal.js"
    const modal = useModalState();

App.vue에 Component 등록 필요
```

## 알게된 것

1. modal은 전역 변수룰 통해 open, close, 버튼 갯수 등을 설정
2. modal의 경우, 항상 존재해야 하므로 app에 등록이 필요함
3. button 갯수를 설정하고 싶다면 버튼 array를 전달하고, v-for를 사용해서, 전달된 갯수만큼 버튼 생성
4. array에 함수도 전달 가능 ex) [{ onClick: () => {} }]
5. 여러개를 전달할 때는 onClick: () => {
   func1;
   func2;
   }
6. 이미 track 된 파일은 git add -u
