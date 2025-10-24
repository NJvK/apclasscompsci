public class Animal {
    private String name;
    private String type;
    private int age;

    public Animal(String type, String name, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }
    public String toString() {
        return "Animal [name=" + name + ", type=" + type + ", age=" + age + "]";
    }
    public String setName() {
        return String.valueOf(name);
    }
    public String getAge() {
        return Integer.toString(age);
    }
}
