package org.kirhgoff.munchkin

import org.scalatest._

class MazeTest extends FlatSpec with Matchers {

  "Maze" should "not allow initially incorrect mazes" in {
    //Incorrect size
    an [IllegalArgumentException] should be thrownBy
      new Maze(Array(Array(Room(South())), Array(Room(North()), Room(North()))))

    //Non-closed from outside
    an [IllegalArgumentException] should be thrownBy
      new Maze(Array(Array(Plain())))

    //Incorrect walls
    an [IllegalArgumentException] should be thrownBy
      new Maze(Array(Array(Room(East()), Plain())))
  }

  it should "be able to build a path in simple" in {
    //3x1
    val maze = new Maze(Array(
      Array(Room(East()), Cell(List(North(), South())), Room(West()))
    ))
    val path = maze.path(Position(0, 0), Position(2, 0))
    path should contain allOf (East(), East())
  }

  it should "be able to build a path" in {
    //3x1
    val maze = new Maze(Array(
      Array(Room(East()), Cell(List(North(), South())), Room(West()))
    ))
    val path = maze.path(Position(0, 0), Position(2, 0))
    path should contain allOf (East(), East())
  }

  it should "find a way from normal maze" in {
    //Simple 2x2 map
    val maze = new Maze(Array(
      Array(Room(South()), Room(South())),
      Array(Cell(List(West(), South())), Cell(List(South(), East())))
    ))

    val path = maze.path(Position(0, 0), Position(1, 0))
    path should contain allOf (South(), East(), North())
  }
}