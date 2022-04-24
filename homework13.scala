object homework extends eecs.cs384 {

  def userName: String = "Bonvie Fosam"

  // DOCUMENTATION SIGNATURE BLOCK GOES HERE
  // CDT Matthias Williams. B-1 '22. Assistance given to the author verbal discussion. CDT Williams heavily provided
  // assistance to me throughout problems two through four in this homework assignment. Before reaching out to
  // him, I was primarily stuck on translating my of the code into code itself. His assistance to me on problems
  // two, three, and four is as descibed below:
  // Problem Two: Before reaching out to CDT Williams, I knew to compare each word in the word list to each other
  // and apply the differByOneLetter function. I was struggling, however, to properly iterate two words to compare them.
  // CDT Williams recommended to be to use a nested while loop to store two words at once. He helped me understand the general
  // structure of this methodology. From there, I was able to construct the code myself.
  // Problem three: In trying to solve this function, I was trying to refer to the BFS algorithm. CDT Williams advised me the
  // that Dijkstra's algorithm could be used to solve the function. I started by copying the function from the course lesson page
  // manipulating the code so that it fit the undirected and unweighted nature of the problem.
  // Problem Four: CDT Williams advised me that I would need a helper function to solve the problem and he helped me recognize that the
  // shortestLadder function could be implemented as the helper function with some slight tweaks. From there, from there I was able to try
  // and manipulate the helper function so that it would not end at the shortest path.
  // CDT Williams did not do any of the coding for me, rather he coached me through solving the problems.
  // All other ideas on this homework were my own. After receiving his assistance, I completed this homework to the best of my
  // ability. 04MAY21. West Point, NY.

  type Word = String // Words are four-letter (uppercase) strings
  import scala.collection.mutable._ // Use mutable Maps, Queues, Sets, Stacks

  // Builds an adjacency-list representation of all four-letter words - an edge
  // exists between any two words if they differ by one letter.
  // USE THIS GRAPH IN YOUR wordLadder AND longestShortestWordLadder FUNCTIONS!
  val foursGraph: Map[Word, List[Word]] = buildWordGraph(Words.fours)

  def differByOneLetter(w1: Word, w2: Word): Boolean = {
    var off = 0
    for(i <- 0 to 3){ if(w1.charAt(i) != w2.charAt(i)) {off += 1} }
    off == 1
  }

  def buildWordGraph(words: List[Word]): Map[Word, List[Word]] = {
    val result = Map[Word, List[Word]]()
    var myList = words
    for(i <- words) {result(i) = List[Word]()}
    while(myList.nonEmpty){
      var myListTwo = myList.tail
      while(myListTwo.nonEmpty) {
        val wordOne = myList.head
        val wordTwo = myListTwo.head
        if (differByOneLetter(wordOne, wordTwo) == true) {
          result(wordOne) = wordTwo :: result(wordOne)
          result(wordTwo) = wordOne :: result(wordTwo)
        }
        myListTwo = myListTwo.tail
      }
      myList = myList.tail
    }
    result
   }

  def shortestLadder(start: Word, end: Word): List[Word] = {
    var result = List[Word]()
    val visited = Set.empty[Word]
    val queue = Queue[List[Word]](List[Word](start))
    while (queue.nonEmpty && result.isEmpty) {
      val current = queue.dequeue()
      if(current.head == end){
        result = current.reverse
      }
      else if (visited.add(current.head)) {
        for (nextWord <- foursGraph(current.head) if !visited(nextWord)) {
          queue.enqueue(nextWord :: current)
        }
      }
    }
    result
  }

  // change "ignoretest" to "test" when you are ready to test
  test("shortestLadder", testShortestLadder _, "start", "end")

  def longestShortestLadder: List[Word] = {
    def helper(start: Word): List[Word] = {
      var result = List[Word]()
      val visited = Set.empty[Word]
      val queue = Queue[List[Word]](List[Word](start))
      while (queue.nonEmpty) {
        val current = queue.dequeue()
        result = current
        if (visited.add(current.head)) {
          for (nextWord <- foursGraph(current.head) if !visited(nextWord)) {
            queue.enqueue(nextWord :: current)
          }
        }
      }
      result
    }
    var curr_max = 0
    var max_list = List[Word]()
    var list = List[Word]()
    for (i <- Words.fours) { //Words.fours
      list = helper(i)
      val len = list.length
      if(len > curr_max) {
        curr_max = len
        max_list = list
      }
    }
    max_list
  }

  // change "ignoretest" to "test" when you are ready to test
  test("longestShortestLadder", testLongestShortestLadder _, "ignore", 35000)

     /*def helper(start: Word): (List[Word], Int) = {
      var result = (List[Word](), Int)
      val visited = Set.empty[Word]
      //val count = 0
      val queue = Queue[(List[Word], Int)](List[Word](start, 1))
      while (queue.nonEmpty) {
        val (current, count) = queue.dequeue()
        result = (current.reverse, count)

        if (visited.add(current.head)) {
          for (nextWord <- foursGraph(current.head) if !visited(nextWord)) {
            queue.enqueue((nextWord :: current), count + 1)
          }
        }
      }
      (result, count) //
    }
    var curr_max = 0
    for (i <- Words.fours) { //Words.fours
      var (list, max) = helper(i)
      if(max > curr_max) {curr_max = max}
    }
    list*/


  // DO NOT CHANGE ANYTHING BELOW THIS LINE
  def getLadderString(ladder: List[String]): String = {
    if (ladder.isEmpty) "(0)"
    else s"(${ladder.length}) ${ladder.mkString(" ")}"
  }
  def testShortestLadder(start: String, end: String): (Int, Boolean) = {
    val ans = shortestLadder(start, end)
    print(s"\n$start -> $end: ${getLadderString(ans)} ")
    (
      ans.length,
      ans
        .zip(ans.drop(1))
        .foldLeft(true)((a, t) => {
          a && (0 until 4).foldLeft(0)((b, i) =>
            b + (if (t._1(i) == t._2(i)) 1 else 0)
          ) == 3
        })
    )
  }
  def testLongestShortestLadder(unused: Int): (Int, Boolean) = {
    val ans = longestShortestLadder
    print(s"LONGEST SHORTEST: ${getLadderString(ans)} ")
    (
      ans.length,
      ans
        .zip(ans.drop(1))
        .foldLeft(true)((a, t) => {
          a && (0 until 4).foldLeft(0)((b, i) =>
            b + (if (t._1(i) == t._2(i)) 1 else 0)
          ) == 3
        })
    )
  }
}
