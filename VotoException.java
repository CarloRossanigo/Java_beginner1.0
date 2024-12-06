// Definizione della classe VotoException che estende RuntimeException

public class VotoException extends RuntimeException {

    // Costruttore della classe VotoException

    public VotoException(String m) {
        // Invoca il costruttore della superclasse (RuntimeException)
        // per inizializzare l'oggetto con il messaggio di errore fornito.
        super(m);
    }
}//end class
