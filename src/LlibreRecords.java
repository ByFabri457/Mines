import java.util.ArrayList;
import java.util.Scanner;

class Records {
    public String nom = null;
    public long temps;
    public int numeroFiles;
    public int numeroColumnes;
    public int numeroMines;
    public String toString() {
        return String.format("Nom: %s | TempsTrigat: %d"+"s | NumeroFiles: %d | NumeroColumnes: %d | NumeroMines: %d", this.nom, this.temps, this.numeroFiles, this.numeroColumnes, this.numeroMines);
    }

}
public class LlibreRecords {
    static Scanner sc = new Scanner(System.in);
    public static void consultarRecords(ArrayList records) {

        System.out.println("RECORDS:");
        System.out.println("________");
        records.add(null);
        if (records.get(0) == null) System.out.println("Encara no hi ha cap record registrat.");
        else {
            for (int i = 0; i < records.size()-1; i++) {

                System.out.println(records.get(i).toString());

            }
        }
        System.out.println("____________________________________________________________________________________");
        System.out.println();
    }
}