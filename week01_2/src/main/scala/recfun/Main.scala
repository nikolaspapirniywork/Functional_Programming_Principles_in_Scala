package recfun

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
  def pascal(c: Int, r: Int): Int = {
    if (c <= 0 || c >= r || r <= 0)
      1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    balanceIterTailRecursive(chars, 0) == 0
  }

  private def balanceIterTailRecursive(listOfChars: List[Char], acc: Int): Int = {
    if (listOfChars.isEmpty)
      acc
    else {
      if (listOfChars.head == '(')
        balanceIterTailRecursive(listOfChars.tail, acc + 1)
      else if (listOfChars.head == ')')
        if (acc == 0) -1 else balanceIterTailRecursive(listOfChars.tail, acc - 1)
      else
        balanceIterTailRecursive(listOfChars.tail, acc)
    }
  }

  private def balanceIterRecursive(listOfChars: List[Char]): Int = {
    if (listOfChars.isEmpty)
      0
    else {
      val countOfClosedInTheEnd: Int = balanceIterRecursive(listOfChars.tail)
      if (listOfChars.head == '(' && countOfClosedInTheEnd == 0)
        -1
      else if (listOfChars.head == ')' && countOfClosedInTheEnd >= 0)
        countOfClosedInTheEnd + 1
      else if (listOfChars.head == '(')
        countOfClosedInTheEnd - 1
      else
        countOfClosedInTheEnd
    }
  }


  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def iter(sortedCoins: List[Int], sum: Int, acc: Int): Int = {
      if (sortedCoins.isEmpty) {
        acc
      } else {
        if (sum + sortedCoins.head < money)
          iter(sortedCoins, sum + sortedCoins.head, acc) + iter(sortedCoins.tail, sum, acc)
        else if (sum + sortedCoins.head > money)
          acc
        else
          acc + 1
      }
    }

    iter(coins.sortWith(_ < _), 0, 0)
  }
}
