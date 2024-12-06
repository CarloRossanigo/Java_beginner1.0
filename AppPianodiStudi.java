import java.util.*;

public class AppPianoDiStudi {

    public static  class CmpOrdineVoto implements Comparator<Esame>{
	@Override
	public int compare(Esame e1,Esame  e2){
	    if(e1.valoreVoto()==e2.valoreVoto()){
		return e1.compareTo(e2);	   
	    }
	    else return -Integer.compare(e1.valoreVoto(), e2.valoreVoto());
	}
    }

    public static void main(String[] args) {

	
        PianoDiStudi piano = new PianoDiStudi();
        Scanner scanner = new Scanner(System.in);
	
        while (scanner.hasNextLine()) {
	    try{
            String lineaInput = scanner.nextLine();
            runLineaInput(lineaInput, piano);
	    }catch(VotoException e) {
		System.err.println("Errore formato voto!");
	    }
	    catch(CfuException e) {
            System.err.println("Errore formato Cfu!");
	    }
        }
	
        scanner.close();
    }

    public static void runLineaInput(String lineaInput, PianoDiStudi piano) {
        String[] tokens = lineaInput.split("#");
        String comando = tokens[0];
            switch (comando) {
                case "E":
                    if (tokens.length == 3) {
                        String nomeEsame = tokens[1];
                        int cfu = Integer.parseInt(tokens[2]);
                        piano.add(nomeEsame, cfu);
                    }else if (tokens.length == 4) {
                        String nomeEsame = tokens[1];
                        int cfu = Integer.parseInt(tokens[2]);
                        Voto voto = buildVoto(tokens[3]);
                        piano.add(nomeEsame, cfu, voto);
		    }
                    break;
                case "EE":
                    if (tokens.length == 5) {
                        String nomeEsame = tokens[1];
                        int cfu = Integer.parseInt(tokens[2]);
                        Voto voto = buildVoto(tokens[3]);
                        String descrizione = tokens[4];
                        piano.add(nomeEsame, cfu, voto, descrizione);
                    } 
                    break;
                case "S":
                    if (tokens.length == 3) {
                        String nomeEsame = tokens[1];
                        Voto voto = buildVoto(tokens[2]);
                        piano.setVoto(nomeEsame, voto);
                    } 
                    break;
                case "V":
                    if (tokens.length == 2) {
                        int valoreLode = Integer.parseInt(tokens[1]);
                        VotoConLode.setValoreLode(valoreLode);
                    } 
                    break;
                case "PA":
		    System.out.print(  "========= PIANO DI STUDI (ORDINE ALFABETICO) =========\n");
		    piano.sort();
                    System.out.println(pianoToString(piano));
                    break;
                case "PV":
		    System.out.print(  "========= PIANO DI STUDI (ORDINE PER VOTO) =========\n");
                    piano.sort(new CmpOrdineVoto() );
                    System.out.println(pianoToString(piano));
                    break;
                default:
                    System.err.println("Comando non disponibile: " + comando);
            }
    }

    public static Voto buildVoto(String specificaVoto) {
            if (specificaVoto.equals("L")) {
                return new VotoConLode();
            } else {
                int valoreVoto = Integer.parseInt(specificaVoto);
                return new Voto(valoreVoto);
            }
    }

   public static String pianoToString(PianoDiStudi piano) {
    String s = "";
    s += piano.toString();
    s += "Numero esami inseriti -----> " + piano.numeroEsami() + "\n";
    s += "Numero esami interni ------> " + piano.numeroEsamiInterni() + "\n";
    s += "Numero esami sostenuti ----> " + piano.numeroEsamiSostenuti() + "\n";
    s += "Numero lodi ---------------> " + piano.numeroLodi() + "\n";
    s += "Totale CFU inseriti -------> " + piano.totCfu() + "\n";
    s += "Totale CFU acquisiti ------> " + piano.totCfuAcquisiti() + "\n";
    s += "media ---------------------> " + String.format("%.2f", piano.media()) +
            " (valore lode: " + new VotoConLode().valoreVoto() + ")\n";
    return s;
}

}//end class
