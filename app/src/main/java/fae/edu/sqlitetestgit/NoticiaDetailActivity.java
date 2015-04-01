package fae.edu.sqlitetestgit;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import fae.edu.sqlitetestgit.dao.NoticiaDao;
import fae.edu.sqlitetestgit.model.Noticia;


public class NoticiaDetailActivity extends ActionBarActivity {

    private NoticiaDao noticiaDao = new NoticiaDao();
    private Noticia noticia;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia_detail);

        noticia = (Noticia) getIntent().getExtras().get("noticia");
        atualizarTela();

    }

    private void atualizarTela() {
        TextView textNoticiaTitulo = (TextView) findViewById(R.id.textNoticiaTitulo);
        TextView textNoticiaTexto = (TextView) findViewById(R.id.textNoticiaTexto);

        textNoticiaTitulo.setText(noticia.getTitulo());
        textNoticiaTexto.setText(noticia.getTexto());
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.noticia_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_delete) {
            noticiaDao.excluir(noticia);
            Toast.makeText(this, "Notícia Excluída com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }
        if(item.getItemId()==R.id.action_edit) {
            Intent intent = new Intent(this, NoticiaFormActivity.class);
            intent.putExtra("noticia", noticia);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(noticia!=null) {
            noticia = noticiaDao.buscaPorId(noticia.getIdNoticia());
            atualizarTela();
        }
    }
}
