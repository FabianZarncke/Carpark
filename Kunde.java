public class Kunde
{
    //Instanzvariablen
    private String vorname;
    private String nachname;
    private boolean darfleihen;
    
    //Konstruktor
    
    public Kunde(String vorname, String nachname, boolean darfleihen)
    {
        this.vorname = vorname;
        this.nachname = nachname;
        this.darfleihen = darfleihen;
    }
    
    //Print Kunde
    
    public void printKunde()
    {
        System.out.println("Vorname: " + getVorname() + " / Nachname: " + getNachname() + " / Darf leihen: " + getDarfleihen());
        System.out.println("");
    }
    
    //SETTER
    
    public void setVorname(String vorname)
    {
        this.vorname = vorname;
    }
    
    public void setNachname(String nachname)
    {
        this.nachname = nachname;
    }
    
    public void setDarfleihen(boolean darfleihen)
    {
        this.darfleihen = darfleihen;
    }
    
    //GETTER
    
    public String getVorname()
    {
        return vorname;
    }
    
    public String getNachname()
    {
        return nachname;
    }
    
    public boolean getDarfleihen()
    {
        return darfleihen;
    }
}
