import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String Confirm;
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
            }
            if (opcio == 1) {
                taula = new TaulaVirtual();
                taula.crearTaula();
                taula.crearMines();

                while (taula.gameOver == 0) {
                    TaulaUsuari.mostrarTaulaUsuari(taula);
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
                            Confirm = sc.nextLine();
                            if (Confirm.equals("CONFITMAR")) taula.gameOver = 2;
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
                    TaulaUsuari.mostrarTaulaUsuari(taula);
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
                    TaulaUsuari.mostrarTaulaUsuari(taula);

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
            if (opcio == 2) LlibreRecords.consultarRecords(records);
        }while (!sortida);
    }


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
            System.out.println("3-Canviar disseny del taulell (NO DISPONIBLE PEL MOMENT)");
            System.out.println("0-Sortir");
            try {
                System.out.print("> ");
                opcio = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException error) {
                opcio = -1;
            }
            if (opcio < 0 || opcio > 3) {
                opcioNoValida = true;
                System.out.println("Opció no valida!");
                System.out.println("___________________________________");
            }
        } while (opcioNoValida);

        return opcio;
    }

    public static void pause() {
        System.out.println("Pressiona Intro per continuar...");
        sc.nextLine();
    }

}