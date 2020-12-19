package day3

import shared.loadPuzzleInput

private const val filename = "src/main/kotlin/day3/input.txt"
private const val smallTestFilename = "src/main/kotlin/day3/small_test_input.txt"

fun main(args: Array<String>) {
    val input = loadPuzzleInput(filename)
    var yIndex = 0
    var xIndex = 0
    val slopes = listOf(
        Pair(1,1),
        Pair(3,1),
        Pair(5,1),
        Pair(7,1),
        Pair(1,2)
    )
    slopes.forEach { slope ->
        var treeCounter = 0
        while(yIndex < input.size) {
            if(input[yIndex][xIndex] == '#') treeCounter++
            xIndex = (xIndex + slope.first) % input.first().length
            yIndex += slope.second
        }
        xIndex = 0
        yIndex = 0
        println("$slope $treeCounter")
    }

}