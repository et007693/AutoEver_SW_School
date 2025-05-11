## 문제 상황

main-content 부분이 video에 가려져서 나오지 않음
-> z-index를 적용했음에도, 보이지 않음
-> position : relative를 적용하여 해결

## 알게 된 것

1. static일 때 z-index 속성이 작용하지 않음 -> relative, absolute, fixed, sticky일 때만 작동
2. 자식 요소를 부모 요소에 맞추려면 부모 요소의 position을 relative로 설정
3. 배경을 흐리게 하려면 backdrop-filter: blur(10px) 사용
4. flex 요소들의 너비를 같게 하려면 flex : 1
5. forEach의 인자 1은 각 요소, 인자 2는 index
6. class를 지웠다 없앴다는 toggle, 추가-제거는 add, remove
