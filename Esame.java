public class Esame implements Comparable<Esame> {
    // CAMPI:
    private String nome;  // Nome dell'esame
    private int cfu;      // Numero di CFU dell'esame (1-9)
    private Voto voto;    // Voto dell'esame (null se non ancora definito)

    // COSTRUTTORI:
    // Costruttore che inizializza nome, CFU e voto
    public Esame(String n, int c, Voto v) {
        if (c < 1 || c > 9)
            throw new CfuException("ERRORE! CFU deve essere tra 1 e 9.");
        this.nome = n;
        this.cfu = c;
        this.voto = v;
    }

    // Costruttore che inizializza solo nome e CFU (voto è null)
    public Esame(String n, int c) {
        this.nome = n;
        this.cfu = c;
        // correzione prof: this(n, c, null); 
    }

    // METODI:
    // Restituisce il valore del voto se definito e maggiore o uguale a 18, altrimenti -1
    // Funziona anche per VotoConLode, grazie alla sovrascrittura di valoreVoto
    public int valoreVoto() {
        return (this.voto != null && this.voto.valoreVoto() >= 18) ? this.voto.valoreVoto() : -1;
    }

    // Imposta il voto dell'esame
    public void setVoto(Voto v) {
        this.voto = v;
    }

    // Restituisce il voto dell'esame (null se non definito)
    public Voto getVoto() {
        return this.voto;
    }

    // Restituisce il numero di CFU dell'esame
    public int getCfu() {
        return this.cfu;
    }

    // Verifica se l'esame è stato sostenuto (se il voto è valido)
    public boolean sostenuto() {
        return (this.valoreVoto() != -1); // Se il valore del voto è valido, l'esame è sostenuto
    }

    // Restituisce una rappresentazione testuale dell'esame
    @Override
    public String toString() {
        String s = "ESAME: " + this.nome + " CFU: " + Integer.toString(this.cfu);
        if (this.sostenuto()) 
            s += " " + (this.getVoto()).toString();  // Aggiunge il voto se presente
        return s;
    }

    // Confronta due esami per nome (usato per l'uguaglianza)
    public boolean equals(Esame e) {
        return this.nome.equals(e.nome);  // Confronta i nomi degli esami
    }

    // Sovrascrive equals() per oggetti generici (Object)
    @Override
    public boolean equals(Object e) {
        return (e instanceof Esame && this.equals((Esame) e));  // Confronta gli oggetti se sono dello stesso tipo
    }

    // ES3: Confronta due esami per nome (usato per ordinamento)
    @Override
    public int compareTo(Esame e) {
        return this.nome.compareTo(e.nome);  // Ordina per nome dell'esame
    }
}//end class
