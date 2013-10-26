
class Test extends org.scalatest.FunSuite {

  import Main._

  test("Exercise 1") {
    assert(fib(1) === 0)
    assert(fib(2) === 1)
    assert(fib(6) === 5)
  }

  test("Exercise 2") {
    val gt = (a: Int, b: Int) => a > b
    assert(isSorted(Array(1,2,3,4), gt))
    assert(!isSorted(Array(1,3,2,4), gt))
    assert(isSorted(Array(2), gt))
  }

  test("Exercise 3") {
    val sum = (a: Int, b: Int) => a + b
    val sumCurry = curry(sum)
    val sum3 = sumCurry(3)
    assert(sum3(4) === 7)
  }

  test("Exercise 4") {
    val sumCurry: Int => Int => Int     = (a: Int) => (b: Int) => a + b
    val sum = uncurry(sumCurry)
    assert(sum(4, 3) === 7)
  }

  test("Exercise 5") {
    val f = (s: String) => s + s
    val g = (c: Char) => c.toString
    val c = compose(f, g)
    assert(c('a') === "aa")
  }
}
