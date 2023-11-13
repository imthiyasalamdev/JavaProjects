import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {


        Album album = new Album("album1", "alam");
        album.addSong("Oonchi ", 3.44);
        album.addSong("Allah  de bandeya", 4.6);
        album.addSong("Saware ", 4.5);
        album.addSong("Love  aaj kal", 4);
        album.addSong("Mehrema  ", 3.9);

        albums.add(album);


        album = new Album("album2", "Anna");
        album.addSong("Believe", 3.44);
        album.addSong("Fallin", 4.6);
        album.addSong("Umbrella ", 4.5);
        album.addSong("Despacito ", 4);
        album.addSong("Irreplaceable  ", 3.9);
        albums.add(album);

        LinkedList<Songs> playList1 = new LinkedList<>();
        albums.get(0).addToPlayList("Oonchi", playList1);
        albums.get(0).addToPlayList("Saware", playList1);
        albums.get(0).addToPlayList("Mehrema", playList1);

        albums.get(1).addToPlayList("Believe", playList1);
        albums.get(1).addToPlayList("Fallin", playList1);
        albums.get(1).addToPlayList("Despacito", playList1);

        play(playList1);


    }

    private static void play(LinkedList<Songs> playList1) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Songs> songsListIterator = playList1.listIterator();
        if (playList1.size() == 0) {
            System.out.println(" This playList have no songs");
        } else {
            System.out.println("Now Playing" + songsListIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if (!forward) {
                        if (songsListIterator.hasNext()) {
                            songsListIterator.next();
                        }
                        forward = true;
                    }
                    if (songsListIterator.hasNext()) {
                        System.out.println("Now playing " + songsListIterator.next().toString());
                    } else {
                        System.out.println("no song available");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (songsListIterator.hasPrevious()) {
                            songsListIterator.previous();
                        }
                        forward = false;
                    }
                    if (songsListIterator.hasPrevious()) {
                        System.out.println("now playing" + songsListIterator.previous().toString());
                    } else {
                        System.out.println("at first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if (forward) {
                        if (songsListIterator.hasPrevious()) {
                            System.out.println("Now playing" + songsListIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("we are at the start of the list");
                        }
                    } else {
                        if (songsListIterator.hasNext()) {
                            System.out.println("Now playing" + songsListIterator.next().toString());
                        } else {
                            System.out.println("we reached to the end");
                        }
                    }
                    break;

                case 4:
                    printList(playList1);
                    break;
                case 5:
                    printMenu();
                    break;

                case 6:
                    if (playList1.size() > 0) {
                        songsListIterator.remove();
                        if (songsListIterator.hasNext()) {
                            System.out.println("Now playing" + songsListIterator.next().toString());
                            forward = true;
                        } else {
                            if (songsListIterator.hasPrevious()) {
                                System.out.println("now playing" + songsListIterator.previous().toString());
                            }
                        }
                    }
            }
        }

    }

    private static void printMenu() {
        System.out.println("Available options\n press");
        System.out.println("o to Quit\n" + "1 to play next Song\n" +
                "2 to play previous song\n" +
                "3 to replay current song\n" +
                "4 to  list of all songs " +
                "5 print all available options" +
                "6 to delete current song from album");
    }

    private static void printList(LinkedList<Songs> playList) {
        Iterator<Songs> songsIterator = playList.iterator();
        System.out.println("--------------------------");
        while (songsIterator.hasNext()) {
            System.out.println(songsIterator.next());
        }
        System.out.println("--------------------------");

    }
}