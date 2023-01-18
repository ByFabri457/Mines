public class TaulaUsuari {
    public static void mostrarTaulaUsuari(TaulaVirtual taula) {
        String[][] vistaUsuari = new String[taula.midaTaulaX][taula.midaTaulaY];
        for (int i = 1;i < taula.midaTaulaX+1;i++) {
            for (int j = 1;j < taula.midaTaulaY+1;j++) {
                if (taula.taula[i][j] == 0) System.out.print(" ■ ");
                if (taula.taula[i][j] == 1) System.out.print(" □ ");
                if (taula.taula[i][j] == 3) {
                    if (taula.gameOver == false) System.out.print(" ■ ");
                    if (taula.gameOver == true) System.out.print(" ¤ ");
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
            System.out.println();
        }
    }
}
