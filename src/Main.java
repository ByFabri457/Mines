import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int posicioY = 0;
        int posicioX = 0;
        int[][] taula = new int[8][8];
        Random rand = new Random();
        int numeroMines = 5;
        int[] cordenadesMinesY = new int[numeroMines];
        int[] cordenadesMinesX = new int[numeroMines];
        for (int i = 0;i < numeroMines; i++) {
            posicioX = rand.nextInt(1, 7);
            posicioY = rand.nextInt(1, 7);
            cordenadesMinesX[i] = posicioX;
            cordenadesMinesY[i] = posicioY;
            for (int j = 0;j < i;j++) {

                if (cordenadesMinesX[i] == cordenadesMinesX[j] && cordenadesMinesY[i] == cordenadesMinesY[j]) {
                    --i;
                }
            }
            System.out.println(posicioX+" - "+posicioY+", ");

        }
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {
                for (int k = 0;k<numeroMines;k++) {
                    if (i == cordenadesMinesX[k] && j == cordenadesMinesY[k]) {
                        taula[i][j] = 3;
                        break;
                    } else {
                        taula[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0;i < 8;i++) {
            for (int j = 0;j < 8;j++) {
                System.out.print(taula[i][j] + "  ");
            }
            System.out.println();
        }

    }
}