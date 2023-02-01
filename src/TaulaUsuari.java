import java.util.Scanner;

public class TaulaUsuari {
    public static long startTime; // Obté el temps actual en milisegons
    public static long tempsDefinitiu = 0;
    public static Scanner sc = new Scanner(System.in);
    public static String[] conjuntCaracters;
    public static char[] caracters;

    /**
     * Demana a l'usuari quins caracters vol registrar per als determinats estats d'una casella.
     */
    public static void crearCaractersPersonalitzats() {
        System.out.println("Sol es tindrà en compte el primer valor que escrigis per no alterar la estructura de la taula");
        conjuntCaracters = new String[4];
        caracters = new char[4];

        System.out.println("Escriu quin caracter vols utilitzar per senyalitzar CASELLA SENSE EXPLORAR (Per defecte \"■\")");
        conjuntCaracters[0] = sc.nextLine();
        caracters[0] = conjuntCaracters[0].charAt(0);
        System.out.println("Escriu quin caracter vols utilitzar per senyalitzar CASELLA EXPLORADA (Per defecte \"□\")");
        conjuntCaracters[1] = sc.nextLine();
        caracters[1] = conjuntCaracters[1].charAt(0);
        System.out.println("Escriu quin caracter vols utilitzar per senyalitzar CASELLA MARCADA (Per defecte \"p\")");
        conjuntCaracters[2] = sc.nextLine();
        caracters[2] = conjuntCaracters[2].charAt(0);
        System.out.println("Escriu quin caracter vols utilitzar per senyalitzar CASELLA AMB MINA (Per defecte \"¤\")");
        conjuntCaracters[3] = sc.nextLine();
        caracters[3] = conjuntCaracters[3].charAt(0);

    }

    /**
     * Mostra a l'usuari el tauler del joc traduïnt els valors que rep de la taula virtual
     * @param taula És la taula a on es fan tots els calculs de posicions i valors a les caselles
     */
    public static void mostrarTaulaUsuari(TaulaVirtual taula) {

        if (taula.firstPlay) {
            startTime = System.currentTimeMillis();
        }
        int comptadorMines = taula.nMines;
        System.out.println();

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
                        if (taula.gameOver == 0) {
                            System.out.print(" P ");
                            if (comptadorMines > 0)comptadorMines--;
                        }
                        if (taula.gameOver == 1) System.out.print(" X ");
                    }
                    if (taula.taula[i][j] == 32) {
                        System.out.print(" P ");
                        if (comptadorMines > 0)comptadorMines--;
                    }
                    if (taula.taula[i][j] == 3) {
                        if (taula.gameOver == 0) System.out.print(" ■ ");
                        else if (taula.gameOver == 3) System.out.print(" P ");
                        else System.out.print(" ¤ ");
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
        mostrarTemps(taula);
        minesRestants(comptadorMines);
    }

    /**
     * Fa la diferència entre el temps incial i el temps d'actualització un cop es truca el metode de mostrarTaula.
     * @param taula és la taula a on es fan els calculs, utilitzarem el boleà gameOver per determinar si la partida ha terminat.
     */
    public static void mostrarTemps(TaulaVirtual taula) {
        long updateTime = System.currentTimeMillis();
        long diffTimeSeconds = updateTime/1000-startTime/1000;
        System.out.println();
        System.out.println("Temps transcurrit: "+diffTimeSeconds+"s");
        if (taula.gameOver > 0) {
            tempsDefinitiu = diffTimeSeconds;
        }

    }

    /**
     * S'encarrega de comptar el nombre de mines restants quan l'usuari marca una casella en la qual creu que hi pot haver una mina,
     * cal destacar que el comptador pot registrar valors negatius si lùsuari marca més caselles que el nombre de mines al taulell.
     * @param comptadorMines
     */
    public static void minesRestants(int comptadorMines) {
        System.out.println("Mines restants: "+comptadorMines);
        System.out.println("----------------------");

    }

    public static void mostrarTaulaUsuariPersonalitzada(TaulaVirtual taula) {

        if (taula.firstPlay) {
            startTime = System.currentTimeMillis();
        }
        int comptadorMines = taula.nMines;
        System.out.println();

        for (int i = 0; i < taula.midaTaulaX + 1; i++) {
            for (int j = 0; j < taula.midaTaulaY + 1; j++) {
                if (i == 0 && j == 0) System.out.print("   ");
                if (j == 0 && (i < 10 && i != 0)) System.out.print(" " + i + " ");
                if ((j < 10 && j != 0) && i == 0) System.out.print(" " + j + " ");
                if (j >= 10 && i == 0) System.out.print(" " + j + "");
                if (j == 0 && i >= 10) System.out.print(" " + i + "");
                if (j != 0 && i != 0) {
                    if (taula.taula[i][j] == 0) System.out.print(" "+caracters[0]+" ");
                    if (taula.taula[i][j] == 1) System.out.print(" "+caracters[1]+" ");
                    if (taula.taula[i][j] == 2) {
                        if (taula.gameOver == 0) {
                            System.out.print(" "+caracters[2]+" ");
                            if (comptadorMines > 0)comptadorMines--;
                        }
                        if (taula.gameOver == 1) System.out.print(" X ");
                    }
                    if (taula.taula[i][j] == 32) {
                        System.out.print(" "+caracters[2]+" ");
                        if (comptadorMines > 0)comptadorMines--;
                    }
                    if (taula.taula[i][j] == 3) {
                        if (taula.gameOver == 0) System.out.print(" "+caracters[0]+" ");
                        else if (taula.gameOver == 3) System.out.print(" "+caracters[2]+" ");
                        else System.out.print(" "+caracters[3]+" ");
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
        mostrarTemps(taula);
        minesRestants(comptadorMines);
    }
}
