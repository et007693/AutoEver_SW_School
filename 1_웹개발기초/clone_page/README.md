## 발생 문제들

main-wrap이 header의 위에서부터 시작해야 함 (video가 왼쪽 위에 위치하기 위해)
-> main-wrap position을 absolute로 설정하면 main의 높이가 main-wrap의 위치를 인식하지 못함
-> 해결 : header를 absolute로 바꿔주었음

main-content 부분이 video에 가려져서 나오지 않음
-> z-index를 적용했음에도, 보이지 않음
-> position : relative를 적용하여 해결

## 알게된 것

1. z-index를 사용하려면 position을 relative로 설정해줘야 함
2. position이 absolute이면 문서의 흐름에서 빠짐 -> 높이 계산에서 측정이 안 됨
3. position이 absolute로 바꿔서 위치 차지를 안 하는데, 높이에 포함시키고 싶다면 가짜 div를 만들어서 공간 확보하기

4. static일 때 z-index 속성이 작용하지 않음 -> relative, absolute, fixed, sticky일 때만 작동
5. 자식 요소를 부모 요소에 맞추려면 부모 요소의 position을 relative로 설정
6. 배경을 흐리게 하려면 backdrop-filter: blur(10px) 사용
7. flex 요소들의 너비를 같게 하려면 flex : 1
8. forEach의 인자 1은 각 요소, 인자 2는 index
9. class를 지웠다 없앴다는 toggle, 추가-제거는 add, remove
