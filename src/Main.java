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
            }
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
        sc.nextLine();
        System.out.println();
        System.out.println("Pressiona Intro per continuar...");
        System.out.println(sc.nextLine());
    }
}