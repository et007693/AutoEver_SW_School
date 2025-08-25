import UIKit

// MARK: 동시성: 동시성은 여러 작업을 동시에 실행하거나 병렬로 처리하는 것을 의미한다.

/// 일반적인 순차 실행
/// 수행문 한 줄이 끝나고 다음으로 넘어간다.
print("A")
print("B")
print("C")

// 오래 걸리는 비동기 작업
func fetchUser(_ name: String) async -> String {
    // 시간이 걸리는 요청
    return "userData"
}

print("A")
//let userData = fetchUser()
print("B")
print("C")

// Task: 동시 실행 작업 단위: 백그라운드에서 실행
Task {
    // 순차 실행과 같은 끝날때까지 기다린다는 의미지만, 다른 Task들이 CPU를 사용할 수 있또록 한다. -> 동시성 효율 UP
    let user = await fetchUser("user1")
    print(user)
}

/// 구조적 동시성
/// - 여러개의 동시 작업을 깔끔하게 묶어서 관리할 수 있는 방식
Task {
    // async let: 동시에 실행, 나중에 결과를 기다림
    async let user1 = fetchUser("user1")
    async let user2 = fetchUser("user2")
    let result = await (user1, user2)

    print(result)
}

Task {
    for i in 1...5 {
        try? await Task.sleep(for: .seconds(1))
        print("Task1: \(i)")
    }
}

Task {
    for i in 1...5 {
        try? await Task.sleep(for: .seconds(1))
        print("Task2: \(i)")
    }
}

Task {
    for i in 1...5 {
        try? await Task.sleep(for: .seconds(1))
        print("Task3: \(i)")
    }
}

/// Actor
/// 동시성 환경에서 안전하게 상태를 관리하기 위해 나온 타입
/// - 즉 여러 태스크가 동시에 접근할 수 있는 데이터를 데이터 경쟁 없이 안전하게 보호
/// 클래스와 비슷, 한 번에 하나의 태스크만 내부 상태에 접근 가능
/// await으로 접근해야 하는 비동기 메서드와 동기 메서드를 구분

actor BankAccount {
    private var balance = 0
    
    func deposit(_ amount:Int) {
        balance += amount
    }
    
    func withdraw(_ amount: Int) {
        balance -= amount
    }
    
    func getBalance() -> Int {
        balance
    }
}

/// Actor 사용
/// - await -> 액터의 메서드나 속성 접근 시 비동기 안전하게 접근
/// - 액터 내부에서는 동시성 문제가 자동으로 방지
/// - private 변수처럼 외부에서 직접 접근 불가 -> 안전
let account = BankAccount()
Task {
    await account.deposit(100)
    await account.withdraw(50)
    let current = await account.getBalance()
    print("Balance: \(current)")
    
}

// @MainActor
@MainActor
class ViewModel {
    var text = ""
    func updateText() {
        text = "Hello, World!"
    }
}

let vm = ViewModel()
Task {
    vm.updateText()
    print(vm.text)
}
