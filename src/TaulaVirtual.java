import java.util.Random;
import java.util.Scanner;

public class TaulaVirtual {
    public static Scanner sc = new Scanner(System.in);
    public static boolean gameOver = false;
    public static int[][] taula;
    public static int midaTaulaX;
    public static int midaTaulaY;
    public static void crearTaula() {

        System.out.println("Escolleigx la mida de la taula");
        System.out.print("Numero Files:");
        midaTaulaX = sc.nextInt();
        System.out.println();
        System.out.print("Numero Columnes:");
        midaTaulaY = sc.nextInt();
        taula = new int[midaTaulaX][midaTaulaY];
    }
    public static void afegirMines() {
        int posicioY = 0;
        int posicioX = 0;
        boolean minaTrobada;



        Random rand = new Random();

        System.out.println("Escriu el numero de mines");

        int numeroMines = sc.nextInt();

        int[] cordenadesMinesY = new int[numeroMines];
        int[] cordenadesMinesX = new int[numeroMines];

        for (int i = 0; i < numeroMines; i++) {
            posicioX = rand.nextInt(0, midaTaulaX);
            posicioY = rand.nextInt(0, midaTaulaY);
            cordenadesMinesX[i] = posicioX;
            cordenadesMinesY[i] = posicioY;
            for (int j = 0; j < i; j++) {

                if (cordenadesMinesX[i] == cordenadesMinesX[j] && cordenadesMinesY[i] == cordenadesMinesY[j]) {
                    --i;
                }
            }


        }
        for (int i = 0; i < midaTaulaX; i++) {

            for (int j = 0; j < midaTaulaY; j++) {
                minaTrobada = false;
                for (int k = 0; k < numeroMines; k++) {

                    if (i == cordenadesMinesX[k] && j == cordenadesMinesY[k]) {
                        taula[i][j] = 3;
                        minaTrobada = true;
                    } else if (minaTrobada == false) {
                        taula[i][j] = 0;
                    }
                }
            }
        }
    }
}
