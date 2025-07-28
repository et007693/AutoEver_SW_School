fun main() {
    // 콘솔 확인
    println("Hello World!")
    println("반가워요!!")

    // 한 줄 주석입니다.
    println("한 줄 주석")

    // 여러 줄 주석
    /*
    첫번째 줄
    두번째 줄
    세번째 줄
    네번째 줄
    */

    print("출력합니다.")
    print("출력합니다.")
    print("출력합니다.")
    println()

    println("값 : " + 100 + 200)
    println("값 : " + "100" + "200")

    println("코틀린에서는 세미콜런이 없어도 됨")
    print("한 줄에 여러 수행문 할 때만 ");println("세미콜론 필요");

    // Literal
    val a = 100
    println("값 : ${a}")
    println("값 : $a")

    println(123_456_789)
    println(1_2345_6789)

    println('A')
    println('가')

    // Rww String
    println("""여러줄 출력하고 싶어요.
        여러줄 출력하고 싶어요.
        여러줄 출력하고 싶어요.
    """)

    println("""여러줄 출력하고 싶어요.
        |여러줄 출력하고 싶어요.
        |여러줄 출력하고 싶어요.
    """.trimMargin())

    // 논리값도 리터럴
    println(true)
    println(false)

    // 자료형

    // 정수형
    println("Byte 용량 : ${Byte.SIZE_BYTES}")
    println("Byte 최소값 : ${Byte.MAX_VALUE}")
    println("Byte 최대값 : ${Byte.MIN_VALUE}")

    println("Short 용량 : ${Short.SIZE_BYTES}")
    println("Short 최소값 : ${Short.MAX_VALUE}")
    println("Short 최대값 : ${Short.MIN_VALUE}")

    println("Int 용량 : ${Int.SIZE_BYTES}")
    println("Int 최소값 : ${Int.MAX_VALUE}")
    println("Int 최대값 : ${Int.MIN_VALUE}")

    println("Long 용량 : ${Long.SIZE_BYTES}")
    println("Long 최소값 : ${Long.MAX_VALUE}")
    println("Long 최대값 : ${Long.MIN_VALUE}")

    // 논리형
    // Boolean
    // 논리형은 1바이트를 사용한다.
    val bool = true
    val bool2  = false

    // 문자
    // 기본적으로 2바이트를 사용하지만, 시스템에 따라간다.
    println("Char 용량 : ${Char.SIZE_BYTES}")

    // 문자열(사용하는 용량만큼)

    // 변수

    // 변수 정의하는 방법
    // var/val 변수의 이름 : 타입

    var a1: Int
    a1 = 100
    println("a1 : $a1")

    a1 = 200

    var a2: Int = 300
    var a3 = 300

    var a7: Byte = 100
    var a8: Short = 100
    var a9: Int = 100

    var a10: Double = 11.11
    var a11: Float = 22.22F

    var a12: Char = '가'

    var a13: Boolean = true

    var a14: String = "문자열"

    // val 키워드를 이용해 선언된 변수는 값을 자유롭게 저장할 수 없다.
    val a21 = 100
    println("a21: $a21")

    // null을 허용하지 않는 변수. ?를 붙이지 않는다.
//    val a22: Int = null

    // null을 허용하는 변수. ?fmf qnxduwnsek.
    val a23: Int? = null

    // 함수
    test1()
    test2(a1 = 100, a2 = 11.11)
    val k1 = 200
    val k2 = 22.22
    test2(k1, k2)
    test3(0, 0.0)
    test3()

    val r1 = test4(100, 200)
    println("r1: $r1")

    test5()

    test6()
    test6(100)
    test6(100, 200)

    test7()
//    test8()

    var c1 = 10
    var c2 = 20

    // 연산자 사용
    println(c1 + c2)
    print(c1.plus(c2))

    // 최우선 연산자
    // "()" :
    var c3 = 10 + 2 * 4
    var c4 = (10 + 2) * 4

    // 단항 연산자
    // 연산에 참여하는 값이 하나인 연산자
    // ! (not) : 참을 거짓으로, 거짓을 참으로 변경하는 연산자
    // 조건식의 결과를 반대로 부정하고 싶을 때 사용
    var c5 = true
    var c6 = !c5
    var c7 = !c6
    println("c5 : $c5")
    println("c6 : $c6")
    println("c7 : $c7")

    // 부호 연산자
    var c8 = 100
    var c9 = +a8
    var c10 = -a8
    println("c9 : $c9")
    println("c10 : $c10")

    // 증감 연산자
    // 변수가 가지고 잇는 값을 1증가하거나 1 감소한다
    // 변수 앞에 있을 때와 뒤에 있을 때 수행이 다르다.
    var c11 = 100
    c11++
    println("c11 : $c11")
    --c11
    println("c11 : $c11")

    // 증감 연산자가 변수 엎에 잇을 경우에
    // 최우선 연산자를 제외한 다른 모든 연산자들보다 먼저 수행한다.
    var c13 = 10
    var c14 = 10
    var c15 = ++c13
    var c16 = --c14

    println("c13 : $c13, c15 : $c15")
    println("c14 : $c14, c16 : $c16")

    // 증감 연산자가 변수의 뒤에 있을 때
    // 모든 연산자들보다 가장 마지막에 수행된다.
    c13 = 10
    c14 = 10

    c15 = c13++
    c16 = c14--

    println("c13 : $c13, c15 : $c15")
    println("c14 : $c14, c16 : $c16")

    // 산술 연산자
    // 곱하기, 나누기, 나머지 연산자가 더하기, 빼기보다 먼저 수행

    var d1 = 10 + 3
    var d2 = 10 -3

    // 대입 연산자
    // 우측에 있는 값을 좌측의 변수에 저장하는 연산자

    // if
    val e1 = 10
    if (e1 == 10) {
        println("a1은 10입니다.")
    }
    if (e1 != 10) {
        println("a1은 10이 아닙니다.")
    }

    if (e1 == 10) {
        println("a1은 10입니다.")
    } else if (e1 == 20) {
        println("a1은 20입니다.")
    } else {
        println("a1은 10이 아닙니다.")

    }

    val e2 = 10
    val e3 = 20

    // 모든 조건을 만족해야 하는 경우
    if (e2 ==10 && e3 == 20) {
        println("a2는 10이고 a3은 20입니다.")
    }

    var e4 = ""
    var e5 = 10

    if (e5 ==10) {
        e4 = "10입니다."
    } else {
        e4 = "10이 아닙니다."
    }
    println("e4 : $e4")

    val e6 = if(e5 == 10) "10입니다" else "10이 아닙니다."
    println("e6 : $e6")

//    val e7 = if (e5 == 10) {
//        "10입니다."
//    } else {
//        "10이 아닙니다."
//    }

    var e7 = ""
    if (e5 == 10) {
        var e8 = ""
        e8 += "안녕하세요"
        e8 += "반갑습니다."
        e7 = e8
    }

    var e9 = if(e5 == 10) {
        var e8 = ""
        e8 += "안녕하세요"
        e8 += "반갑습니다."
        e8
    } else {
        var e8 = ""
        e8 += "감사합니다."
        e8 += "고맙습니다."
        e8
    }


    ㅑㄹ"

    // for

    // while


}

// 기본 함수
fun test1() {
    println(message = "test1 호출")
}

// 매개 변수를 가지고 있는  함수
fun test2(a1: Int, a2: Double) {
    println(message = "test2 호출")
    println("a1: $a1")
    println("a2: $a2")
}

// 매개 변수 기본값을 가지고 있는  함수
fun test3(a1: Int = 100, a2: Double = 22.22) {
    println(message = "test3 호출")
    println("a1: $a1")
    println("a2: $a2")
}

fun test4(a1: Int, a2: Int): Int {
    println("test4 호출")
    return(a1 + a2)
}

fun test5() : Unit {
    println("test5 호출")
}

// 메소드 오버로딩
fun test6() {
    println("test6 호출 - 매개 변수 없음")
}
fun test6(a1: Int, a2: Int) {
    println("test6 호출 - 매개 변수 두 개(a1: $a1, a2: $a2")
}
fun test6(a1: Int) {
    println("test6 호출 - 매개 변수 한 개(a1: $a1")
}

// 지역 함수
fun test7() {
    println("test7 호출")
    fun test8() {
        println("test8 호출")
    }
    test8()
}