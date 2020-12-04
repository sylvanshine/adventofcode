package advent.day1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumThree2020_PartTwo {
  private final static int[] leftTo2020 = new int[2020];
  private final static List<Integer> numbers = new ArrayList<>();
  private static int numberOne = 0;
  private static int numberTwo = 0;
  public static void main(String[] args) throws Exception{
    Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "/src/main/java/adventofcode/day1/input.txt"));

    while(scanner.hasNextInt())
    {
      int number = scanner.nextInt();
      if(number <= 2020 ){
        leftTo2020[2020 - number] =  number;
        numbers.add(number);
      }
    }
    for (int number : numbers) {
      if (isSum(number)) {
        System.out.println(numberOne);
        System.out.println(numberTwo);
        System.out.println(number);
        System.out.println(numberOne * numberTwo * number);
        break;
      }
    }
  }

  private static boolean isSum(int number){
    for(int numberToSum : numbers){
      int leftover = numberToSum + number;
      if(leftover < 2020  && leftTo2020[leftover] != 0){
        numberOne = numberToSum;
        numberTwo = leftTo2020[leftover];
        return true;
      }
    }

    return false;
  }
}
