/**
  * https://www.hackerrank.com/challenges/pascals-triangle
  * Created by 212457624 on 08.07.2016.
  */
object PascalsTriangle {

  def printPascal(array: Array[Int], ln: Int) : Int = {
    if(array.length!=ln+1){
      val extendedArray=new Array[Int](array.length+1);
      extendedArray(array.length)=1
      extendedArray(0)=1
      for ( i <- 0 to (array.length - 1)) {
        print(array(i)+" ")
        if(array.length!=i+1 ){
          extendedArray(i+1)=array(i);
          extendedArray(i+1)+=array(i+1)
        }
      }
      println()
      printPascal(extendedArray,ln)
    }
    return -1;
  }

  def main(args: Array[String]) {
    for (ln <- io.Source.stdin.getLines()) {
      val array = new Array[Int](1)
      array(0)=1
      printPascal(array,ln.toInt)

    }
  }

}
