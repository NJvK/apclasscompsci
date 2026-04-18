import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {

        ArrayList<LanguageInterface> myLanguages = new ArrayList<LanguageInterface>();

        myLanguages.add(new Spanish());
        myLanguages.add(new French());
        myLanguages.add(new English());
        myLanguages.add(new Italian());

        for (LanguageInterface each : myLanguages) {
            System.out.println(each.getAuthor());
            System.out.println(each.getHello());
            System.out.println(each.getBye());
            System.out.println(each.getThankYou());
            System.out.println();
        }
    }
}