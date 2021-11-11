import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;


public class Application {
  ArrayList<Marsvin> listOfMarsvin = new ArrayList<>();
  final String fileName = "Marsvin.txt";

  public static void main(String[] args) throws IOException {
    Application app = new Application();
    app.readFile();
    System.out.println(" ");
    System.out.println(app.listOfMarsvin);
    System.out.println(" ");
    app.sumGram();
  }

  private void readFile() throws IOException {
    Scanner reader = new Scanner(new File(fileName));
    while (reader.hasNext()){
      String lines = reader.nextLine();
      Marsvin marsvin = new Marsvin();
      marsvin.setDataFromFileLine(lines);
      listOfMarsvin.add(marsvin);
      System.out.println("Indlæst marsvin: "+ marsvin);
    }
  }

private void sumGram() throws IOException{
    ArrayList<String> marsvinArrayList = new ArrayList<>();
    marsvinArrayList.add(String.valueOf(listOfMarsvin));
    int sum = 0;
  for (String findGram : marsvinArrayList) {
    String gram = findGram.substring(findGram.indexOf("Vægt: ")+6);
    gram = gram.substring(0,gram.indexOf(" "));
    int gramSum = Integer.parseInt(gram);
    sum = sum + gramSum;
  }
  System.out.println(sum);
}

  }


