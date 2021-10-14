fun alternate(s: String): Int {
    val FAIL = 0
    //
    if (s.length == 1) return FAIL // + 100
        
    // Convert the string into array of letters
    var arr = s.toCharArray()
    
    // Find the amount of distinct letters used in the string
    val set = arr.toMutableSet()
    //
    if (set.size == 1) return FAIL // + 200
    
    // Identify letters that are already compromised (i.e. they go together already)
    var mustContinue: Boolean = true
    outerLoop@ while(mustContinue) {
               
        // check whether it can continue
        if (arr.size < 2) return FAIL // + 300
        if (set.size == 1) return FAIL //  + 400
        
        innerLoop@ for (i in 0..arr.lastIndex-1) {
            // Two identical letters go one after another
            if (arr[i] == arr[i + 1]) {
                val letterToRemove = arr[i]
                val arrAfterRemoval = arr.filter { it != letterToRemove }.toCharArray()
                arr = arrAfterRemoval
                set.remove(letterToRemove)
                // Restart the outer loop with the new sequence of letters
                continue@outerLoop
            }
        }
        // Stop the outer loop
        mustContinue = false
    }
    
    // Lets find out the frequences of the given letters
    var freqArr: Array<Pair<Char, Int>> = arrayOf()
    for (item in set) {
        freqArr += (Pair(item, arr.filter{ it == item }.size))
    }
    // Sort the array of frequencies in descending order
    freqArr.sortWith(compareBy { -it.component2() })
    
    // So far the best solution to the problem is FAIL
    var bestSolution: Int = FAIL // 0
    
    // From here we can start composing strings using only two letters at the time
    firstLoop@ for (i in 0..freqArr.lastIndex) {
        val letter1 = freqArr[i].component1()
        val freq1 = freqArr[i].component2()
        
        secondLoop@ for (ii in i..freqArr.lastIndex) {
            val letter2 = freqArr[ii].component1()   
            val freq2 = freqArr[i].component2()
            if (freq1 + freq2 < bestSolution) {
                // Don't waste the effort, change the first letter
                continue@firstLoop
            }
            
            // Reduce the sequence of letters and check its suitability
            val reducedArr = arr.filter { it == letter1 || it == letter2 }
            for (ind in 0..reducedArr.lastIndex-1) { 
                if (reducedArr[ind] == reducedArr[ind + 1]) {
                    // Don't waste the effort, change the second letter
                    continue@secondLoop
                }
            }
            
            // Did it find a better solution?
            bestSolution = if (reducedArr.size > bestSolution) reducedArr.size else bestSolution
        }
    }  
    return bestSolution
}

fun main() {
    println(alternate("asdcbsdcagfsdbgdfanfghbsfdab"))  
}
