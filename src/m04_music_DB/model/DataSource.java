package m04_music_DB.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING =
            "jdbc:sqlite:/home/krzysztof/workspace/Buchalka/Databases/src/m04_music_DB/" + DB_NAME;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONGS_ID = "_id";
    public static final String COLUMN_SONGS_TRACK = "track";
    public static final String COLUMN_SONGS_TITLE = "title";
    public static final String COLUMN_SONGS_ALBUM = "album";
    public static final int INDEX_SONGS_ID = 1;    // Indeksy zaczynają się od 1 (!)
    public static final int INDEX_SONGS_TRACK = 2;
    public static final int INDEX_SONGS_TITLE = 3;
    public static final int INDEX_SONGS_ALBUM = 4;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUMS_ID = "_id";
    public static final String COLUMN_ALBUMS_NAME = "name";
    public static final String COLUMN_ALBUMS_ARTIST = "artist";
    public static final int INDEX_ALBUMS_ID = 1;
    public static final int INDEX_ALBUMS_NAME = 2;
    public static final int INDEX_ALBUMS_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTISTS_NAME = "name";
    public static final int INDEX_ARTISTS_ID = 1;
    public static final int INDEX_ARTISTS_NAME = 2;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    private  Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't open database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close the connection: " + e.getMessage());
        }
    }

    // Metoda bez wykorzystania try-with-resources:
    public List<Artist> queryArtist(int sortOrder){

        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTISTS_NAME);
            sb.append(" COLLATE NOCASE");
            if (sortOrder == ORDER_BY_ASC) {
                sb.append(" ASC");
            } else {
                sb.append(" DESC");
            }
        }

        Statement statement = null;
        ResultSet rs = null;

        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sb.toString());

            List<Artist> artists = new ArrayList<>();
            while (rs.next()){
                Artist artist = new Artist();
                artist.setId(rs.getInt(INDEX_ARTISTS_ID));    // wykorzystanie indeksów kolumn jest wydajniejsze
                //artist.setId(rs.getInt(COLUMN_ARTISTS_ID));
                artist.setName(rs.getString(INDEX_ARTISTS_NAME));
                artists.add(artist);
            }
            return artists;

        } catch (SQLException e){
            System.out.println("Couldn't get information: " + e.getMessage());
            return null;
        } finally {
            try {
                if (rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error while closing ResultSet: " + e.getMessage());;
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e){
                System.out.println("Couldn't close the statement: " + e.getMessage());
            }
        }
    }
}
