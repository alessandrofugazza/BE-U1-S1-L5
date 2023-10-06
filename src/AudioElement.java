public class AudioElement extends ReproducibleElement {
    private int volume = 10;

    public AudioElement (String title, int length) {
        super(title, length);
    }

    public void abbassaVolume() {

    }

    public void alzaVolume() {

    }

    public void play() {
        String exclamationMarks = "";
        for (int i = 0; i < this.volume; i++) {
            exclamationMarks+="!";
        }
        for (int i = 0; i < this.length; i++) {
            System.out.println(this.title + exclamationMarks);
        }
    }

}
