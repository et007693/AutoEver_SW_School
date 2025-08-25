import UIKit

// MARK: 옵셔널 체이닝
// - 옵셔널로 감싸진 값에 안전하게 접근하기 위한 문법

/// 1. 기본 개념
/// - 옵셔널 체이닝은 옵셔널 값이 nil이 아니면 이어서 속성, 메서드 등을 호출하고, nil이면 전체 표현식이  nil을 반환하도록 해준다.

class A {
    
}
let a: A? = A()
// let a: A? = nil

// 옵셔널 바인딩
if let a = a {
//    a.a1
}
/// a?.b?.c
/// 위와 같은 표현이 있으면
/// - a가 nil이 아니면 b에 접근
/// - b가 nil이 아니면 c에 접근
/// - 중간에 하나라도 nil이면 결과가 nil

class Dog {
    var name: String
    init(name: String) {
        self.name = name
    }
}

class Person {
    var dog: Dog?
}


let person = Person()
person.dog = Dog(name: "Arthor")

// 일반 접근(옵셔널 바인딩)
if let dog = person.dog {
    print("dog.name: \(dog.name)")
}

// 옵셔널 체이닝 사용
print(person.dog?.name)

class Dog2 {
    func bark() {
        print("멍멍!!")
    }
}

class Person3 {
    var dog: Dog3?
}


class Dog3 {
    
}

let person3 = Person3()

/// 옵셔널 체이닝의 결과 타입
/// - 속성 접근시 -> 원래 타입이 옵셔널로 감싸져서 반환됨
/// - 메서드 호출시 -> 리턴값이 잇으면 옵셔널로, 없으면 Void처럼 작동
let name: String? = person.dog?.name

/// 중첩된 옵셔널 체이닝
/// - 연속으로 체이닝이 가능
class Company {
    var ceo: Person?
}
let company = Company()
company.ceo = Person()

let dogName = company.ceo?.dog?.name
print(dogName)

/// 정리: 옵셔널 체이닝은
/// 1. nil 안전하게 처리
/// 2. 코드 간결화
/// 3. if let, guard let으로 매번 바인딩하지 않아도 된다.











































