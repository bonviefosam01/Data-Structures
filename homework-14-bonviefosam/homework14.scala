object homework extends App {

  def userName: String = "Bonvie Fosam"

  // DOCUMENTATION SIGNATURE BLOCK GOES HERE
  // CDT Matthias Williams. B-1 '22. Assistance given to the author, written discussion. I reached out to CDT Williams
  // to get an opinion of the overall, general structure of my constraints. He told me that I was moving in the right direction
  // and shared with me the first couple lines of his code. From there, I used the link attached to the homework page to guide me
  // through the rest of the problem. West Point, NY. 10 MAY 2021.

  // the odd function returns true if n is odd else returns false
  def odd(n: Int): Boolean = n % 2 == 1
  // The prime function does not calculate a prime number, rather it
  // returns true if n is one of the listed prime numbers
  def prime(n: Int): Boolean = (n == 2 || n == 3 || n == 5 || n == 7)

  println(userName)
  println("----------")

  // a for loop to add all of your constraints for the squares
  // order of the constraints can make a big difference!
  for {

    n <- 1 to 9
    if n <= 4
    k = n^2
    h = k^2

    if h <= 9

    a <- 1 to 9
    b <- 1 to 9
    c <- 1 to 9
    d <- 3 to 4
    e <- 2 to 3
    f <- 1 to 9
    g <- 1 to 9
    h <- 1 to 9
    i <- 3 to 4
    j <- 1 to 9
    k <- 1 to 9
    l <- 1 to 9
    m <- 1 to 9
    //n <- 1 to 9
    o <- 1 to 4
    p <- 1 to 9

    //p = m + n + o -1



    if odd(m + n + o + p)
    a = 1
    //if odd(a)

    if prime(d)
    e = 3
    o = 2
    d = 3

    if prime(m) && m < 4 && m != 2
    m = 3
    //p = 5
    l = 4

    c = 5
    b = 8
    j = 7
    g = 3

    odds <- 8 to 12
    i = odds/2 - 1
    if i == 5
    m = 3
    l = 4


  } {
    //The following lines use string interpolation
    //make sure you use a-p as your variables for your squares!
    println(s"$a$b$c$d")
    println(s"$e$f$g$h")
    println(s"$i$j$k$l")
    println(s"$m$n$o$p")
    println("----------")
  }

}
