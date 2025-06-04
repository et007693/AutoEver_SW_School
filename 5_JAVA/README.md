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

# 0529 - JAVA

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

## 싱글톤

```
프로그램 전체에서 단 하나의 객체만 만들어야 하는 경우
클래스 간 데이터 공유가 쉬움

```

## 알게된 것

1. 상속 받으려면 생성자가 필요함, 자식 클래스에서 super 생성을 하거나 부모 클래스에 생성자를 넣어주면 됨
2. super를 사용하면 부모 클래스의 생성자나 메소드에 접근 가능

# 0530 - JAVA

## 추상클래스

```
실체 클래스의 공통적인 부분을 추출해 어느정도 규격을 잡아놓은 클래스, 공통 기능을 묶어서 제공하고, 자식 클래스에서 반드시 구현해야 할 메서드를 강제함
따라서 인스턴스를 만들 수 없음
설계에 중점을 둔 듯

```

## 인터페이스

```

```

- 추상 클래스 vs 인터페이스

| **항목**         | **추상 클래스**                                                          | **인터페이스**                                                                        |
| ---------------- | ------------------------------------------------------------------------ | ------------------------------------------------------------------------------------- |
| 키워드           | abstract class                                                           | interface                                                                             |
| 인스턴스 생성    | 불가능                                                                   | 불가능                                                                                |
| 다중 상속        | 불가능 (단일 상속만 가능)                                                | 가능                                                                                  |
| 필드             | 변수, 상수                                                               | 상수(final static)만 가능                                                             |
| 메서드 구현 여부 | 가능 (일반 메서드 허용)                                                  | Java 8부터 default, static 허용                                                       |
| 목적             | 기반 구현 제공                                                           | 표준 규격 제공                                                                        |
| 공통 기능 제공   | 공통된 필드와 메서드 구현을 **부분적으로 제공**할 수 있음                | 공통된 기능 구조(시그니처)만 정의함, **구현은 제공하지 않음** (Java 8 이후 일부 가능) |
| 기반 클래스 제공 | **기본 동작(로직)**이 필요한 경우 사용→ _“템플릿 클래스로서 역할”_       | **표준 API 명세나 기능 계약**을 정의할 때 사용→ _“역할 또는 행위의 정의”_             |
| 상속 관계 모델링 | 서로 밀접한 관계의 클래스 계층을 구성할 때 적합                          | 서로 다른 계열의 클래스에 **공통된 동작을 부여**할 때 적합                            |
| 코드 재사용성    | 부모 클래스의 코드를 **상속하여 재사용**                                 | 코드는 재사용하지 않고 **구현 강제만 부여**                                           |
| 설계 의도        | “이 클래스들은 모두 어떤 공통 구조를 가진다”는 **is-a 관계**를 표현할 때 | “이 기능을 반드시 구현해야 한다”는 **can-do 역할**을 부여할 때                        |
| 예시             | abstract class Animal → Dog, Cat 등이 상속하여 공통 동작 사용            | interface Flyable → Bird, Airplane 등 서로 다른 클래스가 ‘날 수 있다’는 역할 구현     |

# 0602 JAVA

## SOLID 설계 원칙

```
유지보수성, 확장성, 유연성을 확보하기 위한 5가지 원칙
느슨한 결합을 추구하는 데 목적이 있음

SRP(단일 책임 원칙) : 클래스는 하나의 책임만 가져야 한다
OCP(개방-폐쇄 원칙) : 확장에는 열려있고, 변경에는 닫혀야 한다
LSP(리스코프 치환 원칙) : 하위 클래스는 상위 클래스의 행위를 대체할 수 있어야 한다
ISP(인터페이스 분리 원칙) : 인터페이스는 클라이언트가 사용하는 메서드만 가져야 한다
DIP(의존 역전 원칙) : 고수준 모듈은 저수준 모듈에 의존하지 않아야 한다
```

## 다운 캐스팅

```
상위 클래스 타입으로 선언된 객체를 다시 하위 클래스 타입으로 형변환하는 것
Parent {name} = new Child();

<-> 업캐스팅 :
```

## 자바 API

```
java.lang : 기본적인 동작을 수행하는 클래스의 집합합
    Object
    System
    Class
    String
    StringBuffer, StringBuilder(멀티스레드 지원여부, Buffer가 지원)
    Math
    Byte, Short, Character, Integer...

java.util
    Arrays
    Calender
    Date
    Objects
    StringTokenizer
    Random

---------------------------------------------------------
Object
    toString : 객체 정보를 문자열로 반환
    equals : 객체가 같은지 비교
    clone : 얕은복사
    hashCode
    getClass
    wait | notify | notifyAll
    finalize

StringBuffer
    append(value) : 문자열 추가
    delete(index) : 문자열 제거
    insert(index, value) : 특정 위치에 문자열 삽입
    substring(start, end) : start - end 문자열 제거

Math
    random
    abs
    floor | ceil | round
    max | min

Enum(열거타입) : 한정된 상수 집합을 정의할 수 잇는 참조 타입(값을 제한함)
    장점
        1. 타입 안정성 : 다른 enum기리 비교불가
        2. 코드 가독성 : 의미 있는 이름으로 상수 정의
        3. 유지보수성 : 상수 추가 / 변경이 한 곳에서 관리됨
        4. 기능 확장성 : 메소드와 필드, 생성자 등 객체처럼 활용가능
    선언
        public enum {name} {
            value1, valu2, ....
        }
    사용
        {name}.value

Wrapper
    기본 타입의 데이터를 객체로 취급해야 하는 경우에 사용
    기본 타입에 해당하는 데이터를 객체로 포장해주는 클래스

    Age age = new Age();
    age.age = 100;

    class Age {
        int age;
    }

Arrays
    sort : 오름차순
    sort(arr, Collections.reverOrder()) : 내림차순
    custom 정렬
        Arrays.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p2.getPrice().compareTo(p1.getPrice()); // 역순
            }
        });
    asList : 일반 배열을 ArrayList로 변환

StringTokenizer
    = Python의 split
    countTokens : 꺼내지 않고 남아있는 토큰의 수
    hasMoreTokens : 토큰이 남아 있는지 여부
    nextToken : 토큰을 하나씩 꺼냄
```

## Generic

```
데이터의 타입을 일반화하여, 다양한 타입의 데이터를 하나의 코드로 처리할 수 있도록 하는 기능

ex) ArrayList<{type}> {name} = new ArrayList<>();

class Person <T> {
    public T info;
    Person(T info) {
        this.info = info;
    }
}

public class Main {
    public static void main(String[] args) {
        Person<String> p1 = new Person<>("고유림");
        Person<Integer> p2 = new Person<>(1000);
        System.out.println(p1.info);
        System.out.println(p2.info);
    }
}
```

## 컬렉션 프레임워크

```
List : 인덱스, 순서유지, 중복허용
Set : 순서X, 중복X
Map : (key, value) 쌍, Key 중복X, value 중복O,

List(ArrayList, Vector, LinkedList)
    add(value) : 마지막에 값 추가
    add(index, value) : 특정 위치에 추가
    get(index) : 값 가져오기
    set(index, value) : 값 변경
    remove(index) : 값 제거
    remove(object) : 객체제거
    clear : 모든 요소 삭제
    size : dyth rottn
    contains(object) : 포함여부 확인
    isEmpty : 비어있는지 확인
    indexOf(object) : 처음 등장하는 위치
    toArray : 배열로 변환
    sort : 정렬

Set(HashSet, LinkedHashSet : 입력 순서대로 값을 정렬, TreeSet : 오름차순 정렬)
    add : 값 추가
    addAll(Arrays.asList(value1, value2)) : 값 여러개 추가
    remove(value) : 특정 값 제거거

Map(HashMap, TreeMap : 정렬된 key로 저장, Hashtable : 동기화 지원, Properties : 설정 정보 저장에 사용)
    put(key, value) : 요소 추가
    get(key) : key에 해당하는 value 반환
    remove(key) : key에 해당하는 쌍 삭제
    constains(key) / contains(value) : 존재 여부 확인
    keySet / values / entrySet : 전체 key, 전체 value, 쌍 반환

```

# 0604 - JAVA

## Map

```
key-value 쌍으로 저장
key 중복 불가

HashMap : 순서 없음, 가장 많이 사용됨, null 허용
Hashtable : HashMap과 유사하지만 동기화 지원 (멀티스레드 환경에 적합)
TreeMap : 정렬된 key로 저장, 성능은 낮지만 순서가 필요할 때 사용
Properties : 키와 값을 모두 문자열(String)로 제한한 Map, 설정 정보 저장에 사용

put(key, value) : 요소 추가
get(key) : key에 해당하는 value 반환
remove(key) : key에 해당하는 쌍 삭제
containsKey(key) / containsValue(value) : 존재여부 확인
size / isEmpty / clear : 크기 확인 및 초기화
keySet / values / entrySet : 전체 key, value 쌍 반환
replace(key, value) : 값 변경
```

## Set

```
중복 X
순서 X
중복 제거 및 빠른 검색시 사용

hashcode ---같음--- equals ---같음--- 동등 객체
다름 |           다름 |
     |               |
     ㄴ------- 다른 객체

```

## Tree

```
이진 검색 트리
자동 정렬
중복 X

데이터 정렬할 때, 중복 제외시 사용

put : 값 추가
get : 값 조회
entrySet : 전체 key-value쌍 출력
descendingMap : 내림차순 정렬

```

| **항목**  | **TreeSet**            | **TreeMap**          |
| --------- | ---------------------- | -------------------- |
| 구조      | 이진 검색 트리 (Set)   | 이진 검색 트리 (Map) |
| 정렬 기준 | 요소 자체              | Key 기준             |
| 중복      | 허용 안 함             | Key 중복 허용 안 함  |
| 사용 예   | 정렬된 목록, 점수 모음 | 점수표, 키-값 정렬   |

## Comparable / Comparator

```
객체를 정렬하는 데 사용

Comparable
    객체 자신이 정렬기준을 가짐

    선언
        public class Fruit implements Comparable<Fruit> {
            private String name;
            private int price;

            public Fruit(String name, int price) {
                this.name = name;
                this.price = price;
            }

            @Override
            public int compareTo(Fruit other) {
                if (this.price > other.price) {
                    return 1;  // 현재 객체가 더 비싸면 뒤로
                } else if (this.price < other.price) {
                    return -1; // 현재 객체가 더 싸면 앞으로
                } else {
                    return 0;  // 같으면 그대로
                }
            }
        }

    사용
        List<Product> list = ...;
        Collections.sort(list); // 자동으로 compareTo() 기준으로 정렬


Comparator
    외부에서 다른 기준을 적용할 수 있음
    Comparator 인터페이스는 compare 메소드를 구현해야 함

    선언 1
        public class NameDescendingComparator implements Comparator<Fruit> {
            @Override
            public int compare(Fruit f1, Fruit f2) {
                return f2.getName().compareTo(f1.getName()); // 이름 기준 내림차순
            }
        }

    선언 2
        public int compareTo(CarComp o) {
        if (this.year == o.year) { // 비교
            int rst = this.name.compareTo(o.name);
            if (rst != 0) return rst; // 다르면 return
            else {
                return this.color.compareTo(o.color); // 같으면 2번째 조건으로 비교
            }
        } else if (this.year < o.year) return -1; // (오름차순 : -1, 내림차순 : 1, 같음 : 0)
        else return 1;
        }

    선언 3
        public int compare(Fruit f1, Fruit f2) {
            return Integer.compare(f1.getPrice(), f2.getPrice());  // 오름차순
        }



    사용
        List<Product> list = ...;
        Collections.sort(list, new NameComparator()); // 이름 기준 정렬


람다 함수
    오름차순
        products.sort(Comparator.comparing(Product::getPrice));
    내림차순
        products.sort(Comparator.comparing(Product::getPrice).reversed());


```

## 알게된 것

1. public은 클래스 당 하나
2. main에 다른 객체를 정의하고 싶다면 class만 사용
3. 접근제어자(public : 어디서든 접근 가능, protected : 해당 클래스 내부에서만 접근 가능, protected : 같은 패키지 + 다른 패키지의 하위 클래스에서 접근 가능, default : 같은 패키지 내에서만 접근 가능) type{}
