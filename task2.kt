// https://open.kattis.com/problems/evolvingetymology


fun main() {
   val k = readln().split(" ")[1].toBigInteger()
   val s = readln()
   val coef = 2.toBigInteger()
       .modPow(k, s.length.toBigInteger())
       .toInt()
   println(buildString {
       for (i in s.indices) {
           append(s[((i.toLong() * coef) % s.length).toInt()])
       }
   })
}
