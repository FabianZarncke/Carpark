import java.util.*;
import java.io.*;

public class Autopark
{
    //Instanzvariablen
    private ArrayList<Auto> autos;
    private ArrayList<Kunde> kunden;
    private ArrayList<Vermietung> vermietungen;
    
    private BufferedReader reader;
    
    //Kontruktor
    
    public Autopark()
    {
        System.out.print('\u000C');
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.autos = new ArrayList<Auto>();
        this.kunden = new ArrayList<Kunde>();
        this.vermietungen = new ArrayList<Vermietung>();
        
        showMenu();
    }
    
    public void showMenu()
    {
        System.out.println("--- Autovermietung ---");
        System.out.println("--- 1. Autos  anzeigen ---");
        System.out.println("--- 2. Kunden anzeigen ---");
        System.out.println("--- 3. Auto erstellen ---");
        System.out.println("--- 4. Kunde erstellen ---");
        System.out.println("--- 5. Starte Vermietung ---");
        System.out.println("--- 99. Beende das Programm ---");
        
        waitForInput();
    }
    
    //waitForInput Methode
    
    public void waitForInput()
    {
        String input = "";
        try{
            input = this.reader.readLine();
        }
        catch(IOException err){
            System.out.println("Fehler bei der Eingabe!");
        }
        
        //Eingaben prüfen
        if(input.equals("1"))
        {
            alleAutosAnzeigen();
            showMenu();
        }
        else if(input.equals("2"))
        {
            alleKundenAnzeigen();
            showMenu();
        }
        else if(input.equals("3"))
        {
            autoErstellenInput();
            showMenu();
        }
        
        else if(input.equals("4"))
        {
            kundeErstellenInput();
            showMenu();
        }
        else if(input.equals("5"))
        {
            starteVermietungInput();
            showMenu();
        }
        else if(input.equals("99"))
        {
            System.out.println("Programm wird beendet...");
        }
        else
        {
            System.out.println("Keine gültige Eingabe");
            showMenu();
        }
    }
    
    public String newInput()
    {
        String input = "";
        
        try
        {
            input = this.reader.readLine();
        }
        catch(IOException err)
        {
            System.out.println("Fehler bei der Eingabe!");
        }
        return input;
    }
    
    public void alleAutosAnzeigen()
    {
        for(Auto auto : this.getAutos())
        {
            System.out.println("Kennzeichen: " + auto.getKennzeichen() + " / Typ: " + auto.getTyp() + " / Preis: " + auto.getPreis() + "€ pro Tag / Ist verliehen: " + auto.getVerliehen());
            System.out.println("");
        }
    }
    
    public void alleKundenAnzeigen()
    {
        for(Kunde kunde : this.getKunden())
        {
            System.out.println("Vorname: " + kunde.getVorname() + " / Nachname: " + kunde.getNachname() + " / Darf leihen: " + kunde.getDarfleihen());
            System.out.println("");
        }
    }
    
    public void autoErstellenInput()
    {
        System.out.println("Auto Typ:");
        String typ = newInput();
        
        System.out.println("Auto Kennzeichen:");
        String kennzeichen = newInput();
        
        System.out.print("Preis ");
        String spreis = newInput();
            
        int ipreis = Integer.parseInt(spreis);
        
        int preis = ipreis;
        
        boolean verliehen = false;
        
        autoErstellen(typ, kennzeichen, preis, verliehen);
    }
    
    public void autoErstellen(String typ, String kennzeichen, int preis, boolean verliehen)
    {
        Auto neuesAuto = new Auto(typ, kennzeichen, preis, verliehen);
        this.autos.add(neuesAuto);
    }
    
    public void kundeErstellenInput()
    {
        System.out.println("Vorname:");
        String vorname = newInput();
        
        System.out.println("Nachname:");
        String nachname = newInput();
        
        System.out.print("Darf leihen:");
        String sdarfleihen = newInput();
            
        boolean bdarfleihen = Boolean.parseBoolean(sdarfleihen);
        
        boolean darfleihen = bdarfleihen;
        
        
        kundeErstellen(vorname, nachname, darfleihen);
    }
    
    public void kundeErstellen(String vorname, String nachname, boolean darfleihen)
    {
        Kunde neuerKunde = new Kunde(vorname, nachname, darfleihen);
        this.kunden.add(neuerKunde);
    }
    
    public void starteVermietungInput(){
        System.out.print("Start: ");
        String start = newInput();
        
        System.out.print("Ende: ");
        String ende = newInput();
        
        System.out.print("Auto-index: ");
        String sauto = newInput();
        
        int iauto = Integer.parseInt(sauto);
        Auto auto = getAutos().get(iauto);
        
        System.out.print("kunde-index: ");
        String skunde = newInput();
        
        int ikunde = Integer.parseInt(skunde);
        Kunde kunde = getKunden().get(ikunde);
        
        
        starteVermietung(start, ende, auto, kunde);
    }
    
    public void starteVermietung(String start, String ende, Auto auto, Kunde kunde)
    {
        Vermietung neueVermietung = new Vermietung(start, ende, auto, kunde);
        neueVermietung.getAuto().setVerliehen(true);
        this.vermietungen.add(neueVermietung);
        vermietung.printVermietung();
    }
    
    //add Methoden
    
    public void addAuto(Auto auto)
    {
        this.autos.add(auto);
    }
    
    public void addKunde(Kunde kunde)
    {
        this.kunden.add(kunde);
    }
    
    public void addVermietung(Vermietung vermietung)
    {
        this.vermietungen.add(vermietung);
    }
    
    //remove Methoden
    
    public void removeAuto(Auto auto)
    {
        this.autos.remove(auto);
    }
    
    public void removeKunde(Kunde kunde)
    {
        this.kunden.remove(kunde);
    }
    
    public void removeVermietung(Vermietung vermietung)
    {
        this.vermietungen.remove(vermietung);
    }
    
    //GETTER
    
    public ArrayList<Auto> getAutos()
    {
        return autos;
    }
    
    public ArrayList<Kunde> getKunden()
    {
        return kunden;
    }
    
    public ArrayList<Vermietung> getVermietungen()
    {
        return vermietungen;
    }
}
