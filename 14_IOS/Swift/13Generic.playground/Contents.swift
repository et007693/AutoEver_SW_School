import UIKit

// MARK: -input 함수
/// - 매개변수에 input키워드를 사용하는 함수
/// - 함수의 배개변수를 값이 아닌 참조로 전달하여 함수 내부에 해당 매개변수를 수정하고, 호출한 곳의 원본 변수에도 그 변경사항을 반영할 수 있게 하는 키워드
//func someMethod(inner: Int) { // 원래 스튀프트에선 전달인자 값은 물론이고, 매개변수 값도 수정하지 못한다.
//    inner = 100
//}
//someMethod(inner: outer)

var outer = 0
var outer2 = 10
func inoutMethod(inner: inout Int) {
    inner = 100
}
inoutMethod(inner: &outer)
print("outer: \(outer)")

// MARK: GENERIC
/// - 제네릭은 타입에 의존하지 않고, 여러 타입에서 재사용할 수 있는 코드를 만드는 방법
/// 즉, 같은 기능을 하는 코드를 타입마다 만들지 않고, 하나의 템플릿으로 만들어 놓는다

// 제네릭이 없을 때의 불편함
// 매개변수로 전달되는 두 변수의 값을 스왑하는 함수 예시

// Int 스왑
func swapInt(_ a: inout Int, _ b: inout Int) {
    let temp = a
    a = b
    b = temp
}
var a1 = 10
var b1 = 20
swapInt(&a1, &b1)
print("a1: \(a1), b1: \(b1)") 

// String 스왑
func swapString(_ a: inout String, _ b: inout String) {
    let temp = a
    a = b
    b = temp
}
var a2 = "Hello"
var b2 = "World"
swapString(&a2, &b2)
print("a2: \(a2), b2: \(b2)")

// 제네릭 함수로 변환, <T>fmf gkatnaud enldp ensek.
// T는 호출하면서 정하고 싶은 타입, 직접 지정이 가능, 여러개도 가능 <T, S> 등
func swap<T>(_ a: inout T, _ b: inout T) {
    let temp = a
    a = b
    b = temp
}

var a3 = 10
var b3 = 20
swap(&a3, &b3) // 매개변수로 전달되는 전달인자 타입이 Int이므로 생략 가능하다. T -> Int
print("a3: \(a3), b3: \(b3)")

var a4 = "Hello"
var b4 = "World"
swap(&a4, &b4)
print("a4: \(a4), b4: \(b4)")

/// 제네릭 타입
/// - 함수뿐만 아니라 타입도 제네릭을 가질 수 있다.
/// - 객체가 만들어질 때 타입을 전달한다.
/// - 이번엔 T가 아니라 Element로 해본다.
class Stack<Element> {
    private var items: [Element] = []
    
    func printStack() {
        print(items)
    }
    
    func push(_ element: Element) {
        items.append(element)
    }
}

var intStack = Stack<Int>()
intStack.push(1)
intStack.push(2)
intStack.printStack()

var stringStack = Stack<String>()
stringStack.push("a")
stringStack.push("b")
stringStack.printStack()

/// 제네릭 제약
/// - 모든 타입을 다 열어두면 위험할 수 있으니, 조건을 붙일 수 있다.
/// - T 뒤에는 모든 타입이 올 수 있다. 뒤에 오는 타입을 상속, 채택한 T만 가능하도록 제약을 걸어준다.
/// - 보통 프로토콜을 채택하면 제약을 걸어준다.
protocol TestProtocol {
    var a: Int { get }
}
class TestClass: TestProtocol {
    var a: Int = 100
}
func printA<T: TestProtocol>(value: T) {
    print("\(value.a)")
}
//print<Int>(value:100)
//printA<TextClass>(value: TestClass())
printA(value: TestClass())
