package elements;

public class VideoElement extends ReproducibleElement implements Brightness {
    private int brightness = 10;
    public VideoElement (String title, int length) {
        super(title, length);
    }

    public void aumentaLuminosita() {
        if (this.brightness == MAX_BRIGHTNESS) {
            System.out.println("Brightness already at minimum.");
        } else {
            this.brightness += 1;
        }
    }

    public void diminuisciLuminosita() {
        if (this.brightness == MIN_BRIGHTNESS) {
            System.out.println("Brightness already at minimum.");
        } else {
            this.brightness -= 1;
        }
    }

    public void play() {
        String exclamationMarks = "";
        for (int i = 0; i < this.volume; i++) {
            exclamationMarks+="!";
        }
        String asterisks = "";
        for (int i = 0; i < this.brightness; i++) {
            asterisks+="*";
        }
        for (int i = 0; i < this.length; i++) {
            System.out.println(this.title + exclamationMarks + asterisks);
        }
    }

}
