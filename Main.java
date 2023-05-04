/*
Написати мінімальний клас студент, який має: ідентифікатор студента (тобто, унікальний), ім'я, прізвище.
Написати клас, який репрезентує групу студентів з наступними полями:
староста (тип студент)
список студентів (тип студент)
список завдань
Група не може існувати без старости.
Методи класу:
змінити старосту
додати/видалити/перейменувати студента,
додати завдання (для всієї групи)
позначити завдання як виконане (для зазначеного студента)
Староста та студенти є об'єктами класу студент.
Завдання є простими рядками (приклад: вивчити інкапсуляцію).
Зробити цей клас максимально інкапсульованим.
Забезпечити максимальну безпеку стану класу.
 */

public class Main {

  public static void main(String[] args) {
    Student student1 = new Student("Agata", "Christie");
    Student student2 = new Student("Artur", "Conan Doyle");
    String task1 = "Learn encapsulation";
    String task2 = "Translate article";

    System.out.println(student1);
    System.out.println(student2);

    Group group = new Group(student1);
    group.addStudent(student1);
    group.addStudent(student2);
    group.deleteStudent(student1);
    group.setLeader(student2);
    group.deleteStudent(student1);
    group.deleteStudent(student2);
    group.setLeader(student1);
    group.deleteStudent(student2);
    group.deleteStudent(student2);
    group.renameStudent(student2, "Oscar", "Wilde");
    group.renameStudent(student1, "Oscar", "Wilde");
    group.addStudent(student2);

    group.addTask(task1);
    group.addTask(task2);
    group.completeTaskForStudent("Learn encapsulation", student1);
    group.completeTaskForStudent(task1, student1);
    group.completeTaskForStudent(task1, student2);
    group.completeTaskForStudent("translate", student1);
    group.completeTaskForStudent(task2, student1);
    group.deleteStudent(student2);
    group.completeTaskForStudent(task2, student2);

    System.out.println("****** Group Info *******");
    System.out.println("Leader - "+group.getLeader());
    System.out.println("List of students - "+group.getStudents());
    System.out.println("Tasks:");
    group.getTasks();

  }

}
