import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
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
public class Group {

  private Student leader;
  private List<Student> students;
  private Map<String, Set<Student>> tasks;

  public Group(Student leader) {
    this.leader = leader;
    students = new ArrayList<>();
    addStudent(leader);
    tasks = new HashMap<>();
  }

  public String getLeader() {
    return leader.toString();
  }

  public String getStudents() {
    return Arrays.toString(students.toArray());
  }

  public void getTasks() {
    for (Entry entry: tasks.entrySet()) {
      System.out.printf("Task '%s' completed by %s\n",
          entry.getKey(),  Arrays.toString(((Set) entry.getValue()).toArray()));
    }
  }

  public void setLeader(Student leader) {
    this.leader = leader;
    if (!students.contains(leader)) {
      students.add(leader);
    }
    System.out.println("Leader was successfully changed");
  }

  public void addStudent(Student student){
    if (!students.contains(student)){
      students.add(student);
      System.out.println("Student was successfully added to group");
    } else {
      System.out.println("Unable to add. Student already exists in group");
    }
  }

  public void deleteStudent(Student student){
    if (student.equals(leader)){
      System.out.println("Leader cannot be deleted. Change him/her first");
    } else {
      System.out.println( students.remove(student)
          ? "Student was successfully deleted"
          : "Unable to delete. Student is not in the group");
    }
  }

  public void renameStudent(Student student, String newFirstName, String newLastName){
    if (!students.contains(student)) {
      System.out.println("Unable to rename. Student is not in the group");
    } else {
      String oldName = student.getFirstName() + " " +student.getLastName();
      student.setFirstName(newFirstName);
      student.setLastName(newLastName);
      System.out.printf("%s was renamed to %s\n", oldName, students.get(students.indexOf(student)));
    }
  }

  public boolean isStudentInGroup(Student student){
    return students.contains(student);
  }

  public void addTask(String task){
    if (tasks.containsKey(task)) {
      System.out.printf("Unable to add '%s'. Task already exists\n", task);
    } else {
      tasks.put(task, new HashSet<>());
      System.out.printf("Task '%s' was successfully added\n", task);
    }
  }

  public boolean isTaskInList(String task){
    return tasks.containsKey(task);
  }

  public void completeTaskForStudent(String task, Student student){
    if (tasks.containsKey(task) & students.contains(student)) {
      System.out.println( tasks.get(task).add(student)
          ? String.format("Task '%s' was successfully completed by %s", task, student)
          : String.format("Student %s has already completed task '%s'", student, task));
    } else {
      System.out.printf("Unable to complete '%s' for %s. Check the existence of task and student in group\n", task, student);
    }
  }

}
