package advent2020.day3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DownTheSlope_PartOne {
    static int trees = 0;
    static int slopePatternLength=0;
    public static void main(String[] args) throws Exception{
      Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "/src/main/java/advent/day3/input3.txt"));
      List<List<Character>> slope = new ArrayList<>();
      while(scanner.hasNextLine())
      {
        slope.add(scanner.nextLine().chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
      }
      if(!slope.isEmpty()){
        slopePatternLength = slope.get(0).size();
        goDown(slope, 0, 0);
      }

      System.out.println(trees);
    }

    private static void goDown(List<List<Character>> slope, int x, int y ){
      if(slope.get(y).get(x) == '#'){
        trees++;
      }

      if(slope.size() > y+1){
        if ((x+3) >= slope.get(0).size()){
          x = (x+3) % slope.get(0).size();
        } else {
          x+=3;
        }
        goDown(slope, x, y+1);
      }

    }
}
