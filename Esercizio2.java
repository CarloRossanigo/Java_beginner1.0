public class  Esercizio2 {
    public static void main(String[] args)   {
	VotoConLode.setValoreLode(30);
   PianoDiStudi mioPiano = new PianoDiStudi();
   mioPiano.add( "Algebra 1",  9, new Voto(28)  );
   mioPiano.add( "Geometria 1",  6, new Voto(24)  );
   mioPiano.add( "Programmazione 1",  6, new Voto(30) );
   mioPiano.add( "Geometria 2",  9);
   mioPiano.add( "Programmazione 2",  6 );
   mioPiano.add( "Analisi Matematica 1",  9 );
   mioPiano.add( "Analisi Matematica 2",  6 );
  
   mioPiano.add( "Calcolo Numerico 1",  9, new VotoConLode() );
   mioPiano.setVoto( "Geometria 2",  new Voto(27) );
   mioPiano.setVoto( "Analisi Matematica 1",  new Voto(20) );
   mioPiano.setVoto( "Analisi Matematica 1",  new Voto(24) );  // sovrascrive voto precedente
   mioPiano.setVoto( "Analisi Matematica 2",  new VotoConLode() );
   mioPiano.add( new EsameEsterno( "Analisi Matematica 3", 6, new Voto(27), "Politecnico MI") );
   mioPiano.add( new EsameEsterno( "Fisica Generale 1", 9, new VotoConLode(), "Politecnico MI") );
   mioPiano.add( new Esame( "Probabilita’", 9 ) );
   mioPiano.add( new Esame( "Fisica Matematica 1", 6 ) );
   mioPiano.add( new Esame( "Fisica Matematica 2", 6 ) );
   mioPiano.setVoto( "Fisica Matematica 1", new Voto(26) );
   //***  FINE INSERIMENTO ESAMI ***
   System.out.println( mioPiano );
   System.out.println( "Numero esami inseriti -----> "  +  mioPiano.numeroEsami() );
   System.out.println( "Numero esami interni ------> "  +  mioPiano.numeroEsamiInterni() );
   System.out.println( "Numero esami sostenuti ----> "  +  mioPiano.numeroEsamiSostenuti() );
   System.out.println( "Numero lodi ---------------> "  +  mioPiano.numeroLodi() );
   System.out.println( "Totale CFU inseriti -------> "  +  mioPiano.totCfu() );
   System.out.println( "Totale CFU acquisiti ------> "  +  mioPiano.totCfuAcquisiti() );
   
   
   System.out.println("Media(senza lode) :" +Double.toString(mioPiano.media()));
   
    VotoConLode.setValoreLode(32);
   
   System.out.println("Media( lode=32) :" +Double.toString(mioPiano.media()));
   
  } // end main
  
} //end class

