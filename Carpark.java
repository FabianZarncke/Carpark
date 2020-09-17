import java.util.*;
import java.io.*;
import java.util.Random;

public class Carpark
{
    private ArrayList<Car> cars;
    private ArrayList<Customer> customers;
    private ArrayList<Rental> rentals;
    
    private BufferedReader reader;
    
    //contructor
    public Carpark()
    {
        this.cars = new ArrayList<Car>();
        this.customers = new ArrayList<Customer>();
        this.rentals = new ArrayList<Rental>();
        
        createTestCar();
        createTestCustomer();
        createTestRental();
    }
    
    //showAll Methods
    
    public void showAllCars()
    {
        System.out.print('\u000C');
        System.out.println("List of all cars in this Carpark");
        System.out.println("");
        for(Car car : this.getCars())
        {
            car.printCarSimple();
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void showAllCustomers()
    {
        System.out.print('\u000C');
        System.out.println("List of all customers in this Carpark");
        System.out.println("");
        for(Customer customer : this.getCustomers())
        {
            customer.printCustomerSimple();
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void showAllRentals()
    {
        System.out.print('\u000C');
        System.out.println("List of all Rentals in this Carpark");
        System.out.println("");
        for(Rental rental : this.getRentals())
        {
            Customer customer = getCustomers().get(0);
            Car car = getCars().get(0);
            System.out.println("Customer: " + customer.getForename() + " " + customer.getSurname());
            System.out.println("Car: " + car.getLicenseplate() + " / Type: " + car.getType() + " / Price: " + car.getPrice());
            System.out.println("Rental: " + rental.getStart() + " to " + rental.getEnd());
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void showAvailableCars()
    {
        for(Car car : this.getCars())
        {
            if(!car.getLend())
            {
                car.printCarSimple();
            }
        }
    }
    
    //create Methods
    
    public void createCar(String brand, String type, String licenseplate, int maxspeed, int horsepower, int price, boolean  lend, boolean damaged, boolean electric)
    {
        Car newCar = new Car(brand, type, licenseplate, maxspeed, horsepower, price, lend, damaged, electric);
        this.cars.add(newCar);
        System.out.println("created car");
        newCar.printCarSimple();
        System.out.println("");
    }
    
    public void createCustomer(String forename, String surname, String customerid, int age, boolean driverslicense, boolean maylend)
    {
        Customer newCustomer = new Customer(forename, surname, customerid, age, driverslicense, maylend);
        this.customers.add(newCustomer);
        System.out.println("created customer");
        newCustomer.printCustomerSimple();
        System.out.println("");
    }
    
    public void startRental(String start, String end, int rentalcode, Car car, Customer customer)
    {
        Rental newRental = new Rental(start, end, rentalcode, car, customer);
        newRental.getCar().setLend(true);
        this.rentals.add(newRental);
        System.out.println("created rental:");
        newRental.printRentalSimple();
        System.out.println("");
    }
    
    //check Methods
    
    public boolean checkLicenseplate2(String slicenseplate)
    {
        for(Car car : this.getCars())
        {
            if(car.getLicenseplate().equals(slicenseplate))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkCustomerid2(String scustomerid)
    {
        for(Customer customer : this.getCustomers())
        {
            if(customer.getCustomerid().equals(scustomerid))
            {
                return true;
            }
        }
        return false;
    }
    
    //change Methods
    
    public void changeCar(Car car, String brand, String type, String licenseplate, int maxspeed, int horsepower, int price, boolean lend, boolean damaged, boolean electric)
    {
        car.setBrand(brand);
        car.setType(type);
        car.setLicenseplate(licenseplate);
        car.setMaxspeed(maxspeed);
        car.setHorsepower(horsepower);
        car.setPrice(price);
        car.setLend(lend);
        car.setDamaged(damaged);
        car.setElectric(electric);
    }
    
    public void changeCustomer(Customer customer, String forename, String surname, String customerid, int age, boolean driverslicense, boolean maylend)
    {
        customer.setForename(forename);
        customer.setSurname(surname);
        customer.setCustomerid(customerid);
        customer.setAge(age);
        customer.setDriverslicense(driverslicense);
        customer.setMaylend(maylend);
    }
    
    //create test objects method
    
    public void createTestCar()
    {
        getCars().add(new Car("TestBrand", "TestType", "XX XX XXXX", 000, 00, 00, false, false, true));
    }
    
    public void createTestCustomer()
    {
        getCustomers().add(new Customer("TestForename", "TestSurname", "00000", 00, true, true));
    }
    
    public void createTestRental()
    {
        getRentals().add(new Rental("00.00.000", "00.00.0000", 00000, getCars().get(0), getCustomers().get(0)));
    }
    
    //add Methods
    
    public void addCar(Car car)
    {
        this.cars.add(car);
    }
    
    public void addCustomer(Customer customer)
    {
        this.customers.add(customer);
    }
    
    public void addRental(Rental rental)
    {
        this.rentals.add(rental);
    }
    
    //remove Methods
    
    public void removeCar(Car car)
    {
        this.cars.remove(car);
    }
    
    public void removeCustomer(Customer customer)
    {
        this.customers.remove(customer);
    }
    
    public void removeRental(Rental rental)
    {
        this.rentals.remove(rental);
    }
    
    //GETTER
    
    public ArrayList<Car> getCars()
    {
        return cars;
    }
    
    public ArrayList<Customer> getCustomers()
    {
        return customers;
    }
    
    public ArrayList<Rental> getRentals()
    {
        return rentals;
    }
}