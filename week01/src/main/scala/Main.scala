

object Main {
  def pascal(col: Int, row: Int) : Int = {
    if(col <= 0 || row <= 0 || row <= col) 1
    else pascal(col, row - 1) + pascal(col - 1, row - 1)
  }

}