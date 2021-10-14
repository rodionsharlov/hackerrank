/*
 * Complete the 'flippingMatrix' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
 */

fun flippingMatrix(matrix: Array<Array<Int>>): Int {
    val n = matrix.size / 2
    var sum = 0

    for (r in 0..n-1) {
        for (c in 0..n-1) {
            val v1 = matrix[r][c]
            val v2 = matrix[r][2 * n - 1 - c]
            val v3 = matrix[2 * n - 1 - r][c]
            val v4 = matrix[2 * n - 1 - r][2 * n - 1 - c]
            sum += arrayOf(v1, v2, v3, v4).max()!!
        }
    }
    return sum
}