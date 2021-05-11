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

    // KOLEJNOŚĆ JEST WAŻNA!
    // SELECT -> FROM -> JOIN -> WHERE -> ORDER BY


    // MINI CHALLENGE 1:
    // Produce a list of all artists, with their albums, in alphabetical order of artists name
    // SELECT artists.name, albums.name FROM artists INNER JOIN albums ON albums.artist = artists._id
    //      ORDER BY artists.name;
}
