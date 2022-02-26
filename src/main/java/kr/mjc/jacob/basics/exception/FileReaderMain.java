package kr.mjc.jacob.basics.exception;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {

  public static void main(String[] args) {

    try {
      FileReader in = new FileReader("build.gradle");
      int ch;
      while ((ch = in.read()) != -1) {
        System.out.print((char) ch);
      }
      in.close();
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
