import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;

public class Client {
  public static void main(String args[]) throws Exception {
    Socket soc;
    BufferedImage img = null;
    soc = new Socket("localhost", 4000);
    System.out.println("Client is running. ");
    try {
      System.out.println("Reading image from disk. ");
      img = ImageIO.read(new File("./image.jpeg"));
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ImageIO.write(img, "jpg", baos);
      baos.flush();
      byte[] bytes = baos.toByteArray();
      baos.close();
      System.out.println("Sending image to server. ");
      OutputStream out = soc.getOutputStream();
      DataOutputStream dos = new DataOutputStream(out);
      dos.writeInt(bytes.length);
      dos.write(bytes, 0, bytes.length);
      System.out.println("Image sent to server. ");
      dos.close();
      out.close();
    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
      soc.close();
    }
    soc.close();
  }
}
