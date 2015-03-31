package fae.edu.sqlitetestgit.dao;

import android.content.Context;

/**
 *
 * @author Robson
 *
 */
public class DatabaseFactory {
    private static DatabaseConnection databaseConnection;

    public static void initDatabaseConnection(Context context) {
        databaseConnection = new DatabaseConnection(context);
        databaseConnection.getWritableDatabase();
    }

    public static DatabaseConnection getDatabaseConnection() {
        return databaseConnection;
    }
}
