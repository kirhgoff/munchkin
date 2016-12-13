package org.kirhgoff.munchkin

import java.io.PrintWriter
import java.util.Scanner
import scala.util.control.Breaks._

class UserCommandsReader(val output:PrintWriter) extends Runnable{
  val scanner = new Scanner(System.in)
  override def run() = {
    while(true) {
      val command = scanner.next()
      println(s"user>$command")
      output.println(command)
      output.flush()
      if (command.equals("quitnow")) break
    }
    println("system> Quit reader")
  }
}
