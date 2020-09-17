public class Vermietung
{
   //Instanzvariablen
   private String start;
   private String ende;
   private Auto auto;
   private Kunde kunde;
    
   //Konstruktor
    
   public Vermietung(String start, String ende, Auto auto, Kunde kunde)
   {
        this.start = start;
        this.ende = ende; 
        this.auto = auto;
        this.kunde = kunde;
   }
   
   //Print Vermietung
   
   public void printVermietung()    
   {
       System.out.println("Start: " + getStart() + " / Ende: " + getEnde() + " / Auto: " + auto.getKennzeichen() + " / Kunde: " + kunde.getVorname() + " " + kunde.getNachname());
   }
    
   //SETTER
    
   public void setStart(String start)
   {
       this.start = start;
   }
   
   public void setEnde(String ende)
   {
       this.ende = ende;
   }
   
   public void setAuto(Auto auto)
   {
       this.auto = auto;
   }
   
   public void setKunde(Kunde kunde)
   {
       this.kunde = kunde;
   }
   
   //GETTER
   
   public String getStart()
   {
       return start;
   }
   
   public String getEnde()
   {
       return ende;
   }
   
   public Auto getAuto()
   {
       return auto;
   }
   
   public Kunde getKunde()
   {
       return kunde;
   }
}
