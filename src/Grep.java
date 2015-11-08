import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep {
  public static ArrayList<String> searchFile(String filename, Pattern pattern) {
    ArrayList<String> result = new ArrayList<String>();
    File file = new File(filename);
    int i = 0;
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
      String line;
      while ((line = reader.readLine()) != null) {
        if (searchLine(line, pattern, result)) {
          result.add(String.format("%d\n%s", i++, line));
        }
      }
    } catch (java.io.IOException e) {
      return null;
    }
    return result.size() > 0 ? result : null;
  }

  private static boolean searchLine(String line, Pattern pattern, ArrayList<String> results) {
    Matcher m = pattern.matcher(line);
    if (m.find()) {
      return true;
    } else return false;
  }

}
