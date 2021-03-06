package fae.edu.sqlitetestgit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.fae.util.Utils;
import fae.edu.sqlitetestgit.dao.NoticiaDao;
import fae.edu.sqlitetestgit.model.Noticia;


public class NoticiaFormActivity extends AppCompatActivity {
    NoticiaDao noticiaDao = new NoticiaDao();
    private Noticia noticia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia_form);
        if(getIntent().hasExtra("noticia")) {
            noticia = (Noticia) getIntent().getExtras().get("noticia");

            Utils.setTextEditText(this, R.id.editTitulo, noticia.getTitulo());
            Utils.setTextEditText(this, R.id.editTexto, noticia.getTexto());

            //Edicao
        }else{
            //Cria um novo
            noticia = new Noticia();
        }

    }


    public void salvar(View view) {

        noticia.setTitulo(Utils.getTextFromEditText(this, R.id.editTitulo));
        noticia.setTexto(Utils.getTextFromEditText(this, R.id.editTexto));


        noticiaDao.salvar(noticia);

        Toast.makeText(this, "Noticia salva com sucesso", Toast.LENGTH_LONG).show();

        //Fecha esta tela e volta para a anterior
        super.finish();
    }

}
