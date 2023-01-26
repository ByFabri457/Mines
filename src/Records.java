public class Records {
    public static String nom;
    public static int temps;
    public static int numeroFiles;
    public static int numeroColumnes;
    public static int numeroMines;

    public String toString() {
        return String.format("Nom: %s | TempsTrigat: %.2f | NumeroFiles: %2 | NumeroColumnes: %2 | NumeroMines: %3", this.nom, this.temps, this.numeroFiles, this.numeroColumnes, this.numeroMines);
    }
}
