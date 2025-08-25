import UIKit

// MARK: Closure
/// - C 언어의 블록, 코틀린 또는 다른 언어의 람다와 비슷
/// - 일정 기능을 하는 어떤 코드들을 모아 놓은 것
/// - 함수와 비슷하고, 함수 자체를 하나의 변수, 상수처럼 다루고자 사용. 매개변수로 전달 or 반환값으로 받음

// 클로저 예시
// 클로저는 스위프트에서 객체로 취급
let sayHello = { (name: String) -> String in
    return "Hello, \(name)!"
}
print(sayHello("song"))

// 함수는 이름이 있는 클로저
func function(a: Int, b: Int) -> Int{
    return a + b
}

// 실제 클로저는 스위프트에서 객체로 취급산다.
// 클로저의 타입은 아래처럼 매개변수와 반환값으로 표현한다.
let sum: (Int, Int) -> Int = { (a: Int, b: Int) -> Int in
    return a + b
}

// sum이라는 변수를 호출
let sumResult = sum(10, 20) // 클로저를 호출 할 때, 변수명 뒤에 괄호 안에 매개변수를 넣어주는 것이 클로저를 매개변수로 수행한다는 의미.
print(sumResult)

/// 전달인자로서의 클로저
/// - 클로저는 주로 함수의 전달인자로 사용된다.

// 매개변수로 클로저를 받아 클로저 반환값으로 클로저를 실행하는 함수
func caluculate(a: Int, b: Int, method: (Int, Int) -> Int) -> Int {
    return method(a, b)
}

// 두 수를 더하는 역할을 하는 클로저
let add: (Int, Int) -> Int = { (a: Int, b: Int) -> Int in
    return a + b
}

let result = caluculate(a: 10, b: 20, method: add)
print(result)

// 따로 클로저를 상수/변수에 넣어 전달하지 않고, 함수를 호출할 때 클로저를 작성하여 전달할 수 있다.
let calculated = caluculate(a: 20, b: 30, method: { (first: Int, second: Int) -> Int in
    return first + second
})
print("calculated: \(calculated)")

// 변수를 미리 선언해놓고 전달하느냐, 함수에 전달인자로 바로 전달하냐의 차이
func testFunction(a: Int) {
    print("a: \(a)")
}
let closure = 10
testFunction(a: closure)
testFunction(a: 10)

// 전달인자로 전달된 클로저의 축약
// calculate 함수
func calculate(a: Int, b: Int, method: (Int, Int) -> Int) -> Int {
    return method(a, b)
}
// 클로저 바로 전달하면서 축약 안 한 상태
let calculated2 = calculate(a: 20, b: 30, method: { (first: Int, second: Int) -> Int in
    return first + second
})
// 축약 1: calculate 함수의 매개변수 method의 타입이 "(Int, Int) -> Int)"이기 때문에
let calculated3 = calculate(a: 20, b: 30, method: { (first, second) in
    return first + second
})

// 축약 2(단축인자 사용) : 클로즈의 매개변수 자체를 축약. 순서대로 $0, $1, $2...로 표시
let calculated4 = calculate(a: 20, b: 30, method: {
    return $0 + $1
})

// 축약 3(암시적 반환 표현) : 클로저의 본문이 단일표현식일 경우 return 키워드 생략 가능. 한 줄로도 가능.
let calculated5 = calculate(a: 20, b: 30, method: { $0 + $1 })


// 후행 클로저
// - 마지막 전달인자가 클로저이면 후행 클로저로 표현 가능
let calculated6 = calculate(a: 20, b: 30) { $0 + $1 }

print("calculated6: \(calculated6)")

let numbers: [Int] = [1, 2, 3, 4, 5]
let newNumbers = numbers.map { $0 * 2 }
let newNumbers2 = numbers.map { $0 * 2 }
let newNumbers3 = numbers.map { (item: Int) -> Int in
    return item * 2
}

// "Array.map()아 너 Array의 각 아이템 하나씩 꺼내서 내가 주는 함수를 수행하고, 새로운 Array 반환해줘.
print("newNumber3: \(newNumbers3)")
