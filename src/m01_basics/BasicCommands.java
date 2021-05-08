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
    // 2) INSERT INTO [nazwa_tabeli] VALUES('[...]', [...]);
    //    lub
    // INSERT INTO [nazwa_tabeli] ([nagłówek] text, [nagłówek] integer) VALUES('[...]', [...]);
    // 3) SELECT * FROM [nazwa_tabeli] WHERE [nagłówek][warunek];
    // 4) UPDATE [nazwa_tabeli] SET [nagłówek][wartość] WHERE [nagłówek][warunek];
    // 5) DELETE FROM [nazwa_tabeli] WHERE [nagłówek][warunek];
}
