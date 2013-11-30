import scala.collection.JavaConversions._

object Solution {
    // Solution for http://codility.com/demo/take-sample-test/ => got 100 score
    def solution(A: Array[Int]): Int = {
        // write your code in Scala 2.10
        val length = A.length
        val sum = A.foldLeft(0L)(_ + _)
        var sumLeft = 0
        for (i <- 0 to length - 1) {
            val sumRight = sum - sumLeft - A(i)
            if (sumRight == sumLeft) return i
            sumLeft = sumLeft + A(i)
        }
        -1
    }
    

    // Solution for Prefix Set Test http://codility.com/demo/take-sample-test/ps/ => got 100 score
    def solutionPS(A: Array[Int]): Int = {
        // write your code in Scala 2.10
        val distinct = scala.collection.mutable.Set()++A
        var i = -1
        while (!distinct.isEmpty) {    
            i += 1
            if (distinct.contains(A(i))) distinct.remove(A(i))           
        }
        i
    }
}