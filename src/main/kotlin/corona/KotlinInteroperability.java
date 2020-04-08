package corona;

public class KotlinInteroperability {

  public static void main(String [] args) {
    InfectionState borisState = new InfectionState(true, false);
    Person person = new Person("Boris", 55, borisState);
    System.out.println(PersonKt.lastChar(person.getName()));
  }
}
