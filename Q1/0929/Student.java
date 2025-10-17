public class Student {
    String name;

    public Student() {
        name = "none";
    }
    public Student(String name) {
        this.name = name;
    }
    public void printName() {
        System.out.println("Student name: " + name);
    }
    public void printName(int age) {
        System.out.println("Student name: " + name + ", Age: " + age);
    }
}
