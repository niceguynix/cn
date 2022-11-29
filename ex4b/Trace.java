import java.io.*;
import java.util.*;
public class Trace {
  public static void main(String[] arg) {
    try {
      Process proc = Runtime.getRuntime().exec("tracert www.yahoo.com");
      BufferedInputStream stream =
          new BufferedInputStream(proc.getInputStream());
      int data = 0;
      while ((data = stream.read()) > 0) {
        System.out.print((char) data);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
