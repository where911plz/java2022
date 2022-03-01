package kr.mjc.jacob.basics.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {

  public static void main(String[] args) {

    try {
      BufferedReader buf = new BufferedReader(new FileReader("build.gradle"));
      String line;
      while ((line = buf.readLine()) != null) {
        System.out.println(line);
      }
      buf.close();
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
