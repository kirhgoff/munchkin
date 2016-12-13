package org.kirhgoff.munchkin;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserCommandsReader implements Runnable{
  private final Scanner scanner;
  private final OutputStream outputStream;
  private final PrintWriter writer;

  public UserCommandsReader (OutputStream outputStream) {
    this.outputStream = outputStream;
    this.writer = new PrintWriter(outputStream);
    this.scanner = new Scanner(System.in);
  }

  public void run() {
    boolean keepRunning = true;

    while(keepRunning) {
      String command = scanner.next();
      if (command.equals("quitnow")) {
        keepRunning = false;
      }
      System.out.println("user>" + command);
      writer.println(command);
      writer.flush();
    }

    System.out.println("System> Quit reader");
  }
}
