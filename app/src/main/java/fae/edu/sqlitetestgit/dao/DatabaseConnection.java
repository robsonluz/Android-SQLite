package fae.edu.sqlitetestgit.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * @author Robson
 *
 */
public class DatabaseConnection extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "noticias1.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("criando o database");

        db.execSQL("create table Noticia(" +
                "id integer primary key autoincrement, " +
                "titulo text," +
                "texto text" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Utilizado para fazer upgrade o banco, quando o usuário for
        //atualizar o aplicativo
    }

}
