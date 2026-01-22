package mastermind2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


enum Colors {
    GREEN, PINK, BLUE, RED, PURPLE, ORANGE
}

public class Methods {
    private List<ColorEntry> history;

    public Methods() {
        this.history = new ArrayList<>();
    }

    public void show_dificulty() {
        System.out.println("=========================================\n"
                + "|||   Choose Dificulty: (1, 2 or 3)   |||\n"
                + "=========================================");
        System.out.println("1. Easy (8 pogginen)");
        System.out.println("2. Medium (5 pogginen)");
        System.out.println("3. Difícult (3 pogginen)");
    }

    public int dificulty(int dificultad) {
        int maxIntentos;

        switch (dificultad) {
            case 1:
                maxIntentos = 8;
                break;
            case 2:
                maxIntentos = 5;
                break;
            case 3:
                maxIntentos = 3;
                break;
            default:
                System.out.println("dat is niet mogelijk, Easy mode automatisch gekozen");
                maxIntentos = 8;
        }
        return maxIntentos;
    }

    public void spatie() {
        System.out.println("");
    }

    public void Vak(int i) {
        i = i + 1;
        System.out.println("===========\n"
                + "|| Vak_" + i + " ||\n"
                + "===========");
    }

    public void mogelijke_kleuren() {
        System.out.println("============================================================================================\n"
                + "============================================================================================\n"
                + "||||||||     Mogelijke kleuren: GREEN, PINK, BLUE, RED, PURPLE, ORANGE         |||||||||||||"
                + "\n"
                + "============================================================================================\n"
                + "============================================================================================");
    }

    public Colors colorChoose(int index) {
        return Colors.values()[index];
    }

    public int color_random() {
        Random random = new Random();
        return random.nextInt(Colors.values().length);
    }

    public void decoder(String[] playerGuesses, Colors[] correctColors) {
        boolean isWin = true;
        boolean[] checked = new boolean[correctColors.length];
        String[] responses = new String[playerGuesses.length]; // Array para almacenar respuestas

        for (int i = 0; i < playerGuesses.length; i++) {
            if (playerGuesses[i].equals(correctColors[i].toString().toLowerCase())) {
                System.out.println("Vak_" + (i + 1) + " is goed!");
                responses[i] = "Correct"; // Almacena la respuesta
            } else {
                isWin = false;
                boolean found = false;

                for (int j = 0; j < correctColors.length; j++) {
                    if (playerGuesses[i].equals(correctColors[j].toString().toLowerCase()) && !checked[j]) {
                        found = true;
                        checked[j] = true;
                    }
                }

                if (found) {
                    System.out.println("Vak_" + (i + 1) + " niet goed, maar kleur komt wel in de doosje.");
                    responses[i] = "Incorrect, maar kleur komt voor"; // Almacena la respuesta
                } else {
                    System.out.println("Vak_" + (i + 1) + " is niet goed!");
                    responses[i] = "Incorrect"; // Almacena la respuesta
                }
            }
        }

        // Agregar al historial
        for (int i = 0; i < responses.length; i++) {
            if (playerGuesses[i] != null) {
                addColorEntry(playerGuesses[i], responses[i]); // Asegúrate de que esta función esté disponible
            }
        }
    }

    // Método para agregar una entrada al historial
    public void addColorEntry(String color, String response) {
        history.add(new ColorEntry(color, response));
    }

    // Método para mostrar el historial de colores
    public void displayHistory() {
        System.out.println("Historial de colores escogidos:");
        System.out.println("==================================");
        for (ColorEntry entry : history) {
            System.out.println("Color: " + entry.color + " | Respuesta: " + entry.response);
        }
        System.out.println("==================================");
    }

    private class ColorEntry {
        String color;
        String response;

        ColorEntry(String color, String response) {
            this.color = color;
            this.response = response;
        }
    }
}

