# 0428 html

## html 기초

```
h1, h2, h3 ...
p, span
div
ol, ul - li
script
img, audio
a(href)
```

## 알게된 것

1. a tag에 target="\_blank"를 설정하면 새 창에서 열림
2. a tag에 p tag를 감싸면 inline
3. table tag 사용하면 표 생성 가능
4. caption tag를 사용하여 표 제목
5. tr : table row, th : table header, td : table data
6. border-collapse: collapse;를 사용하면 제대로 된 표의 구분선 생성
7. rowspan 속성 사용하면 세로로 병합
8. colspan 속성 사용하면 가로로 병합
9. colgroup -> col tag 사용하면 각 열 속성 설정 가능

# 0429 html, css

## html - input

```
form : action 지정
radio
fieldset : 그룹화
textarea : 다중 입력
select : select -> option
button : input->button, <button>
```

## css

```
css 적용 종류 : inline 스타일(tag style 속성), 내부 스타일(head style 태그), 외부 스타일(.css파일, head link[href])

전체 선택자 : *
태그 선택자 : div, body ...
클래스 선택자 : .class_name
id 선택자 : #id_name
속성 선택자 : tag[속성]

집합 선택자 : tag 여러개
직계 자식 선택자 : a > b
인접 자식 선택자 : a + b
모든 자식 선택자 : a ~ b
가상 요소 선택자 - 실제로 존재하지 않는 부분에 스타일 적용(before, after): a::b
가상 클래스 선택자(link, visited...) - a:b
동적 가상 클래스 선택자(active, hover...) : a:b
입력 요소 가상 클래스 선택자(focus, checked, disabled, enabled) : a:b
구조적 가상 클래스 연산자 - 요소의 위치 : a:(n-child)

% : 부모 요소 속성값 대비 크기
em : 부모 요소의 텍스트 대비 크기
rem : html 요소의 텍스트 대비 크기
vw, vh : 뷰포트 대비 크기

color : keyword(red), rgb(rgb(255, 0, 0)), HEX(#f00, #00ff04)
```

## 알게된 것

1. 동적 가상 클래스 선택자 : 마우스를 올렸을 때 변화 transition, transform을 많이 사용함
2. nth-child(2n), nth-child(2n-1) : 짝수, 홀수번째 항목

# 0430 CSS

## CSS

```
letter-spacing : 자간
line-height : 줄 간격

box model - margin, border, padding
    1개 - 모든 방향
    2개 - 상하, 좌우
    3개 이상 - 시계 방향(상, 우, 하, 좌)

box-sizing : content-box, border-box(크기에 padding, border 포함)

블록 : 요소의 너비가 가로 전체를 차지하는 것(hn, p, div)
인라인 : 요소의 너비가 컨텐츠 크기(a, span)

position - static, relative, absolute, fixed, sticky
    - static : 기본값, 문서의 흐름에 따라 배치
    - relative : 자신의 원래 위치가 기준
    - absolute : 가장 가까운 위치 지정 부모 요소 기준
    - fixed : 뷰포트 기준
    - sticky : 스크롤시 특정 위치에 고정
```

## 알게된 것

1. 가운데 정렬을 하려면, 요소가 이동할 공간이 있어야 함 -> span 같은 경우 inline 속성이기 때문에, 가운데 정렬을 하더라도, 화면 중앙으로 이동하지 않음, 따라서 p tag를 사용해주어야 함
2. 블록, 인라인 블록은 width, height, margin, padding이 모두 적용
3. 인라인은 width, height 적용X, padding과 margin만 좌우에 적용
4. vscode 여러 행 선택 단축키 : ctrl + alt + 방향키
5. vscode 아래에 행 복사 : alt + shigr + 방향키

# 0502 CSS - flex

## flex

```
flex-direction(아이템 방향)
    - row(오 -> 왼)
    - row-reverse(왼 -> 오)
    - columns(위 -> 아래)
    - column-reverse(아래 -> 위)

flex-wrap(요소가 부모 요소보다 크기가 클 때)
    - nowrap(한 줄에 모든 아이템, 넘치면 줄거나 잘림)
    - wrap(여러 줄로 자동 줄바꿈)
    - wrap-reverse(줄바꿈을 하되, 아래에서 위로 감쌈)

flex-grow : 크기에 맞게 자동으로 꽉 채움

justify-content(주축 정렬)
    - flex-start(시작점 정렬)
    - flex-end(끝점 정렬)
    - center(가운데 정렬)
    - space-between(사이 간격 균등, 끝에 붙음)
    - space-around(아이템마다 좌우 여백)
    - space-evenly(모든 간격 균등)

align-items(교차축 정렬)
    - stretch
    - flex-start
    - flex-end
    - center
    - baseline
```

## CSS 전환

```
transition
    - transition-property : 변경할 값 ex) background-color, color, width...
    - transition-duration : 몇 초 동안 변경할 것인지, 반드시 property와 duration을 함께 사용 해야 함
    - transition-delay : 몇 초 후에 전환을 시작할 것인지
    - transition-timing-functdion : 전환 진행 방식(linear : 일정, ease : 빨라지다가 점점 느려짐, ease-in : 점점 빨라짐, ease-out : 점점 느려짐, cubic-bezier(p1, p2, p3, p4) : 사용자 정의)
    - transition : <property>, <duration>, <timing-function>, <delay>
    - transition: width, 1s, ease-in, 1s 한 번에 지정이 가능;

transform
    - translate(x,y) : 위치 이동
    - scale(n) : n배 확대
    - skew('n'deg, 'n'deg) : 기울이기
    - rotate('n'deg) : 회전하기기

animation
    @keyframe name1 {
        from {
            /* 요소의 초기 상태 */
        }
        to {
            /* 요소의 최종 상태 */
        }
    }

    @keframe name2 {
        0% {
            /* 요소의 초기 상태 */
        }
        50% {
            /* 요소의 중간 상태 */
        }
        100% {
            /* 요소의 최종 상태 */
        }
    }

    .animation {
        animation-name : name1 <- 애니메이션 지정
        animation-duration : <시간>
        animation-iteration-count : <횟수> *infinite는 무한 반복
    }
```

## 알게된 것

    1. 주축 정렬은 justify-content, 교차 축 정렬은 align-items
    2. 부모 크기에 맞게 꽉 채우고 싶다면 flex-grow 사용, 위치만 균듷하게 싶다면 justify-content : space-around
    3. CSS 계산식 작성은 calc() 사용 ex) height: calc(120vh - 120px)
    4. transition 두 가지 적용하려면 쉼표 사용 ex)  transition: background-color 0.3s ease, transform 0.5s ease-in-out;

# 0507 CSS - grid

## Grid

'''
display : grid
grid-template-columns : 한 영역당 갯수 및 너비 지정
grid-template-rows : 한 영역당 갯수 및 너비 지정
grid-template-areas : 영역 지정 -> grid-area를 통해 할당
'''

## media query

## 알게된 것

    1. repeat을 사용해서 한 줄에 몇 개를 배치할 수 있을지 결정
    2. auto-fit을 사용하면 한 칸을 지정한 크기로 채움, minmax를 사용해서 최대/최소 설정 가능
    3. 영역을 지정하지 않을 때 .으로 대체
    4. video tag 아래 source로 넣어주면 자동재생 가능
    <!-- 5. 자식 요소의 %를 사용하려면 부모 요소의 높이 지정 해주어야 함 -->
