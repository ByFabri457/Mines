import java.util.Random;
import java.util.Scanner;

public class TaulaVirtual {
    public static Scanner sc = new Scanner(System.in);
    public static boolean gameOver = false;
    public static int[][] taula;

    public static int[] indexExploracioX = {-1,0,+1,+1,+1,0,-1,-1};

    public static int[] indexExploracioY = {-1,-1,-1,0,+1,+1,+1,0};
    public static int midaTaulaX;
    public static int midaTaulaY;
    public static void crearTaula() {

        System.out.println("Escolleigx la mida de la taula");
        System.out.print("Numero Files:");
        midaTaulaX = sc.nextInt();
        System.out.println();
        System.out.print("Numero Columnes:");
        midaTaulaY = sc.nextInt();
        taula = new int[midaTaulaX+2][midaTaulaY+2];
    }
    public static void crearMines() {
        int posicioY = 0;
        int posicioX = 0;




        Random rand = new Random();

        System.out.println("Escriu el numero de mines");

        int numeroMines = sc.nextInt();

        int[] cordenadesMinesY = new int[numeroMines];
        int[] cordenadesMinesX = new int[numeroMines];

        for (int i = 0; i < numeroMines; i++) {
            posicioX = rand.nextInt(1, midaTaulaX+1);
            posicioY = rand.nextInt(1, midaTaulaY+1);
            cordenadesMinesX[i] = posicioX;
            cordenadesMinesY[i] = posicioY;
            for (int j = 0; j < i; j++) {

                if (cordenadesMinesX[i] == cordenadesMinesX[j] && cordenadesMinesY[i] == cordenadesMinesY[j]) {
                    --i;
                }
            }


        }
        colocarMines(numeroMines,cordenadesMinesX,cordenadesMinesY);

    }
    public static void modificarTaula(int eleccioX,int eleccioY) {
        int indexMina;
        for (int i = 1;i < midaTaulaX+1;i++) {
            for (int j = 1;j < midaTaulaY+1;j++) {
                if (i == eleccioX && j == eleccioY) {
                    if (taula[i][j] == 0) {
                        indexMina = 0;
                        for (int k = 0;k < 8;k++) {

                            if (taula[i+indexExploracioX[k]][j+indexExploracioY[k]] == 3) {
                                indexMina += 1;
                            }

                        }
                        if (indexMina == 0) {
                            taula[i][j] = 1;
                            expandirTaulell(eleccioX,eleccioY);
                        }
                        if (indexMina >= 1) taula[i][j] = indexMina + 10;
                    }
                    if (taula[i][j] == 3) {
                        gameOver = true;
                    }
                }
            }
        }
    }
    public static void colocarMines(int numeroMines,int[] cordenadesMinesX,int[] cordenadesMinesY) {
        boolean minaTrobada;
        for (int i = 1; i < midaTaulaX+1; i++) {

            for (int j = 1; j < midaTaulaY+1; j++) {
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

    public static void expandirTaulell(int eleccioX,int eleccioY) {
        for (int i = 0;i < 8; i++) {
            modificarTaula(eleccioX+indexExploracioX[i],eleccioY+indexExploracioY[i]);
        }
    }
}
