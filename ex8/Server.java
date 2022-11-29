import java.io.*;
import java.net.*;

class Server {
  public static DatagramSocket ds;
  public static byte buffer[] = new byte[2048];
  public static int clientport = 789, serverport = 790;
  public static void main(String args[]) throws Exception {
    ds = new DatagramSocket(clientport);
    System.out.println("press ctrl+c to quit the program");
    BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
    InetAddress ia = InetAddress.getLocalHost();
    while (true) {
      DatagramPacket p = new DatagramPacket(buffer, buffer.length);
      ds.receive(p);
      String psx = new String(p.getData(), 0, p.getLength());
      System.out.println("Client:" + psx);
      InetAddress ib = InetAddress.getByName(psx);
      System.out.println("Server output:" + ib.getHostAddress());
      String str = ib.getHostAddress();
      if (str.equals("end"))
        break;
      buffer = str.getBytes();
      ds.send(new DatagramPacket(buffer, str.length(), ia, serverport));
    }
  }
}