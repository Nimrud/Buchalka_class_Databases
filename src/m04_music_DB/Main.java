package m04_music_DB;

import m04_music_DB.model.Artist;
import m04_music_DB.model.DataSource;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        List<Artist> artists = dataSource.queryArtist(DataSource.ORDER_BY_ASC);
        if (artists == null) {
            System.out.println("No artists found!");
            return;
        }
        for (Artist a : artists) {
            System.out.println(a.getId() + ": " + a.getName());
        }

        dataSource.close();
    }
}
