import java.util.ArrayList;

public class StudentRunner {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Henry", 34));
        studentList.add(new Student("Jose", 21));
        studentList.add(new Student("Carla", 21));
        studentList.add(new Student("Nancy", 19));

        int totalAge = 0;
        for (Student s : studentList) {
            totalAge += s.getAge();
        }
        System.out.println("Total age: " + totalAge);

        for (int i = studentList.size() - 1; i >= 0; i--) {
            if (studentList.get(i).getAge() == 21) {
                studentList.remove(i);
            }
        }

        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}