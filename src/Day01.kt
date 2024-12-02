import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val first = ArrayList<Int>()
        val second = ArrayList<Int>()
        for (line in input) {
            val couple = line.split(" ").filter { it != "" }.map { it.toInt() }
            first.add(couple[0])
            second.add(couple[1])
        }
        first.sort()
        second.sort()

        var result = 0
        for (i in input.indices) {
            result += abs(second[i] - first[i])
        }
        return result
    }

    fun part2(input: List<String>): Int {
        val first = ArrayList<Int>()
        val second = ArrayList<Int>()
        for (line in input) {
            val couple = line.split(" ").filter { it != "" }.map { it.toInt() }
            first.add(couple[0])
            second.add(couple[1])
        }

        var result = 0
        for (i in input.indices) {
            var appears = 0
            for (j in input.indices) {
                if (first[i] == second[j]) appears++
            }
            result += first[i] * appears
        }
        return result
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(listOf("3   4", "4   3", "2   5", "1   3", "3   9", "3   3")) == 11)

    // Or read a large test input from the `src/Data_test.txt` file:
    val testInput = readInput("Data_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Data.txt` file.
    val input = readInput("Data")
    part1(input).println()
    part2(input).println()
}
