import java.util.ArrayList;

public class Records {
    public String nom = null;
    public long temps;
    public int numeroFiles;
    public int numeroColumnes;
    public int numeroMines;
    public String toString() {
        return String.format("Nom: %s | TempsTrigat: %d"+"s | NumeroFiles: %d | NumeroColumnes: %d | NumeroMines: %d", this.nom, this.temps, this.numeroFiles, this.numeroColumnes, this.numeroMines);
    }

    /**
     * S'encarrega de llistar tots els records que s'han registrat mentre el programa ha estat obert
     * @param records És la llista de records de la qual treu la informació
     */
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
        System.out.println("________________________________________________________________________________________");
        System.out.println();
    }

}
