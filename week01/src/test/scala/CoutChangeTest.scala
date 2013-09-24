import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CoutChangeTest extends FunSuite {
  test("should pass video lecture example")(assert(3 == Main.countChange(4, List(1, 2))))

  test("should return zero if no money")(assert(0 === Main.countChange(0, List(1, 2))))
  
  test("should return zero if no coins")(assert(0 === Main.countChange(10, List())))
  
}