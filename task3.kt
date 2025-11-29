// https://open.kattis.com/problems/limitedlibrary
fun main() {
   fun readInts() = readln().split(" ")
       .map { it.toInt() }.toIntArray()
   val (_, _, x, y) = readInts()
   val a = readInts().apply { sort() }
   val b = readInts().apply { sort() }
   fun check(k: Int): Boolean {
       var pt = 0
       for (i in a.indices) {
           val allowed = if (i < k) y else x
           val lim = minOf(b.size, pt + allowed)
           while (pt < lim && b[pt] <= a[i]) {
               pt++
           }
       }
       return pt == b.size
   }
   var lf = -1
   var rg = a.size + 1
   while (rg - lf > 1) {
       val mid = (lf + rg) / 2
       if (check(mid)) {
           lf = mid
       } else {
           rg = mid
       }
   }
   println(if (lf == -1) "impossible" else lf)
}

