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
          passAggr.append(line);
        }
        String passport = passAggr.toString();
        if(passport.matches(".*byr:(19[2-9]\\d|20[012]).*")
            && passport.matches(".*iyr:20(1\\d|20).*")
            && passport.matches(".*eyr:20(2\\d|30).*")
            && passport.matches(".*hgt:(1([5-8]\\d|9[0-3])cm|(59|6[0-9]|7[0-6])in).*")
            && passport.matches(".*hcl:#[0-9a-f]{6}.*")
            && passport.matches(".*ecl:(amb|blu|brn|gry|grn|hzl|oth).*")
            && passport.matches(".*pid:\\d{9}.*")
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
