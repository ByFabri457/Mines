import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {


        int modificarX;
        int modificarY;
        Scanner sc = new Scanner(System.in);
        TaulaVirtual taula = new TaulaVirtual();

        taula.crearTaula();
        taula.crearMines();



        while (!taula.gameOver) {
            TaulaUsuari.mostrarTaulaUsuari(taula);
            System.out.println();
            do {
                System.out.println("Escogeix columna (1-" + taula.midaTaulaX + "):");
                modificarX = sc.nextInt();
                if (modificarX > taula.midaTaulaX+1 || modificarX < 1) {
                    System.out.println("No s'ha trobat la columna " + modificarX);
                }
            }while (modificarX > taula.midaTaulaX+1 || modificarX < 1);
            do {
                System.out.println("Escogeix fila (1-" + taula.midaTaulaY + "):");
                modificarY = sc.nextInt();
                if (modificarY > taula.midaTaulaY+1 || modificarY < 1) {
                    System.out.println("No s'ha trobat la fila " + modificarY);
                }
            }while (modificarY > taula.midaTaulaY+1 || modificarY < 1);

            taula.modificarTaula(modificarX, modificarY);

        }
        if (taula.gameOver) {
            TaulaUsuari.mostrarTaulaUsuari(taula);
            System.out.println("Has Perdut!");
        }

//        System.out.println();
//        for (int i = 0; i < taula.midaTaulaX; i++) {
//          for (int j = 0; j < taula.midaTaulaY; j++) {
//                System.out.print(taula.taula[i][j] + "  ");
//            }
//            System.out.println();
//        }
//        System.out.println();
    }


}