import java.util.Scanner;

public class Esercizio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PianoDiStudi pianoDiStudi = new PianoDiStudi();
	//TRY CATCH nel WHILE DEL MAIN
        while (scanner.hasNextLine()) {
            String lineaInput = scanner.nextLine();
            try {
                runLineaInput(lineaInput, pianoDiStudi);
            } catch (CfuException | VotoException e) {
                System.err.println(e.getMessage());
            }
        }

        // Dopo che tutti gli esami sono stati inseriti, compiere le operazioni richieste
        pianoDiStudi.sort(); // Ordinamento alfabetico
        System.out.println("========= PIANO DI STUDI (ORDINE ALFABETICO) =========");
        System.out.println(pianoToString(pianoDiStudi));

        // Ordinamento per voto
        pianoDiStudi.sort(new Esercizio3.CmpOrdineVoto());
        System.out.println("========= PIANO DI STUDI (ORDINE PER VOTO) =========");
        System.out.println(pianoToString(pianoDiStudi));
    }

    public static void runLineaInput(String lineaInput, PianoDiStudi pianoDiStudi) throws CfuException, VotoException {
        String[] tokens = lineaInput.split("#");
        String tipoOperazione = tokens[0];

        switch (tipoOperazione) {
            case "E":
                if (tokens.length == 4) {
                    String nomeEsame = tokens[1];
                    int cfu = Integer.parseInt(tokens[2]);
                    int voto = buildVoto(tokens[3]);
                    pianoDiStudi.add(nomeEsame, cfu, new Voto(voto));
                } else if (tokens.length == 5 && tokens[4].equals("L")) {
                    String nomeEsame = tokens[1];
                    int cfu = Integer.parseInt(tokens[2]);
                    pianoDiStudi.add(nomeEsame, cfu, new VotoConLode());
                } else {
                    throw new IllegalArgumentException("Formato input non valido");
                }
                break;

            case "EE":
                if (tokens.length == 6) {
                    String nomeEsame = tokens[1];
                    int cfu = Integer.parseInt(tokens[2]);
                    int voto = buildVoto(tokens[3]);
                    String descrizione = tokens[5];
                    pianoDiStudi.add(new EsameEsterno(nomeEsame, cfu, new Voto(voto), descrizione));
                } else {
                    throw new IllegalArgumentException("Formato input non valido");
                }
                break;

            case "S":
                if (tokens.length == 3) {
                    String nomeEsame = tokens[1];
                    int voto = buildVoto(tokens[2]);
                    pianoDiStudi.setVoto(nomeEsame, new Voto(voto));
                } else {
                    throw new IllegalArgumentException("Formato input non valido");
                }
                break;

            case "V":
                if (tokens.length == 2) {
                    int valoreLode = Integer.parseInt(tokens[1]);
                    VotoConLode.setValoreLode(valoreLode);
                } else {
                    throw new IllegalArgumentException("Formato input non valido");
                }
                break;

            case "PA":
                System.out.println("========= PIANO DI STUDI (ORDINE ALFABETICO) =========");
                System.out.println(pianoToString(pianoDiStudi));
                break;

            case "PV":
                System.out.println("========= PIANO DI STUDI (ORDINE PER VOTO) =========");
                System.out.println(pianoToString(pianoDiStudi, new Esercizio3.CmpOrdineVoto()));
                break;

            default:
                throw new IllegalArgumentException("Tipo di operazione non valido");
        }
    }

    public static int buildVoto(String specificaVoto) throws VotoException {
        if (specificaVoto.equals("L")) {
            return VotoConLode.getValoreLode();
        } else {
            int voto = Integer.parseInt(specificaVoto);
            if (voto < 18 || voto > 30) {
                throw new VotoException("Voto non valido: " + voto + " - deve essere compreso fra 18 e 30");
            }
            return voto;
        }
    }

    public static String pianoToString(PianoDiStudi piano) {
        // Implementa la logica per convertire il piano di studi in una stringa
        // Include tutte le informazioni richieste (esami interni/esterni, media, conteggio cfu, ecc.)
        return piano.toString();
    }

    public static String pianoToString(PianoDiStudi piano, Comparator<Esame> comparator) {
        // Implementa la logica per convertire il piano di studi ordinato in una stringa
        // Utilizza il comparatore fornito
        // Include tutte le informazioni richieste (esami interni/esterni, media, conteggio cfu,....)
        // Ordina il piano di studi utilizzando il comparatore
        piano.sort(comparator);
        return piano.toString();
    }
}//end class
