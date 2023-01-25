import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        boolean opcioNoValida;
        int opcio;

        int modificarX;
        int modificarY;
        Scanner sc = new Scanner(System.in);
        TaulaVirtual taula = new TaulaVirtual();

        do {
            opcioNoValida = false;
            mostrarMenu();
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
        }
        if (opcio == 1) {

            taula.crearTaula();
            taula.crearMines();

            while (!taula.gameOver) {
                TaulaUsuari.mostrarTaulaUsuari(taula);
                System.out.println();
                do {
                    System.out.println("Escolleix fila (1-" + taula.midaTaulaX + "):");
                    modificarX = sc.nextInt();
                    if (modificarX > taula.midaTaulaX + 1 || modificarX < 1) {
                        System.out.println("No s'ha trobat la columna " + modificarX);
                    }
                } while (modificarX > taula.midaTaulaX + 1 || modificarX < 1);
                do {
                    System.out.println("Escolleix columna (1-" + taula.midaTaulaY + "):");
                    modificarY = sc.nextInt();
                    if (modificarY > taula.midaTaulaY + 1 || modificarY < 1) {
                        System.out.println("No s'ha trobat la fila " + modificarY);
                    }
                } while (modificarY > taula.midaTaulaY + 1 || modificarY < 1);

                taula.modificarTaula(modificarX, modificarY);

            }
            if (taula.gameOver) {
                TaulaUsuari.mostrarTaulaUsuari(taula);
                System.out.println();
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

            }
        }
    }

    public static void mostrarMenu() {
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
    }
}