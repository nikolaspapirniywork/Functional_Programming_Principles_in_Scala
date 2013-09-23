import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ParenthesesBalancingTest extends FunSuite {

  test("should return true if string with parentheses balanced #1") {
    assert(true == Main.balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("should return true if string with parentheses balanced #2") {
    assert(true == Main.balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
  }

  test("should return false if string with parentheses not balanced #1") {
    assert(false == Main.balance(":-)".toList))
  }

  test("should return false if string with parentheses not balanced #2") {
    assert(false == Main.balance("())(".toList))
  }
}