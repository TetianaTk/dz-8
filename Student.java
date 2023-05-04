
//Написати мінімальний клас студент, який має: ідентифікатор студента (тобто, унікальний), ім'я, прізвище.

public class Student {

  private static int counter = 0;

  private int id;
  private String firstName;
  private String lastName;

  public Student(String firstName, String lastName) {
    this.id = counter;
    counter++;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public String toString() {
    return String.format("%s %s, id:%d", firstName, lastName, id);
  }

}
