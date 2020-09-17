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
        
        erstelleTestAuto();
        erstelleTestKunde();
        erstelleTestVermietung();
        showMenu();
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Menu Methode --------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public void showMenu()
    {
        System.out.println("-----------------------------");
        System.out.println("--- Autovermietung - Menü ---");
        System.out.println("--- 1. Autos  anzeigen ---");
        System.out.println("--- 2. Kunden anzeigen ---");
        System.out.println("--- 3. Auto erstellen ---");
        System.out.println("--- 4. Kunde erstellen ---");
        System.out.println("--- 5. Starte Vermietung ---");
        System.out.println("--- 6. Vermietungen anzeigen ---");
        System.out.println("--- 7. Auto verändern ---");
        System.out.println("--- 8. Kunde verändern ---");
        System.out.println("--- 99. Beende das Programm ---");
        System.out.println("");
        
        try
        {
            waitForInput();
        }
        catch(Abbruch a)
        {
            showMenu();
        }
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //wait for Input Methode --------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public void waitForInput()
    {
        String input = "";
        try{
            input = this.reader.readLine();
        }
        catch(IOException err){
            System.out.println("Fehler bei der Eingabe!");
            System.out.println("");
        }
        
        //Eingaben prüfen
        if(input.equals("1"))
        {
            alleAutosAnzeigen();
        }
        else if(input.equals("2"))
        {
            alleKundenAnzeigen();
        }
        else if(input.equals("3"))
        {
            autoErstellenInput();
        }
        else if(input.equals("4"))
        {
            kundeErstellenInput();
        }
        else if(input.equals("5"))
        {
            starteVermietungInput();
        }
        else if(input.equals("6"))
        {
            alleVermietungenAnzeigen();
        }
        else if(input.equals("7"))
        {
            changeAuto();
        }
        else if(input.equals("8"))
        {
            changeKunde();
        }
        else if(input.equals("99"))
        {
            confirmProgrammEnde();
            return;
        }
        else
        {
            System.out.println("Keine gültige Eingabe");
            System.out.println("");
        }
        
        showMenu();
    }
    
    public void confirmProgrammEnde()
    {
        System.out.println("möchtest du das programm wirklich beenden?");
        System.out.println("");
        String ende = newInput();
        System.out.println("");
        if(ende.equals("no") || ende.equals("nein"))
        {
            System.out.println("Programm wird nicht beendet!");
            System.out.print('\u000C');
            showMenu();
        }
        else if(ende.equals("yes") || ende.equals("ja"))
        {
            System.out.print('\u000C');
            System.out.println("Programm wird beendet...");
            sleepSeconds(1);
            System.out.print('\u000C');
            System.out.println("Programm wird beendet..");
            sleepSeconds(1);
            System.out.print('\u000C');
            System.out.println("Programm wird beendet.");
            sleepSeconds(1);
            System.out.print('\u000C');
        }
        else
        {
            System.out.println("Fehler bei der eingabe...");
            System.out.println("");
            System.out.println("Bitte antworte mit ja/nein oder yes/no");
            System.out.println("");
            confirmProgrammEnde();
        }
    }
    
    //sleep Methode
    public void sleepSeconds(int seconds)
    {
        try
            {
                Thread.sleep(seconds*1000);
            }
            catch(InterruptedException err)
            {
            }
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //getting a new Input --------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
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
            System.out.println("");
        }
        if(input.equalsIgnoreCase("ABBRECHEN"))
        {
            throw new Abbruch();
        }
        return input;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Objekte anzeigen lassen --------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public void alleAutosAnzeigen()
    {
        System.out.print('\u000C');
        System.out.println("Liste aller Autos in diesem Autopark");
        System.out.println("");
        for(Auto auto : this.getAutos())
        {
            System.out.println("Kennzeichen: " + auto.getKennzeichen() + " / Typ: " + auto.getTyp() + " / Preis: " + auto.getPreis() + "€ pro Tag / Ist verliehen: " + auto.getVerliehen());
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void alleKundenAnzeigen()
    {
        System.out.print('\u000C');
        System.out.println("Liste aller Kunden in diesem Autopark");
        System.out.println("");
        for(Kunde kunde : this.getKunden())
        {
            System.out.println("Vorname: " + kunde.getVorname() + " / Nachname: " + kunde.getNachname() + " / Kunden-ID: " + kunde.getKundenID() + " / Darf leihen: " + kunde.getDarfleihen());
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void alleVermietungenAnzeigen()
    {
        System.out.print('\u000C');
        System.out.println("Liste aller Vermietungen in diesem Autopark");
        System.out.println("");
        for(Vermietung vermietung : this.getVermietungen())
        {
            Kunde kunde = getKunden().get(0);
            Auto auto = getAutos().get(0);
            System.out.println("Kunde: " + kunde.getVorname() + " " + kunde.getNachname());
            System.out.println("Auto: " + auto.getKennzeichen() + " / Typ: " + auto.getTyp() + " / Preis: " + auto.getPreis());
            System.out.println("Vermietung: " + vermietung.getStart() + " bis " + vermietung.getEnde());
            System.out.println("");
        }
        System.out.println("");
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Objekte erstellen (Auto) -------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public void autoErstellenInput()
    {
        System.out.print('\u000C');
        System.out.println("--- Erstellung eines neuen Autos ---");
        
        System.out.println("Auto Typ:");
        String typ = newInput();
        System.out.println("");
        
        String kennzeichen = checkKennzeichen();
        System.out.println("");
        
        int preis = preisInput();
        System.out.println("");
        
        boolean verliehen = false;
        
        autoErstellen(typ, kennzeichen, preis, verliehen);
    }
    
    public String checkKennzeichen()
    {
        System.out.println("Auto Kennezichen:");
        String skennzeichen = newInput();
        if (checkKennzeichen2(skennzeichen) == true)
        {
            System.out.println("Dieses Kennezeichen existiert bereits...");
            System.out.println("");
            return checkKennzeichen();
        }
        else
        {
            return skennzeichen;
        }
    }
    
    public boolean checkKennzeichen2(String skennzeichen)
    {
        for(Auto auto : this.getAutos())
        {
            if(auto.getKennzeichen().equals(skennzeichen))
            {
                return true;
            }
        }
        return false;
    }
    
    public int preisInput()
    {
        try{
            System.out.print("Preis: ");
            String spreis = newInput();
                
            int ipreis = Integer.parseInt(spreis);
            
            int preis = ipreis;
            
            return preis;
        }
        catch(NumberFormatException err)
        {
            System.out.println("Fehler bei der Eingabe...");
            System.out.println("");
            int preis = preisInput();
            return preis;
        }
    }
    
    public void autoErstellen(String typ, String kennzeichen, int preis, boolean verliehen)
    {
        Auto neuesAuto = new Auto(typ, kennzeichen, preis, verliehen);
        this.autos.add(neuesAuto);
        System.out.println("erstelltes Auto:");
        neuesAuto.printAuto();
        System.out.println("");
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Objekte erstellen (Kunde) ------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public void kundeErstellenInput()
    {
        System.out.print('\u000C');
        System.out.println("--- Erstellung eines neuen Kunden ---");
        
        System.out.println("Vorname:");
        String vorname = newInput();
        System.out.println("");
        
        System.out.println("Nachname:");
        String nachname = newInput();
        System.out.println("");
        
        String kundenid = checkKundenID();
        System.out.println("");
        
        boolean darfleihen = darfleihenInput();
        System.out.println("");
        
        
        kundeErstellen(vorname, nachname, kundenid, darfleihen);
    }
    
    public String checkKundenID()
    {
        System.out.println("Kunden-ID");
        String skundenid = newInput();
        if (checkKundenID2(skundenid) == true)
        {
            System.out.println("Diese KundenID existiert bereits...");
            System.out.println("");
            return checkKundenID();
        }
        else
        {
            String kundenid = skundenid;
            return kundenid;
        }
    }
    
    public boolean checkKundenID2(String skundenid)
    {
        for(Kunde kunde : this.getKunden())
        {
            if(kunde.getKundenID().equals(skundenid))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean darfleihenInput()
    {
        try{
            System.out.print("Darf leihen: ");
            String sdarfleihen = newInput();
            if(sdarfleihen.equals("yes") || sdarfleihen.equals("true"))
            {
                sdarfleihen = "true";
            }
            else if(sdarfleihen.equals("no") || sdarfleihen.equals("false"))
            {
                sdarfleihen = "false";
            }
            else
            {
                System.out.println("Fehler bei der Eingabe...");
                System.out.println("");
                boolean darfleihen = darfleihenInput();
                System.out.println("");
                return darfleihen;
            }
                
            boolean bdarfleihen = Boolean.parseBoolean(sdarfleihen);
            
            boolean darfleihen = bdarfleihen;
            System.out.println("");
            
            return darfleihen;
        }
        catch(NumberFormatException err)
        {
            System.out.println("Fehler bei der Eingabe...");
            System.out.println("");
            boolean darfleihen = darfleihenInput();
            System.out.println("");
            return darfleihen;
        }
    }
    
    public void kundeErstellen(String vorname, String nachname, String kundenid, boolean darfleihen)
    {
        Kunde neuerKunde = new Kunde(vorname, nachname, kundenid, darfleihen);
        this.kunden.add(neuerKunde);
        System.out.println("erstellter Kunde:");
        neuerKunde.printKunde();
        System.out.println("");
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Objekte erstellen (Vermietung) -------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public void starteVermietungInput(){
        System.out.print('\u000C');
        System.out.println("--- Erstellung einer neuen Vermietung ---");
        
        System.out.print("Start: ");
        String start = newInput();
        System.out.println("");
        
        System.out.print("Ende: ");
        String ende = newInput();
        System.out.println("");
        
        System.out.println("Diese Autos stehen zur verfügung:");
        System.out.println("");
        for(Auto auto : this.getAutos())
        {
            System.out.println("Kennzeichen: " + auto.getKennzeichen() + " / Typ: " + auto.getTyp() + " / Preis: " + auto.getPreis() + "€ pro Tag / Ist verliehen: " + auto.getVerliehen());
            System.out.println("");
        }
        System.out.println("");
        
        Auto auto = chooseAuto();
        System.out.println("");
        
        System.out.println("Diese Kunde stehen zur verfügung:");
        System.out.println("");
        for(Kunde kunde : this.getKunden())
        {
            System.out.println("Vorname: " + kunde.getVorname() + " / Nachname: " + kunde.getNachname() + " / Kunden-ID: " + kunde.getKundenID() + " / Darf leihen: " + kunde.getDarfleihen());
            System.out.println("");
        }
        System.out.println("");
        
        Kunde kunde = chooseKunde();
        System.out.println("");
        
        starteVermietung(start, ende, auto, kunde);
    }
    
    //Diese Methode startet eine neue Vermietung mit den Parametern aus starteVermietungInput()
    public void starteVermietung(String start, String ende, Auto auto, Kunde kunde)
    {
        Vermietung neueVermietung = new Vermietung(start, ende, auto, kunde);
        neueVermietung.getAuto().setVerliehen(true);
        this.vermietungen.add(neueVermietung);
        System.out.println("erstellte Vermietung:");
        neueVermietung.printVermietung();
        System.out.println("");
    }
    
    //diese Methode soll das ensprechende Auto zurükgeben, welches in der Variable kennezeichen den Input hat
    public Auto chooseAuto()
    {
        System.out.print("Auto-Kennzeichen: ");
        String skennzeichen = newInput();
        for(Auto auto : this.getAutos())
        {
            if(auto.getKennzeichen().equals(skennzeichen))
            {
                return auto;
            }
        }
        System.out.println("Es gibt kein Auto mit diesem Kennzeichen im Autopark; versuche ein anderes Kennzeichen");
        return chooseAuto();
    }
    
    //diese Methode soll den entsprechenden Kunde zurükgeben, welcher in der Variable kundenid den Input hat
    public Kunde chooseKunde()
    {
        System.out.print("Kunden-ID: ");
        System.out.println("");
        String sID = newInput();
        for(Kunde kunde : this.getKunden())
        {
            if(kunde.getKundenID().equals(sID))
            {
                return kunde;
            }
        }
        System.out.println("Es gibt keinen Kunden mit dieser KundenID im Autopark; versuche eine andere KundenID");
        System.out.println("");
        return chooseKunde();
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Auto verändern -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public void changeAuto()
    {
        System.out.println("Welches Auto möchtest du verändern (Kennzeichen):");
        Auto auto = chooseAuto();
        
        System.out.println("neuer Typ:");
        String typ = newInput();
        
        System.out.println("neues Kennzeichen");
        String kennzeichen = checkKennzeichen();
        
        System.out.println("neuer Preis:");
        int preis = preisInput();
        
        boolean verliehen = auto.getVerliehen();
        
        autoVeraendern(auto, typ, kennzeichen, preis, verliehen);
    }
    
    public void autoVeraendern(Auto auto, String typ, String kennzeichen, int preis, boolean verliehen)
    {
        auto.setTyp(typ);
        auto.setKennzeichen(kennzeichen);
        auto.setPreis(preis);
        auto.setVerliehen(verliehen);
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Kunde verändern -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public void changeKunde()
    {
        System.out.println("Welchen Kunde möchtest du verändern (KundenID):");
        Kunde kunde = chooseKunde();
        
        System.out.println("neuer Vorname");
        String vorname = newInput();
        
        System.out.println("neuer Nachname");
        String nachname = newInput();
        
        System.out.println("neue KundenID");
        String kundenid = checkKundenID();
        
        System.out.println("darf dieser Kunde leihen?:");
        boolean darfleihen = darfleihenInput();
        
        
        kundeVeraendern(kunde, vorname, nachname, kundenid, darfleihen);
    }
    
    public void kundeVeraendern(Kunde kunde, String vorname, String nachname, String kundenid, boolean darfleihen)
    {
        kunde.setVorname(vorname);
        kunde.setNachname(nachname);
        kunde.setKundenID(kundenid);
        kunde.setDarfleihen(darfleihen);
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Objekte erstellen (TestObjekte) ------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public void erstelleTestAuto()
    {
        getAutos().add(new Auto("TestCarTyp", "XX XX XXXX", 00, false));
    }
    
    public void erstelleTestKunde()
    {
        getKunden().add(new Kunde("TestVorname", "TestNachname", "00000", true));
    }
    
    public void erstelleTestVermietung()
    {
        getVermietungen().add(new Vermietung("08.09.2020", "09.09.2020", getAutos().get(0), getKunden().get(0)));
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //add Methoden -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
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
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //remove Methoden ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
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
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //GETTER -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
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