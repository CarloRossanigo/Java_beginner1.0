public class Voto {
    // CAMPI: variabile che rappresenta il voto numerico
    private int voto;

    // COSTRUTTORI:
    // Il costruttore accetta un valore intero 'v' e verifica se è valido (tra 18 e 33).
    // Se il valore non è valido, lancia un'eccezione VotoException.
    public Voto(int v) {
        if (v < 18 || v > 33) 
            throw new VotoException("ERRORE! Il voto deve essere tra 18 e 33.");
        this.voto = v;
    }

    // METODI:
    // Restituisce il valore numerico del voto
    public int valoreVoto() {
        return this.voto;
    }

    // Sovrascrive il metodo toString() per restituire una rappresentazione testuale del voto
    // con il formato "VOTO : X/30", dove X è il valore del voto.
    @Override
    public String toString() {
        return "VOTO : " + this.valoreVoto() + "/30";
    }

    // Confronta due oggetti Voto per vedere se hanno lo stesso valore
    public boolean equals(Voto v) {
        return this.voto == v.voto;
    }

    // Sovrascrive il metodo equals() della classe Object per consentire il confronto tra oggetti generici.
    // Verifica se l'oggetto passato è un'istanza di Voto e poi chiama il metodo equals(Voto v) per il confronto.
    @Override
    public boolean equals(Object o) {
        return o instanceof Voto && this.equals((Voto) o);
    }
}//end class
