public class Animal {
    private String animalType;
    private int age;

    public void setVariable(){
        animalType = "Dog";
        age = 5;
    }
    public void dogInfo(){
        System.out.println("Animal Type: " + animalType);
        System.out.println("Age: " + age);
    }
}
