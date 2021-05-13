package m03_test_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // 1) Dodajemy sterownik JDBC (Java DataBase Conectivity) do SQLite:
        // https://github.com/xerial/sqlite-jdbc/releases
        // - File -> Project structure -> Libraries -> + -> Java -> zaznaczamy ściągnięty sterownik (*.jar)
        // 2) Instalujemy SQLite Browser:
        // https://sqlitebrowser.org/dl/
        // (gdy przeglądamy bazę danych w tym programie, to dodaje ona locka to tej bazy!)
        // (aby móc dalej z nią pracować: Plik -> Zamknij bazę danych)
        // 3) Łączymy się z bazą danych (jeśli próbujemy się połączyć z nieistniejącą
        //      bazą, to SQLite ją stworzy)
        // 4) Wszystkie sterowniki JDBC wymagają 'connection string' - jego atrybuty zależą
        //      od konkretnej bazy danych (mogą być wymagane np. login i hasło)

        try (Connection conn = DriverManager.getConnection(
                "jdbc:sqlite:/home/krzysztof/workspace/Buchalka/Databases/src/m03_test_DB/test01.db");
             Statement statement = conn.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER , email TEXT)");
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
