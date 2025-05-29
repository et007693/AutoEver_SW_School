# 0528 - JAVA

## JAVA

```
변수와 자료형
    변수 : 메모리 공간에 이름을 붙인 것, 자바에서는 JVM이 메모리 할당을 담당
자료형
    boolean
    byte(8byte), short(16byte), int(32byte), long(64byte)
    floatm double
    char, String
상수 : 프로그램이 실행되는 동안 메모리에 저장된 데이터를 변경할 수 없음, final 키워드를 사용하여 선언

입출력
    System.out.print~
    Scanner sc = new Scanner;

연산자
    산술 : +, -, *, /, %,
    대입 : =, +=, -=, *=, /=, %=
    증감 : ++, —
    비교 : ==, ≠, <, >, ≥, ≤, instanceof
    논리 : !, &, |, &&, ||
    비트 : AND, OR, XOR, NOT, <<, >>
    삼항  : (조건식)?A:B

조건문
    if ~ else
    if ~ else if ~ else
    switch ~ case ~ default

반복문
    while
    do ~ while
    for
배열
    {type}[] {name} = new {type}[length]
    arr.length

    {type}[][] {name} = new{type}[][]
    for({type} i : arr) {

    }
문자열
    String.equals("{value}") : 특정 문자가 시작하는 인덱스(number)
    String.indexOf("{String}") : 특정 문자가 시작되는 인덱스(number)
    String.contains("{String}") : 특정 문자열 포함 여부(boolean)
    String.carAt({number}) : 특정 위치의 문자(char)
    String.replace(target, value) : 문자열 변경
    String.substring(number) : 문자열 중 특정 부분을 뽑아냄
    String.split("{String}") : 문자열을 특정 구분자로 분리하여 배열 생성
    문자열을 문자 배열로 변경
    {type}[] {name} = {variable}.toCharArray();

```

## 알게된 것

1. 문자와 문자열이 구분됨, 문자는 '', 문자열은 ""
2. 변경 불가능한 값은 final, 캡슐화는 private

# 0529

## 객체지향 프로그래밍

```
클래스 : 필드와 메서드를 정의
객체 : 클래스를 기반으로 실제 할당된 인스턴스
4가지 특징
    - 캡슐화 : 데이터와 메소드를 하나로 묶고, 정보은닉
    - 상속 : 기존 클래스를 확장해 새로운 클래스를 작성
    - 다형성 : 동일한 메서드가 다양한 방식으로 동작하는 것, 메소드 오버라이딩
    - 추상화 : 복잡한 내부는 숨기고 필요한 정보만 노출. 인터페이스나 추상화 클래스 활용
인스턴스 : 클래스를 기반으로 생성된 실제 객체, 데이터에 load된 상태
메소드 : 클래스가 가진 기능

```

## 접근 제한자

```
다른 패키지나 클래스에서 접근을 제한하는 용도로 사용
    public : 어디서나 접근 가능
    protected : 자식 클래스가 아닌 다른 패키지에 소속된 클래스에서 사용 불가
    derault : 다른 패키지에 소속된 클래스에서 사용불가
    private : 모든 외부 클래스에서 사용 불가
```

## 알게된 것

1. 상속 받으려면 생성자가 필요함, 자식 클래스에서 super 생성을 하거나 부모 클래스에 생성자를 넣어주면 됨
2. super를 사용하면 부모 클래스의 생성자나 메소드에 접근 가능
