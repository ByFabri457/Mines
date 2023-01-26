import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;
public class TaulaUsuari {

    public static LocalDateTime inici = java.time.LocalDateTime.now();
    public static void mostrarTaulaUsuari(TaulaVirtual taula) {
        System.out.println();

        String[][] vistaUsuari = new String[taula.midaTaulaX+2][taula.midaTaulaY+2];
        for (int i = 0; i < taula.midaTaulaX + 1; i++) {
            for (int j = 0; j < taula.midaTaulaY + 1; j++) {
                if (i == 0 && j == 0) System.out.print("   ");
                if (j == 0 && (i < 10 && i != 0)) System.out.print(" " + i + " ");
                if ((j < 10 && j != 0) && i == 0) System.out.print(" " + j + " ");
                if (j >= 10 && i == 0) System.out.print(" " + j + "");
                if (j == 0 && i >= 10) System.out.print(" " + i + "");
                if (j != 0 && i != 0) {
                    if (taula.taula[i][j] == 0) System.out.print(" ■ ");
                    if (taula.taula[i][j] == 1) System.out.print(" □ ");
                    if (taula.taula[i][j] == 2) {
                        if (taula.gameOver == 0) System.out.print(" P ");
                        if (taula.gameOver == 1) System.out.print(" X ");
                    }
                    if (taula.taula[i][j] == 32) System.out.print(" P ");
                    if (taula.taula[i][j] == 3) {
                        if (taula.gameOver == 0) System.out.print(" ■ ");
                        if (taula.gameOver == 1) System.out.print(" ¤ ");
                    }
                    if (taula.taula[i][j] == 11) System.out.print(" 1 ");
                    if (taula.taula[i][j] == 12) System.out.print(" 2 ");
                    if (taula.taula[i][j] == 13) System.out.print(" 3 ");
                    if (taula.taula[i][j] == 14) System.out.print(" 4 ");
                    if (taula.taula[i][j] == 15) System.out.print(" 5 ");
                    if (taula.taula[i][j] == 16) System.out.print(" 6 ");
                    if (taula.taula[i][j] == 17) System.out.print(" 7 ");
                    if (taula.taula[i][j] == 18) System.out.print(" 8 ");
                }
            }
            System.out.println();
        }
        mostrarTemps();
    }
    public static void mostrarTemps() {
        LocalDateTime cronometre = java.time.LocalDateTime.now();
        System.out.println();
        System.out.println("Temps transcurrit:"+(cronometre.getSecond()-inici.getSecond())+"s");
        System.out.println("----------------------");
    }
}
