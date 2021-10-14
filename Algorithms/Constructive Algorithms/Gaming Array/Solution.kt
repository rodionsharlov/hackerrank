/*
 * Complete the 'gamingArray' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

// Bob always plays first.
fun gamingArray(arr: Array<Int>): String {

    val winner = arrayOf("ANDY", "BOB")
    val map = mutableMapOf<Int, Int>()

    for ((index, item) in arr.withIndex())
        map[item] = index

    var turns: Int = 0
    var index: Int = arr.size
    for (key in map.keys.sortedDescending()) {
        if (map[key]!! < index) {
            turns++
            index = map[key]!!
            if (index == 0) break
        }
    }
    return winner[turns % 2]
}

fun main() {
    println(gamingArray(arrayOf(5, 7, 1, 3, 9)))
}