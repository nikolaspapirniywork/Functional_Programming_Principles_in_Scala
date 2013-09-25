package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c <= 0 || r <= 0 || r <= c) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def loopOverChars(chars: List[Char], countOfOpenedParantheses: Int): Boolean = {
      if (chars.isEmpty)
        countOfOpenedParantheses == 0
      else {
        def firstChar = chars.head
        def n =
          if (firstChar == '(') countOfOpenedParantheses + 1
          else if (firstChar == ')') countOfOpenedParantheses - 1
          else countOfOpenedParantheses

        if (n >= 0) loopOverChars(chars.tail, n)
        else false
      }
    }
    loopOverChars(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeAfterCheck(money: Int, coins: List[Int]): Int = {
      def eligibleCoins = coins.filter(_ <= money)

      if (money == 0)
        1
      else if (money < 0 || eligibleCoins.length == 0)
        0
      else
        countChangeAfterCheck(money - coins.head, coins) + countChangeAfterCheck(money, coins.tail)
    }

    if (money != 0)
      countChangeAfterCheck(money, coins)
    else 0
  }
}