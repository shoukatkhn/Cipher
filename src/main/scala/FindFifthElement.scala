package Cipher

/**
  * For a single-linked (forward only) list write a function that returns 5th element from the end of the list.
  * The list can only be walked once (reverse, length, or size of this list cannot be used)
  */

case class Node(data: Int, next: Option[Node])
object Node {
  def apply(x: Int): Node = this(x, None)
  /*
    using an array eases adding nodes from test perspective
   */
  def apply(arr: Array[Int]): Node = {
    arr.reverse.tail
      .foldLeft(Node(arr.head)) {
        (n,d) => new Node(d, Some(n))
      }
  }
}

object FindFifthElement {
  def getFifthElement(head: Node, elementFromTail:Int = 5): Node = {
    var count = 1
    var node = head
    var nextNode = head

    do {
      if (count >= elementFromTail) {
        node = node.next.get
      }
      nextNode = nextNode.next.get
      count = count + 1
    } while (nextNode.next.isDefined)

    node
  }

  def main(args: Array[String]): Unit = {
    val arr = Node(Array(1,2,3,4,5,6,7,8,9,10))
    getFifthElement(arr)
  }
}



