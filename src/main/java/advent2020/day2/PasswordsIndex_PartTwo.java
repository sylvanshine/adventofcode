package advent2020.day2;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordsIndex_PartTwo {
  public static void main(String[] args) throws Exception{
    Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "/src/main/java/advent/day2/input3.txt"));
    Pattern pattern = Pattern.compile("^(\\d+)-(\\d+)\\s([a-zA-Z]):\\s([a-zA-Z]+)");
    int validCount = 0;
    while(scanner.hasNextLine())
    {
      String line = scanner.nextLine();
      Matcher matcher = pattern.matcher(line);
      if(matcher.find()){
        int indexOne = Integer.parseInt(matcher.group(1));
        int indexTwo = Integer.parseInt(matcher.group(2));
        char charToCheck = matcher.group(3).charAt(0);
        String pass = matcher.group(4);
        if(!(pass.charAt(indexOne-1) == charToCheck && pass.charAt(indexTwo-1) == charToCheck)  &&
            (pass.charAt(indexOne-1) == charToCheck || pass.charAt(indexTwo-1) == charToCheck)){
          validCount++;
        }
      }
    }
    System.out.println(validCount);
  }
}
