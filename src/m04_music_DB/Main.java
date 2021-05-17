package m04_music_DB;

import m04_music_DB.model.DataSource;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        dataSource.close();
    }
}
