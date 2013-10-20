package scala.objsets

import _root_.objsets.{GoogleVsApple, TweetReader, TweetSet}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class GoogleWithAppleTest extends FunSuite {

  trait TestSets {
    lazy val allTweets: TweetSet = TweetReader.allTweets
  }

  test("test") {
    new TestSets {
      val obj1 = GoogleVsApple.trending
      println(obj1)
    }
  }
}
