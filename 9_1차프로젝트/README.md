# 0618

## Entity 설계

```
@Entity
@Table(name = "{table_name}")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class {name} {
    @Id
    @Column(name = "{name}", length = "", nullable = "")
    @GeneratedValue(strategy = GenerationType.{option})
    private {type} {name};

    @PrePersist
    @PreUpdate

    @OneToOne
    @JoinColumn(name = "{column_name}") // FK

    @OneToMany

    @ManyToOne
}
```

- AllArgsConstructor : 모든 필드를 파라미터로 가지는 생성자를 생성
- NoArgsConstructor : 파라미터가 없는 기본 생성자를 생성
- builder : 빌더 패턴 생성, 각 필드를 체이닝 방식으로 설정정
- GeneratedValue(AUTO | IDENTITY | SEQUENCE | TABLE)

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

```
// sub
@ManyToOne
@JoinColumn(name = "{column_name}") // fk

@OneToMany(mappedBy = "{sub_entity_name}", cascade, orphanRemoval)
private List<{sub_entity} {name} = new ArrayList<>();
```

### ManyToMany

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
