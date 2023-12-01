package advent2020.day6;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class DeclarationForms_PartOne {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(
      new File( System.getProperty("user.dir") + "/src/main/java/advent/day6/input.txt"));
    Set<Character> answers = new HashSet<>();
    long totalAnswers=0;
    while(scanner.hasNextLine()){
      String line = scanner.nextLine();
      if((line.isEmpty() && answers.size() != 0) || !scanner.hasNextLine()){
        if(!scanner.hasNextLine()){
          answers.addAll(line.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        }
        totalAnswers+=answers.size();
        answers.clear();
      } else {
        answers.addAll(line.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
      }
    }
    System.out.println(totalAnswers);
  }
}
