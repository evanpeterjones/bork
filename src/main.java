public class main {
  public static void main(String[] args) {
    if (args == null || !args[0].contains(".jpg"))
    {
      System.out.println("must input a filename")
	System.exit(1);
    }
    bork test = new bork(args[0]);

  }
}
