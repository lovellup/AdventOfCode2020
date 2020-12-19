package day2

import shared.loadPuzzleInput
import java.io.File

private const val filename = "src/main/kotlin/day2/input.txt"

fun main(args: Array<String>) {
    val input = loadPuzzleInput(filename)
    val regexPattern = """(\d+)-(\d+) (.): (.+)""".toRegex()
    var validCount = 0
    input.forEach {
        if (it.passwordValidPart2(regexPattern)) validCount++
    }
    println(validCount)


}

fun String.passwordValidPart1(regex: Regex): Boolean {
    val result = regex.find(this)
    val minimum = result?.groupValues?.get(1)?.toInt() ?: -1
    val maximum = result?.groupValues?.get(2)?.toInt() ?: -1
    val character = result?.groupValues?.get(3)?.first()
    val password = result?.groupValues?.get(4)
    return password?.count { it == character } in (minimum..maximum)
}

fun String.passwordValidPart2(regex: Regex): Boolean {
    val result = regex.find(this)
    val index1 = (result?.groupValues?.get(1)?.toInt() ?: -1) - 1
    val index2 = (result?.groupValues?.get(2)?.toInt() ?: -1 )- 1
    val character = result?.groupValues?.get(3)?.first()
    val password = result?.groupValues?.get(4)
    return (password?.get(index1) == character).xor(password?.get(index2) == character)
}