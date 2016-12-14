package org.kirhgoff.munchkin

abstract class MazeCell

case class Plain() extends MazeCell //Could go to all 4 sides
case class Room(entrance:Direction) extends MazeCell //Only one entrance
case class Cell(walls:List[Direction])

case class Position(x:Int, y:Int)

//columns[rows]
class Maze(cells: Array[Array[_ >: MazeCell]]) {
  def wander (from:Position):Position = ???
  def path (from:Position, to:Position):List[Direction] = ???
}


