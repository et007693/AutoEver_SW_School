import UIKit

// MARK: - 연산자

// 할당 연산자: "=" (대입 연산자)
var a = 2
var b = 10

// 산술 연산자
print(a+b)
print(a-b)
print(a*b)
print(a/b)
print(a%b) // 나머지 연산자

// 비교 연산자
//print(a>b)
//print(a<b) 
//print(a==b) 
//print(a!=b)

// 삼항 연산자
var valueA: Int = 3
var valueB: Int = 5
var biggerValue: Int = valueA > valueB ? valueA : valueB
print(biggerValue)

// 범위 연산자
a...b
a..<b
a...
...a
..<a

// 논리 연산자
var isTrue: Bool = true
var isFalse: Bool = false
print(!isTrue)

isTrue && isFalse

// 복합 할당 연산자
var c1: Int = 10
var c2: Int = 20
c1 += c2
c1 -= c2
c1 *= c2
c1 /= c2
c1 %= c2
