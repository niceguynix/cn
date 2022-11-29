import java.io.*;
import java.net.*;

public class Server {
  public static void main(String args[]) throws Exception {
    // establishing the connection with the server
    ServerSocket sersock = new ServerSocket(5000);
    System.out.println("Server ready for connection");
    Socket sock = sersock.accept();
    System.out.println("Connection is successful and wating for chatting");
    InputStream istream = sock.getInputStream();
    BufferedReader fileRead =
        new BufferedReader(new InputStreamReader(istream));
    String fname = fileRead.readLine();
    // reading file contents
    BufferedReader contentRead = new BufferedReader(new FileReader(fname));
    OutputStream ostream = sock.getOutputStream();
    PrintWriter pwrite = new PrintWriter(ostream, true);
    String str;
    while ((str = contentRead.readLine()) != null) {
      pwrite.println(str);
    }
    sock.close();
    pwrite.close();
    fileRead.close();
    contentRead.close();
    sersock.close();
  }
}