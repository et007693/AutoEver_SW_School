# Crawling

### GraphQL

- GraphQL은 API를 위한 쿼리 언어
- 타입 시스템을 사용하여 쿼리를 실행하는 SSR 런타임
- 특정한 데이터베이스나 스토리지 엔진과 관계되어 있지 않고, 기존 코드와 데이터에 의해 대체되는 특징을 가짐

```
payload = {
    "operationName": "QueryContentReviews",
    "variables": {
        "contentId": 87987987, # 영화 ID
        "reviewsOffset": 0,
        "reviewsLimit": 100,
        "reviewsOrderBy": "LIKE",
        "reviewsOrderOption": "DESC",
    },
    "query": """
    query QueryContentReviews(
        $contentId: Int!,
        $reviewsOffset: Int = 0,
        $reviewsLimit: Int = 10,
        $reviewsOrderBy: ReviewMoviesOrderType!,
        $reviewsOrderOption: OrderOptionType!,
        $reviewType: ReviewFilterType,
      ) {
      reviews(
        movieId: $contentId
        offset: $reviewsOffset
        limit: $reviewsLimit
        orderBy: $reviewsOrderBy
        # orderOption: $reviewsOrderOption
        reviewType: $reviewType
      ) {
        reviewTitle
        review

      }
    }
    """,
}
```

- REST API와의 차이점
  GraphQL은 보통 하나의 엔드포인트만을 가진다  
  GraphQL은 요청할 때 사용하는 쿼리에 따라 다른 응답을 받을 수 있다  
  GraphQL은 원하는 데이터(response)만 받을 수 있다

- GraphQL의 장단점

1. HTTP 요청 횟수를 줄일 수 있다.RESTful의 경우 필요한 리소스 별로 요청 해야하고, 필요한 데이터들이 부분적으로 나눠서 개발되어 있다면 그만큼 요청 횟수가 늘어난다. 하지만 GraphQL은 원하는 정보를 하나의 쿼리에 모두 담아 요청 할 수 있다.

2. HTTP 응답 사이즈를 줄일 수 있다. Restful의 경우 응답의 형태가 정해져있기 때문에 필요한 정보만 부분적으로 요청하는 것이 힘들고, 자연스럽게 데이터의 사이즈가 클 수 밖에 없다. Facebook이 GraphQL을 개발한 초기 이유 중 하나는 모바일 사용의 증가라고 한다. GraphQL을 사용함으로써 응답 데이터 사이즈를 최소화하여 모바일 환경의 부담을 줄일 수 있다.

3. 프론트엔드와 백엔드 개발자의 부담을 덜 수 있다. Restful API를 사용한다면 프론트엔드 개발자는 API의 request/response 형식에 의존하게 된다. 따라서 새로운 엔드포인트를 효율적이게 개발하기 위해서는 프론트엔드와 백엔드 개발자의 커뮤니케이션이 강제되는 경우가 많았다.하지만 GraphQL은 request/response 의존도가 많이 없기 때문에, 개발자들의 API 개발 부담을 덜 수 있다.

출처: https://hahahoho5915.tistory.com/63

# Trouble Shooring

### 0712

! beautifulsoup이나 selenium을 사용하지 않고, 크롤링을 할 수 있을까?
-> Network 탭에서 데이터 주고 받는 방식을 확인하고
-> API에 직접 요청을 보내서 값을 받아오기

!GraphQL
