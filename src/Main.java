import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        TaulaVirtual taula = new TaulaVirtual();

        taula.crearTaula();
        taula.afegirMines();

        TaulaUsuari.mostrarTaulaUsuari(taula);

//        for (int i = 0; i < taula.midaTaulaX; i++) {
//            for (int j = 0; j < taula.midaTaulaY; j++) {
//                System.out.print(taula.taula[i][j] + "  ");
//            }
//            System.out.println();
//        }
    }


}