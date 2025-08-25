import UIKit

// MARK: - 인스턴스(객체)의 생성과 소멸: 초기화 및 해제

/// 기본적인 이니셜라이저(생성자) 작성 방법
/// - 프로퍼티가 없을 때
struct A {
    
}
let a = A()
/// "( )"가 "init( ){ }"를 호출한다는 뜻입니다.
/// 생성자를 호출하게 되면 인스턴스가 a라는 이름으로 생성된다. 기존에 이니셜라이저가 없는 클래스나 구조체를 만들었을 때, 객체 생성을 하면서 자동으로 제공되는 이니셜라이저를 호출했다고 볼 수 있다.

struct B {
    init () {
        
    }
}
let b = B()

/// 프로퍼티의 기본값
/// - 구조체와 클래스의 인스턴스는 처음 생성할 때, 옵셔널 저장 프로퍼티를 제외한 모든 저장 프로퍼티에 초기값을 할당해야 한다.
/// - 이미 프로퍼티에 기본값이 있다면, 이니셜라이저에 초기값을 할당하지 않아도 된다.
struct C {
    var c1: Int
    init() {
        c1 = 10
    }
}
let c = C()
print(c.c1)

// 프로퍼티 기본값 지정
class D {
    var d1: Int = 20
}
let d = D()
print(d.d1)

/// 이니셜라이저의 매개변수
/// - 이니셜라이저도 매개변수를 가질 수 있다.
/// - 인스턴스를 초기화하는 과정에서 필요한 값을 전달 받을 수 있다.

// 아래는 모두 다른 이니셜라이즈
struct E {
    var e1: Int
    init(e11: Int) {
        e1 = e11
        print("첫 번째 이니셜라이저가 호출되었습니다. 값: \(e11)")
    }
    init(label e11: Int) {
        e1 = e11
        print("첫 번째 이니셜라이저가 호출되었습니다. 값: \(e11)")
    }
    init(_ e11: Int) {
        e1 = e11
        print("첫 번째 이니셜라이저가 호출되었습니다. 값: \(e11)")
    }
}
let e = E(e11: 100)
let e2 = E(label: 100)
let e3 = E(100)
//let e4 = E() // 컴파일 에러: 저장 프로퍼티를 초기화하지 못함

/// 이니셜라이저의 생략
/// - 이니셜라이저가 정의되지 않았을 경우에는 저장 프로퍼티를 매개변수로 받는 이니셜라이저가 자동으로 생성된다.(구조체에서만)
/// - 멤버와이즈 이니셜라이즈: 모든 저장 프로퍼티가 초기화 될 수 있도록 자동으로 이니셜라이저들을 제공한다.
struct F {
    var f1: Int
    // 아래 이니셜라이저가 생략되어 있음
//    init(f1: Int) {
//        self.f1 = f1
//    }
}
let f = F(f1: 100) // 사용자가 정의한 이니셜라이저가 없더라도 기본 생성자가 자동으로 생성된다.
//let f2 = F() // 기본 생성자가 있는 것이기 때문에 이렇게 생성할 수 없다.

/// 구조체는 왜 자동 생성자를 제공할까?
/// - 구조체는 값 타입으로 상대적으로 단순한 데이터 구조를 표현한다.
/// - Swift는 구조체의 단순성을 유지하기 위해 모든 저장 프로퍼티를 초기화하는 기본 생성자를 자동으로 제공하여 개발자의 부담을 줄여준다.
/// - 이는 Swift의 안정성 철학(모든 프로퍼티는 초기ㅗ하되어야 한다)을 반영한다.
/// - 저장 프로퍼티에는 기본값이 있어도 멤버와이즈 자동 생성자가 제공도니다.
/// - 멤버와이즈(자동) 생성자 : 모든 저장 프로퍼티가 초기화 될 수 있도록 자동으로 생성자를 한 개 이상 제공한다.
/// - 저장프로퍼티가 기본값도 없고 초기화도 되지 않는 생성자는 제공하지 않는다.
struct FF {
    var fff1: Int
    var fff2: Int = 200
//    init(fff1: Int, fff2: Int) {
//        self.fff1 = fff1
//        self.fff2 = fff2
//    }
}
let ff2 = FF(fff1: 100, fff2: 200)
// let ff3 = FF()
let ff4 = FF(fff1: 1000)
// let ff5 = FF(fff2:2000
print("ff2.fff1 : \(ff2.fff1)")
print("ff2.fff2 : \(ff2.fff2)")

/// 클래스의 이니셜라이저
/// - 반면 클래스는 구조체와 달리 자동 생성자를 제공하지 않는다.
/// - 특정 저장 프로퍼티의 기본값이 없거나 초기화 해줄 수 있는 이니셜라이저가 없을 때 에러가 발생한다.
//class G {
//    var g1:Int
//}
//let g = G()
//let g2 = G(g1: 100)

// 기본값을 설정하거나
class G {
    var g1: Int = 100
}
let g = G()

// 생성자로 초기값을 설정해야 한다.
class H {
    var h1: Int
    init(h1:Int) {
        self.h1 = h1
    }
}
let h = H(h1:100)

// 또는, 옵셔널 저장 프로퍼티를 둘 수 있다.
class I {
    var i1: Int?
}
let i = I()
print(i.i1) // i1은 생성되면서 초기값이 nil로 설정된다.
i.i1 = 100
print(i.i1) // 옵셔널 타입이기 때문에 옵셔널로 출력
if let i = i.i1 {
    print(i)
}

/// 실패 가능한 이니셜라이저
/// - 이니셜라이저를 통해 인스턴스를 초기화 할 수 없는 여러가지 상황이 있을 수 있다.
class Person {
    var name: String
    init?(name: String) {
        if name.isEmpty {
            return nil
        }
        self.name = name
    }
}

let person1: Person? = Person(name: "")
if let person1 = person1 {
    print(person1.name)
} else {
    print("Person 인스턴스 생성에 실패했습니다.")
}

let person2: Person? = Person(name: "조기환")
if let person2 = person2 {
    print("\(person2.name) 이름의 Person인스턴스가 생성되었습니다.")
} else {
    print("Person 인스턴스 생성에 실패했습니다.")
}

/// 인스턴스의 소멸
/// - 디이니셜라이저(소멸자)
/// - 메모리에서 해제되기 직전에 실행된다.
/// - 클래스에만 구현이 가능
/// - 클래스의 인스턴스가 소멸될 때 외부 파일을 저장하고 닫아주는 등의 작업을 위해 사용한다.
class FileWorkClass {
    var filename: String
    init(fileName: String) {
        self.filename = fileName
        print("\(self.filename)을 불러왔습니다.")
    }
    deinit{
        print("\(self.filename) 파일을 저장했습니다.")
    }
}
var fileWord1: FileWorkClass? = FileWorkClass(fileName: "text1.txt")
fileWord1 = nil
