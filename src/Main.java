import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int opcioPartida;
        int opcio;
        boolean sortida;
        TaulaVirtual taula;
        int modificarX;
        int modificarY;
        Records record;
        ArrayList records = new ArrayList<Records>();


        do {
            sortida = false;

            opcio = mostrarMenu();
            if (opcio == 0){
                System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
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
                        opcioPartida = sc.nextInt();
                    } catch (NumberFormatException error) {
                        opcioPartida = -1;
                        sc.nextLine();
                    }
                    switch (opcioPartida) {
                        case 0:
                            taula.gameOver = 2;
                            break;

                        case 1:
                            do {
                                System.out.println("Escogeix fila (1-" + taula.midaTaulaX + "):");
                                modificarX = sc.nextInt();
                                if (modificarX > taula.midaTaulaX + 1 || modificarX < 1) {
                                    System.out.println("No s'ha trobat la fila " + modificarX);
                                }
                            } while (modificarX > taula.midaTaulaX + 1 || modificarX < 1);
                            do {
                                System.out.println("Escogeix columna (1-" + taula.midaTaulaY + "):");
                                modificarY = sc.nextInt();
                                if (modificarY > taula.midaTaulaY + 1 || modificarY < 1) {
                                    System.out.println("No s'ha trobat la columna " + modificarY);
                                }
                            } while (modificarY > taula.midaTaulaY + 1 || modificarY < 1);

                            taula.modificarTaula(modificarX, modificarY);
                            break;

                        case 2:
                            do {
                                System.out.println("Escogeix fila (1-" + taula.midaTaulaX + "):");
                                modificarX = sc.nextInt();
                                if (modificarX > taula.midaTaulaX + 1 || modificarX < 1) {
                                    System.out.println("No s'ha trobat la fila " + modificarX);
                                }
                            } while (modificarX > taula.midaTaulaX + 1 || modificarX < 1);
                            do {
                                System.out.println("Escogeix columna (1-" + taula.midaTaulaY + "):");
                                modificarY = sc.nextInt();
                                if (modificarY > taula.midaTaulaY + 1 || modificarY < 1) {
                                    System.out.println("No s'ha trobat la columna " + modificarY);
                                }
                            } while (modificarY > taula.midaTaulaY + 1 || modificarY < 1);
                            sc.nextLine();
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
                    System.out.println("Temps trigat: NO DISPONIBLE");
                    record.temps = 0;
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
            if (opcio == 2) llibreRecords(records);
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
            System.out.println("2-Mirar llibre de récords (NO DISPONIBLE)");
            System.out.println("3-Canviar disseny del taulell (NO DISPONIBLE)");
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

        System.out.println();
        System.out.println("Pressiona Intro per continuar...");
        System.out.println(sc.nextLine());
    }
    public static void llibreRecords(ArrayList records) {
        int opcio;
        boolean confirmar;
        boolean sortir;
        boolean fName = false;
        boolean fTemp = false;
        boolean fRow = false;
        boolean fCol = false;
        boolean fMine = false;

        String nom;
        int[] intervalTemps = {0,0};
        int[] intervalFiles = {0,0};
        int[] intervalColumnes = {0,0};
        int[] intervalMines = {0,0};


        for (int i = 0;i < records.size();i++) {
            System.out.println(records.get(i));
        }
        do {
            opcio = 0;
            sortir = false;

            System.out.println("OPCIONS:");
            System.out.println("______________");
            System.out.println("0-Tornar al menu");
            System.out.println("1-Realitzar cerca avançada amb filtres");
            System.out.println("2-Tornar a mostrar tots els registres");
            System.out.println("3-Eliminar un registre");
            System.out.print(">");
            try {
                opcio = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException error) {
                opcio = -1;
            }
            switch (opcio) {
                default:
                    System.out.println("Opció no valida.");
                    break;
                case 0:
                    sortir = true;
                    break;
                case 1:
                    do {
                        confirmar = false;
                        System.out.println("CERCA AMB FILTRES:");
                        System.out.println("0-Tornar al menu");
                        System.out.println("1-Afegir/treure filtre per nom");
                        System.out.println("2-Afegir/treure filtre per interval de temps");
                        System.out.println("3-Afegir/treure filtre per interval de files");
                        System.out.println("4-Afegir/treure filtre per interval de columnes");
                        System.out.println("5-Afegir/Treure filtre per interval de mines");
                        System.out.println("6-Confirmar canvis i incialitzar cerca");
                        System.out.println("_________________________________________________");
                        System.out.print(">");
                        try {

                        } catch (NumberFormatException error) {
                            opcio = -1;
                        }

                        switch (opcio) {
                            default:
                                System.out.println("Opció no valida.");
                                break;
                            case 0:
                                break;
                            case 1:
                                if (!fName) {
                                    fName = true;
                                    System.out.println("Escriu el nom per el qual vols filtrar les dades:");
                                    nom = sc.nextLine();
                                }
                                else if (fName) {
                                    fName = false;
                                    nom = null;
                                }
                                break;
                            case 2:
                                if (!fTemp) {
                                    fTemp = true;
                                    System.out.println("Escriu entre quins valors vols filtrar el temps");
                                    intervalTemps[0] = Integer.parseInt(sc.nextLine());
                                    intervalTemps[1] = Integer.parseInt(sc.nextLine());
                                }
                                else if (fTemp) {
                                    fTemp = false;
                                    intervalTemps[0] = 0;
                                    intervalTemps[1] = 0;
                                }
                                break;
                            case 3:
                                if (!fRow) {
                                    fRow = true;
                                    System.out.println("Escriu entre quins valors vols filtrar les files");
                                    intervalFiles[0] = Integer.parseInt(sc.nextLine());
                                    intervalFiles[1] = Integer.parseInt(sc.nextLine());
                                }
                                else if (fRow) {
                                    fRow = false;
                                    intervalFiles[0] = 0;
                                    intervalFiles[1] = 0;
                                }
                                break;
                            case 4:
                                if (!fCol) {
                                    fCol = true;
                                    System.out.println("Escriu entre quins valors vols filtrar les files");
                                    intervalColumnes[0] = Integer.parseInt(sc.nextLine());
                                    intervalColumnes[1] = Integer.parseInt(sc.nextLine());
                                }
                                else if (fCol) {
                                    fCol = false;
                                    intervalColumnes[0] = 0;
                                    intervalColumnes[1] = 0;
                                }
                                break;
                            case 5:
                                if (!fMine) {
                                    fMine = true;
                                    System.out.println("Escriu entre quins valors vols filtrar les mines");
                                    intervalMines[0] = Integer.parseInt(sc.nextLine());
                                    intervalMines[1] = Integer.parseInt(sc.nextLine());
                                }
                                else if (fMine) {
                                    fMine = false;
                                    intervalMines[0] = 0;
                                    intervalMines[1] = 0;
                                }
                                break;
                            case 6:
                                confirmar = true;
                                break;
                        }

                    } while (!confirmar);
                    if (opcio == 6) {
                        for (int i = 0;i < records.size();i++) {

                        }
                    }
                    break;

            }
            if (opcio == 2) {
                for (int i = 0;i < records.size();i++) {
                    System.out.println(records.get(i));
                }
            }

        }while (sortir);

    }
}