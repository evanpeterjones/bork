import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class bork {
  public BufferedImage pic;
  public BufferedImage newPic;
  public File output;
  private int alpha;
  private int red;
  private int green;
  private int blue;
  private int height;
  private int width;
  private int pixel;
  // later needs to be generalized, enums for filetypes, etc
  private String outFile = "output.jpg";

  public bork(Image img) {
    pic = img;
    output = new File(outFile);
    height = pic.getHeight();
    width = pic.getWidth();
    // needs solutions for different types of BufferedImages
    newPic = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);
  }
  public bork(String img) throws IOException {
    pic = ImageIO.read(new File(img));
    output = new File(outFile);
    height = pic.getHeight();
    width = pic.getWidth();
    // same here
    newPic = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);
  }

  public void run() throws IOException {
    int temp = 0; boolean done = false;
    String concat = "";
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
	temp =  pic.getRGB(i, j);
	if (temp == 0 || done) { System.out.println(concat); done = true; continue; }
	concat += getAlphaAsChar(temp);
//                getARGBfromPixel(pic.getRGB(i, j));
//                newPic.se
      }
    }	
    //   ImageIO.write(newPic, "jpg", output);
  }

  public void setPixel(int a, int r, int g, int b) {
    pixel = ((a % 255)<<24) | ((r % 255)<<16) | ((g % 255)<<8) | b % 255;
  }

  private void getARGBfromPixel(int pixel) {
    alpha = (pixel >> 24) & 0xff;
    red = (pixel >> 16) & 0xff;
    green = (pixel >> 8) & 0xff;
    blue = pixel & 0xff;
  }
  public char getAlphaAsChar(int pixel) {
    return (char) ((pixel >> 24) & 0xff);
  }
  public int getA() { return alpha; }
  public int getR() { return red;   }
  public int getG() { return green; }
  public int getB() { return blue;  }

  public static void main(String[] args) throws IOException {
    if (args.length == 0) {
      System.out.println("ERROR: Input Filename");
      System.exit(1);
    }
    //bork a = new bork(args[0]);
    bork a = new bork(args[0]);
//    a.setPixel(1, 1, 1, 1);
//    System.out.println(a.pixel);
  }
}
