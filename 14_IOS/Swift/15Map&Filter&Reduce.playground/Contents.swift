import UIKit

// MARK: 고차함수 map, filter, reduce
/// - 고차함수는 다른 함수를 전달인자로 받거나 함수실행의 결과를 함수로 반환하는 함수
/// - 주로 컬렉션 관련 (Array, Set, Dictionary)

// map
// - 컬렉션 내보의 기존 데이터를 변형하여 새로운 컬렉션을 생성
let numbers: [Int] = [1, 2, 3, 4, 5]
var doubledNumbers: [Int]
var strings: [String]

doubledNumbers = [Int]()
strings = [String]()

// map 안 쓰기
for number in numbers {
    doubledNumbers.append(number * 2)
    strings.append(String(number))
}
print(doubledNumbers)
print(strings)

// map 사용
doubledNumbers = numbers.map({ (number: Int) -> Int in
    return (number) * 2
})
// 축약형
doubledNumbers = numbers.map({ $0 * 2 })
print(doubledNumbers)

let closure = { (number: Int) -> Int in
    return number * 2
}

// 컬렉션 클래스 내부
func map<T> (_ closure: (T) -> T) -> [T] {
    var newItems = [T]()
    for item in numbers { // numbers는 실제로 컬렉션 클래스 내부에서 self가 됨
        newItems.append(closure(item as! T))
    }
    return newItems
}

// filter
// 내부의 값을 걸러서 새로운 컬렉션을 추출할 때 사용
var filterd: [Int] = [Int]()
for number in numbers {
    if number % 2 == 0 {
        filterd.append(number)
    }
}
print("filtered : \(filterd)")

// numbers의 요소 중 짝수를 걸러내어 새로운 배열로 반환
let evenNumbers: [Int] = numbers.filter { $0 % 2 == 0 }
print("evenNumbers : \(evenNumbers)")

// numbers의 요소 중 짝수를 걸러내어 새로운 배열로 반환
let oddNumbers: [Int] = numbers.filter { $0 % 2 == 1 }
print("oddNumbers : \(oddNumbers)")

// reduce
// 초기값이 0이고, someNumbers 내부의 모든 값을 더한다.
let someNumbers: [Int] = [1, 2, 3, 4, 5]
//let sum: Int = someNumbers.reduce(0, +)

let sum: Int = someNumbers.reduce(0, { (first: Int, second: Int) -> Int in
    print("\(first) + \(second)")
    return first + second
})
print("sum: \(sum)")

// 초기값이 3이고 모든 배열의 요소를 더한다.
let sumFromThree = someNumbers.reduce(3) { $0 + $1 }

let someStrings: [String] = ["a", "b", "c", "d"]
let sum4: String = someStrings.reduce("z", { (first: String, second: String) -> String in
    print("\(first) + \(second)")
    return first + second
})
print("sum4: \(sum4)")

// 클로저 대신 연산자 오퍼레이터로 제공 가능하다.
let sum5 = someNumbers.reduce(0, +)
print("sum5: \(sum5)")

let sum6 = someStrings.reduce("z", +)
print("sum6: \(sum6)")
