package m04_music_DB;

import m04_music_DB.model.Album;
import m04_music_DB.model.Artist;
import m04_music_DB.model.DataSource;
import m04_music_DB.model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        System.out.println("\n===== Printing all artists =====");
        List<Artist> artists = dataSource.queryArtist(DataSource.ORDER_BY_ASC);
        if (artists == null) {
            System.out.println("No artists found!");
            return;
        }
        for (Artist a : artists) {
            System.out.println(a.getId() + ": " + a.getName());
        }

        System.out.println("\n===== Printing all albums of an artist =====");
        List<Album> artistsAlbums = dataSource.queryAlbums("Metallica", DataSource.ORDER_BY_ASC);
        if (artistsAlbums.isEmpty()){
            System.out.println("No such artist found in database");
            return;
        }
        for (Album album: artistsAlbums){
            System.out.println(album.getId() + ": " + album.getName());
        }

        System.out.println("\n===== Printing performer(s) of the song =====");
        List<SongArtist> performersOfTheSong = dataSource.performerOfTheSong("Go your own way");
        if (performersOfTheSong.isEmpty()){
            System.out.println("No artists in database matches given song title");
            return;
        }
        for (SongArtist sa: performersOfTheSong) {
            System.out.println("Artist: " + sa.getArtistName() +
                                ", album: " + sa.getAlbumName() +
                                ", track #" + sa.getTrackNumber());
        }

        System.out.println("\n===== Table MetaData =====");
        dataSource.querySongsMetaData();

        System.out.println("\n===== Retrieving function result =====");
        int numberOfSongs = dataSource.getCount(DataSource.TABLE_SONGS);
        System.out.println("Number of songs in database: " + numberOfSongs);

        System.out.println("\n===== Creating View =====");
        dataSource.createViewForSongArtists();

        System.out.println("\n===== Printing performer(s) of the song (using VIEW) =====");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter song title: ");
        String title = scanner.nextLine();
        // przykład SQL Injection:
        // Donna" or 1=1 or "

        List<SongArtist> performerOfTheSongView = dataSource.performerOfTheSongView(title);
        // kod jak u góry, gdy funkcja nie znajdzie pasującego rekordu (tu pomijam)
        for (SongArtist sa: performerOfTheSongView) {
            System.out.println("Artist: " + sa.getArtistName() +
                    ", album: " + sa.getAlbumName() +
                    ", track #" + sa.getTrackNumber());
        }

        dataSource.close();
    }
}
