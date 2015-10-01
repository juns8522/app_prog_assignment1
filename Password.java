public class Password
{   private String password;
    private final int tries = 3;
    
    public void setPassword()
    {
        password = readPassword();
        while(!isValid(password))
        {
            System.out.println("    The word must be >= 6 characters with >= 2 non-letters");
            password = readPassword();
        }
        this.password = password;
        System.out.println("Password accepted");
    }
    
    public String readPassword()
    {
        System.out.print("  Password: ");
        return In.nextLine();
    }
    
    public void changePassword()
    {
        System.out.println("    Enter new password twice");
        String first = readPassword();
        while(!isValid(first))
        {
            System.out.println("    The word must be >= 6 characters with >= 2 non-letters");
            first = readPassword();
        }
        String second = readPassword();
        while(!isValid(second) || !first.equals(second))
        {
            if(!isValid(second))
                System.out.println("    The word must be >= 6 characters with >= 2 non-letters");
            else
                System.out.println("        You must enter the same word again");
            second = readPassword();
        }
        password = second;
        System.out.println("Password changed");
    }
    
    public boolean isValid(String password)
    { return goodLength(password) && goodCombination(password); }
    
    public boolean goodLength(String password)
    {
        if(password.length() >= 6)
            return true;
        return false;
    }
    
    public boolean goodCombination(String password)
    {
        int count = 0;
        for(int i = 0; i < password.length(); i++)
            if(!Character.isLetter(password.charAt(i)))
                count++;
        return count >= 2;
    }
    
    public boolean isCorrect()
    {
        for(int i = 0; i < tries; i++)
        {
            String password = readPassword();
            if(this.password.equals(password))
                return true;
            System.out.println("    Invalid password. Try again.");
        }
        return false;
    }
}
