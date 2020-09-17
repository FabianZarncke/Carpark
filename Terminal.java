import java.io.*;
import java.util.Random;

public class Terminal
{
    private Carpark carpark;
    
    private BufferedReader reader;
    
    private Random random;
    
    //constructor
    public Terminal()
    {
        System.out.println('\u000C');
        
        this.carpark = new Carpark();
        
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        
        this.random = new Random(1);
        
        showMenu();
    }
    
    public void showMenu()
    {
        System.out.println("--------------------------------");
        System.out.println("|       Rent-a-Car Menu        |");
        System.out.println("--------------------------------");
        System.out.println("--- 1. show Cars             ---");
        System.out.println("--- 2. show Customers        ---");
        System.out.println("--- 3. show Rentals          ---");
        System.out.println("--- 4. create Car            ---");
        System.out.println("--- 5. create Customer       ---");
        System.out.println("--- 6. start Rental          ---");
        System.out.println("--- 7. change Car            ---");
        System.out.println("--- 8. change Customer       ---");
        System.out.println("--- 99. end Programm         ---");
        System.out.println("--------------------------------");
        
        try
        {
            startReading();
        }
        catch(Cancel c)
        {
            showMenu();
        }
    }
    
    
    //startReading Method
    public void startReading()
    {
        String input = "";
        try
        {
            input = this.reader.readLine().replaceAll(" *", "");
        }
        catch(IOException err)
        {
            System.out.println("Fehler bei der Eingabe!");
            System.out.println("");
        }
        
        if(input.equals("1") || input.equalsIgnoreCase("showCars"))
        {
            carpark.showAllCars();
        }
        else if(input.equals("2") || input.equalsIgnoreCase("showCustomers"))
        {
            carpark.showAllCustomers();
        }
        else if(input.equals("3") || input.equalsIgnoreCase("showRentals"))
        {
            carpark.showAllRentals();
        }
        else if(input.equals("4") || input.equalsIgnoreCase("createCar"))
        {
            createCarInput();
        }
        else if(input.equals("5") || input.equalsIgnoreCase("createCustomer"))
        {
            createCustomerInput();
        }
        else if(input.equals("6") || input.equalsIgnoreCase("startRental"))
        {
            startRentalInput();
        }
        else if(input.equals("7") || input.equalsIgnoreCase("changeCar"))
        {
            changeCarInput();
        }
        else if(input.equals("8") || input.equalsIgnoreCase("changeCustomer"))
        {
            changeCustomerInput();
        }
        else if(input.equals("99") || input.equalsIgnoreCase("EndProgramm"))
        {
            confirmEndProgram();
            return;
        }
        else
        {
            System.out.println("No valid input");
            System.out.println("");
        }
        
        showMenu();
    }
    
    public void confirmEndProgram()
    {
        System.out.println("Are you sure that you want to end the program?");
        System.out.println("");
        String end = newInput();
        System.out.println("");
        
        if(end.equalsIgnoreCase("no"))
        {
            System.out.println("The program will not be ended.");
            sleepSeconds(2);
            System.out.println('\u000C');
            showMenu();
        }
        else if(end.equalsIgnoreCase("yes"))
        {
            System.out.print('\u000C');
            System.out.println("Program will be ended...");
            sleepSeconds(1);
            System.out.print('\u000C');
            System.out.println("Program will be ended..");
            sleepSeconds(1);
            System.out.print('\u000C');
            System.out.println("Program will be ended.");
            sleepSeconds(1);
            System.out.print('\u000C');
        }
        else
        {
            System.out.println("No valid input");
            System.out.println("");
            System.out.println("please answer with yes or no");
            System.out.println("");
            confirmEndProgram();
        }
    }
    
    //sleep Method
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
    
    public String newInput()
    {
        String input = "";
        
        try
        {
            input = this.reader.readLine();
        }
        catch(IOException err)
        {
            System.out.println("No valid input");
            System.out.println("");
        }
        
        if(input.equalsIgnoreCase("CANCEL"))
        {
            throw new Cancel();
        }
        return input;
    }
    
    public int newIntInput()
    {
        try{
            String sintinput = newInput();
                
            int iintinput = Integer.parseInt(sintinput);
            
            int intinput = iintinput;
            
            return intinput;
        }
        catch(NumberFormatException err)
        {
            System.out.println("No valid input");
            System.out.println("");
            int intinput = newIntInput();
            return intinput;
        }
    }
    
    public boolean newBooleanInput()
    {
        try{
            String sbooleaninput = newInput();
                
            boolean ibooleaninput = Boolean.parseBoolean(sbooleaninput);
            
            boolean booleaninput = ibooleaninput;
            
            return booleaninput;
        }
        catch(NumberFormatException err)
        {
            System.out.println("No valid input");
            System.out.println("");
            boolean booleaninput = newBooleanInput();
            return booleaninput;
        }
    }
    
    public int randomIntInput()
    {
        int randomint = this.random.nextInt(1000)+1;
        return randomint;
    }
    
    public void createCarInput()
    {
        System.out.print('\u000C');
        System.out.println("--- Creating a new Car ---");
        System.out.println("");
        
        System.out.println("Car Brand:");
        String brand = newInput();
        System.out.println("");
        
        System.out.println("Car Type:");
        String type = newInput();
        System.out.println("");
        
        String licenseplate = checkLicenseplate();
        System.out.println("");
        
        System.out.println("Maxspeed:");
        int maxspeed = newIntInput();
        System.out.println("");
        
        System.out.println("Horsepower:");
        int horsepower = newIntInput();
        System.out.println("");
        
        System.out.println("Price:");
        int price = newIntInput();
        System.out.println("");
        
        boolean lend = false;
        
        boolean damaged = false;
        
        System.out.println("Electric:");
        boolean electric = newBooleanInput();
        System.out.println("");
        
        carpark.createCar(brand, type, licenseplate, maxspeed, horsepower, price, lend, damaged, electric);
    }
    
    public String checkLicenseplate()
    {
        System.out.println("Licenseplate:");
        String slicenseplate = newInput();
        if (carpark.checkLicenseplate2(slicenseplate) == true)
        {
            System.out.println("This Licenseplate already exists; please choose another.");
            System.out.println("");
            return checkLicenseplate();
        }
        else
        {
            return slicenseplate;
        }
    }
    
    public void createCustomerInput()
    {
        System.out.print('\u000C');
        System.out.println("--- Creating a new Customer ---");
        System.out.println("");
        
        System.out.println("Forename:");
        String forename = newInput();
        System.out.println("");
        
        System.out.println("Surname:");
        String surname = newInput();
        System.out.println("");
        
        String customerid = checkCustomerid();
        System.out.println("");
        
        System.out.println("Age:");
        int age = newIntInput();
        System.out.println("");
        
        System.out.println("Does he/she have a Driverslicense?");
        boolean driverslicense = newBooleanInput();
        System.out.println("");
        
        System.out.println("Does he/she have permission to lent?");
        boolean maylend = newBooleanInput();
        System.out.println("");
        
        carpark.createCustomer(forename, surname, customerid, age, driverslicense, maylend);
    }
    
    public String checkCustomerid()
    {
        System.out.println("Kunden-ID");
        String scustomerid = newInput();
        if (carpark.checkCustomerid2(scustomerid) == true)
        {
            System.out.println("This CustomerID already exists; please choose another.");
            System.out.println("");
            return checkCustomerid();
        }
        else
        {
            String customerid = scustomerid;
            return customerid;
        }
    }
    
    public void startRentalInput(){
        System.out.print('\u000C');
        System.out.println("--- Starting a new Rental ---");
        
        System.out.print("Start: ");
        String start = newInput();
        System.out.println("");
        
        System.out.print("End: ");
        String end = newInput();
        System.out.println("");
        
        int rentalcode = randomIntInput();
        
        System.out.println("These Cars are available:");
        System.out.println("");
        carpark.showAvailableCars();
        System.out.println("");
        
        Car car = chooseCar();
        System.out.println("");
        
        System.out.println("These customers exist in the Carpark:");
        System.out.println("");
        carpark.showAllCustomers();
        System.out.println("");
        
        Customer customer = chooseCustomer();
        System.out.println("");
        
        carpark.startRental(start, end, rentalcode, car, customer);
    }
    
    public Car chooseCar()
    {
        System.out.print("Licenseplate:");
        String slicenseplate = newInput();
        for(Car car : carpark.getCars())
        {
            if(car.getLicenseplate().equals(slicenseplate))
            {
                return car;
            }
        }
        System.out.println("There is no car with this Licenseplate in this Carpark; try another");
        return chooseCar();
    }
    
    public Customer chooseCustomer()
    {
        System.out.print("CustomerID:");
        String scustomerid = newInput();
        for(Customer customer : carpark.getCustomers())
        {
            if(customer.getCustomerid().equals(scustomerid))
            {
                return customer;
            }
        }
        System.out.println("There is no Customer with this CustomerID; try another.");
        return chooseCustomer();
    }
    
    public void changeCarInput()
    {
        System.out.println("Choose a car to change (Licenseplate)");
        Car car = chooseCar();
        
        System.out.print('\u000C');
        System.out.println("--- Changing a Car ---");
        System.out.println("");
        
        System.out.println("new Car Brand:");
        String brand = newInput();
        System.out.println("");
        
        System.out.println("new Car Type:");
        String type = newInput();
        System.out.println("");
        
        String licenseplate = checkLicenseplate();
        System.out.println("");
        
        System.out.println("new Maxspeed:");
        int maxspeed = newIntInput();
        System.out.println("");
        
        System.out.println("new Horsepower:");
        int horsepower = newIntInput();
        System.out.println("");
        
        System.out.println("new Price:");
        int price = newIntInput();
        System.out.println("");
        
        System.out.println("lend:");
        boolean lend = newBooleanInput();
        System.out.println("");
        
        System.out.println("damaged:");
        boolean damaged = newBooleanInput();
        System.out.println("");
        
        System.out.println("Electric:");
        boolean electric = newBooleanInput();
        System.out.println("");
        
        
        carpark.changeCar(car, brand, type, licenseplate, maxspeed, horsepower, price, lend, damaged, electric);
    }
    
    public void changeCustomerInput()
    {
        System.out.println("Wich Customer do you want to change (CustomerID)?");
        Customer customer = chooseCustomer();
        System.out.println("");
        
        System.out.println("new forename");
        String forename = newInput();
        System.out.println("");
        
        System.out.println("new surname");
        String surname = newInput();
        System.out.println("");
        
        System.out.println("new CustomerID");
        String customerid = checkCustomerid();
        System.out.println("");
        
        System.out.println("new age");
        int age = newIntInput();
        System.out.println("");
        
        System.out.println("Has this Customer a driverslicense?:");
        boolean driverslicense = newBooleanInput();
        System.out.println("");
        
        System.out.println("May this Customer lend?:");
        boolean maylend = newBooleanInput();
        System.out.println("");
        
        
        carpark.changeCustomer(customer, forename, surname, customerid, age, driverslicense, maylend);
    }
}