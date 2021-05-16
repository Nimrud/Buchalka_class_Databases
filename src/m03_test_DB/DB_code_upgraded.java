package m03_test_DB;

import java.sql.*;

public class DB_code_upgraded {
    public static final String DB_NAME = "test01.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/home/krzysztof/workspace/Buchalka/Databases/src/m03_test_DB/" + DB_NAME;

    public static final String TABLE_CONTACTS ="contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = conn.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + "("
                + COLUMN_NAME + " text, "
                + COLUMN_PHONE + " integer, "
                + COLUMN_EMAIL + " text)");

            statement.execute(addContact(TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL,
                    "Bob", 456789, "bob@rock.com"));
            statement.execute(addContact(TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL,
                    "Anna", 4466655, "anna@gmail.com"));
            statement.execute(addContact(TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL,
                    "Mike", 1258741, "mickey@op.com"));
            insertContact(statement, "Chuck", 753951, "chuck@something.com");

            statement.execute("UPDATE " + TABLE_CONTACTS + " SET "
                    + COLUMN_PHONE + "=45612378 WHERE " + COLUMN_NAME + "='Bob'");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while (resultSet.next()){
                System.out.println(resultSet.getString(COLUMN_NAME) + " " +
                        resultSet.getInt(COLUMN_PHONE) + " " +
                        resultSet.getString(COLUMN_EMAIL));
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Moja próba napisania metody:
    private static String addContact(String table, String column1, String column2, String column3,
                           String name, int phone, String email){
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO " + table + " ("
                + column1 + ", " + column2 + ", " + column3 + ")"
                + "VALUES ('" + name + "', " + phone + ", '" + email + "')");
        return sb.toString();
    }

    // Propozycja Buchalki (nie rekomendowana przez niego):
    private static void insertContact(Statement statement, String name, int phone, String email)
        throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL + " ) " +
                "VALUES('" + name + "', " + phone + ", '" + email + "')");
    }

}
