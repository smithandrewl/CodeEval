package com.smithandrewl.codeeval.lowestcommonancestor

import scala.annotation.tailrec

object Main extends App {
  // Tree is an algebraic data type with values of either
  //   Node(has subtrees) or Leaf(no sub-trees)
  sealed class  Tree
  case   class  Node(val value: Int, val leftChild: Tree, val rightChild: Tree) extends Tree
  case   class  Leaf(val value: Int) extends Tree

  /*
            30
            |
          ____
          |   |
          8   52
          |
        ____
        |   |
        3  20
            |
           ____
          |   |
          10 29
   */
  val bst =
    Node(30, Node(8, Leaf(3),
                     Node(20, Leaf(10),
                              Leaf(29))),
             Leaf(52))

  // Find the common ancestor of two integers in a binary search tree
  def commonAncestor(num1: Int, num2: Int, tree: Tree): Int = {
    // Finds the path to a node containing the specified number
    @tailrec
    def iter(num: Int, tree: Tree, path: List[Int]): Option[List[Int]] = tree match {
      case Node(int, _, _) if (int == num) => Some(path) // 1. If it is a node and it is the number we are looking for
                                                         //    wrap in a Some and return it
      case Leaf(int)       if (int == num) => Some(path) // 2. If it is a Leaf and it holds the number we are looking for
                                                         //    wrap in a Some and return it
      case Node(other, left, right)        =>
        val nextTree = if (num < other) left else right
        iter(num, nextTree, other :: path)
      case Leaf(other) => None // Leaf and it does not hold the number, return None
    }

    // find number 1
    val ancestors1 = iter(num1, tree, List())
    // find number 2
    val ancestors2 = iter(num2, tree, List())

    Pair(ancestors1, ancestors2) match {
      case Pair(None, other)              => throw new IllegalStateException()
      case Pair(other, None)              => throw new IllegalStateException()
      case Pair(Some(path1), Some(path2)) => {
        path1.intersect(path2)(0)
      }
    }
  }

  def processLine(line:String): String = {
    val numbers = for {
      piece <- line.split(" ")
    } yield piece.toInt

    commonAncestor(numbers(0), numbers(1), bst).toString
  }

  val source  = scala.io.Source.fromFile(args(0))
  val lines   = source.getLines().filter(_.length > 0)

  val res = lines.map(line => processLine(line)).mkString("\n")
  print(res)
}
