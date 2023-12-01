package advent2023.day1;

import java.io.File;
import java.util.Scanner;

public class Trebuchet_PartOne{

  public static void main(String[] args) throws Exception{
    Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "/adventofcode/src/main/java/advent2023/day1/input1.txt"));
    long sum= 0;
    while (scanner.hasNextLine()) {
      Character first = null;
      Character last = null;
      String line = scanner.nextLine();
      System.out.println(line);
      for(int i =0 ; i<line.length(); i ++){
        if(first == null && Character.isDigit(line.charAt(i))){
          first = line.charAt(i);
        }
        char last1 = line.charAt(line.length() - i - 1);
        if(last == null && Character.isDigit(last1)){
          last = last1;
        }

        if(first != null && last != null){
          break;
        }
      }
      System.out.println("" + first + last);
      sum+= Integer.parseInt( "" + first + last);

    }
    System.out.println(sum);
  }

}
