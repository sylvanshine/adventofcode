package advent.day1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumTwo2020_PartOne {
  private static List<Integer> numbers = new ArrayList<>();
  private static int numberOne = 0;
  public static void main(String[] args) throws Exception{
    Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "/src/main/java/advent/day1/input3.txt"));

    while(scanner.hasNextInt())
    {
      int number = scanner.nextInt();
      if(number <=  2020){
         if (isSum2020(number)){
           System.out.println(numberOne);
           System.out.println(number);
           System.out.println(numberOne * number);
           break;
         }
      }
    }
  }

  private static boolean isSum2020(int number){
    for(int numbertoSum : numbers){
      if(numbertoSum + number  == 2020){
        numberOne = numbertoSum;
        return true;
      }
    }
    numbers.add(number);
    return false;
  }

}
