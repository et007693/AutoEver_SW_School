## 0428 html

### html 기초

    h1, h2, h3 ...
    p, span
    div
    ol, ul - li
    script
    img, audio
    a(href)

### 알게된 것

    1. a tag에 target="_blank"를 설정하면 새 창에서 열림
    2. a tag에 p tag를 감싸면 inline
    3. table tag 사용하면 표 생성 가능
    4. caption tag를 사용하여 표 제목
    5. tr : table row, th : table header, td : table data
    6. border-collapse: collapse;를 사용하면 제대로 된 표의 구분선 생성
    7. rowspan 속성 사용하면 세로로 병합
    8. colspan 속성 사용하면 가로로 병합
    9. colgroup -> col tag 사용하면 각 열 속성 설정 가능

## 0429 html, css

### html - input

    form : action 지정
    radio
    fieldset : 그룹화
    textarea : 다중 입력
    select : select -> option
    button : input->button, <button>

### css

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

### 알게된 것

    1. 동적 가상 클래스 선택자 : 마우스를 올렸을 때 변화 transition, transform을 많이 사용함

## 0430 CSS

### CSS

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

### 알게된 것

    1. 가운데 정렬을 하려면, 요소가 이동할 공간이 있어야 함 -> span 같은 경우 inline 속성이기 때문에, 가운데 정렬을 하더라도, 화면 중앙으로 이동하지 않음, 따라서 p tag를 사용해주어야 함
    2. 블록, 인라인 블록은 width, height, margin, padding이 모두 적용
    3. 인라인은 width, height 적용X, padding과 margin만 좌우에 적용
    4. vscode 여러 행 선택 단축키 : ctrl + alt + 방향키
    5. vscode 아래에 행 복사 : alt + shigr + 방향키
