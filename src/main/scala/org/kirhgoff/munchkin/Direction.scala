package org.kirhgoff.munchkin

abstract class Direction
case class North() extends Direction
case class East() extends Direction
case class South() extends Direction
case class West() extends Direction

object Direction {
  def clockwise = List(North, East, South, West)
}

