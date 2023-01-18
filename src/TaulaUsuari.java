public class TaulaUsuari {
    public static void mostrarTaulaUsuari(TaulaVirtual taula) {
        String[][] vistaUsuari = new String[taula.midaTaulaX][taula.midaTaulaY];
        for (int i = 0;i < taula.midaTaulaX;i++) {
            for (int j = 0;j < taula.midaTaulaY;j++) {
                if (taula.taula[i][j] == 0) System.out.print(" ■ ");
                if (taula.taula[i][j] == 1) System.out.print(" □ ");
                if (taula.taula[i][j] == 3) {
                    if (taula.gameOver == false) System.out.print(" ■ ");
                    if (taula.gameOver == true) System.out.print(" ¤ ");
                }
            }
            System.out.println();
        }
    }
}
