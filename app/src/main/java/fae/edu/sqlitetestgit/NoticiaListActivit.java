package fae.edu.sqlitetestgit;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import fae.edu.sqlitetestgit.dao.NoticiaDao;
import fae.edu.sqlitetestgit.model.Noticia;


public class NoticiaListActivit extends ActionBarActivity {

    private NoticiaDao noticiaDao;
    private NoticiaListAdapter noticiaListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia_list);

        ListView noticiasListView = (ListView) findViewById(R.id.noticiasListView);

        noticiaDao = new NoticiaDao();
        noticiaListAdapter = new NoticiaListAdapter(this);

        noticiasListView.setAdapter(noticiaListAdapter);
        buscaNoticias();
    }

    private void buscaNoticias() {
        List<Noticia> noticias = noticiaDao.busca();

        noticiaListAdapter.clear();
        noticiaListAdapter.addAll(noticias);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.noticia_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_new) {
            Intent intent = new Intent(this, NoticiaFormActivity.class);
            startActivity(intent);
            return true;
        }
        if(item.getItemId()==R.id.action_refresh) {
            buscaNoticias();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();

        buscaNoticias();
    }
}
