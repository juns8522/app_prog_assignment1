public class Shop
{   public static void main (String[] args)
    {   new Shop(); }

    private Customers customers = new Customers();
    private Songs songs = new Songs();
    
    public Shop()
    { 
        char choice = readOption().charAt(0);
        while(choice != 'X' && choice != 'x')
        {
            execute(choice);
            choice = readOption().charAt(0);
        }
    }
    
    public String readOption()
    {
        System.out.println();
        System.out.print("Enter choice (or ?): ");
        return In.nextLine();
    }
    
    public void execute(char choice)
    {
        switch(choice)
        {
            case 'C': case 'c': customers.addCustomer(); break;
            case 'R': case 'r': customers.removeCustomer(); break;
            case 'S': case 's': customers.showSongs(); break;
            case 'N': case 'n': songs.searchByName(); break;
            case 'A': case 'a': songs.searchByArtist(); break;
            case 'D': case 'd': download(); break;
            case 'P': case 'p': customers.changePassword(); break;
            case '?': showChoices(); break;
            case 'X': case 'x': break;
            default: System.out.println("Invalid choice."); break;
        }
    }
    
    public void download()
    {
        Customer customer = customers.customer();
        if(customer != null)
        {
            int id = readId();
            while(id != 0)
            {
                Song song = songs.song(id);
                if(song == null)
                    System.out.println("    No matching id");
                else
                    customers.download(song, customer);
                id = readId();
            }
        }
    }
    
    public int readId()
    {
        System.out.print("  Song id (0 to exit): ");
        return In.nextInt();
    }
    
    public void showChoices()
    {
        System.out.println("    The menu choices are\n"
                            +"    C/c: Add a customer\n"
                            +"    R/r: Remove a customer\n"
                            +"    S/s: Show your songs\n"
                            +"    N/n: Search by name\n"
                            +"    A/a: Search by artist\n"
                            +"    D/d: Download\n"
                            +"    P/p: Change password\n"
                            +"    ?: Show choices\n"
                            +"    X/x: Exit");
    }
}
