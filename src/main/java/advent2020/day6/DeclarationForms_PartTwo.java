package advent2020.day6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeclarationForms_PartTwo {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(
      new File( System.getProperty("user.dir") + "/src/main/java/advent/day6/input.txt"));

    List<String> forms = new ArrayList<>();
    long totalAnswers=0;
    StringBuilder aggr = new StringBuilder();
    while(scanner.hasNextLine()){
      String line = scanner.nextLine();
      aggr.append(line).append(" ");
      if(line.isEmpty() || !scanner.hasNextLine()){
        forms.add(aggr.toString());
        aggr = new StringBuilder();
      }
    }
    for(String form: forms){
      String base = form.substring(0, form.indexOf(" "));
      int targetCount = form.split(" ").length;
      for(int i=0 ; i <base.length(); i++){
        int count = 0;
        for(int y=0; y<form.length(); y++){
          if(form.charAt(y) == base.charAt(i))
            count++;
        }
        if(count == targetCount)
          totalAnswers++;
      }
    }
    System.out.println(totalAnswers);
  }
}
