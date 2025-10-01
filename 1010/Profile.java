public class Profile {
    String name;
    int age;

    public Profile() {
        this.name = "Blank";
        this.age = 0;
    }
    public Profile(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void printName(){
        System.out.println("Name: " + this.name);
    }
    public void printAge(){
        System.out.println("Age: " + this.age);
    }
}
