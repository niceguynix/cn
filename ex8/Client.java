import java.io.*;
import java.net.*;

class Client {
  public static DatagramSocket ds;
  public static int clientport = 789, serverport = 790;
  public static void main(String args[]) throws Exception {
    byte buffer[] = new byte[2048];
    ds = new DatagramSocket(serverport);
    BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("server waiting");
    InetAddress ia = InetAddress.getLocalHost();
    while (true) {
      System.out.println("Client:");
      String str = dis.readLine();
      if (str.equals("end"))
        break;
      buffer = str.getBytes();
      ds.send(new DatagramPacket(buffer, str.length(), ia, clientport));
      buffer = new byte[2048];
      DatagramPacket p = new DatagramPacket(buffer, 15);
      ds.receive(p);
      String psx = new String(p.getData(), 0, p.getLength());
      System.out.println("Server:" + psx);
    }
  }
}
