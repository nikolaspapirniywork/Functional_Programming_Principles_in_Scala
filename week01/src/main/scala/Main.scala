
import scala.annotation.tailrec

object Main {
  def pascal(col: Int, row: Int): Int = {
    if (col <= 0 || row <= 0 || row <= col) 1
    else pascal(col, row - 1) + pascal(col - 1, row - 1)
  }

  def balance(chars: List[Char]): Boolean = {
    def loopOverChars(chars: List[Char], countOfOpenedParantheses: Int): Boolean = {
      if (chars.isEmpty)
        countOfOpenedParantheses == 0
      else {
        var firstChar = chars.head
        var n =
          if (firstChar == '(') countOfOpenedParantheses + 1
          else if (firstChar == ')') countOfOpenedParantheses - 1
          else countOfOpenedParantheses

        if (n >= 0) loopOverChars(chars.tail, n)
        else false
      }
    }
    loopOverChars(chars, 0)
  }

  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeAfterCheck(money: Int, coins: List[Int]): Int = {
      var eligibleCoins = coins.filter(_ <= money)

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