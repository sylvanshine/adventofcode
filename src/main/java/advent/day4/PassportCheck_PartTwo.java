package advent.day4;

import java.io.File;
import java.util.Scanner;

public class PassportCheck_PartTwo {

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
        if(
            passport.matches(".*byr:(19[2-9]\\d|200[012])\\s+.*")
            && passport.matches(".*iyr:20(1\\d|20)\\s+.*")
            && passport.matches(".*eyr:20(2\\d|30)\\s+.*")
            && passport.matches(".*hgt:(1([5-8]\\d|9[0-3])cm|(59|6[0-9]|7[0-6])in)\\s+.*")
            && passport.matches(".*hcl:#[0-9a-f]{6}\\s+.*")
            && passport.matches(".*ecl:(amb|blu|brn|gry|grn|hzl|oth)\\s+.*")
            && passport.matches(".*pid:\\d{9}\\s+.*")
        ){
        validPasses++;
        }
        passAggr = new StringBuilder();
      } else {
        passAggr.append(line).append(" ");
      }
    }

    System.out.println(validPasses);

  }
}
