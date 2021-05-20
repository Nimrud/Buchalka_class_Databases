package m04_music_DB;

import m04_music_DB.model.Album;
import m04_music_DB.model.Artist;
import m04_music_DB.model.DataSource;
import m04_music_DB.model.SongArtist;

import java.util.List;

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

        dataSource.close();
    }
}
