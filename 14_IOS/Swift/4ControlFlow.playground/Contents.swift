import UIKit

// MARK: - 흐름 제어
// 조건문

// if
let first = 5
let second = 10

if first < second {
    print("first가 second보다 큽니다.")
} else if first < second {
    print("first가 second보다 작습니다.")
} else {
    print("first와 second는 같습니다.")
}

// switch
let integerValue: Int = 5

switch integerValue {
case 1:
    print("1")
case 2, 3:
    print("2 or 3")
case 10...20:
    print("10-20")
default:
    print("Other")
}

// for
for i in 0...2 {
    print(i)
}

var result: Int = 0
for _ in 1...5 {
    result += 10
}
print(result)

// while
var names: [String] = ["Alice", "Bob", "Charlie"]

while names.isEmpty == false {
    print("잘가 \(names.removeLast())!")
}

// repeat-while(do-while)
var names2: [String] = ["Alice", "Bob", "Charlie"]

repeat {
    print("잘가 \(names2.removeLast())!")
} while names2.isEmpty == false
