package elements;

public class ImageElement extends MultimediaElement implements Brightness {
    private int brightness = 10;
    final private int minBrightness = 0;
    final private int maxBrightness = 10;

    public ImageElement (String title) {
        super(title);
    }

    public void aumentaLuminosita() {
        if (this.brightness == maxBrightness) {
            System.out.println("Brightness already at minimum.");
        } else {
            this.brightness += 1;
        }
    }

    public void diminuisciLuminosita() {
        if (this.brightness == minBrightness) {
            System.out.println("Brightness already at minimum.");
        } else {
            this.brightness -= 1;
        }
    }

    public void show() {
        String asterisks = "";
        for (int i = 0; i < this.brightness; i++) {
            asterisks+="*";
        }
        System.out.println(this.title + asterisks);
    }
}
