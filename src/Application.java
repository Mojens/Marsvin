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
    app.printArray();
    app.printSortedArray();
    app.sumGram();


  }

  private void readFile() throws IOException {
    line();
    Scanner reader = new Scanner(new File(fileName));

    System.out.println("\033[0;1m" + "Marsvin der skal indlæsses i ArrayListen:\n" + "\033[0;0m");//"\033[0;1m" gør at alt tekst efter er BOLD,
    // "\033[0;0m" gør at Teksten skal stoppe med at være BOLD
    int counter = 1;

    while (reader.hasNext()) {
      String lines = reader.nextLine();
      Marsvin marsvin = new Marsvin();
      marsvin.setDataFromFileLine(lines);
      listOfMarsvin.add(marsvin);
      System.out.println("\033[0;1m" + "Marsvin " + counter++ + "\033[0;0m" + ": " + marsvin);
    }
    line();
  }

  private void printArray() {
    System.out.println("\033[0;1m" + "ArrayListen før sortering: " + "\033[0;0m" + "\n");
    int counter = 1;

    //grunden til jeg bruger sådan en For Loop er så jeg får selve indholdet af Arrayen (Objekterne),
    // og min replacements er kun til det som ArrayListen på automatik generer
    for (int i = 0; i < listOfMarsvin.size(); i++) {
      listOfMarsvin.toString().replace(",", "")//Fjerner brackets og komma fra Arraylisten når den skal printes
          .replace("[", "")
          .replace("]", "");
      System.out.println("\033[0;1m" + "Marsvin " + counter++ + "\033[0;0m" + ": " + listOfMarsvin.get(i));
    }

   /*
   //Den her er også en måde at gøre det på, så printer du self bare arraylisten ud, hvor der er replacet, og Brackets
   System.out.println(listOfMarsvin.toString().replace(",","")//Fjerner brackets og komma fra Arraylisten når den skal printes
        .replace("[","")
            .replace("]",""));

    */

    line();
  }

  private void printSortedArray() {
    System.out.println("\033[0;1m" + "ArrayListen efter sortering: " + "\033[0;0m" + "\n");
    Collections.sort(listOfMarsvin); //Først sorter jeg min liste ved hjælp af Comparable
    int counter = 1;

    for (int i = 0; i < listOfMarsvin.size(); i++) {
      listOfMarsvin.toString().replace(",", "")//Fjerner brackets og komma fra Arraylisten når den skal printes
          .replace("[", "")
          .replace("]", "");
      System.out.println("\033[0;1m" + "Marsvin " + counter++ + "\033[0;0m" + ": " + listOfMarsvin.get(i));
    }
    System.out.println("----------------------------" +
        "-------------------------------" + "\n");
  }

  private void sumGram() {
    //dette er summen af alle marsvins objekters weight tilsammen
    int sum = 0;
    for (Marsvin marsvin : listOfMarsvin) {
      sum = sum + marsvin.getWeight();
    }
    System.out.println("\033[0;1m" + "Antal Gram Foder: " + "\033[0;0m" + "\n" + sum + "g\n");
    line();
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

  private void line() {
    System.out.println("----------------------------" +
        "-------------------------------" + "\n");
  } //Bruger til at fordele mellem printen
}

