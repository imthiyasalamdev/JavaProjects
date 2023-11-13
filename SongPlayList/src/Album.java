import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    String album;
    String artist;
    ArrayList<Songs> songsList;

    public Album(String album, String artist) {
        this.album = album;
        this.artist = artist;
        this.songsList = new ArrayList<Songs>();
    }

    public Album() {

    }

    public Songs findSong(String title) {
        for (Songs checkedSongs : songsList) {
            if (checkedSongs.getTitle().equals(title)) {
                return checkedSongs;
            } else {
                return null;
            }
        }
        return null;
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songsList.add(new Songs(title, duration));
            System.out.println(title + "Successfully added");
            return true;
        } else {
            System.out.println("Song with name" + title + "already exists");
            return false;
        }
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Songs> playList) {
        int index = trackNumber - 1;
        if (index > 0 && index <= this.songsList.size()) {
            playList.add(this.songsList.get(index));
            return true;
        }
        System.out.println("this album doesn't have trackNumber" + trackNumber);
        return false;
    }

    void addToPlayList(String title, LinkedList<Songs> playList) {
        for (Songs checkedSongs : this.songsList) {
            if (checkedSongs.getTitle().equals(title)) {
                playList.add(checkedSongs);
                return;
            }
        }
        System.out.println(title + "no such songs");
        return;
    }

}
