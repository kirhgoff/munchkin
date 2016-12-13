package org.kirhgoff.munchkin;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

class MudLorePrinter implements Runnable {
  private final InputStream inputStream;
  private final InputStreamReader reader;

  public MudLorePrinter(InputStream inputStream) {
    this.inputStream = inputStream;
    this.reader = new InputStreamReader(inputStream);
  }

  public void run() {
    try {
      char buffer[] = new char[1024];
      int readCount = reader.read(buffer);
      while (readCount != 0) {
        char[] actuallyRead = Arrays.copyOfRange(buffer, 0, readCount);
        String string = String.valueOf(actuallyRead);
        System.out.print(string);

        Arrays.fill(buffer, ' ');
        readCount = reader.read(buffer);
      }
      System.out.println("System> mud lore printer exited");
    } catch (Exception e) {
      System.out.println("System> mud lore printer caugth an exception");
      e.printStackTrace();
    }
  }
}
