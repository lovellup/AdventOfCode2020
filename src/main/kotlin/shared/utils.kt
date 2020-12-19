package shared

import java.io.File

fun loadPuzzleInput(fileName: String): List<String> {
    return File(fileName).readLines(Charsets.UTF_8)
}