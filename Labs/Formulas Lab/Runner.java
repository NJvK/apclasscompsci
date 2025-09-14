public class Runner {
    public static void main(String[] args) {
        Fromulas formulas = new Fromulas();
        System.out.println("Formulas Lab");
        while (formulas.getChoice() != 0){
            System.out.println("Make a selection from the following: \n 1. Cercumfrance of a Circle \n2. Area of a Circle \n3. Area of a Square \n4. Area of a Triangle \n 5. Area of a Rectangle \n6. perimeter of a Rectangle \n7. preimeter of a Square \n8. average of two numbers \n9. pythagorean theorem \n10. volume of a cone \n11. volume of a cylinder \n12. volume of a sphere \n13. volume of a pyramid \n14. surface area of a sphere \n15. area of a trapizoid");
            formulas.setVariable();
            if (formulas.getChoice() == 1){
                formulas.c();
            } else if (formulas.getChoice() == 2){
                formulas.a();
            } else if (formulas.getChoice() == 3){
                formulas.s();
            } else if (formulas.getChoice() == 4){
                formulas.t();
            } else if (formulas.getChoice() == 5){
                formulas.r();
            } else if (formulas.getChoice() == 6){
                formulas.p();
            } else if (formulas.getChoice() == 7){
                formulas.pS();
            } else if (formulas.getChoice() == 8){
                formulas.average();
            } else if (formulas.getChoice() == 9){
                formulas.pythagorean();
            } else if (formulas.getChoice() == 10){
                formulas.vCone();
            } else if (formulas.getChoice() == 11){
                formulas.cimport();
            } else if (formulas.getChoice() == 12){
                formulas.define();
            } else if (formulas.getChoice() == 13){
                formulas.vPyraimid();
            }else if (formulas.getChoice() == 14){
                formulas.sSphere();
            } else if (formulas.getChoice() == 15){
                formulas.aTrapizoid();
            } else if (formulas.getChoice() == 0){
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice");
            }
         }
    }
}
