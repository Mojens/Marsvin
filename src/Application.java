import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
  final String fileName = "Marsvin.txt";
  ArrayList<Marsvin> listOfMarsvin = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    Application app = new Application();
    app.readFile();
  }





  public void readFile() throws IOException {
    Scanner reader = new Scanner(new File(fileName));
    while (reader.hasNext()){
      String lines = reader.nextLine();
      Marsvin marsvin = new Marsvin();
      marsvin.setDataFromFileLine(lines);
      listOfMarsvin.add(marsvin);
      System.out.println("Indlæst marsvin: "+ marsvin);
    }
  }

}
