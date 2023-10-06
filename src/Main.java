import elements.*;

public class Main {
    public static void main(String[] args) {
//        AudioElement test = new AudioElement("ciao", 3);
//        test.play();
//        test.abbassaVolume();
//        test.abbassaVolume();
//        test.abbassaVolume();
//        test.abbassaVolume();
//        test.abbassaVolume();
//        test.play();
//        VideoElement test = new VideoElement("ciao", 3);
//        test.play();
//        test.diminuisciLuminosita();
//        test.diminuisciLuminosita();
//        test.diminuisciLuminosita();
//        test.diminuisciLuminosita();
//        test.play();
        MultimediaElement[] arr = {
                new AudioElement("audio test", 3),
                new VideoElement("video test", 4),
                new ImageElement("image test")
        } ;
        for (MultimediaElement element: arr) {
            if (element instanceof ReproducibleElement) {
                ((ReproducibleElement) element).play();
            } else if (element instanceof ImageElement) { // controllo instanceof ImageElement per chiarezza di codice anche se non sarebbe necessario
                ((ImageElement) element).show();
            }
        }
    }
}
