import kotlin.math.abs

fun main() {

    fun nextLevelSafe(first: Int, second: Int, shouldIncrease: Boolean): Boolean {
        var safe = true
        if (shouldIncrease && first > second) safe = false
        if (!shouldIncrease && first < second) safe = false
        if (abs(first - second) < 1) safe = false
        if (abs(first - second) > 3) safe = false
        return safe
    }

    fun part1(input: List<String>): Int {
        var result = 0
        for (line in input) {
            var safe = true
            val values = convertToIntList(line)
            val increasing = values[0] < values[1]
            for (i in 1..<values.size) {
                val first = values[i-1]
                val second = values[i]
                safe = safe && nextLevelSafe(first, second, increasing)
            }
            if (safe) result++
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0
        for (line in input) {
            var safe = true
            val values = convertToIntList(line)
            val increasing = values[0] < values[1]
            for (i in 1..<values.size) {
                val first = values[i-1]
                val second = values[i]
                safe = safe && nextLevelSafe(first, second, increasing)
            }
            if (safe) result++
            else for (i in values.indices) {
                safe = true
                val newList = removeElementAtIndex(values, i)
                for (j in 1..<newList.size) {
                    val first = newList[j-1]
                    val second = newList[j]
                    safe = safe && nextLevelSafe(first, second, increasing)
                }
                if (safe) {
                    result++
                    break
                }
            }
        }
        return result
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("3   4", "4   3", "2   5", "1   3", "3   9", "3   3")) == 11)

    // Or read a large test input from the `src/Data_test.txt` file:
    val testInput = readInput("Data_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    // Read the input from the `src/Data.txt` file.
    val input = readInput("Data")
    part1(input).println()
    part2(input).println()
}
