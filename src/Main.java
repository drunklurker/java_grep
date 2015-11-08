import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
    Pattern p = Pattern.compile("java");
    ArrayList<String> r = Grep.searchFile("src/Main.java", p);
    for (String s: r) {
      System.out.println(s);
    }
  }
}
