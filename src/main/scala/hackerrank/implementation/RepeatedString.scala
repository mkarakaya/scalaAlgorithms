package hackerrank.implementation

/**
  * Created by mokarakaya on 10.10.2016.
  */
object RepeatedString {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    var s = sc.next();
    var n = sc.nextLong();
    val as = s.filter(_ == 'a').length
    var count = (n / s.length) * as
    val mod = n % s.length
    var index = 0
    while (index != mod) {
      if (s.charAt(index).equals('a')) count += 1
      index += 1
    }
    print(count)
  }




}
