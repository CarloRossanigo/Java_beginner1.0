public class CfuException extends RuntimeException {
    // COSTRUTTORE:
    // Il costruttore accetta un messaggio di errore e lo passa al costruttore della superclasse RuntimeException
    public CfuException(String m) {
        super(m);  // Passa il messaggio al costruttore della RuntimeException
    }
}//end class

