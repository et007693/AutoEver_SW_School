import UIKit

// MARK: 상속
/// - 클래스는 메서드나 프로퍼티 등을 다른 클래스로부터 상속 받을 수 있다.
/// - 어떤 클래스로부터 상속을 받으면 ㅅ아속받은 클래스는 그 어떤 클래스의 자식 클래스라고 한다.
/// - 자식 클래스에게 자신의 특성을 물려준 클래스를 부모 클래스라고 한다.
class Person {
    var name: String = ""
    var age: Int = 0
    
    func introduction() {
        print("이름은\(name)이고 \(age)살 입니다.")
    }
}
let person1 = Person()
person1.name = "김철수"
person1.age = 20
person1.introduction()

class Student: Person {
    var grade: String = "F"
    
    /// 메서드 오버라이딩
    /// - 부모 클래스로부터 상속받은 인스턴스 메서드를 자식 클래스에서 용도에 맞도록 재정의 할 수 있다.
    override func introduction() {
        // 재정의를 했다고 하더라도 부모 메서드를 호출할 수 있다.
        super.introduction()
        print("저는 \(name)입니다. \(age)살이고 \(grade)성적입니다.")
    }
    
    func study() {
        print("열심히 공부합니다.")
    }
}
let student1 = Student()
student1.name = "이영희"
student1.age = 18
student1.grade = "A-"
student1.introduction()
student1.study()

/// 프로퍼티 재정의
/// 연산 프로퍼티, 프로퍼티 감시자
class Person2 {
    var name: String = ""
    var age: Int = 0

    func introduction() {
        print("이름은\(name)이고 \(age)살 입니다.")
    }
}

class Student2: Person2 {
    // 프로퍼티 감시자로 재정의
    override var name: String {
        willSet {
            print("이름이 바뀌기 전입니다.")
        }
        didSet {
            print("이름이 바뀌었습니다.")
        }
    }
    
    override var age: Int {
        get {
            return self.age - 1
        }
        set {
            self.age = newValue + 1
        }
    }
}

/// 재정의 방지
/// - 재정의를 방지하려면 class 앞이나, 메서드, 프로퍼티 앞에 final키워드를 붙여준다.
class Person3 {
    final var name: String = ""
    final func speak() {
        print("가나다라")
    }
}

//final class Student3: Person3 {
//    override var name: String {
//        didSet {
//            print("이름이 바뀐것입니다.")
//        }
//    }
//    
//    override func speak() {
//        print("안녕하세요")
//    }
//}

//class UniversityStudent: Student3 {
//    
//}

/// - 자식클래스 인스턴스를 부모클래스 참조 변수에 담게되면 부노 클래스 멤버에만 접근 가능하다.
/// - 이 때 자식 클래스에서 재정의한 메서드를 호출하면 부모 클래스의 메서드가 아닌 자식 클래스의 메서드가 호출된다.
class Person4 {
    var name: String = ""
    var age: Int = 0
    
    func introduction() {
        print("이름은 \(name)이고, \(age)살입니다.")
    }
}

class Student4: Person4 {
    var grade: String = "F"
    
    /// method overriding
    /// - 부모 클래스로부터 상속 받은 인스턴스 메서드를 자식 클래스의 용도에 맞도록 재정의 할 수 있다.
    override func introduction() {
        print("이름은 \(name)이고 \(age)살이고 \(grade)성적입니다.")
    }
    
    func study() {
        print("열심히 공부합니다.")
    }
}

let student4: Person4 = Student4()
student4.name = "이영희"
student4.age = 29
//student4.grade = "A-" // 접근 불가
student4.introduction()
//student4.study() // 접근 불가
