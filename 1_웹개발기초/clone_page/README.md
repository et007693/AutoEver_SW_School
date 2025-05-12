## 발생 문제들

main-wrap이 header의 위에서부터 시작해야 함 (video가 왼쪽 위에 위치하기 위해)
-> main-wrap position을 absolute로 설정하면 main의 높이가 main-wrap의 위치를 인식하지 못함
-> 해결 : header를 absolute로 바꿔주었음

## 알게된 것

1. z-index를 사용하려면 position을 relative로 설정해줘야 함
2. position이 absolute이면 문서의 흐름에서 빠짐 -> 높이 계산에서 측정이 안 됨
3. position이 absolute로 바꿔서 위치 차지를 안 하는데, 높이에 포함시키고 싶다면 가짜 div를 만들어서 공간 확보하기
