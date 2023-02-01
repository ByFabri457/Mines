import java.util.ArrayList;
import java.util.Scanner;

//FABRICIO LASO, ARNAU GIBERT I XAVIER PANDELE

class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean visioProfunda = false;
        boolean taulaPersonalitzada = false;
        int opcioPartida;
        int opcio;
        boolean sortida;
        TaulaVirtual taula;
        int modificarX;
        int modificarY;
        Records record;
        ArrayList<Records> records = new ArrayList<Records>();


        do {
            sortida = false;

            opcio = mostrarMenu();
            if (opcio == 0){
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                        "░░░▄▄▀▀▀▀▀▄░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                        "░▄▀░░░▄▄░░░▀▀▀▀▀▀▀▀▄▄▀▀▀▀▀▀▀▀▀▀▀▀▄▄░░░░\n" +
                        "░█░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░▀▄░░\n" +
                        "░█░░░░██▄▄▄▄▄░░██▄░░░░▄██░▄████▄░░░░▀▄░\n" +
                        "░█░░░░██▀▀▀▀██▄░██▄░░██▀░██▀░░░██░░░░█░\n" +
                        "░█░░░░██░░░░███░░█████▀░░██▀▀▀▀▀░░░░░█░\n" +
                        "░█░░░░███▄▄███▀░░░▀██▀░░░▀██▄▄▄██░░░░█░\n" +
                        "░▀▄░░░░▀▀▀▀▀▀░░░░░██▀░░░░░░▀▀▀▀▀░░░░░█░\n" +
                        "░░▀▄░░░░░░░░░░░░░▀▀░░░░░░░░░░░░░░░░░▄▀░\n" +
                        "░░░░▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀░░░\n" +
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                pause();
                sortida = true;
            }
            if (opcio == 1) {
                taula = new TaulaVirtual();
                taula.crearTaula();
                taula.crearMines();

                while (taula.gameOver == 0) {
                    if (visioProfunda) {
                        System.out.println();
                        for (int i = 0; i < taula.midaTaulaX + 1; i++) {
                            for (int j = 0; j < taula.midaTaulaY + 1; j++) {
                                System.out.print(taula.taula[i][j] + "  ");
                            }
                            System.out.println();
                        }
                        System.out.println();
                    }
                    if (taulaPersonalitzada) TaulaUsuariPersonalitzada.mostrarTaulaUsuari(taula);
                    else TaulaUsuari.mostrarTaulaUsuari(taula);

                    System.out.println("Escriu 0 per finalitzar la partida");
                    System.out.println("Escriu 1 per explorar una casella");
                    System.out.println("Escriu 2 per marcar una casella");
                    try {
                        opcioPartida = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException error) {
                        opcioPartida = -1;
                        sc.nextLine();
                    }
                    switch (opcioPartida) {
                        case 0:
                            System.out.println("Estas segur de que vols Tornar al menu principal? escriu 'CONFIRMAR' per finalitzar la partida:");
                            System.out.print(">");

                            if (sc.nextLine().equals("CONFIRMAR")) taula.gameOver = 2;
                            break;
                        case 1:
                            do {
                                System.out.println("Escogeix fila (1-" + taula.midaTaulaX + "):");

                                try {modificarX = Integer.parseInt(sc.nextLine());}
                                catch (NumberFormatException error) {modificarX = 0;}

                                if (modificarX > taula.midaTaulaX + 1 || modificarX < 1) {
                                    System.out.println("No s'ha trobat la fila " + modificarX);
                                }
                            } while (modificarX > taula.midaTaulaX + 1 || modificarX < 1);
                            do {
                                System.out.println("Escogeix columna (1-" + taula.midaTaulaY + "):");

                                try {modificarY = Integer.parseInt(sc.nextLine());}
                                catch (NumberFormatException error) {modificarY = 0;}

                                if (modificarY > taula.midaTaulaY + 1 || modificarY < 1) {
                                    System.out.println("No s'ha trobat la columna " + modificarY);
                                }
                            } while (modificarY > taula.midaTaulaY + 1 || modificarY < 1);

                            taula.modificarTaula(modificarX, modificarY);
                            break;

                        case 2:
                            do {
                                System.out.println("Escogeix fila (1-" + taula.midaTaulaX + "):");

                                try {modificarX = Integer.parseInt(sc.nextLine());}
                                catch (NumberFormatException error) {modificarX = 0;}

                                if (modificarX > taula.midaTaulaX + 1 || modificarX < 1) {
                                    System.out.println("No s'ha trobat la fila " + modificarX);
                                }
                            } while (modificarX > taula.midaTaulaX + 1 || modificarX < 1);
                            do {
                                System.out.println("Escogeix columna (1-" + taula.midaTaulaY + "):");

                                try {modificarY = Integer.parseInt(sc.nextLine());}
                                catch (NumberFormatException error) {modificarY = 0;}

                                if (modificarY > taula.midaTaulaY + 1 || modificarY < 1) {
                                    System.out.println("No s'ha trobat la columna " + modificarY);
                                }
                            } while (modificarY > taula.midaTaulaY + 1 || modificarY < 1);
                            taula.marcarCasella(modificarX, modificarY);
                            break;

                        default:
                            System.out.println("Opció no vàlida");
                            break;
                    }


                }
                if (taula.gameOver == 1) {
                    if (visioProfunda) {
                        System.out.println();
                        for (int i = 0; i < taula.midaTaulaX + 1; i++) {
                            for (int j = 0; j < taula.midaTaulaY + 1; j++) {
                                System.out.print(taula.taula[i][j] + "  ");
                            }
                            System.out.println();
                        }
                        System.out.println();
                    }
                    if (taulaPersonalitzada) TaulaUsuariPersonalitzada.mostrarTaulaUsuari(taula);
                    else TaulaUsuari.mostrarTaulaUsuari(taula);
                    System.out.println("┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "███▀▀▀██┼███▀▀▀███┼███▀█▄█▀███┼██▀▀▀\n" +
                            "██┼┼┼▄▄▄┼██▄▄▄▄▄██┼██┼┼┼▀┼┼┼██┼██▀▀▀\n" +
                            "███▄▄▄██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██▄▄▄\n" +
                            "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "███▀▀▀███┼▀███┼┼██▀┼██▀▀▀┼██▀▀▀▀██▄┼\n" +
                            "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██▀▀▀┼██▄▄▄▄▄▀▀┼\n" +
                            "███▄▄▄███┼┼┼─▀█▀┼┼─┼██▄▄▄┼██┼┼┼┼┼██▄\n" +
                            "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼████▄┼┼┼▄▄▄▄▄▄▄┼┼┼▄████┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼┼▀▀█▄█████████▄█▀▀┼┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼┼┼┼██▀▀▀███▀▀▀██┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼┼┼┼██┼┼┼███┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼┼┼┼█████▀▄▀█████┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼▄▄▄██┼┼█▀█▀█┼┼██▄▄▄┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼▀▀██┼┼┼┼┼┼┼┼┼┼┼██▀▀┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n");
                    pause();
                }
                if (taula.gameOver == 3) {
                    if (visioProfunda) {
                        System.out.println();
                        for (int i = 0; i < taula.midaTaulaX + 1; i++) {
                            for (int j = 0; j < taula.midaTaulaY + 1; j++) {
                                System.out.print(taula.taula[i][j] + "  ");
                            }
                            System.out.println();
                        }
                        if (taulaPersonalitzada) TaulaUsuariPersonalitzada.mostrarTaulaUsuari(taula);
                        else TaulaUsuari.mostrarTaulaUsuari(taula);
                        System.out.println();
                        System.out.println("ESTADISTIQUES DE LA PARTIDA:");
                        System.out.println("_______________________________________");
                        System.out.println("Temps trigat (s): " + TaulaUsuari.tempsDefinitiu);
                        System.out.println("Nombre de mines:" + taula.nMines);
                        System.out.println("Nombre de files:" + taula.midaTaulaY);
                        System.out.println("Nombre de columnes:" + taula.midaTaulaX);
                        System.out.println("DEGUT A QUE HAS JUGAT AMB VISIO PROFUNDA, NO ES GUARDARA CAP REGISTRE NI RECORD D'AQUESTA PARTIDA");
                        pause();
                    }

                    else {
                        if (taulaPersonalitzada) TaulaUsuariPersonalitzada.mostrarTaulaUsuari(taula);
                        else TaulaUsuari.mostrarTaulaUsuari(taula);

                        System.out.println(
                                "                                                                                                                                                     \n" +
                                        "                                                                                                                                                     \n" +
                                        "      YYYYYYY       YYYYYYY     OOOOOOOOO     UUUUUUUU     UUUUUUUU     WWWWWWWW                           WWWWWWWWIIIIIIIIIINNNNNNNN        NNNNNNNN\n" +
                                        "      Y:::::Y       Y:::::Y   OO:::::::::OO   U::::::U     U::::::U     W::::::W                           W::::::WI::::::::IN:::::::N       N::::::N\n" +
                                        "      Y:::::Y       Y:::::Y OO:::::::::::::OO U::::::U     U::::::U     W::::::W                           W::::::WI::::::::IN::::::::N      N::::::N\n" +
                                        "      Y::::::Y     Y::::::YO:::::::OOO:::::::OUU:::::U     U:::::UU     W::::::W                           W::::::WII::::::IIN:::::::::N     N::::::N\n" +
                                        "      YYY:::::Y   Y:::::YYYO::::::O   O::::::O U:::::U     U:::::U       W:::::W           WWWWW           W:::::W   I::::I  N::::::::::N    N::::::N\n" +
                                        "         Y:::::Y Y:::::Y   O:::::O     O:::::O U:::::D     D:::::U        W:::::W         W:::::W         W:::::W    I::::I  N:::::::::::N   N::::::N\n" +
                                        "          Y:::::Y:::::Y    O:::::O     O:::::O U:::::D     D:::::U         W:::::W       W:::::::W       W:::::W     I::::I  N:::::::N::::N  N::::::N\n" +
                                        "           Y:::::::::Y     O:::::O     O:::::O U:::::D     D:::::U          W:::::W     W:::::::::W     W:::::W      I::::I  N::::::N N::::N N::::::N\n" +
                                        "            Y:::::::Y      O:::::O     O:::::O U:::::D     D:::::U           W:::::W   W:::::W:::::W   W:::::W       I::::I  N::::::N  N::::N:::::::N\n" +
                                        "             Y:::::Y       O:::::O     O:::::O U:::::D     D:::::U            W:::::W W:::::W W:::::W W:::::W        I::::I  N::::::N   N:::::::::::N\n" +
                                        "             Y:::::Y       O:::::O     O:::::O U:::::D     D:::::U             W:::::W:::::W   W:::::W:::::W         I::::I  N::::::N    N::::::::::N\n" +
                                        "             Y:::::Y       O::::::O   O::::::O U::::::U   U::::::U              W:::::::::W     W:::::::::W          I::::I  N::::::N     N:::::::::N\n" +
                                        "             Y:::::Y       O:::::::OOO:::::::O U:::::::UUU:::::::U               W:::::::W       W:::::::W         II::::::IIN::::::N      N::::::::N\n" +
                                        "          YYYY:::::YYYY     OO:::::::::::::OO   UU:::::::::::::UU                 W:::::W         W:::::W          I::::::::IN::::::N       N:::::::N\n" +
                                        "          Y:::::::::::Y       OO:::::::::OO       UU:::::::::UU                    W:::W           W:::W           I::::::::IN::::::N        N::::::N\n" +
                                        "          YYYYYYYYYYYYY         OOOOOOOOO           UUUUUUUUU                       WWW             WWW            IIIIIIIIIINNNNNNNN         NNNNNNN\n" +
                                        "                                                                                                                                                     ");
                        System.out.println("Felicitats, has guanyat!");
                        pause();
                        record = new Records();
                        System.out.println("ESTADISTIQUES DE LA PARTIDA:");
                        System.out.println("_______________________________________");
                        System.out.println("Temps trigat (s): " + TaulaUsuari.tempsDefinitiu);
                        record.temps = TaulaUsuari.tempsDefinitiu;
                        System.out.println("Nombre de mines:" + taula.nMines);
                        record.numeroMines = taula.nMines;
                        System.out.println("Nombre de files:" + taula.midaTaulaY);
                        record.numeroFiles = taula.midaTaulaY;
                        System.out.println("Nombre de columnes:" + taula.midaTaulaX);
                        record.numeroColumnes = taula.midaTaulaX;
                        pause();
                        System.out.println("Escriu el teu Nom:");
                        record.nom = sc.nextLine();
                        records.add(record);
                    }

                }
            }
            if (opcio == 2) Records.consultarRecords(records);
            if (opcio == 3 && !taulaPersonalitzada) {
                taulaPersonalitzada = true;
                TaulaUsuariPersonalitzada.crearCaractersPersonalitzats();
            }
            else if (opcio == 3 && taulaPersonalitzada) {
                taulaPersonalitzada = false;
                System.out.println("S'han desctivat els caracters prsonalitzats amb éxit.");
            }
            if (opcio == 4 && !visioProfunda) {
                System.out.println("ADVERTENCIA:");
                System.out.println("Al activar la funcio de visió profunda no podràs desar records ni registres ja que es una funció experimental,\n que et permet mostrar la posicio de les mines a la partida.");
                System.out.println("Per activar la funció, escriu 'CONFIRMAR'");
                if (sc.nextLine().equals("CONFIRMAR")) visioProfunda = true;
            }
            else if (opcio == 4 && visioProfunda) {
                System.out.println("Visio profunda ha sigut desactivada amb éxit.");
                visioProfunda = false;
                pause();
            }
        }while (!sortida);
    }


    /**
     * Mostra el menu principal del programa i demana a l'usuari que seleccioni una opció.
     * @return el valor que farà referència a l'opcio seleccionada per l'usuari.
     */
    public static int mostrarMenu() {
        boolean opcioNoValida;
        int opcio;
        do {
            opcioNoValida = false;
            System.out.println("|B_U_S_C_A_M_I_N_E_S|");
            System.out.println();
            System.out.println("-Fet per Fabricio Laso, Arnau Gibert i Xavier Pandele");
            System.out.println();
            System.out.println("Selecciona una opcio:");
            System.out.println("-------------------------------");
            System.out.println("1-Començar una nova partida");
            System.out.println("2-Mirar llibre de récords");
            System.out.println("3-Activar/desactivar canvi de disseny del taulell");
            System.out.println("4-Activar/desactivar visió profunda del taulell (RECOMANAT PER DESARROLLAR, O TRObAR POSSIBLES ERRORS)");
            System.out.println("0-Sortir");
            try {
                System.out.print("> ");
                opcio = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException error) {
                opcio = -1;
            }
            if (opcio < 0 || opcio > 4) {
                opcioNoValida = true;
                System.out.println("Opció no valida!");
                System.out.println("___________________________________");
            }
        } while (opcioNoValida);

        return opcio;
    }

    /**
     * Utilitzant el metode Scanner podem fer una pausa temporal al cicle del nostre programa, fins que l'usuari introdueixi un intro.
     */
    public static void pause() {
        System.out.println("Pressiona Intro per continuar...");
        sc.nextLine();
    }

}