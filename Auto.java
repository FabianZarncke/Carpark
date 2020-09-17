public class Auto
{
    //Instanzvariablen
    
    private String typ;
    private String kennzeichen;
    private int preis;
    private boolean verliehen;
    
    //Konstruktor
    
    public Auto(String typ, String kennzeichen, int preis, boolean verliehen)
    {
        this.typ = typ;
        this.kennzeichen = kennzeichen;
        this.preis = preis;
        this.verliehen = verliehen;
    }
    
    //Print Auto
    public void printAuto()
    {
        System.out.println("Kennzeichen: " + getKennzeichen() + " / Typ: " + getTyp() + " / Preis: " + getPreis() + "€ pro Tag / Ist verliehen: " + getVerliehen());
        System.out.println("");
    }
    
    //SETTER
    
    public void setTyp(String typ)
    {
        this.typ = typ;
    }
    
    public void setKennzeichen(String kennzeichen)
    {
        this.kennzeichen = kennzeichen;
    }
    
    public void setpreis(int preis)
    {
        this.preis = preis;
    }
    
    public void setVerliehen(boolean verliehen)
    {
        this.verliehen = verliehen;
    }
    
    //GETTER
    
    public String getTyp()
    {
        return typ;
    }
    
    public String getKennzeichen()
    {
        return kennzeichen;
    }
    
    public int getPreis()
    {
        return preis;
    }
    
    public boolean getVerliehen()
    {
        return verliehen;
    }
}
