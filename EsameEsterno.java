public class EsameEsterno extends Esame {
    // CAMPI:
    private String descr;  // Descrizione dell'esame esterno

    // COSTRUTTORI:
    // Costruttore che inizializza nome, CFU, voto e descrizione dell'esame esterno
    public EsameEsterno(String n, int c, Voto v, String d) {
        super(n, c, v);  // Chiama il costruttore della classe padre Esame
        this.descr = d;  // Imposta la descrizione dell'esame esterno
    }

    // METODI:
    // Sovrascrive il metodo toString() per aggiungere la descrizione dell'esame esterno
    @Override
    public String toString() {
        return super.toString() + " ** ESAME ESTERNO **: " + this.descr;  // Aggiunge la descrizione
    }
}//end class

