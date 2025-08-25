import UIKit

// MARK: 에러 처리
/// 스위프트에는 다른 언어의 try-catch문과 다른 do-catch문을 사용
/// do 블럭 안에 에러가 발생할 수 있는 수행문 앞에  try 문을 사용

let a = 10
let b = 0
//print("try")
//a/b
//print("try")

do {
    print("try")
    try a/b
    print("after")
} catch {
    print("수행문이 예외를 발생시킴")
}

enum MyError: Error {
    case somethingWentWrong
    case somethingWentWrong2
    case somethingWentWrong3
}

func riskyFunction() throws {
    print("실행 중 오류 발생!")
    throw MyError.somethingWentWrong
}

do {
    print("코드 수행1")
    try riskyFunction()
    print("코드 수행1")
} catch {
    print("수행문에서 예외 발생")
}

struct NetworkError: Error {
    let code: Int
    let message: String
}
do {
    // 에러 직접 던지기(상태 코드와 메시지를 함께 포함)
    throw NetworkError(code: 404, message: "Not Found")
} catch {
//    print("구조체 에러 잡힘: \(error)")
//    print("\(error.code) \(error.message)")
    if let networkError = error as? NetworkError {
        print("구조체 에러 잡힘: \(networkError.code) \(networkError.message)")
    } else {
        print("알 수 없는 에러: \(error)")
    }
}

// MARK: 자판기 오류 예제
enum vendingMachineError: Error {
    case invalidInput // 사용자가 수량을 잘못 입력
    case insufficientFunds(amountNeeded: Int) // 돈 부족
    case outOfStock //재고 없음
}

class vendingMachine {
    let itemPrice = 100
    var itemCount = 10
    var deposit = 0
    
    // 돈 받기 메서드
    func receiveMoney(_ money: Int) throws {
        guard money > 0 else {
            throw vendingMachineError.invalidInput
        }
        deposit += money
        print("\(money)원 받음")
    }
    
    // 물건 팔기
    func vend(numberOfItems numberOfItemsToVend: Int) throws -> String {
        // 구매하려는 수량보다 미리 넣어둔 돈이 적으면 오류 발생
        guard numberOfItemsToVend * itemCount <= deposit else {
            let moneyNeeded = numberOfItemsToVend * itemCount - deposit
            throw vendingMachineError.insufficientFunds(amountNeeded: moneyNeeded)
        }
        return "물건 팔기 성공"
    }
}

// 자판기 객체 생성
let machine = vendingMachine()
// 판매 결과를 전달받을 변수
var result: String?

do {
    try machine.receiveMoney(100000)
    result = try machine.vend(numberOfItems: 1)
    print("result: \(result)")
} catch vendingMachineError.invalidInput {
    print("입력이 잘못되었습니다.")
} catch vendingMachineError.insufficientFunds(let moneyNedded) {
    print("\(moneyNedded)원이 부족합니다.")
} catch vendingMachineError.outOfStock {
    print("수량이 부족합니다.")
}

result = try? machine.vend(numberOfItems: 10)
result = try! machine.vend(numberOfItems: 10)
