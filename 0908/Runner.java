public class Runner {
    public static void main(String[] args){
        Dog dog = new Dog();
        Student student = new Student();
        Toy toy = new Toy();
        toy.type();
        toy.maker();
        toy.price();
        student.speak();
        student.sayID();
        dog.speak();
        dog.sayName();

    }
}
