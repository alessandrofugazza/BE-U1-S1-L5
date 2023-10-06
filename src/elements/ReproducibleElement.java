package elements;

public abstract class ReproducibleElement extends MultimediaElement {
    protected int length;
    protected int volume = 10;

    final private int minVolume = 0;
    final private int maxVolume = 10;

    public ReproducibleElement(String title, int length) {
        super(title);
        this.length = length;
    }
    public abstract void play();

    public void abbassaVolume() {
        if (this.volume == minVolume) {
            System.out.println("Volume already at minimum.");
        } else {
            this.volume -= 1;
        }
    }

    public void alzaVolume() {
        if (this.volume == maxVolume) {
            System.out.println("Volume already at maximum.");
        } else {
            this.volume += 1;
        }
    }
}
