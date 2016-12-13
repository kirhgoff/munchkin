package org.kirhgoff.munchkin

import java.io.BufferedReader

class MudLorePrinter(val input:BufferedReader) extends Runnable{
  override def run() = {
    var line = input.readLine()
    while (line != null) {
      println(s">$line")
      line = input.readLine()
    }
    println("system> Quit printer")
  }
}
