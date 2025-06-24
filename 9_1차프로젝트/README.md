Entity -> Repository -> Dto -> Service -> Controller

# Entity

```
@Entity
@Table(name = "{table_name}")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = ...)

public class {name} {
    @Id
    @Column(name = "{name}", length = "", nullable = "")
    @GeneratedValue(strategy = GenerationType.{option})
    private {type} {name};
    @Enumerated // 값 제약 조건 지정

    @PrePersist
    @PreUpdate

    @OneToOne

    @OneToMany
    @ManyToOne

    @ManyToMany

    @JoinColumn(name = "{column_name}") // FK
}
```

- AllArgsConstructor : 모든 필드를 파라미터로 가지는 생성자를 생성
- NoArgsConstructor : 파라미터가 없는 기본 생성자를 생성
- builder : 빌더 패턴 생성, 각 필드를 체이닝 방식으로 설정정
- GeneratedValue(AUTO | IDENTITY | SEQUENCE | TABLE)
- ToString(exclude) : 자동으로 toString() 메서드 생성, exclude와 사용시 순환참조 예방 가능

### builder 패턴 사용 이유

협업을 하거나 변경에 대한 요구 사항이 많은 경우에 대해 손쉽게 대처할 수 있음

1. 필요한 데이터만 설정 가능
2. 순서 상관 없이 객체 생성 가능
3. 가독성 향상
4. 불변성 확보

### GeneratedValue

| 전략       | 설명                             | 특징                               | 주로 사용되는 경우                          |
| ---------- | -------------------------------- | ---------------------------------- | ------------------------------------------- |
| `AUTO`     | 기본 전략. DB에 따라 자동 선택됨 | 가장 일반적이지만 DB 의존적        | 테스트용, DB가 바뀔 가능성이 있을 때        |
| `IDENTITY` | DB의 `auto_increment` 기능 사용  | insert 직후 ID 조회됨              | MySQL, PostgreSQL 등에서 자주 사용          |
| `SEQUENCE` | DB의 시퀀스 객체 사용            | 성능 좋고 시퀀스 객체로 관리됨     | Oracle, PostgreSQL (시퀀스 지원 DB)         |
| `TABLE`    | 별도 테이블에서 ID 관리          | 모든 DB에서 호환되지만 성능이 느림 | 특수 상황 (DB 기능 제한, DB 독립성 필요 시) |

### OneToOne

1:1 관계

```
// sub
@OneToOne
@JoinColumn(name = "{column_name}") // fk
private {entity} {name};

// main
@OneToOne(mappedBy = "{sub_entity_name}", cascade, orphanRemoval)
private {sub_entity} {name};
```

### OneToMany, ManyToOne

1:N 관계
OneToMany는 보통 연관 테이블을 일괄 삭제할 때 사용

```
// sub
@ManyToOne
@JoinColumn(name = "{column_name}") // fk

@OneToMany(mappedBy = "{sub_entity_name}", cascade, orphanRemoval) // 이건 잘 안 씀, findBy로 해서 찾는 것이 더 빠름
private List<{sub_entity} {name} = new ArrayList<>();
```

### ManyToMany

N:M join을 사용하기보다, 조인 테이블 만드는 것을 권장(확장성, 추가 컬럼)

N:M 관계
| 방식 | 설명 | 특징 |
| ---------------------------------- | ------------------- | ---------------- |
| 1. 단순 `@ManyToMany` + `@JoinTable` | JPA에서 자동 조인 테이블 생성 | 간단하지만 유연성 부족 |
| 2. 조인 테이블을 엔티티로 분리 | 중간 테이블을 엔티티로 직접 만들기 | 부가정보 가능, 실무에서 권장 |

```
// sub
@ManyToMany
@JoinTable(
    name="{sub_table}" // 중간 테이블명
    joinColumn = @JoinColumn(name="{column_name}") // 현재 엔티티의 FK
    inverseJoinColumns = @JoinColumn(name="{column_name}") // 반대 엔티티의 FK
)
private List<{entity}> {name} = new ArrayList<>();

// main
@ManyToMany(mappedBy = "books") // 반대편 필드명
private List<{entity}> {name} = new ArrayList<>();
```

### JoinOption

| 속성            | 타입            | 설명                                                                     | option                              |
| --------------- | --------------- | ------------------------------------------------------------------------ | ----------------------------------- |
| `mappedBy`      | `String`        | 양방향 관계에서 반대편 필드명을 지정. 이 엔티티는 외래 키를 가지지 않음. | 외래 키를 가진 쪽의 필드명을 지정   |
| `cascade`       | `CascadeType[]` | 연관된 엔티티에 대해 자동으로 전파할 작업 지정. (`PERSIST`, `REMOVE` 등) | PERSIST, REMOVE, MERGE, DETACH, ALL |
| `fetch`         | `FetchType`     | 데이터를 가져오는 방식                                                   | EAGER, LAZY                         |
| `orphanRemoval` | `boolean`       | 컬렉션에서 제거된 자식 엔티티를 자동으로 삭제할지 여부                   | T/F                                 |

# Repository

PK에 대한 CRUD는 자동 제공되며, 그 외 컬럼 기반 조회는 메서드 이름 또는 @Query를 통해 직접 정의해야 함
함수 명은 CamelCase, 입력 값은 Entity에서 정의한 값

본인 테이블의 column은 findBy{column}
조인 테이블의 column은 findBy{table}{column}

```
@Repository
public interface {name} extends JpaRepository<{entity}, {pk_type}> {
    List<{entity}> findBy + 필드명(entity 변수명) + 연산자 + 조건연결자 + 필드명
}

```

### 기본 CRUD 메서드

| 메서드                            | 설명                                          |
| --------------------------------- | --------------------------------------------- |
| `save(BoardEntity entity)`        | 저장 또는 수정 (`INSERT` 또는 `UPDATE`)       |
| `findById(Long id)`               | ID로 단건 조회 (`Optional<BoardEntity>`) 반환 |
| `existsById(Long id)`             | 해당 ID가 존재하는지 여부 반환 (`boolean`)    |
| `findAll()`                       | 전체 목록 조회 (`List<BoardEntity>`)          |
| `findAllById(Iterable<Long> ids)` | 여러 ID로 조회                                |
| `count()`                         | 전체 개수 반환                                |
| `deleteById(Long id)`             | ID로 삭제                                     |
| `delete(BoardEntity entity)`      | 엔티티로 삭제                                 |
| `deleteAll()`                     | 전체 삭제                                     |
| `saveAll(List<BoardEntity>)`      | 여러 개 저장                                  |

<!-- 주요 키워드
| 연산자 키워드 | 의미 | 예시 |
| ------------------------- | ------------- | ---------------------------------- |
| `findBy` | 조회 시작 | `findByName(...)` |
| `And` | AND 조건 | `findByNameAndPrice(...)` |
| `Or` | OR 조건 | `findByItemNumOrItemDetail(...)` |
| `Between` | 범위 | `findByPriceBetween(min, max)` |
| `LessThan`, `GreaterThan` | 비교 연산자 | `findByStockLessThan(10)` |
| `Like`, `Containing` | 부분 일치(문자열 검색) | `findByItemDetailLike("%신발%")` |
| `IsNull`, `IsNotNull` | 널 여부 | `findByDescriptionIsNull()` |
| `OrderBy` | 정렬 | `findByCategoryOrderByPriceDesc()` |
| `In` | 리스트 포함 여부 | `findByItemNumIn(List<Long> ids)` | -->

### 연산자 키워드

| 연산자 키워드          | 의미             | 예시 메서드 이름                          | SQL 동작 방식                                              |
| ---------------------- | ---------------- | ----------------------------------------- | ---------------------------------------------------------- |
| `findBy`               | 조회 시작        | `findByName(String name)`                 | `SELECT * FROM ... WHERE name = ?`                         |
| `Distinct`             | 중복 제거        | `findDistinctByLastnameAndFirstname(...)` | `SELECT DISTINCT ... WHERE lastname = ? AND firstname = ?` |
| `And`                  | AND 조건         | `findByNameAndPrice(String n, int p)`     | `WHERE name = ? AND price = ?`                             |
| `Or`                   | OR 조건          | `findByItemNumOrItemDetail(...)`          | `WHERE item_num = ? OR item_detail = ?`                    |
| `Is`, `Equals`         | 같음 / null 체크 | `findByFirstnameIs(String f)`             | `WHERE firstname = ? OR firstname IS NULL`                 |
| `Between`              | 범위 검색        | `findByStartDateBetween(d1, d2)`          | `WHERE start_date BETWEEN ? AND ?`                         |
| `LessThan`             | 작은 값          | `findByAgeLessThan(30)`                   | `WHERE age < ?`                                            |
| `LessThanEqual`        | 작거나 같은 값   | `findByAgeLessThanEqual(30)`              | `WHERE age <= ?`                                           |
| `GreaterThan`          | 큰 값            | `findByAgeGreaterThan(20)`                | `WHERE age > ?`                                            |
| `GreaterThanEqual`     | 크거나 같은 값   | `findByAgeGreaterThanEqual(20)`           | `WHERE age >= ?`                                           |
| `After`                | 이후 날짜        | `findByStartDateAfter(LocalDate d)`       | `WHERE start_date > ?`                                     |
| `Before`               | 이전 날짜        | `findByStartDateBefore(LocalDate d)`      | `WHERE start_date < ?`                                     |
| `IsNull`, `Null`       | NULL 여부        | `findByAgeIsNull()`                       | `WHERE age IS NULL`                                        |
| `IsNotNull`, `NotNull` | NOT NULL 여부    | `findByAgeIsNotNull()`                    | `WHERE age IS NOT NULL`                                    |
| `Like`                 | 패턴 일치        | `findByFirstnameLike(String s)`           | `WHERE firstname LIKE ?`                                   |
| `NotLike`              | 패턴 불일치      | `findByFirstnameNotLike(String s)`        | `WHERE firstname NOT LIKE ?`                               |
| `StartingWith`         | 시작 문자열      | `findByFirstnameStartingWith("Kim")`      | `LIKE 'Kim%'`                                              |
| `EndingWith`           | 끝나는 문자열    | `findByFirstnameEndingWith("son")`        | `LIKE '%son'`                                              |
| `Containing`           | 포함 문자열      | `findByFirstnameContaining("ho")`         | `LIKE '%ho%'`                                              |
| `OrderBy`              | 정렬             | `findByAgeOrderByLastnameDesc(int age)`   | `WHERE age = ? ORDER BY lastname DESC`                     |
| `Not`                  | 부정 조건        | `findByLastnameNot("Lee")`                | `WHERE lastname <> ?`                                      |
| `In`                   | IN 절            | `findByAgeIn(List<Integer> ages)`         | `WHERE age IN (?, ?, ?)`                                   |
| `NotIn`                | NOT IN 절        | `findByAgeNotIn(List<Integer> ages)`      | `WHERE age NOT IN (?, ?, ?)`                               |
| `True`                 | Boolean 값 true  | `findByActiveTrue()`                      | `WHERE active = true`                                      |
| `False`                | Boolean 값 false | `findByActiveFalse()`                     | `WHERE active = false`                                     |
| `IgnoreCase`           | 대소문자 무시    | `findByFirstnameIgnoreCase("kim")`        | `WHERE UPPER(firstname) = UPPER(?)`                        |

### JQPQL | Querydsl | Spring Data JPA | NativeQuery | JDBC

# DTO

Data Transform Obejct : 계층간 데이터 전달을 위한 데이터용 객체
Entity는 DB와 직접 연결된 객체이므로, 클라언트와 그대로 주고받으면 보안 문제나 정보 노출이 발생할 수 있음
[Controller] -> [Service] -> [Repository]

```
@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class {Dto_name} {
    ...data
}
```

# Service

# Controller

클라이언트에게 성공 여부 외에도 메시지를 보내려면 Dto 사용

```
// ApiReponseDto
    public class ApiResponseDto<T> {
        private boolean success;
        private String message;
        private T data;

        public ApiResponseDto(boolean success, String message, T data) {
            this.success = success;
            this.message = message;
            this.data = data;
        }
    }

// controller
    public ResponseEntity<ApiResponseDto<Void>> postBoard(@RequestBody BoardWriteDto dto) {
        try {
            boardService.postBoard(dto);
            return ResponseEntity.ok(new ApiResponseDto<>(true, "게시글 등록 성공", null));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponseDto<>(false, e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, "알 수 없는 오류가 발생했습니다.", null));
        }
    }
```

# Pageable

```
// Repository
Page<{Entity}> findAll(Pageable pageable);

// Service
    public Page<{Dto}> {name}(Pageable pageable) {
        Page<Entity> {objects} = {Repository}.findAll(pageable);
        return {objects}.map(this::convertEntityToDto);
    }

// controller
// PageableDefault을 통해 기본값 지정
// 정렬 조건은 direction = Sort.Direction.DESC
    public ResponseEntity <Page<ResDto>> {name}(@PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            Page<BoardResDto> response = boardService.boardList(pageable);
            return ResponseEntity.ok(new ApiResponseDto<>(true, "게시글 목록 조회 성공", response));
    }
```

# JWT

### 인증 정보 가져오기

```

Authentication authentication = SecurityContextHolder.getContext().getAuthentication().getName();
```

### Spring Security + JWT CORS

```
// Security Config
@Bean
public CorsConfigurationSource corsConfigurationSource() {
CorsConfiguration config = new CorsConfiguration();
config.setAllowedOrigins(List.of("http://localhost:5173")); // 프론트 주소
config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
config.setAllowedHeaders(List.of("\*"));
config.setAllowCredentials(true); // 쿠키, Authorization 헤더 포함 허용

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
```

# API

### 외부 API 연결하기

| **Layer**    | **클래스 예시**    | **역할**                             |
| ------------ | ------------------ | ------------------------------------ |
| `Config`     | `WebClientConfig`  | WebClient 또는 RestTemplate 설정     |
| `Client`     | `AladinApiClient`  | 외부 API 호출 및 응답 처리           |
| `DTO`        | `BestSellerResDto` | API 응답 구조를 담는 객체            |
| `Service`    | `BookService`      | Client를 사용하여 비즈니스 로직 처리 |
| `Controller` | `BookController`   | 클라이언트 요청 처리 및 응답 반환    |

```
// config
    public class WebClientConfig {
        @Bean
        public WebClient webClient(WebClient.Builder builder) {
            return builder
                    .baseUrl({baseUrl})
                    .build();
        }
    }

// Service
    public class AladinApiClient {

        private final WebClient webClient;

        public BestSellerResDto getBestSeller() {
            return webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path({주소의 ?뒤에 나오는 uri})
                            .queryParam({param1}, {value1})
                            .queryParam({param2}, {value2})
                            .queryParam({param3}, {value3})
                            .build()
                    )
                    .retrieve()
                    .bodyToMono(BestSellerResDto.class)
                    .block();
        }
    }
```

# 예외처리

```
    throw new {exception_type}("{message}")
    try{

    } catch (Exception e) {
        log.error("{log}, {}", e.getMessage());
        return ResponseEntity.badRequest()
            .body(new ApiResponseDto<>(false, e.getMessage(), null));
    }
```

# Trouble Shooting

## 0620

유저 정보를 받는 Util 작성시 UserRepository.findByEmail(userEmail)에서 오류 발생

! UserRepository는 인스턴스가 아니기 때문에 의존성 등록 필요
-> 1. 일반 클래스가 아닌 Spring Bean으로 등록하기 위해 @Component 사용
-> 2. UserRepository를 생성자로 주입

```
    private final UserRepository userRepository;

        public UserUtil(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public UserEntity getCurrentUser() {
            String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByEmail(userEmail)
                    .orElseThrow(() -> new RuntimeException("유저 정보를 찾을 수 없습니다."));
        }
```

## 0623

jwt를 적용하여 토큰을 입력했는데도 401 에러 발생
-> 1. 토큰 유효성 검증을 통과 후 인증 정보 저장이 필요함
-> 2. JwtAuthenticationFilter에 인증 정보 저장하는 코드 추가

```
SecurityContextHolder.getContext().setAuthentication(auth);
```

### 0624

게시글 좋아요 기능을 만들던 중 user와 board가 n:m으로 매핑되어 있음
board에 user를 어떻게 설정해주어야 하나?
-> 1. 조인 관계가 이미 설정되어 있더라도 또, 매핑이 가능함
-> 2. 즉 게시글 좋아요 기능은 N:M, user와 board는 1:N으로 두 번의 매핑을 해도 됨
-> 3. 좋아요/싫어요 기능은 기존 board service에 작성하기보다 새로운 클래스로 만들어 하는 것이 좋음
