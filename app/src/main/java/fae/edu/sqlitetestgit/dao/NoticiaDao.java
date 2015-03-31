package fae.edu.sqlitetestgit.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fae.edu.sqlitetestgit.model.Noticia;

/**
 *
 * @author Robson
 *
 */
public class NoticiaDao {

    private DatabaseConnection dbHelper;
    private SQLiteDatabase database;

    public NoticiaDao() {
        dbHelper = DatabaseFactory.getDatabaseConnection();
        database = dbHelper.getWritableDatabase();
    }

    public void salvar(Noticia noticia) {
        ContentValues values = new ContentValues();
        values.put("titulo", noticia.getTitulo());
        values.put("texto", noticia.getTexto());

        if(noticia.getIdNoticia()==null) {
            database.insert("Noticia", null, values);
        }else{
            database.update("Noticia", values, "id="+noticia.getIdNoticia(), null);
        }
    }

    public void excluir(Noticia noticia) {
        if(noticia!=null && noticia.getIdNoticia()!=null) {
            database.delete("Noticia", "id="+noticia.getIdNoticia(), null);
        }
    }

    public List<Noticia> busca() {
        List<Noticia> noticias = new ArrayList<>();
        Cursor cursor = database.rawQuery("select id, titulo, texto from Noticia", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            Noticia not = new Noticia();
            not.setIdNoticia(cursor.getLong(0));
            not.setTitulo(cursor.getString(1));
            not.setTexto(cursor.getString(2));
            noticias.add(not);
            cursor.moveToNext();
        }

        cursor.close();
        return noticias;
    }

    public Noticia buscaPorId(Long idNoticia) {
        Cursor cursor = database.rawQuery("select id, titulo, texto from Noticia where id="+idNoticia, null);
        cursor.moveToFirst();
        if(!cursor.isAfterLast()) {
            Noticia not = new Noticia();
            not.setIdNoticia(cursor.getLong(0));
            not.setTitulo(cursor.getString(1));
            not.setTexto(cursor.getString(2));
            cursor.close();
            return not;
        }else{
            cursor.close();
            return null;
        }
    }
}
