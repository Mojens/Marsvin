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
    app.sumGram();
    app.printArray();
    app.printSortedArray();


  }

  private void readFile() throws IOException {
    Scanner reader = new Scanner(new File(fileName));
    System.out.println("----------------------------" +
        "-------------------------------"+"\n");
    System.out.println("Marsvin der skal indlæsses i ArrayListen:\n");
    int counter = 1;
    while (reader.hasNext()) {
      String lines = reader.nextLine();
      Marsvin marsvin = new Marsvin();
      marsvin.setDataFromFileLine(lines);
      listOfMarsvin.add(marsvin);
      System.out.println("Marsvin "+counter+++": " + marsvin);
    }
    System.out.println("----------------------------" +
        "-------------------------------"+"\n");
  }

  private void printArray(){
    System.out.println("ArrayListen før sortering: ");
    System.out.println(listOfMarsvin.toString().replace(",","")
        .replace("[","")
            .replace("]",""));
    System.out.println("----------------------------" +
        "-------------------------------"+"\n");
  }

  private void printSortedArray(){
    System.out.println("ArrayListen efter sortering: ");
    Collections.sort(listOfMarsvin);
    System.out.println(listOfMarsvin.toString().replace(",","")
        .replace("[","")
        .replace("]",""));
    System.out.println("----------------------------" +
        "-------------------------------"+"\n");
  }

  private void sumGram() {
    //dette er summen af alle marsvins objekters weight tilsammen
    int sum = 0;
    for (Marsvin marsvin : listOfMarsvin) {
      sum = sum + marsvin.getWeight();
    }
    System.out.println("Antal Gram Foder: " + sum + "g");
    System.out.println("\n----------------------------" +
        "-------------------------------"+"\n");
  }

/*
private int sumGram1() {
  //Dette for neden er anden måde at gøre det på,
  //ved at ændre Arraylistens datatype til en Strings
  ArrayList<String> marsvinArrayList = new ArrayList<>();
  marsvinArrayList.add(String.valueOf(listOfMarsvin));

  int sum1 = 0;
  for (String findGram : marsvinArrayList) {
    for (String Clear : marsvinArrayList) {
      marsvinArrayList.toString();
      String gram = findGram.substring(findGram.indexOf("Vægt: ") + 6);
      gram = gram.substring(0, gram.indexOf(" "));
      int gramSum = Integer.parseInt(gram);
      sum1 = sum1 + gramSum;
      //s¢um1 = sum1+gram;
    }
  }
  return sum1;
}
  }

 */
}

