package advent2020.day4;

import java.io.File;
import java.util.Scanner;

public class PassportCheck_PartOne {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(
        new File(System.getProperty("user.dir") + "/src/main/java/advent/day4/input.txt"));
    int validPasses = 0;
    StringBuilder passAggr = new StringBuilder();
    while(scanner.hasNextLine()){
      String line = scanner.nextLine();
      if((line.isEmpty() && passAggr.length() != 0) || !scanner.hasNextLine()){
        if(!scanner.hasNextLine()){
          passAggr.append(line).append(" ");
        }
        String passport = passAggr.toString();
        if(passport.contains("byr:")
            && passport.contains("iyr:")
            && passport.contains("eyr:")
            && passport.contains("hgt:")
            && passport.contains("hcl:")
            && passport.contains("ecl:")
            && passport.contains("pid:")
           ){
          validPasses++;
        }
        passAggr = new StringBuilder();
      } else {
        passAggr.append(line);
      }

    }
    System.out.println(validPasses);
  }
}
