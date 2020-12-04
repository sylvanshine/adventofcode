package advent.day2;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordsCount_PartOne {
  public static void main(String[] args) throws Exception{
    Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "/src/main/java/adventofcode/day2/input.txt"));
    Pattern pattern = Pattern.compile("^(\\d+)-(\\d+)\\s([a-zA-Z]):\\s([a-zA-Z]+)");
    int validCount = 0;
    while(scanner.hasNextLine())
    {
      String line = scanner.nextLine();
      Matcher matcher = pattern.matcher(line);
      if(matcher.find()){
        int minTimes = Integer.parseInt(matcher.group(1));
        int maxTimes = Integer.parseInt(matcher.group(2));
        char charRepeat = matcher.group(3).charAt(0);
        String pass = matcher.group(4);
        int counter =0;
        for(char c : pass.toCharArray()) {
          if(charRepeat == c){
            counter++;
          }
          if(counter > maxTimes){
            break;
          }
        }
        if(minTimes <= counter && maxTimes>= counter){
          validCount++;
        }
      }
    }
    System.out.println(validCount);
  }
}
