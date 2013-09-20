package example

object sheet1 {
  def sum(xs: List[Int]): Int = {
    def loop(sum: Int, i: Int): Int =
      if (i == xs.size) sum
      else loop(sum + xs(i), i + 1)

    loop(0, 0)
  }                                               //> sum: (xs: List[Int])Int

  sum(List(1, 2, 3))                              //> res0: Int = 6
  sum(List())                                     //> res1: Int = 0
  sum(Nil)                                        //> res2: Int = 0

  def max(xs: List[Int]): Int = {
    def loop(currentMax: Int, i: Int): Int =
      if (i == xs.size) currentMax
      else if (xs(i) > currentMax) loop(xs(i), i + 1)
      else loop(currentMax, i + 1)
      
      loop(xs.head, 0)
  }                                               //> max: (xs: List[Int])Int
  
  max(List(1,2,3))                                //> res3: Int = 3
}