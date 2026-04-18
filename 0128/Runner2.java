import java.util.ArrayList;

public class Runner2 {
    public static void main(String args[]) {

        ArrayList<Song> songList1 = new ArrayList<Song>();

        songList1.add(new Song("John", "Happy"));
        songList1.add(new Song("Jose", "Hello"));

        System.out.println();
        System.out.println(songList1.get(0).getName());
        System.out.println(songList1.get(1).getName());
        System.out.println(songList1.get(0));
        System.out.println(songList1.get(1));

        System.out.println();
        songList1.set(1, new Song("Jen", "Happy Days"));
        System.out.println(songList1.get(1));

        // new part starts here

        ArrayList<Song> songList2 = new ArrayList<Song>();

        songList2.add(new Song("Drake", "God's Plan"));
        songList2.add(new Song("Adele", "Hello"));
        songList2.add(new Song("Coldplay", "Yellow"));

        System.out.println();
        System.out.println(songList2.get(0)); // first song added
        System.out.println(songList2.get(songList2.size() - 1)); // last song added
    }
}