import java.util.*;

public class Songs
{   private LinkedList<Song> songs = new LinkedList<Song>();
    private int id = 101;
    
    public Songs()
    {
        songs.add(new Song("Lonely Boy", "The Black Keys", id++));
        songs.add(new Song("Lonely Girl", "The Blue Keys", id++));
        songs.add(new Song("Lonely Snoop Dog", "The Black Keyes", id++));
        songs.add(new Song("Lonely Sentient Entity", "The Black Keys", id++));
        songs.add(new Song("Lonely Pine", "Black The Keys", id++));
        songs.add(new Song("Hey Hey Hey", "Laurent Wery", id++));
        songs.add(new Song("Paradise", "Coldplay", id++));
        songs.add(new Song("Nirvana", "Coldplay", id++));
        songs.add(new Song("Set It Off", "Timomatic", id++));
        songs.add(new Song("Take Care", "Drake", id++));
        songs.add(new Song("As Back Home", "Gym Class Heroes", id++));
        songs.add(new Song("Young, Wild & Free", "Wiz Khalifa", id++));
        songs.add(new Song("Young, Wild & Free", "Snoop Dog", id++));
        songs.add(new Song("Young & Free", "The Snoop Snap", id++));
        songs.add(new Song("Young & Wild", "Aye Bee Cee Dee Eek", id++));
        songs.add(new Song("Wild & Free", "S& Dog", id++));
        songs.add(new Song("Pumped Up Kicks", "Foster The People", id++));
    }
    
    public void searchByName()
    {
        String name = readName();
        String s = "";
        for(Song song : songs)
            if(song.containsName(name))
                s += song.toString() + "\n";
        System.out.print(s);
    }
    
    public String readName()
    {
        System.out.print("  Song name: ");
        return In.nextLine();
    }
    
    public void searchByArtist()
    {
        String artist = readArtist();
        String s = "";
        for(Song song : songs)
            if(song.containsArtist(artist))
                s += song.toString() + "\n";
        System.out.print(s);
    }
    
    public String readArtist()
    {
        System.out.print("  Artist name: ");
        return In.nextLine();
    }
    
    public Song song(int id)
    {
        for(Song song : songs)
            if(song.matches(id))
                return song;
        return null;
    }
}
