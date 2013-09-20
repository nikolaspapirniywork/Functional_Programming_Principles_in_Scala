package example

object sheet1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(188); 
  def sum(xs: List[Int]): Int = {
    def loop(sum: Int, i: Int): Int =
      if (i == xs.size) sum
      else loop(sum + xs(i), i + 1)

    loop(0, 0)
  };System.out.println("""sum: (xs: List[Int])Int""");$skip(22); val res$0 = 

  sum(List(1, 2, 3));System.out.println("""res0: Int = """ + $show(res$0));$skip(14); val res$1 = 
  sum(List());System.out.println("""res1: Int = """ + $show(res$1));$skip(11); val res$2 = 
  sum(Nil);System.out.println("""res2: Int = """ + $show(res$2));$skip(238); 

  def max(xs: List[Int]): Int = {
    def loop(currentMax: Int, i: Int): Int =
      if (i == xs.size) currentMax
      else if (xs(i) > currentMax) loop(xs(i), i + 1)
      else loop(currentMax, i + 1)
      
      loop(xs.head, 0)
  };System.out.println("""max: (xs: List[Int])Int""");$skip(22); val res$3 = 
  
  max(List(1,2,3));System.out.println("""res3: Int = """ + $show(res$3))}
}
