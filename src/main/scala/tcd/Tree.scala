package tcd

import scala.math.Ordering

enum Tree[T] derives Eq: // , Ordering, Show:
  case Branch(left: Tree[T], right: Tree[T])
  case Leaf(elem: T)

