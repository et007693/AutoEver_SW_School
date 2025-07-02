# 0605 SpringBoot

## Spring Boot 개념

```
제어 역전 : 객체 생성과 의존성 관리를 스프링 컨테이너가 대신 수행하도록 하는 설계 원칙
    기존
        public class Car {
            private Engine engine;

            public Car() {
                this.engine = new Engine(); // 직접 생성
            }
        }
    제어 역전
        public class Car {
            // new를 사용하지 않음
            private Engine engine;

            public Car(Engine engine) {
                this.engine = engine;
            }
        }


의존성 주입 : 객체가 자신이 사용할 다른 객체를 직접 생성하지 않고 외부로부터 주입받는 방식, 클래스가 다른 클래스에 의존할 때, 그 의존 객체를 외부에서 넣어주는 것
    @Autowired : 의존성 자동 주입
    @Qualifier : 동일 타입 빈 중 특정 이름 지정
    @Resource : 자바 표준, 이름 기준 주입

스프링 컨테이너 : 객체를 생성하고 관리하는 역할
빈 : 스프링이 관리하는 객체

관점 지향 프로그래밍(AOP) : 자주 반복되는 기능을 깔끔하게 분리해서 관리할 수 있게 해주는 프로그래밍 패러다임
AOP의 핵심 개념
    Aspect : 공통 기능(로깅, 트랜잭션 등)을 모아놓은 모듈
    Join Point : 실행될 수 있는 지점 (ex. 메서드 실행 전/후 등)
    Advice : 실제 실행될 코드 (언제 무엇을 할지 정의함)
    Pointcut : 어떤 Join Point에 적용할지 선택하는 필터
    Weaving	: Aspect를 핵심 로직에 끼워 넣는 과정 (컴파일 시, 런타임 시 등)

레이어드 아키텍쳐(계층 구조) : 소포트웨어를 관심사에 따라 계층으로 나누는 설계 방식
    Presentation Layer : 사용자 요청 처리
    Service Layer : 비즈니스 로직 처리
    Data Access Layer : DB와의 연결/쿼리 처리
    Domain/Entity Layer : 데이터 구조 정의
```

| 스타터 이름                  | 설명                                            |
| ---------------------------- | ----------------------------------------------- |
| spring-boot-starter-web      | RESTful 웹 애플리케이션 개발을 위한 의존성 모음 |
| spring-boot-starter-jdbc     | 기본적인 JDBC 지원                              |
| spring-boot-starter-data-jpa | Spring Data JPA(Hibernate) 지원                 |
| spring-boot-starter-test     | 단위 테스트 및 통합 테스트 지원                 |
| spring-boot-starter-security | 스프링 시큐리티(인증 및 권한) 지원              |

## 프로젝트 생성

```
application.properties

spring.application.name=sample-jpa-mysql
server.port=8111

spring.datasource.url=jdbc:mysql://localhost:3306/{project_name}?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Seoul
spring.datasource.username=root
spring.datasource.password={password}

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=create
spring.mvc.pathmatch.matching-strategy=ant_path_matcher
```

## RestAPI

```
REST는 분산 시스템을 위한 아키텍쳐 스타일로, HTTP 기반 웹 서비스에서 가장 많이 사용되는 형식. REST API는 자원을 URI로 식별하고, GET, POST, PUT, DELETE를 통해 자원에 대한 행위를 정의함

All
    @RequestMapping("/url")

GET
    1. PathVariable을 활용
    @GetMapping("/url/{variable}")
    public String getVariable(@PathVariable String variable)
    public String getVariable(@PathVariable("variable") String var)

    2. RequestParam을 활용
    // localhost:1111?name=value&email=email
    public String getRequest(
        @RequestParam String name,
        @RequestParam String email,
    )

    3. DTO(Data Transfer Object) 객체 활용

@PostMapping("/url")

```

# 0609 - SpringBoot

## ORM

```
주요 구성요소
    JPA
    Hibernate
    Spring Data JPA

레이어드 아키텍쳐
    dto - FE와 통신에 사용하는 데이터 전송용 객체체
    entity - DB table과 직접 매핑되는 클래스스
    repository - JPA 설계 명세(Hibernate), CRUD + 쿼리 메소드 정의의
    service - 비즈니스 로직을 담당
    exception - 예외 처리를 위한 클래스스
    jwt - JWT 관련 인증 로직 담당
    config - 애플리케이션의 설정 관련 파일(CORS, Swagger, JPA, 빈 등록)

```

# 0610 - SpringBoot

## Pagination

```
pagination : 대량의 데이터를 페이지 단위로 나누어 부분적으로 조회하는 기법, 사용자가 페이지 이동 시 해당 페이지의 데이터를 서버에 새로 요청

```

## 연관 관계 매핑

```

```

## 영속성 전이

```
부모 엔티티의 변화를 자식 엔티티에도 알림
DB의 cascade와 비슷
영속성 전이가 없다면 조회만 가능
```

## 지연로딩

```
객체를 실제로 사용할 때까지 DB에서 로딩하는 것을 지연시킴
```

# 0611 SpringBoot

## service

```
데이터 처리 로직
FE -> controller -> dto -> service
Entity는 DB, Dto는 FE와 연결
```

# 0612 SpringBoot

## 기능 구현

```
Entity -> Repository -> Dto -> Service -> Controller
```

# 0618

## JWT

```
세션 기반
토큰 기반

gradle 의존성 추가
    implementation 'org.springframework.boot:spring-boot-starter-security'
    implementation group: 'io.jsonwebtoken', name: 'jjwt-api', version: '0.11.2'
    runtimeOnly group: 'io.jsonwebtoken', name: 'jjwt-impl', version: '0.11.2'
    runtimeOnly group: 'io.jsonwebtoken', name: 'jjwt-jackson', version: '0.11.2'

application.properties 
    jwt.secret 추가

entity Member에 추가
    @Enumerated(EnumType.STRING)
    private Authority authority;

    public Member(String name, String pwd, String email, String image, Authority authority) {
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.image = image;
        this.regData = LocalDateTime.now();
        this.authority = authority;
    }
constant에 Authority 생성

jwt > tokenprovider 생성

dto > tokenDto 생성

```
