import java.util.*;

public class Customers
{   private LinkedList<Customer> customers = new LinkedList<Customer>();

    public void addCustomer()
    {
        String userName = readUserName();
        while(customer(userName) != null)
        {
            System.out.println("    That name is already taken. Choose another name.");
            userName = readUserName();
        }
        customers.add(new Customer(userName, readName()));
    }
    
    public void removeCustomer()
    {
        Customer customer = customer(readUserName());
        if(customer == null)
            showMatchingError();
        else
        {
            if(customer.isCorrect())
            {
                customers.remove(indexNumber(customer));
                System.out.println("You are gone");
            }
        }
    }
    
    public Customer customer(String userName)
    {
        for( Customer customer : customers)
            if(customer.matches(userName))
                return customer;
        return null;
    }
    
    public Customer customer()
    {
        Customer customer = customer(readUserName());
        if(customer == null)
            System.out.println("    No matching customer");
        else
            if(customer.isCorrect())
                return customer;
        return null;
    }
    
    public String readUserName()
    {
        System.out.print("  Username: ");
        return In.nextLine();
    }
    
    public String readName()
    {
        System.out.print("  Your real name: ");
        return In.nextLine();
    }
    
    public int indexNumber(Customer customer)
    {
        int index = -1;
        for(int i = 0; i < customers.size(); i++)
            if(customer.equals(customers.get(i)))
                index = i;
        return index;
    }
    
    public void download(Song song, Customer currentCustomer)
    {
        for(Customer customer : customers)
            if(customer.equals(currentCustomer))
                customer.download(song);
    }
    
    public void changePassword()
    {
        Customer customer = customer(readUserName());
        if(customer == null)
            showMatchingError();
        else
            if(customer.isCorrect())
                 customer.changePassword();
    }
    
    public void showSongs()
    {
        Customer customer = customer(readUserName());
        if(customer == null)
            showMatchingError();
        else
            customer.showSongs();
    }
    
    public void showMatchingError()
    { System.out.println("No matching customer"); }
}
