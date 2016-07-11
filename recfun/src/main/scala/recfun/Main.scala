package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println(balance("(()".toList))
    println(balance("))((".toList))
    println(balance("(())()()(())".toList))
    val coins: List[Int] = List(2,5,3,6)
    println("Coins : " + countChange(10, coins))
  }

  def factorial (n : Int) : Int = {
    def loop (acc : Int, n: Int) : Int =
      if (n == 0) acc
      else loop(acc * n, n-1)
    loop (1,n)
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      factorial(r) / (factorial(c) * factorial(r-c))
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def loop (accOpen : Int, chars: List[Char]) : Boolean = {
        if (chars.isEmpty) {
          if (accOpen != 0) return false else return true
        }
        if (chars.head == '(') loop (accOpen + 1, chars.tail)
        else if (chars.head == ')') {
          if (accOpen > 0) loop (accOpen - 1, chars.tail) else false
        }
        else loop (accOpen, chars.tail)
      }

      loop(0,chars)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def count (coins: List[Int], m : Int, n : Int) : Int = {
        if (n == 0) return 1
        if (n < 0) return 0
        if (m <= 0 && n >= 1) return 0
        return count(coins, m - 1, n) + count(coins, m, n - coins(m-1))
      }
      count (coins, coins.length, money)
    }
  }
