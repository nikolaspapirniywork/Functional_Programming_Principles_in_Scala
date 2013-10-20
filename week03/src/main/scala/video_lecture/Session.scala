package scala.video_lecture

abstract class MyBoolean {
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => MyBoolean): MyBoolean = ifThenElse(x, False)
  def || (x: => MyBoolean): MyBoolean = ifThenElse(True, x)
  def unary_! : MyBoolean = ifThenElse(False, True)

  def == (x: MyBoolean): MyBoolean = ifThenElse(x, x.unary_!)
  def != (x: MyBoolean): MyBoolean = ifThenElse(x.unary_!, x)

  def < (x: MyBoolean): MyBoolean = ifThenElse(False, x)
}

object True extends MyBoolean {
  def ifThenElse[T](t: => T, e: => T): T = t
}

object False extends MyBoolean {
  def ifThenElse[T](t: => T, e: => T): T = e
}

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Suc(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat

  def getValue: Int = getValueIter(this, 0)
  private def getValueIter(currValue: Nat, acc: Int): Int = if(currValue.isZero) acc else getValueIter(currValue.predecessor, acc + 1)
}

object Zero extends Nat {
  def isZero: Boolean = true

  def predecessor: Nat = throw new IllegalArgumentException("Negative")

  def +(that: Nat): Nat = that

  def -(that: Nat): Nat = if(that.isZero) this else throw new IllegalArgumentException("Negative")

  override def toString: String = "0"
}

class Suc(n: Nat) extends Nat {
  def isZero: Boolean = false

  def predecessor: Nat = n

  def +(that: Nat): Nat = new Suc(n + that)

  def -(that: Nat): Nat = if(that.isZero) this else n - that.predecessor

  override def toString: String = getValue.toString
}

object Session {
  def getOne: Nat = new Suc(Zero)

  def getNat(value: Int): Nat = {
    def iter(currValue: Nat, acc: Int): Nat = {
      if(acc == value) currValue else iter(currValue + getOne, acc + 1)
    }
    iter(Zero, 0)
  }

  def main(args: Array[String]) {
    println(getNat(5) + getNat(5))
    println(getNat(5) - getNat(5))
    println(getNat(5) - getNat(2))
  }
}
