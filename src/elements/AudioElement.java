package elements;

public class AudioElement extends ReproducibleElement {

    public AudioElement (String title, int length) {
        super(title, length);
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
