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

    /**
     * Crea la taula de valors amb la qual interactua l'usuari
     */
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

    /**
     * Crea un determinat numero de posicions X i Y a on es col·locaran lés mines
     */
    public static void crearMines() {

        int numeroMines = 0;

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

        inicialitzarTaula();
    }

    /**
     * Crea un determinat numero de posicions X i Y a on es col·locaran lés mines i les distribueix a la taula
     * @param numeroMines Numero de mines que ha establert l'usuari
     */
    public static void colocarMines(int numeroMines,int eleccioX,int eleccioY) {
        Random rand = new Random();
        int posicioY = 0;
        int posicioX = 0;
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
                if (taula[cordenadesMinesX[i]][cordenadesMinesY[j]] == 1) {
                    --i;
                }
            }
        }

        for (int i = 1; i < midaTaulaX + 1; i++) {
            for (int j = 1; j < midaTaulaY + 1; j++) {
                for (int k = 0; k < numeroMines; k++) {

                    if (i == cordenadesMinesX[k] && j == cordenadesMinesY[k] && taula[i][j] == 0) {
                        taula[i][j] = 3;
                    }
                }
            }
        }
    }

    /**
     * Incialitza el taulell buit amb les mesures indicades per l'usuari
     */
    public static void inicialitzarTaula() {
        for (int i = 1; i < midaTaulaX + 1; i++) {
            for (int j = 1; j < midaTaulaY + 1; j++) {
                taula[i][j] = 0;
            }
        }
    }

    /**
     * utilitzant la posició que ens ha donat l'usuari, explorem la casella i els seus voltants per comprovar si hi ha mines o no,
     * en cas que la posicio donada contingui una mina, el joc finalitza i l'usuari haurà perdut.
     * @param eleccioX Cordenada de X que ha enviat l'usuari.
     * @param eleccioY Cordenada de Y que ha enviat l'usuari
     */
    public static void modificarTaula(int eleccioX, int eleccioY) {
        int indexMina;


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
                                if (firstPlay) { //Si l'usuari fa la primera jugada, s'aseguren les caselles del voltant per evitar que l'usauri comenci explorant una casella amb mina
                                    asegurarCaselles(eleccioX,eleccioY);
                                    colocarMines(nMines,eleccioX,eleccioY);
                                    reiniciarCaselles(eleccioX,eleccioY);
                                    firstPlay = false;
                                    modificarTaula(eleccioX,eleccioY);
                                }

                                else {
                                    taula[i][j] = 1;
                                    expandirTaulell(eleccioX, eleccioY); //Si no hi ha cap casella amb una mina al voltant, es fa una cerca a les caselles del voltatn per expandir les caselles explorades.
                                }

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

    /**
     * Asegura Que les cel·les del voltant a l'hora de fer la primera jugada no s'hi pugi colocar mines
     * @param eleccioX
     * @param eleccioY
     */
    public static void asegurarCaselles(int eleccioX,int eleccioY) {
        taula[eleccioX][eleccioY] = 1;
        for (int k = 0; k < 8; k++) {
            if (taula[eleccioX + indexExploracioX[k]][eleccioY + indexExploracioY[k]] == 0) {
                taula[eleccioX + indexExploracioX[k]][eleccioY + indexExploracioY[k]] = 1;
            }
        }
    }

    /**
     * Una vegada les caselles han sigut asegurades i s'ha col·locat les mines,
     * les caselles asegurades tornen al valor incial, a on es realitzarà una cerca.
     * @param eleccioX
     * @param eleccioY
     */
    public static void reiniciarCaselles(int eleccioX,int eleccioY) {
        taula[eleccioX][eleccioY] = 0;
        for (int k = 0; k < 8; k++) {
            if (taula[eleccioX + indexExploracioX[k]][eleccioY + indexExploracioY[k]] == 1) {
                taula[eleccioX + indexExploracioX[k]][eleccioY + indexExploracioY[k]] = 0;
            }
        }
    }


    /**
     * utilitzant la posició que ens ha donat l'usuari, marquem la casella i bolquejem que l'usuari pugi explorarla fins que la desmarqui,
     * en cas que la posicio donada contingui una mina, la casella quedarà marcada, però amb un valor diferent, en cas que no hi hagi mina, si l'usuari perd la partida,
     * es mostrarà amb una "X", Simboltizant que la casella estaba marcada, però que no hi havia cap mina.
     * @param eleccioX Cordenada de X que ha enviat l'usuari.
     * @param eleccioY Cordenada de Y que ha enviat l'usuari
     */
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

    /**
     * S'activa quan el metode modificarTaula no troba camp mina al costat,
     * ens permet explorar totes les caselles del voltant fins que es trobi una mina a tot arreu.
     * @param eleccioX la posició X de la casella explorada per l'usuari.
     * @param eleccioY la posició Y de la casella explorada per l'usuari.
     */
    public static void expandirTaulell(int eleccioX,int eleccioY) {
        for (int i = 0; i < 8; i++) {
            modificarTaula(eleccioX + indexExploracioX[i], eleccioY + indexExploracioY[i]);
        }
    }

    /**
     * S'encarrega de comprovar que encara hi ha caselles sense mina que l'usuari no ha explorat,
     * si no troba cap casella marcada o sense explorar que no tingui mina el joc es termina i l'usuari hi ha guanyat.
     */
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
