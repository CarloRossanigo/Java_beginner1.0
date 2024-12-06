public class VotoConLode extends Voto {
    // CAMPi:
    // Proprietà della classe (static), valore predefinito della lode
    // Il voto con lode è fissato inizialmente a 32 (e non 30), correzione del prof.
    private static int lode = 32;

    // COSTRUTTORI:
    // Il costruttore chiama il costruttore della classe padre (Voto) con il valore 30.
    // Nota: non viene lanciata un'eccezione, poiché il voto di base è 30 e non può essere inferiore.
    public VotoConLode() {
        super(30); // super(30);, non super(lode)!!
    }

    // METODI:
    // Imposta il valore della lode se è tra 30 e 33 (compreso).
    // Lancia un'eccezione VotoException se il valore è fuori da questo range.
    public static void setValoreLode(int val) {
        if (val > 33 || val < 30)
            throw new VotoException("ERRORE! Il valore della lode deve essere tra 30 e 33.");
        lode = val; // Imposta il nuovo valore per la lode
    }

    // Sovrascrive il metodo toString della classe padre per rappresentare il voto con lode.
    // Restituisce una stringa con il formato "VOTO: 30/30 (Lode)".
    @Override
    public String toString() {
        return "VOTO : 30/30 (Lode)";
    }

    // Sovrascrive il metodo valoreVoto() per restituire il valore della lode.
    // Restituisce il valore statico della lode.
    @Override
    public int valoreVoto() {
        return lode; // Restituisce il valore della lode (32 per default)
    }

    // ES4 (commentato):
    // Questo metodo era pensato per restituire il valore della lode.
    // Non è necessario poiché valoreVoto() già fornisce il valore della lode.
    // public int valoreLode(){
    //     return lode; // Restituisce il valore statico della lode
    //}
}//end class
