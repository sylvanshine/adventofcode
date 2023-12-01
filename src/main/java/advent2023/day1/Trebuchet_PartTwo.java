package advent2023.day1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trebuchet_PartTwo {

  private static final Map<String, Character> numbers = new HashMap<>();

  static {
    numbers.put("one", '1');
    numbers.put("two", '2');
    numbers.put("three", '3');
    numbers.put("four", '4');
    numbers.put("five", '5');
    numbers.put("six", '6');
    numbers.put("seven", '7');
    numbers.put("eight", '8');
    numbers.put("nine", '9');

  }

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(
        new File(System.getProperty("user.dir") + "/adventofcode/src/main/java/advent2023/day1/input1.txt"));
    long sum = 0;
    while (scanner.hasNextLine()) {

      Character first = null;
      Character last = null;
      String line = scanner.nextLine();

      System.out.println(line);
      for (int i = 0; i < line.length(); i++) {
        if (first == null && Character.isDigit(line.charAt(i))) {
          first = line.charAt(i);
        } else if (first == null) {
          for (String key : numbers.keySet()) {
            if (line.startsWith(key, i)) {
              first = numbers.get(key);
              break;
            }
          }
        }
        char last1 = line.charAt(line.length() - i - 1);
        if (last == null && Character.isDigit(last1)) {
          last = last1;
        } else if (last == null) {
          for (String key : numbers.keySet()) {
            if (line.startsWith(key, (line.length() - i - 1))) {
              last = numbers.get(key);
              break;
            }
          }
        }

        if (first != null && last != null) {
          break;
        }
      }
      System.out.println("" + first + last);
      sum += Integer.parseInt("" + first + last);

    }
    System.out.println(sum);
  }

}
