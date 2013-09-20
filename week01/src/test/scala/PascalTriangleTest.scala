import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalTriangleTest extends FunSuite {

  test("should return correct value on first row")(assert(1 == Main.pascal(0, 0)))

  test("should return correct value on second row") {
    assert(1 == Main.pascal(0, 1))
    assert(1 == Main.pascal(1, 1))
  }

  test("should return correct value on third row") {
    assert(1 == Main.pascal(0, 2))
    assert(2 == Main.pascal(1, 2))
    assert(1 == Main.pascal(2, 2))
  }

  test("should return correct value on tenth row") {
    assert(1 == Main.pascal(0, 9))
    assert(9 == Main.pascal(1, 9))
    assert(126 == Main.pascal(4, 9))
  }
}