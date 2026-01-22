
package mastermind2;

import java.util.Scanner;

public class MasterMind2 {
    public static void main(String[] args) {
        Methods methods = new Methods();
        Scanner input = new Scanner(System.in);
        Colors[] correctColors;
        String[] playerGuesses;
        boolean isWin;
        int trys = 0;
        int attempts;

        methods.show_dificulty();

        try {
            trys = methods.dificulty(input.nextInt());
        } catch (Exception e) {
            System.out.println("Verkeerde invoer");
            trys = 8;
        }

        correctColors = new Colors[4];
        for (int i = 0; i < 4; i++) {
            int randomIndex = methods.color_random();
            correctColors[i] = methods.colorChoose(randomIndex);
        }

        attempts = 0;
        while (attempts < trys) {
            playerGuesses = new String[4];
            methods.spatie();
            methods.mogelijke_kleuren();
            
            // Mostrar el historial de colores antes de que el usuario ingrese su elección
            methods.displayHistory(); // Mostrar historial antes de cada intento

            for (int i = 0; i < 4; i++) {
                methods.spatie();
                methods.Vak(i);
                playerGuesses[i] = input.next();
            }

            // Llama al método decoder para procesar las elecciones del jugador
            methods.decoder(playerGuesses, correctColors);

            // Verifica si el jugador ha ganado
            isWin = true;
            for (int i = 0; i < 4; i++) {
                if (!playerGuesses[i].equals(correctColors[i].toString().toLowerCase())) {
                    isWin = false;
                    break;
                }
            }

            if (isWin) {
                methods.spatie();
                System.out.println("¡Gefeliciteerd, you won!");
                methods.spatie();
                for (int i = 0; i < 4; i++) {
                    System.out.println("ANTW_Vak_" + (i + 1) + ": " + correctColors[i]);
                }
                break;
            }

            attempts++;
            if (attempts == trys) {
                methods.spatie();
                System.out.println("¡You Lost! The correct colors waren: ");
                methods.spatie();
                for (int i = 0; i < 4; i++) {
                    System.out.println("ANTW_Vak_" + (i + 1) + ": " + correctColors[i]);
                }
            }
        }

        input.close();
    }
}
