package m01_basics;

public class BasicCommands {

    // PODSTAWOWE KOMENDY:

    // SQLite COMMANDS - do obsługi DB (zaczynają się od kropki):

    // Ctrl+Alt+T -> otwarcie terminala (Linux)
    // sqlite3 -> otwiera SQLite
    // sqlite3 [nazwa].db -> tworzy bazę danych
    // .open [nazwa].db
    // .headers on
    // .backup [nazwa_kopii] -> tworzy kopię bieżącej bazy danych do pliku o podanej nazwie
    // .backup [nazwa].db [nazwa_kopii] -> tworzy kopię bieżącej bazy danych do pliku o podanej nazwie
    // .restore [nazwa_kopii]
    // .tables -> wyświetla tabele w bieżącej DB
    // .schema -> wyświetla strukturę tabel
    // .dump -> wyświetla strukturę tabel oraz polecenia do zapełnienia jej danymi (INSERTY)
    // .quit -> zamyka SQLite (konsola jest znów w formie wiersza poleceń)

    // SQLite STATEMENTS - do operacji na danych (bez kropki, zakończone średnikiem):

    // 1) CREATE table [nazwa_tabeli] ([nagłówek] text, [nagłówek] integer);
    //    np. CREATE table artists (_id INTEGER PRIMARY KEY, name TEXT NOT NULL);
    // 2) INSERT INTO [nazwa_tabeli] VALUES('[...]', [...]);
    //    lub
    //    INSERT INTO [nazwa_tabeli] ([nagłówek] text, [nagłówek] integer) VALUES('[...]', [...]);
    // 3) SELECT * FROM [nazwa_tabeli] WHERE [nagłówek][warunek];
    // 4) UPDATE [nazwa_tabeli] SET [nagłówek][wartość] WHERE [nagłówek][warunek];
    // 5) DELETE FROM [nazwa_tabeli] WHERE [nagłówek][warunek];
    // 6) ORDER BY [nagłówek] (ASC/DESC) -> 'ascending' jest domyślne
    //    ORDER BY [nagłówek] COLLATE NOCASE -> ignoruje wielkość liter
    //    ORDER BY -> może przyjmować wiele parametrów, np. ORDER BY artist, name;
    // 7) WHERE [nagłówek] <> [wartość] -> nagłówek nie jest równy podanej wartości

    // SELECT przyjmuje też funkcje, np:
    // SELECT COUNT(*) FROM songs;

    // SELECT COUNT(*) AS count FROM songs -> w tabeli wynikowej nadajemy pierwszej kolumnie nazwę (count)


    public static void main(String[] args) {

        // MINI-CHALLENGE 1:
        // Find the title of album 367 in music.db
        // SELECT name FROM albums WHERE _id=367;

        // MINI-CHALLENGE 2:
        // List all songs so that the songs from the same album appear together in track order
        // SELECT * FROM songs ORDER BY album, track;
    }
}
