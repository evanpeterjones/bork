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

    public bork(String img) throws IOException {
        //TODO: take an image and set it up to be modified.
        pic = ImageIO.read(new File(img));
        output = new File("output.jpg");
        height = pic.getHeight();
        width = pic.getWidth();
        newPic = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);
    }

    public void run() throws IOException {
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                getARGBfromPixel(pic.getRGB(i, j));
                newPic.se
        ImageIO.write(newPic, "jpg", output);
    }

    public void setPixel(int a, int r, int g, int b){
        pixel = (a<<24) | (r<<16) | (g<<8) | b;
    }

    private void getARGBfromPixel(int pixel) {
        alpha = (pixel >> 24) & 0xff;
        red = (pixel >> 16) & 0xff;
        green = (pixel >> 8) & 0xff;
        blue = pixel & 0xff;
    }

    public static void main(String[] args) throws IOException {
        if (args == null) {
            System.out.println("ERROR: Input Filename");
            System.exit(1);
        }
        //bork a = new bork(args[0]);
        bork a = new bork("briggon.jpg");
        a.setPixel(1, 1, 1, 1);
        System.out.println(a.pixel);
    }
}
