/*
 Ero cosi' preso dal codice che mi sono scordato di fare i commit!!
 */

import elements.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte numberOfElements = 5;
        MultimediaElement[] mediaElements = new MultimediaElement[numberOfElements];
        Scanner input = new Scanner(System.in);
        for (byte i = 0; i < numberOfElements; i++) {
            // switch case per selezionare suffisso da mettere successivamente in una stringa (-st, -nd, -rd, -th)
            String ordinalIndicator;
            switch ((i + 1) % 10) {
                case (1): {
                    ordinalIndicator = OrdinalIndicators.ST.toString().toLowerCase();
                    break;
                }
                case (2): {
                    ordinalIndicator = OrdinalIndicators.ND.toString().toLowerCase();
                    break;
                }
                case (3): {
                    ordinalIndicator = OrdinalIndicators.RD.toString().toLowerCase();
                    break;
                }
                default: {
                    ordinalIndicator = OrdinalIndicators.TH.toString().toLowerCase();
                    break;
                }
            }

            String title;
            System.out.println("Insert the title of the " + (i + 1) + ordinalIndicator + " media element.");
            do {
                title = input.nextLine();
            } while (title.equals(""));

            MediaTypes mediaType = null;
            do {
                System.out.println("Available formats:\n\t1. Audio\n\t2. Video\n\t3. Image");
                System.out.println("Choose a format by typing the corresponding number and then press Enter.");
                int mediaTypeChoice;
                do {
                    // uso do while true invece di while true cosi' si puo' evitare un controllo inutile nel caso il try funzioni
                    // stessa cosa per i do while successivi
                    try {
                        mediaTypeChoice = Integer.parseInt(input.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please insert a number.");
                    }
                } while (true);

                // switch case con enum per interpretare l'input dell'utente, in modo da aumentare leggibilita' del codice e solidita' del programma
                switch (mediaTypeChoice) {
                    case (1): {
                        mediaType = MediaTypes.AUDIO;
                        break;
                    }
                    case (2): {
                        mediaType = MediaTypes.VIDEO;
                        break;
                    }
                    case (3): {
                        mediaType = MediaTypes.IMAGE;
                        break;
                    }
                    default: {
                        System.out.println("Invalid format selection.");
                    }
                }
            } while (mediaType == null);

            if (mediaType == MediaTypes.AUDIO || mediaType == MediaTypes.VIDEO) {
                int length;
                System.out.println("Please insert its duration in minutes:");
                do {
                    try {
                        length = Integer.parseInt(input.nextLine());
                        if (length < 1) {
                            System.out.println("Please insert a number greater than 0.");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please insert a number.");
                    }
                } while (true);

                switch (mediaType) {
                    case AUDIO: {
                        mediaElements[i] = new AudioElement(title, length);
                        break;
                    }
                    case VIDEO: {
                        mediaElements[i] = new VideoElement(title, length);
                        break;
                    }
                }
            } else if (mediaType == MediaTypes.IMAGE) {
                // controllo mediaType == MediaTypes.IMAGE per chiarezza di codice anche se non sarebbe necessario
                // stessa cosa per else if successivi
                mediaElements[i] = new ImageElement(title);
            }
        }

        System.out.println("------------------------------------------");
        byte selection;
        while (true) {
            System.out.println("Select a media element from 1 to " + numberOfElements + ". Enter 0 to close the player.");
            for (int i = 0; i < mediaElements.length; i++) {
                System.out.println((i+1) + ". " + mediaElements[i].getTitle());
            }
            selection = input.nextByte();
            if (selection == 0) {
                System.out.println("Thanks for using our media player.");
                input.close();
                break;
            }
            MultimediaElement selectedElement = mediaElements[selection-1];
            if (selectedElement instanceof ReproducibleElement) {
                ((ReproducibleElement) selectedElement).play();
            } else if (selectedElement instanceof ImageElement) { 
                ((ImageElement) selectedElement).show();
            }
        }
    }
}