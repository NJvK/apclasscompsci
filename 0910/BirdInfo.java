public class BirdInfo {
    private String name = "Tweety";
    private Bird bird = new Bird();
    public void info() {
        bird.Speak();
        bird.DrawMe();
        System.out.println(name);
    }
}
