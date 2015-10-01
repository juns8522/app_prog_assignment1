public class Song
{   private String name;
    private String artist;
    private int id;
    
    public Song(String name, String artist, int id)
    {
        this.name = name;
        this.artist = artist;
        this.id = id;
    }
    
    public boolean containsName(String name)
    { return this.name.toLowerCase().contains(name); }
    
    public boolean containsArtist(String artist)
    {   
        if(this.artist.indexOf(" ") != this.artist.lastIndexOf(" "))
        {
            if(this.artist.substring(0, this.artist.indexOf(" ")).toLowerCase().contains(artist) ||
               this.artist.substring(this.artist.lastIndexOf(" "), this.artist.length()).toLowerCase().contains(artist)) 
               return true;
        }
        else if(this.artist.toLowerCase().contains(artist))
             return true;
        return false;
    }
    
    public boolean matches(int id)
    { return this.id == id; }
    
    public String toString()
    { return "  " + id + ": " + name + ", " + artist; }
}
