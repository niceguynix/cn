import java.io.*;   
import java.net.*;

public class Server {
  public static void main(String args[]) {
    try {
      ServerSocket s = new ServerSocket(8080);
      Socket s1 = s.accept();
      DataInputStream din = new DataInputStream(s1.getInputStream());
      String str = (String) din.readUTF();
      System.out.println("message:" + str);
      DataOutputStream x = new DataOutputStream(s1.getOutputStream());
      x.writeUTF(str);
      din.close();
      s.close();
      s1.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
