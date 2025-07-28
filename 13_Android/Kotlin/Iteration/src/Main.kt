fun main() {
    val k1 = 1..10
    println(k1)
    println(k1.toList())

    // 1~9
    val k2 = 1 until 10
    println(k1.toList())

    // 1~9
    val k3 = 1..< 10
    println(k3.toList())

    // 2씩 증가
    val k4 = 1.. 10 step 2
    println(k4)
    println(k4.toList())

    // 10-1까지 2씩 감소
    val k5 = 10 downTo 1 step 2
    println(k4)
    println(k4.toList())

    // while
    var a5 = 0
    while (a5 < 10) {
        println("a5 : $a5")
        a5++
    }

    var a6 = 0
    do {
        println("a5 : $a5")
        a6++
    } while (a6 < 10)

    // return
    val r1 = testFun1(100)
    println("r1 : $r1")

    val r2 = testFun2(100)
    println("r2 : $r2")

    val r3 = testFun3(2)
    println("r3 : $r3")

    val r4 = testFun3(0)
    println("r4 : $r4")

    // break
    for (item in 1 .. 10) {
        if (item > 5) {
            break
        }
        println("item : $item")
    }

    // continue
    for (item in 1 .. 10) {
        if (item % 2 == 0) {
            continue
        }
        println("item : $item")
    }
}

fun testFun1(a1: Int) : Int {
    println("testFun1")
    // 함수를 호출하는 쪽으로 돌아갈 때 return 뒤에 작성할 값을 가져간다.
    return a1 + 100
}

fun testFun2(a1 : Int) = a1 + 100

fun testFun3(a1: Int) : Int {
    println("testFun3")

    if (a1 == 0) {
        return -1
    }

    println("이 부분이 실행될까요?")
    return 100 / a1
}