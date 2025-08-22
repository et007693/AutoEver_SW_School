import UIKit

// MARK: - 옵셔널(Optional): nil을 포함할 수 있는 변수나 상수
// 스위프트에서 nil은 다른 언어에서의 null과 같음

var a1: Bool = true
var a2: Bool? = true

var a3: Int = 0
var a4: Int = 0

var a5: String = ""
var a6: String = "asdf"
var a7: String = "ㅁㄴㅇㄹ"

var a8: MyClass?

class MyClass {
    
}

// 옵셔널 타입
var a9: Optional<Int> = 9
print(a9)

var a10: Optional<String> = "안녕하세요."
print(a10)

var a11 = String(10)
print(a11)

// nil과 옵셔널의 존재 이유
// - 형변환이 안 되는 값일 때
var a12: String = "안녕하세요."
var a13 = Int(a12)

// - 딕셔너리에서 키가 없을 때를 대비
var dict: [String: Int] = ["a":1, "b":2]
var a14 = dict["c"]

// - 어떤 함수가 반환값이 있는데, 함수 내부의 수행문이 우너하는 결과를 도출하지 못할 때
func divide(num1: Int, num2: Int) -> Int? {
    return num1 / num2 // num2가 0이면 에러 발생
}

var a15: Int? = divide(num1: 10, num2: 5)
var a16 = divide(num1: 10, num2: 0)

var a17: String? = ""
var a18: String? = nil

/// 강제 추출 Force Unwrapping
/// - 옵셔널 타입의 변수나 상수를 사용할 때 강제로 nil이 아니다라고 가정하고 강제로 해당 타입의 데이터를 꺼내온다.
/// - 강제로 데이터 타입의 값을 꺼내오기 때문에 nil이 있을 경우, 런타임에러가 발생하므로 권장하지 않는 방법임
var c1: Int? = 10
var c2: Int? = nil
print(c1!)
print(c2!)

/// Optional Binding
/// - if 구문을 통해 nil이 아닐 때만 안전하게 값을 꺼내 사용
/// - if 문 안에서만 사용 가능
var d1: Int? = 10
if d1 != nil {
    print(d1!)
}

// 코틀린에서의 사용법 : 자동으로 null 검사를 완료한 블럭 내부에서는 스마트 캐스팅이 되어 원래 데이터 타입의 변수를 그대로 사용할 수 잇다.
var d2: Int? = nil
var d3: String? = "asdf"
if let d2unwrapped = d2, let d3unwrapped = d3 {
    print(d2unwrapped)
    print(d3unwrapped)
} else {
    print("d2 or de3 is nil")
}

/// guard-let(var): 이것도 옵셔널 바인딩의 한 방식 + 조기종료
/// - 함수 내부에서 사용
var d4: Int? = 10
var d5: Int? = 12
func testFunc(value: Int?, value2: Int?) {
    guard let d4unwrapped = value, let d5unwrapped = value2 else {
        print("value is nil")
        return
    }
}
testFunc(value: d4, value2: d5)

/// implicitly Unwrapped Optional
var e1: Int? = 10
var e2: Int? = nil
print(e1!)
print(e2!)

var e3: Int! = 10
var e4: Int! = nil
print(e3)
print(e4)


//----------------------------------
// MARK: 1. 옵셔널
/// 옵셔널은 값이 잇을 수도 잇고, 없을 수도 있는 타입입니다.
/// 타입 뒤에 ?를 붙여 선언하며, 값이 없으면 nil이 됩니다.
/// 목적 : 타입 안정성을 유지하며, 값이 없는 상황(예: 네트워크 데이터, 사용자 입력)을 안전하게 다룹니다.
/// 내부적으로는 열거형(enum)으로 구현됨 : .some(값) 또는 .none
/// 실사용: 서버에서 사용자 데이터를 가져올 때, 데이터가 없을 수 있으므로 옵셔널 사용
var unsername: String? // 옵셔널 String 선언, 기본값은 nil
unsername = "Song" // 값 할당
print("exmple?: \(unsername)") // 출력: Optional("Song")

// MARK: 2. nil
/// nil은 옵셔널 타입에서 "값이 없다"는 상태를 나타냅니다.
/// 비옵셔널 타입에슨ㄴ nil을 할당할 수 없어, 타입 안정성을 보장합니다.
/// 목적 : 값이 없는 상태를 명확히 하고, null 포인터 오류를 방지
/// // 실사용: 배열이나 딕셔너리에서 값을 찾을 때, 결과가 없을 경우 nil 반환
var score: Int? nil // nil로 초기ㅗ하
score = 100
if score == nil {
    print("nil : 점수가 없습니다.")
}
score = 100
print("nil: 점수 값 할당 후: \(score)")

// MARK: 3. 강제 언래핑
/// 옵셔널 값을 강제로 풀어서 사용 ! 연산자 사용
/// 값이 nil이면 런타임 오류 발생, 값이 절대 nil이 아닐 때만 사용
/// 목적 : 간단히 옵셔널 값을 사용하지만, 안전하지 않으므로 주의 필요
/// 실사용: 앱 초기화 시 초기 UI에 사용
var message: String? = "Hello, Swift"
print("강제 언래핑 예시: \(message!)")
message = nil
// print(message) // 주석 해제 시 오류


// MARK: 4. 옵셔널 바인딩
/// 옵셔널 값을 안전하게 언래핑 하는 방법, if let or guard let 사용
/// 값이 nil이 아니면 새로운 상수/변수에 할당, nil이면 코드 블록 실행 안 함.
/// 목적: 강제 언래핑의 위험을 피하고, 안전하고 가독성 높은 코드 작성
var optionalName: String? "Student"
if let name = optionalName {
    print("옵셔널 바인딩 예시: 환영합니다.\(name)")
} else {
    print("옵셔널 바인딩 예시: 이름이 없습니다.")
}

// guard let 예시
func greetUser(_ user: String?) {
    guard let name = user else {
        print("옵셔널 바인딩 예시 : 이름이 없습니다.")
        return
    }
    print("옵셔널 바인딩 예시: 환영합니다. \(name)")
}
greetUser(optionalName)
greetUser(nil)

// MARK5: 5. 암시적 추출 바인딩
/// 타입 뒤에 ! 를 붙여 선언, 옵셔널처럼 nil을 가질 수 있시만, 접근 시 자동으로 언래핑됨
/// 목적 : 값이 초기에 nil일 수 있지만, 이후에는 항상 값이 있다고 가정할 때 사용. 하지만 nil이면 오류 위험
/// 주의: 강제 언래핑과 비슷한 위험이 있으므로, 꼭 필요할 때만 사용
var implicitName: String! = "Teacher"
print("임시적 추출 바인딩 예시: \(implicitName)")
implicitName = nil
var labelText = String!= "UILabel Text"
if let text = labelText {
    print("임시적 추출 바인딩 확인: \(text)")
}
