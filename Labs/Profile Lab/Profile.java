public class Profile {
    private String name;
    private int age;
    private String subject;
    private String hobby;
    private String food;
    public Profile() {
        name = "Blank";
        age = 0;
        subject = "Blank";
        hobby = "Blank";
        food = "Blank";
        printInfo();
    }
    public Profile(String name1, int age2, String subject3, String hobby4, String food5) {
        name = name1;
        age = age2;
        subject = subject3;
        hobby = hobby4;
        food = food5;
        printInfo();
    }
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Favorite Subject: " + subject);
        System.out.println("Hobby: " + hobby);
        System.out.println("Favorite Food: " + food);
        printCareer();
    }
    private void printCareer(){
        if (age < 18){
            System.out.println("Career: Student");
        }else if (age >= 18 && age < 22){
            System.out.println("Career: College Student");
        } else if (subject.equalsIgnoreCase("Math")){
            System.out.println("Career: Engineer");
        } else if (subject.equalsIgnoreCase("History")){
            System.out.println("Career: Lawyer");
        } else if (subject.equalsIgnoreCase("English")){
            System.out.println("Career: Writer");
        } else if (subject.equalsIgnoreCase("Art")){
            System.out.println("Career: Artist");
        } else if (subject.equalsIgnoreCase("Physical Education")){
            System.out.println("Career: Athlete");
        } else if (subject.equalsIgnoreCase("Computer Science")){
            System.out.println("Career: Programmer");
        } else if (subject.equalsIgnoreCase("Science")){
            System.out.println("Career: Scientist");
        } else {
            System.out.println("Career: Your choice!");
        }
    }
}
