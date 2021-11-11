import java.util.Scanner;

public class Marsvin implements Comparable {

  private String name;
  private String race;
  private int weight;

  public Marsvin() {

  }

  public void setDataFromFileLine(String line) {
    Scanner sc = new Scanner(line); //Scanner(line).useDelimeter(",");
    // Så kan den læse hvis der ikke er mellemrum men kun komma tal

    name = sc.next();
    race = sc.next();
    weight = sc.nextInt();

    //Alternativ løsning til scanner så kan der bruges lines split
    //String [] strings = line.split(","); //"," hvis det skal deles med komma
    // og "" hvis det er med mellemrum
    //name = strings[0];
    //race = strings[1];
    //weight = Integer.parseInt(strings[2]);
  }

  @Override
  public String toString() {
    return "Navn: " + name + ", Race: " + race +
        ", Vægt: " + weight + "\n";
  }

  @Override
  public int compareTo(Object o) {
    if (o instanceof Marsvin){
      if (name.length()<((Marsvin) o).name.length()){
        return -1;
      }else if (name.length()>((Marsvin) o).name.length()){
        return 1;
      }
    }
    return 0;
  }

  public int getWeight() {
    return weight;
  }
}
