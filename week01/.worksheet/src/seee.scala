object seee {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(299); 
  def countChange(money: Int, coins: List[Int]): Int = {
    var eligibleCoins = coins.filter(_ <= money)

    if (money == 0)
      1
    else if (money < 0 || eligibleCoins.length == 0)
      0
    else
    	countChange(money - coins.head, coins) + countChange(money, coins.tail)
  };System.out.println("""countChange: (money: Int, coins: List[Int])Int""");$skip(30); val res$0 = 

  countChange(4, List(1, 2));System.out.println("""res0: Int = """ + $show(res$0))}
}
