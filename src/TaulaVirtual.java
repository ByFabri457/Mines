import java.util.Random;
import java.util.Scanner;

public class TaulaVirtual {
    public static Scanner sc = new Scanner(System.in);


    public static int gameOver;
    public static int[][] taula;
    public static int nMines;
    public static int[] indexExploracioX = {-1, 0, +1, +1, +1, 0, -1, -1};
    public static int[] indexExploracioY = {-1, -1, -1, 0, +1, +1, +1, 0};

    public static int[] cordenadesMinesY;
    public static int[] cordenadesMinesX;

    public static int midaTaulaX;
    public static int midaTaulaY;
    public static boolean firstPlay;
    public static void crearTaula() {
        firstPlay = true;
        gameOver = 0;
        System.out.println("Escolleix la mida de la taula");
        do {

            try {
                System.out.println();
                System.out.print("Número de files: ");
                midaTaulaX = Integer.parseInt(sc.nextLine());

            }catch (NumberFormatException error){
                midaTaulaX = 0;
            }
            if (midaTaulaX >= 32 || midaTaulaX <=5) {
                System.out.println("El numero de files que has introduït no es valid (Minim de 5, Max de 32, en caracters numerics sense decimals)");
            }

        }while (midaTaulaX >= 32 || midaTaulaX <= 5 );

        do {
            try {
                System.out.println();
                System.out.print("Número de columnes: ");
                midaTaulaY = Integer.parseInt(sc.nextLine());

            }catch (NumberFormatException error){
                midaTaulaY = 0;
            }
            if (midaTaulaY >= 36 || midaTaulaY <=5) {
                System.out.println("El numero de columnes que has introduït no es valid (Minim de 5, Max de 36, en caracters numerics sense decimals)");
            }
        }while (midaTaulaY >= 36 || midaTaulaY <=5);

        taula = new int[midaTaulaX + 2][midaTaulaY + 2];
    }

    public static void crearMines() {
        int posicioY = 0;
        int posicioX = 0;
        int numeroMines = 0;

        Random rand = new Random();

        System.out.println();

        do {
            System.out.print("Escriu el número de mines: ");

            try {
                numeroMines = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException error) {
                numeroMines = 0;
            }
            if (numeroMines < 1 && numeroMines > midaTaulaY * midaTaulaX-10) System.out.println("El numero de mines introduït no és vàlid (com a minim: 1 mina,com a maxim han de quedar 10 posicions lliures a la taula)");
        }while (numeroMines < 1 && numeroMines > midaTaulaY * midaTaulaX-10);
        nMines = numeroMines;

        cordenadesMinesY = new int[numeroMines];
        cordenadesMinesX = new int[numeroMines];

        for (int i = 0; i < numeroMines; i++) {
            posicioX = rand.nextInt(1, midaTaulaX + 1);
            posicioY = rand.nextInt(1, midaTaulaY + 1);
            cordenadesMinesX[i] = posicioX;
            cordenadesMinesY[i] = posicioY;
            for (int j = 0; j < i; j++) {

                if (cordenadesMinesX[i] == cordenadesMinesX[j] && cordenadesMinesY[i] == cordenadesMinesY[j]) {
                    --i;
                }
            }
        }
        colocarMines(numeroMines, cordenadesMinesX, cordenadesMinesY);
    }

    public static void modificarTaula(int eleccioX, int eleccioY) {
        int indexMina;
        if (firstPlay) {
            firstPlay = false;
        }

        for (int i = 1; i < midaTaulaX + 1; i++) {
            for (int j = 1; j < midaTaulaY + 1; j++) {
                if (i == eleccioX && j == eleccioY) {
                    if (taula[i][j] == 0) {
                        indexMina = 0;
                        for (int k = 0; k < 8; k++) {

                            if (taula[i + indexExploracioX[k]][j + indexExploracioY[k]] == 3 || taula[i + indexExploracioX[k]][j + indexExploracioY[k]] == 32) {
                                indexMina += 1;
                            }

                        }
                        if (indexMina == 0 && taula[i][j] != 2) {
                            taula[i][j] = 1;
                            expandirTaulell(eleccioX, eleccioY);
                        }
                        if (indexMina >= 1) taula[i][j] = indexMina + 10;
                    }
                    if (taula[i][j] == 3) {
                        gameOver = 1;
                    }
                }
            }
        }
        checkCasellesRestants();

    }

    public static void colocarMines(int numeroMines, int[] cordenadesMinesX, int[] cordenadesMinesY) {
        boolean minaTrobada;
        for (int i = 1; i < midaTaulaX + 1; i++) {

            for (int j = 1; j < midaTaulaY + 1; j++) {
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


    public static void marcarCasella(int eleccioX, int eleccioY) {
        for (int i = 1; i < midaTaulaX + 1; i++) {
            for (int j = 1; j < midaTaulaY + 1; j++) {
                if (i == eleccioX && j == eleccioY) {
                    if (taula[i][j] == 2) {
                        taula[i][j] = 0;
                    }
                    else if (taula[i][j] == 32) {
                        taula[i][j] = 3;
                    }
                    else if (taula[i][j] == 0) {
                        taula[i][j] = 2;
                    }
                    else if (taula[i][j] == 3) {
                        taula[i][j] = 32;
                    }

                }
            }
        }
        checkCasellesRestants();
    }

    public static void expandirTaulell(int eleccioX,int eleccioY) {
        for (int i = 0; i < 8; i++) {
            modificarTaula(eleccioX + indexExploracioX[i], eleccioY + indexExploracioY[i]);
        }
    }

    public static void checkCasellesRestants() {
        int casellesLliuresSenseExplorar = 0;
        for (int i = 1; i < midaTaulaX + 1;i++) {
            for (int j = 1; j < midaTaulaY + 1;j++) {
                if (taula[i][j] == 0 || taula[i][j] == 2) {
                    casellesLliuresSenseExplorar += 1;
                }
            }
        }
        if (casellesLliuresSenseExplorar == 0) {
            gameOver = 3;
        }
    }
}
