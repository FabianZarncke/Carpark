public class Customer
{
    private String forename;
    private String surname;
    private String customerid;
    private int age;
    private boolean driverslicense;
    private boolean maylend;
    
    //contructor
    public Customer(String forename, String surname, String customerid, int age, boolean driverslicense, boolean maylend)
    {
        setForename(forename);
        setSurname(surname);
        setCustomerid(customerid);
        setAge(age);
        setDriverslicense(driverslicense);
        setMaylend(maylend);
    }
    
    //print Methoden
    
    public void printCustomerSimple()
    {
        System.out.println("forename: " + getForename() + " / surname: " + getSurname() + " / CustomerID: " + getCustomerid() + " / may lend" + getMaylend());
    }
    
    public void printCustomerAdvanced()
    {
        System.out.println("forename: " + getForename() + " / surname: " + getSurname() + " / CustomerID: " + getCustomerid() + " / may lend: " + getMaylend());
        System.out.println("driverslicense: " + getDriverslicense() + " / age: " + getAge());
    }
    
    //SETTER
    
    public void setForename(String forename)
    {
        this.forename = forename;
    }
    
    public void setSurname(String surname)
    {
        this.surname = surname;
    }
    
    public void setCustomerid(String customerid)
    {
        this.customerid = customerid;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
    public void setDriverslicense(boolean driverslicense)
    {
        this.driverslicense = driverslicense;
    }
    
    public void setMaylend(boolean maylend)
    {
        this.maylend = maylend;
    }
    
    //GETTER
    
    public String getForename()
    {
        return forename;
    }
    
    public String getSurname()
    {
         return surname;
    }
    
    public String getCustomerid()
    {
        return customerid;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public boolean getDriverslicense()
    {
        return driverslicense;
    }
    
    public boolean getMaylend()
    {
        return maylend;
    }
}