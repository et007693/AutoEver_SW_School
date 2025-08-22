import UIKit

// 구조체와 클래스는 프로그래머가 데이터와 기능을 용도에 맞게 묵어 표현하고자 할 때 사용한다.

// MARK: struct(구조체)
struct Sample {
    // 가변 프로퍼티
    var mutableProperty: Int = 100
    // 불변 프로퍼티
    var immutableProperty: Int = 200
    // 타입 프로퍼티
    static let typeProperty: Int = 300
    
    // 인스턴스 메서드
    func instanceMethod() {
        print("인스턴스 메서드")
    }
    // 타입 메서드
    static func typeMethod() {
        print("타입 메서드")
    }
}

// 가변 인스턴스 생성
var mutable: Sample = Sample()
mutable.mutableProperty = 1000
print("mutable.mutableProperty: \(mutable.mutableProperty)")
//mutable.immutableProperty = 2000 // 불변 프로퍼티(let)는 수정 불가

// 불변 인스턴스 생성
let immutable: Sample = Sample()
// immutable.mutableProperty = 1000 // 불변 인스턴스는 프로퍼티 수정이 불가

// 타입 프로퍼티에 접근
print("Sample.typeProperty: \(Sample.typeProperty)") // 인스턴스 생성 없이도 접근 가능
Sample.typeMethod() // 인스턴스 생성 없이도 접근 가능
// mutable.typeMethod() // 인스턴스 타입 메서드, 타입 프로퍼티 접근 불가

// 학생 구조체 만들어보기
struct Student {
    // 가변 프로퍼티
    var name: String = "unknown"
    var `class`: String = "스위프트"
    // 강의실 호수
    @MainActor static var classRoom: Int = 7
    // 타입 메서드
    static func selfIntroduce() {
        print("학생입니다.")
    }
    // 인스턴스 메서드
    func selfIntroduce() {
        print("저는 \(name)입니다. \(`class`)에서 배웠습니다.")
    }
}

// 가변 인스턴스 생성
var keon = Student()
keon.name = "Song"
keon.class = "Swift"
Student.classRoom = 5
keon.selfIntroduce()
Student.selfIntroduce()
print("\(Student.classRoom) 강의실입니다.")

var homin = Student()
homin.name = "이호민"
homin.class = "Swift"
Student.classRoom = 4
homin.selfIntroduce()
Student.selfIntroduce()
print("\(Student.classRoom) 강의실입니다.")

struct Circle {
    static let pi: Double = 3.14
    var radius: Double = 0.0
    
    func area() -> Double {
        return Circle.pi * radius * radius
    }
}
var cirecle1 = Circle()
cirecle1.radius = 5.0
print(cirecle1.radius)

var cirecle2 = Circle()
cirecle2.radius = 5.0
print(cirecle2.radius)

// MARK: 구조체와 클래스 비교
struct ValueType {
    var value: Int = 1
}

class ReferenceType {
    var property: Int = 1
}

// 클래스 인스턴스 생성 후 첫 번째 참조 생성
let firstClassReference: ReferenceType = ReferenceType()
// 두 번째 참조 변수에 첫 번째 참조 할당
var secondClassReference: ReferenceType = firstClassReference
secondClassReference.property = 2

let thirdClassReference: ReferenceType = ReferenceType()
secondClassReference = thirdClassReference
//firstClassReference = thirdClassReference

// 두 번째 클래스 참조는 첫 번째 클래스 인스턴스를 참조하기 때문에 두 번째 참조를 통해 인스턴스의 프로퍼티 값을 변경하면, 처 번째 클래스 인트선트의 프로퍼티 값을 변경하게 된다.
print("firstClassReference.property: \(firstClassReference.property)")
print("secondClassReference.property: \(secondClassReference.property)")
