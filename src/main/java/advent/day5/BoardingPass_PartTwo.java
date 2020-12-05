package advent.day5;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BoardingPass_PartTwo {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(
        new File(System.getProperty("user.dir") + "/src/main/java/advent/day5/input.txt"));
    Queue<Integer> seatIds = new PriorityQueue<>();
    while (scanner.hasNextLine()) {
      String boardingPass = scanner.nextLine();
      int minRow = 0;
      int maxRow = 128;
      for (int i = 0; i < 6; i++) {
        char part = boardingPass.charAt(i);
        if (part == 'F') {
          maxRow -= (maxRow - minRow) / 2;
        } else {
          minRow += (maxRow - minRow) / 2;
        }
      }
      int finalRow = boardingPass.charAt(6) == 'F' ? minRow : maxRow - 1;

      int minColumn = 0;
      int maxColumn = 8;
      for (int i = 7; i < 9; i++) {
        char part = boardingPass.charAt(i);
        if (part == 'L') {
          maxColumn -= (maxColumn - minColumn) / 2;
        } else {
          minColumn += (maxColumn - minColumn) / 2;
        }
      }
      int finalColumn = boardingPass.charAt(9) == 'L' ? minColumn : maxColumn - 1;
      seatIds.add((finalRow * 8) + finalColumn);
    }
    int previous = seatIds.poll();
    while (!seatIds.isEmpty()) {
      int current = seatIds.poll();
      if ((current- previous) == 2) {
        System.out.println("Found it : " + (previous + 1));
      }
      previous = current;
    }
  }
}
