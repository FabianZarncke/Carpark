import java.util.Random;

public class Rental
{
    private String start;
    private String end;
    private int rentalcode;
    private Car car;
    private Customer customer;
    
    private Random random;
    
    //contructor
    public Rental(String start, String end, int rentalcode, Car car, Customer customer)
    {
        setStart(start);
        setEnd(end);
        setRentalcode(rentalcode);
        setCar(car);
        setCustomer(customer);
        
        this.random = new Random(1);
    }
    
    //print Methods
    
    public void printRentalSimple()
    {
        System.out.println("Customer: " + customer.getForename() + " " + customer.getSurname() + " / CustomerID: " + customer.getCustomerid());
        System.out.println("Car: " + car.getLicenseplate() + " / Type: " + car.getType() + " / Price: " + car.getPrice());
        System.out.println("Start: " + getStart() + " / End: " + getEnd());
    }
    
    //SETTER
    
    public void setStart(String start)
    {
        this.start = start;
    }
    
    public void setEnd(String end)
    {
        this.end = end;
    }
    
    public void setRentalcode(int rentalcode)
    {
        this.rentalcode = rentalcode;
        //this.random.nextInt(1000)+1
    }
    
    public void setCar(Car car)
    {
        this.car = car;
    }
    
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    //GETTER
    
    public String getStart()
    {
        return start;
    }
    
    public String getEnd()
    {
        return end;
    }
    
    public int getRentalcode()
    {
        return rentalcode;
    }
    
    public Car getCar()
    {
        return car;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
}