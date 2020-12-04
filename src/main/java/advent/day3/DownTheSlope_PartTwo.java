package advent.day3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DownTheSlope_PartTwo {
    static int trees = 0;
    static long multipliedTrees=1;
    static int slopePatternLength=0;
    public static void main(String[] args) throws Exception{
      Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "/src/main/java/adventofcode/day3/input.txt"));
      List<List<Character>> slope = new ArrayList<>();
      int[][] steps =  {{1,1}, {3,1}, {5,1}, {7,1}, {1,2}};

      while(scanner.hasNextLine())
      {
        slope.add(scanner.nextLine().chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
      }
      if(!slope.isEmpty()){
        slopePatternLength = slope.get(0).size();
        for(int[] step: steps){
          trees=0;
          goDown(slope, 0, 0,step[0],step[1]);
          if(trees != 0){
            multipliedTrees*=trees;
          }
        }
      }

      System.out.println(multipliedTrees);
    }

    private static void goDown(List<List<Character>> slope, int x, int y , int xMove, int yMove){
      if(slope.get(y).get(x) == '#'){
        trees++;
      }

      if(slope.size() > y+yMove){
        if ((x+xMove) >= slope.get(0).size()){
          x = (x+xMove) % slope.get(0).size();
        } else {
          x+=xMove;
        }
        goDown(slope, x, y+yMove, xMove, yMove);
      }

    }
}
