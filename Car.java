public class Car
{
    private String brand;
    private String type;
    private String licenseplate;
    private int maxspeed;
    private int horsepower;
    private int price;
    private boolean lend;
    private boolean damaged;
    private boolean electric;
    
    //contructor
    public Car(String brand, String type, String licenseplate, int maxspeed, int horsepower, int price, boolean lend, boolean damaged, boolean electric)
    {
        setBrand(brand);
        setType(type);
        setLicenseplate(licenseplate);
        setMaxspeed(maxspeed);
        setHorsepower(horsepower);
        setPrice(price);
        setLend(lend);
        setDamaged(damaged);
        setElectric(electric);
    }
    
    //print Methoden
    
    public void printCarSimple()
    {
        System.out.println("Licenseplate: " + getLicenseplate() + " / Brand: " + getBrand() + " /Type:" + getType() + " /  Price:" + getPrice() + " / lend: " + getLend());
    }
    
    public void printCarAdvanced()
    {
        System.out.println("Licenseplate: " + getLicenseplate() + " / Brand: " + getBrand() + " /Type:" + getType() + " /  Price:" + getPrice() + " / lend: " + getLend());
        System.out.println("Horsepower: " + getHorsepower() + " / Maximum speed: " + getMaxspeed() + " / damaged: " + getDamaged() + " / electric: " + getElectric());
    }
    
    //SETTER
    
    public void setBrand(String brand)
    {
        this.brand = brand;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public void setLicenseplate(String licenseplate)
    {
        this.licenseplate = licenseplate;
    }
    
    public void setMaxspeed(int maxspeed)
    {
        this.maxspeed = maxspeed;
    }
    
    public void setHorsepower(int horsepower)
    {
        this.horsepower = horsepower;
    }
    
    public void setPrice(int price)
    {
        this.price = price;
    }
    
    public void setLend(boolean lend)
    {
        this.lend = lend;
    }
    
    public void setDamaged(boolean damaged)
    {
        this.damaged = damaged;
    }
    
    public void setElectric(boolean electric)
    {
        this.electric = electric;
    }
    
    //GETTER
    
    public String getBrand()
    {
        return brand;
    }
    
    public String getType()
    {
        return type;
    }
    
    public String getLicenseplate()
    {
        return licenseplate;
    }
    
    public int getMaxspeed()
    {
        return maxspeed;
    }
    
    public int getHorsepower()
    {
        return horsepower;
    }
    
    public int getPrice()
    {
        return price;
    }
    
    public boolean getLend()
    {
        return lend;
    }
    
    public boolean getDamaged()
    {
        return damaged;
    }
    
    public boolean getElectric()
    {
        return electric;
    }
}