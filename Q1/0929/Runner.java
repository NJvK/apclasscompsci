public class Runner {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("Alice");
        student1.printName();
        student1.printName(15);
        student2.printName();
        student2.printName(15);
    }
}
