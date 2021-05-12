package m02_joins;

public class JoiningTables {

    // INNER JOIN (niektóre bazy pozwalają na pominięcie słowa INNER):
    // SELECT [tabela.nagłówek] FROM [tabela1] JOIN [tabela2] ON [tabela1.nagłówek]=[tabela2.nagłówek];
    // SELECT songs.track, songs.title, albums.name FROM songs JOIN albums ON songs.album = albums._id;

    // przykład bardziej złożonego zapytania:
    // SELECT albums.name, songs.track, songs.title FROM songs JOIN albums ON songs.album = albums._id
    //      WHERE albums.artist = 192 ORDER BY albums.name, songs.track;

    // łączenie danych z tabel, które są połączone za pomocą tabeli pośredniej:
    // SELECT artists.name, albums.name, songs.track, songs.title FROM songs
    //      INNER JOIN albums ON songs.album = albums._id
    //      INNER JOIN artists ON albums.artist = artists._id
    //      WHERE albums.name = "Doolittle"
    //      ORDER BY artists.name, albums.name, songs.track;

    // Gdy nie znamy dokładnej szukanej frazy:
    // WHERE songs.title LIKE "%doctor%"
    // % -> zastępuje dowolny znak
    // plus słowo kluczowe LIKE
    // LIKE nie jest case-sensitive

    // ? -> zastępuje 0 lub więcej znaków
    // _ -> zastępuje 1 znak

    // KOLEJNOŚĆ JEST WAŻNA!
    // SELECT -> FROM -> JOIN -> WHERE -> ORDER BY

    // VIEWS (dostępne po utworzeniu po wywołaniu polecenia .schema)
    // można na nich wywoływać polecenia (np. SELECT * FROM artist_list WHERE track = 1;)
    // CREATE VIEW artist_list AS
    //      SELECT artists.name, albums.name, songs.track, songs.title FROM songs
    //      INNER JOIN albums ON songs.album = albums._id
    //      INNER JOIN artists ON albums.artist = artists._id
    //      ORDER BY artists.name, albums.name, songs.track COLLATE NOCASE;
    // kasowanie Widoku:
    // DROP VIEW [nazwa];
    // Podczas łączenia kolumn może się darzyć, że nagłówki różnych tabel mają tę samą nazwę
    // warto wtedy zmienić nazwy w Widoku:
    // CREATE VIEW artist_list AS
    //      SELECT artists.name AS artist, albums.name AS album, songs.track, (...)


    // MINI CHALLENGE 1:
    // Produce a list of all artists, with their albums, in alphabetical order of artists name
    // SELECT artists.name, albums.name FROM artists INNER JOIN albums ON albums.artist = artists._id
    //      ORDER BY artists.name;

    // CHALLENGE:
    // 1) Select the titles of all the songs on the album "Forbidden"
    //      SELECT songs.title FROM songs
    //          INNER JOIN albums ON songs.album = albums._id
    //          WHERE albums.name = "Forbidden";
    // 2) Repeat the previous query, but this time display the songs in track order
    // You may want to include the track number in the output to verify it's OK
    //      SELECT songs.track, songs.title FROM songs
    //          INNER JOIN albums ON songs.album = albums._id
    //          WHERE albums.name = "Forbidden"
    //          ORDER BY songs.track;
    // 3) Display all songs for the band "Deep Purple"
    //      SELECT songs.title FROM songs
    //          INNER JOIN albums ON songs.album = albums._id
    //          INNER JOIN artists ON albums.artist = artists._id
    //          WHERE artists.name = "Deep Purple";
    // 4) Rename the band "Mehitabel" to "One Kitten"
    // Note that this is an exception to the advice to always fully qualify your column names
    // (SET artists.name won't work, you just need to specify name)
    //      UPDATE artists SET name = "One Kitten" WHERE name = "Mehitabel";
    // 5) Check that the record was correctly renamed
    //      SELECT * FROM artists WHERE _id = 3;
    // 6) Select the titles of all songs by Aerosmith in alphabetical order
    // Include only the title in the output
    //      SELECT songs.title FROM songs
    //          INNER JOIN albums ON songs.album = albums._id
    //          INNER JOIN artists ON albums.artist = artists._id
    //          WHERE artists.name = "Aerosmith"
    //          ORDER BY songs.title;
    // 7) Replace the column that you used in the previous answer with count(title)
    // to get just a count of the number of songs
    //      SELECT count(songs.title) FROM songs (...)
    // 8) Search the Internet to find out how to get a list of the songs from step 6
    // without any duplicates
    //      SELECT DISTINCT songs.title FROM songs (...)
    // 9) Search the Internet again to find out how to get a count of the songs without duplicates
    // Hint: It uses the same keyword, but the syntax may not be obvious
    //      SELECT count(DISTINCT songs.title) FROM songs (...)
    // 10) Repeat the previous query to find the number of artists (which, obviously,
    // should be 1) and the number of albums
    //      SELECT count(DISTINCT artists.name) FROM songs (...)
    //      SELECT count(DISTINCT albums.name) FROM songs (...)
}
