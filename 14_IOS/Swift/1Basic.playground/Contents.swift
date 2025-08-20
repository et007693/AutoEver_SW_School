import UIKit

var greeting = "Hello, playground"
print(greeting)

var greeting2 = "Hello, Swift"
print(greeting2)

var greeting3 = "Hello, Swift3"
print(greeting3)

UIImage(systemName: "star")

var sum=0
for i in 1...10 {
    sum += i
}

// MARK: - 주석

// 한 줄 주석

// greeting3

/// 문서주석
/// - 이것은 문서 주석입니다.
/// - 클래스, 메서드 등의 도큐멘트를 작성할 때 사용


// 출력하기
print(greeting)
dump(greeting)

var number = 10
print(number)
dump(number)

// 수행문 작성
// 스위프트 수행문 작성은 코틀린과 같이 수행문 뒤에 ";"를 붙이지 않아도 된다.
print("Hello, World!")
print("Hello, World!", terminator: "") // 개행 X
print("Hello, World!")

// MARK: - 이름 짓기 규칙

// Loswer Camel Case
// 함수, 메소드, 변수, 상수 등의 이름을 지을 때
var someVar = 0

func someFunc1() {
    
}


// Upper Camel Case
// 타입(Int, String, Bool, Float, Double 등), 클래스
var someInt: Int = 0
class SomeClass {
    
}

// 문자열 보간법 (String Interpolation)
let t1 = "안녕하세요." + greeting + "반갑습니다."
let t2 = "안녕하세요. \(greeting) 반갑습니다."
let t3 = "안녕하세요. \(100)"
print(t1)
print(t2)
print(t3)

// MARK: - 변수와 상수
var a = 10 // var : 변수는 다른 값으로 변경 가능
let b = 20 // let : 상수는 한 번 값을 지정하면 변경 불가능

a = 30
//b = 40

var c:Int
let d:Int

c = 50
c = 60
d = 70

// 여러 변수와 상수를 한번에 선언할 수 있다
var ab1, ab2, ab3: Int
var cd1 = 100, cd2 = 200, cd3 = 300

// MARK: - 데이터 타입

// Int, Unit
var int1 = 100

print(Int.max)
print(Int.min)

print(UInt.max)
print(UInt.min)

// Int16 ~ Int64
let int16: Int16 = 100

// unit1 = -100 // Unit 타입은 음의 정수를 담지 못한다.

// 진수별 정수 표현
let decimalInteger = 17 // 10진수
let binaryInteger = 0b10001 //2진수
let octalInteger = 0o144 // 8진수
let hexadecimalInteger = 0x10 // 16진수

// 숫자 리터럴 포맷, 가독성을 위해 사용, 실제 값에 영향 X
let paddedDouble = 00123.456
let oneMillion = 1_000_000
let justOverOneMillion = 1_000_000.000_000_1

// Bool
var boolean:Bool = true
print(boolean)
boolean.toggle()
print(boolean)

// 부동소수형 타입: Float, Double
var float:Float = 3.14
var double:Double = 3.14159

print(Int.random(in: -100...100))
print(UInt.random(in: 1...300))
print(Float.random(in: 1.5...4.3))
print(Double.random(in: 1.5...4.3))

// 문자
let alphabet: Character = "a"
print(alphabet)

// 유니코드 사용 가능
let unicode: Character = "😄"
print(unicode)

let 한글변수: Character = "😘"
print(한글변수)

// 문자열 String
let name: String = "김민수"

var introduce: String = String()
introduce.append("안녕하세요.")
introduce.append(name)
print(introduce)
print(introduce.count)
print(introduce.isEmpty)

var isSameString: Bool = false
isSameString = name == "김민수"
print(isSameString)

print(name.hasPrefix("김민"))
print(name.hasPrefix("민수"))

var hello = "Hello"
print(hello.uppercased())
print(hello.lowercased())

greeting = """
    안녕하세요.
    날씨가 좋네요.
    """
print(greeting)

/// 스위프트의 제어문자들
/// \n, \\, \", \t

print("문자열 내부에서 \n줄바꿈을 하고 싶어요.")
print("문자열 내부에서 \\줄바꿈을\\ 하고 싶어요.")
print("문자열 내부에서 \"줄바꿈을\" 하고 싶어요.")
print(#"문자열 내부에서\"줄바꿈\"을 \#(100)하고 싶어요."#)

// MARK: - Any, AnyObject, nul(=null)

// Any
var someAny: Any = 10.111
someAny = "어떤 타입의 값도 할당 가능"
//var someString: String = someAny // Any도 하나의 타입이기 때문에 다른 타입에 할당 불가

// AnyObject
class SomeClass2 {}
var someAnyObject: AnyObject = SomeClass2()
// someAnyObject = 10 // AnyObject 타입에는 기본 타입 할당 불가

// nil: 아무것도 없는 값
//someAny = nil // 컴파일 에러
//someAnyObject = nil // 컴파일 에러
var someAny2: Any? = 200 // ?를 사용하여 옵셔널로 넣어줘야 함
someAny2 = nil

// MARK: - 데이터 타입 안심(안정성)
// 서로 다른 타입끼리의 데이터 교환은 타입캐스팅을 거쳐야 한다. 즉, 새로운 인스턴스를 생성하여 할당
var safe1: Int = 100
var safe2: Double = 200.333

//safe2 = safe1 // 형변환을 거치지 않으면 에러 발생
safe2 = Double(safe1)

print(safe1)
print(safe2)

var name22 = "Song" // 타입 추론
let int3 = 100
//let double = 333.333  // 기본 부동소수형 타입은 Double

// MARK: - 타입 별치 type alias
typealias MyInt = Int
typealias YourInt = Int

var age: MyInt = 10
var myAge: YourInt = 20

myAge = age

typealias MyString = String
//var name: MyString = "Song"

// Tuple : 타입의 이름이 따로 지정되어 있지 않은 데이터 타입

// 튜플의 인덱스를 통해 요소에 접근
var person: (String, Int, Double) = ("Song", 70, 178.5)
print("이름: \(person.0), 나이 : \(person.1), 키 : \(person.2)")
person.0 = "Kim"

// 튜플의 각 타입의 이름을 통해 요소에 접근
var person2: (name: String, age: Int, height: Double) = ("Song", 70, 178.5)
print("이름: \(person2.name), 나이 : \(person2.age), 키 : \(person2.height)")
person.0 = "Kim"

typealias PersonTuples = (name: String, age: Int, height: Double)
var person3: PersonTuples = ("Song", 20, 178.5)

// MARK: - 컬렉션
// 스위프트의 컬렉션에는 배열, 딕셔너리, 셋

// 배열(Array) : 같은 타입의 데이터를 나열한 후 순서대로 저장하는 컬렉션
// let으로 선언하면 수정, 삭제, 추가 불가
var names: Array<String> = ["Kim", "Song", "Park"]
var names2: [String] = ["Kim", "Song", "Park"]

// 빈 배열
var emptyArray: Array<Int> = [Int]()
var emptyNames2: [Int] = Array<Int>()
var emptyNames3: [Int] = []
print(emptyArray.isEmpty)
print(names.count)

print(names[0])
names[0] = "최지수"

names.append("Song")
names.append(contentsOf: ["Lee", "Choi"])
names.insert("chae", at: 2)
names.insert(contentsOf: ["Lee", "Park"], at: 2)

var names4 = ["조기환", "조기환"]
var name5: Int? = names4.firstIndex(of: "조기환")
names.firstIndex(of: "조기환")
names.first
names.last

// 요소를 삭제한 후에 요소를 반환
let firstName = names.removeFirst()
let firstName2 = names.remove(at:0)
print(names[0...1])

// 딕셔너리 : 요소들이 순서없이 키와 쌍으로 구성되는 컬렉션
var numberForName: Dictionary<String, Int> = Dictionary<String, Int>()
typealias NameNumberDict = Dictionary<String, Int>
var numberForName2: NameNumberDict = Dictionary<String, Int>()
var numberForName3: [String: Int] = [String: Int]()
var numberForName4: NameNumberDict = NameNumberDict() // 타입 별칭 사용하여 빈 딕셔너리 생성
var numberForName5: [String: Int] = [:]
var numberForName6: NameNumberDict = ["조기환" : 100, "김호민" : 200]

print(numberForName6.isEmpty)
print(numberForName6.count)

print(numberForName6["조기환"])
print(numberForName6["김호민"])

numberForName6["조기환"] = 1000
print(numberForName6["조기환"])

numberForName6["아무개"] = 2000
print(numberForName6["아무개"])

print(numberForName6.removeValue(forKey: "김호민"))
print(numberForName6)
print(numberForName6["박수홍", default: 0])

// set: 같은 타입의 데이터를 순서 없이 하나의 묶음으로 저장하는 형태의 컬렉션
// 순서가 중요하지 않거나 각 요소가 유일한 값이어야 할 때 사용

var nameSet: Set<String> = Set<String>()
var nameSet2: Set<String> = []
var nameSet3: Set<String> = ["조기환", "김호민", "김호민"]
print(nameSet3)

var nameSet4: Set<String> = ["조기환", "김호민", "김호민"]
nameSet4.insert("박수홍")
nameSet4.remove("박수홍")

// 집합연산
let unionSet: Set<String> = ["조기환", "김호민", "아무개"]
let unionSet2: Set<String> = ["조기환", "김호민", "박명수"]

// 교집합
print(unionSet.intersection(unionSet2))
print(unionSet2.intersection(unionSet))

// 여집합
print(unionSet.symmetricDifference(unionSet2))
print(unionSet2.symmetricDifference(unionSet))

// 차집합
print(unionSet.subtracting(unionSet2))
print(unionSet2.subtracting(unionSet))

var array: [Int] = [1, 2, 3, 4, 5]
//print(array.randomElement())
print(array.shuffled())
print(array)
array.shuffle()
print(array)

// 열거형
enum School: String {
    case elementary = "ele"
    case middle = "mid"
    case high = "hig"
}

var studentSchool2: School = .elementary
print(studentSchool2.rawValue)

let shool: School = .high
print(shool.rawValue)

let school2: School? = School(rawValue: "ele")
print(school2!.rawValue)

struct Student {
    let name: String
    let school: School
    
    func updateStudent() {
        self.school.rawValue
    }
}

// 열거형의 연관값
enum MainDish {
    case pasta(taste: String)
    case pizza(topping: String)
}

var pasta = MainDish.pasta(taste: "spicy")
print("pasta: \(pasta)")
