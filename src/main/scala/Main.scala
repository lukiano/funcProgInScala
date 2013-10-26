import scala.annotation.tailrec

object Main {

  /*
  EXERCISE 1 (optional): Write a recursive function to get the nth Fibonacci
  number. The first two Fibonacci numbers are 0 and 1. The nth number is always
    the sum of the previous two—the sequence begins 0, 1, 1, 2, 3, 5. Your
    definition should use a local tail-recursive function.
  */
  def fib(n: Int): Int = n match {
    case i if i <= 0 => throw new IllegalArgumentException("n must be greater than zero.")
    case 1 => 0
    case 2 => 1
    case x => fib(x - 1) + fib(x - 2)
  }

  /*
  EXERCISE 2: Implement isSorted, which checks whether an Array[A] is
sorted according to a given comparison function
   */
  def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean =
    as.length <= 1 || gt(as(1), as(0)) && isSorted(as.tail, gt)

  /*
  EXERCISE 3: Let's look at another example, currying9, which converts a
function f of two arguments into a function of one argument that partially applies
f. Here again there is only one implementation that compiles.
   */
  def curry[A,B,C](f: (A, B) => C): A => (B => C) =
    (a: A) => f(a, _)

  /*
  EXERCISE 4 (optional): Implement uncurry, which reverses the
transformation of curry. Note that since => associates to the right, A => (B
=> C) can be written as A => B => C.
   */
  def uncurry[A,B,C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b)

  /*
  EXERCISE 5: Implement the higher-order function that composes two functions.
   */
  def compose[A,B,C](f: B => C, g: A => B): A => C =
   a => f(g(a))

}
