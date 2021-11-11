import java.util.Scanner;

public class Marsvin implements Comparable {
  //Kunne også have skrevet Comparable<Marsvin>, Så behøvede man ikke instanceOf.

  private String name;
  private String race;
  private int weight;
  private String unit;


  public Marsvin() {

  }

  public void setDataFromFileLine(String line) {
    Scanner sc = new Scanner(line); //Scanner(line).useDelimeter(",");
    // Så kan den læse hvis der ikke er mellemrum men kun komma tal

    name = sc.next();
    race = sc.next();
    weight = sc.nextInt();
    unit = sc.next();
/*
    Alternativ løsning til scanner så kan der bruges lines split

    String [] strings = line.split(","); //"," hvis det skal deles med komma
    og "" hvis det er med mellemrum
    name = strings[0];
    race = strings[1];
    weight = Integer.parseInt(strings[2]);

 */
  }

  @Override
  public String toString() {
    return "\n" +
        "\033[0;1m" + "Navn: " + "\033[0;0m" + name +
        "\033[0;1m" + ", Race: " + "\033[0;0m" + race +
        "\033[0;1m" + ", Vægt: " + "\033[0;0m" +
        weight + unit + "\n";
  }
  /*
  "\033[0;1m" Gør at alt tekst efter bliver BOLD
  "\033[0;0m" Den her slutter BOLD

   */

  @Override
  public int compareTo(Object o) {
    //Sorter efter størrelse af vægten
    /*
       if (o instanceof Marsvin){
      if (weight<((Marsvin) o).weight){
        return -1;
      }else if (weight>((Marsvin) o).weight){
        return 1;
      }
    }
    return 0;
     */
    //Sorter efter størelse på navn
    if (o instanceof Marsvin) {
      if (name.length() < ((Marsvin) o).name.length()) {
        return -1;
      } else if (name.length() > ((Marsvin) o).name.length()) {
        return 1;
      }
    }
    return 0;
  }

  public int getWeight() {
    return weight;
  }

  public String getUnit() {
    return unit;
  }
}
