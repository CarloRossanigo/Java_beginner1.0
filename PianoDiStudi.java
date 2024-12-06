import java.util.*;

public class PianoDiStudi {
    // CAMPI: Lista di esami nel piano di studi
    private List<Esame> lista;

    // COSTRUTTORE: Inizializza la lista degli esami
    public PianoDiStudi() {
        this.lista = new ArrayList<Esame>();
    }

    // METODI:

    // Aggiunge un esame alla lista se non è già presente
    public void add(Esame esame) {
        int index = lista.indexOf(esame);
        if (index == -1) 
            lista.add(esame);
    }

    // Aggiunge un esame specificando nome, cfu e voto
    public void add(String nomeEsame, int cfu, Voto voto) {
        add(new Esame(nomeEsame, cfu, voto));
    }

    // Aggiunge un esame specificando solo nome e cfu
    public void add(String nomeEsame, int cfu) {
        add(new Esame(nomeEsame, cfu));
    }

    // Aggiunge un esame esterno con descrizione
    public void add(String nomeEsame, int cfu, Voto voto, String descrizione) {
        add(new EsameEsterno(nomeEsame, cfu, voto, descrizione));
    }

    // Modifica il voto di un esame cercato per nome
    public void setVoto(String nomeEsame, Voto voto) {
        int index = this.lista.indexOf(new Esame(nomeEsame, 2, voto));
        if (index != -1) {
            this.lista.get(index).setVoto(voto);
        }
    }

    // Restituisce il numero totale di esami nel piano di studi
    public int numeroEsami() {
        return lista.size();
    }

    // Restituisce il numero di esami interni (non esterni)
    public int numeroEsamiInterni() {
        int count = 0;
        for (Esame e : lista) {
            if (!(e instanceof EsameEsterno)) {
                count++;
            }
        }
        return count;
    }

    // Restituisce il numero di esami già sostenuti
    public int numeroEsamiSostenuti() {
        int count = 0;
        for (Esame e : lista) {
            if (e.sostenuto()) {
                count++;
            }
        }
        return count;
    }

    // Restituisce il numero di esami sostenuti con lode
    public int numeroLodi() {
        int count = 0;
        for (Esame e : lista) {
            if (e.sostenuto() && (e.getVoto() instanceof VotoConLode)) {
                count++;
            }
        }
        return count;
    }

    // Calcola il totale dei CFU degli esami
    public int totCfu() {
        int totCfu = 0;
        for (Esame e : lista) {
            totCfu += e.getCfu();
        }
        return totCfu;
    }

    // Calcola il totale dei CFU acquisiti (sostenuti)
    public int totCfuAcquisiti() {
        int totCfu = 0;
        for (Esame e : lista) {
            if (e.sostenuto()) {
                totCfu += e.getCfu();
            }
        }
        return totCfu;
    }

    // Restituisce una rappresentazione testuale del piano di studi
    @Override
    public String toString() {
        String s = "";
        for (Esame e : lista) {
            s += e.toString() + "\n";
        }   
        return s;
    }

    // Calcola la media ponderata dei voti degli esami sostenuti
    public double media() {
        double media = 0;
        double cfu = 0;
        for (Esame e : lista) {
            if (e.sostenuto()) {
                cfu += e.getCfu();
                media += (e.getCfu() * e.valoreVoto());
            }
        }
        return media / cfu;
    }

    // Ordina gli esami secondo l'ordine naturale
    public void sort() {
        Collections.sort(lista);
    }

    // Ordina gli esami secondo un comparatore personalizzato
    public void sort(Comparator<Esame> cmp) {
        Collections.sort(lista, cmp);
    }
}//end class



