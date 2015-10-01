import java.text.*;
import java.util.*;

public class Customer
{   private String userName;
    private String name;
    private Password password;
    private double cash = 100.00;
    private final double charge = 0.10;
    private LinkedList<Song> bought = new LinkedList<Song>();
    
    public Customer(String userName, String name)
    {
        this.userName = userName;
        this.name = name;
        password = new Password();
        password.setPassword();
    }
    
    public boolean matches(String userName)
    { return this.userName.equals(userName); }
    
    public boolean isCorrect()
    { return password.isCorrect(); }
    
    public void showSongs()
    {
        int size = bought.size();
        String s = "  " + name + " has downloaded";
        if(size == 0)
            s += " nothing\n";
        else
            s += "\n";
        for(int i=0; i < size; i++)
            s += bought.get(i).toString() + "\n";
        System.out.print(s);
    }
    
    public void download(Song song)
    {
        if( cash >= 0.10)
        {
            bought.add(song);
            cash -= charge;
            System.out.println(toString());
        } 
        else
            System.out.println("  Not enough money");
    }
    
    public void changePassword()
    { password.changePassword(); }
    
    public String toString()
    { return "    " + name + " has $"+ formatted(cash) + " left"; }
    
    public String formatted(double value)
    {
        DecimalFormat form = new DecimalFormat("###,##0.00");
        return form.format(value);
    }
}
