import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/$name.txt").readText().trim().lines()

/**
 * Reads lines from the given input txt file.
 */
fun convertToIntList(strings: String) = strings.split(" ").filter { it != "" }.map { it.toInt() }

/**
 * Reads lines from the given input txt file.
 */
fun removeElementAtIndex(list: List<Int>, index: Int): List<Int> {
    val result = list.subList(0, index).toMutableList()
    result += list.subList(index+1, list.size)
    return result
}

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
