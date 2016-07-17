package recursion

import scala.io.StdIn

/**
  * Created by 212457624 on 17.07.2016.
  */
object StringMingling {
  def printFirst(firstString: String, secondString:String) : Int ={
    if("".equals(firstString)) return -1
    print(firstString.substring(0,1)+secondString.substring(0,1))
    printFirst(firstString.substring(1),secondString.substring(1))
    return 1
  }
  def main(args: Array[String]): Unit = {
    printFirst(StdIn.readLine(),StdIn.readLine())
  }
}
