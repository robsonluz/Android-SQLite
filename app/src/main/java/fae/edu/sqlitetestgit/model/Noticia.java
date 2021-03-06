package fae.edu.sqlitetestgit.model;

import java.io.Serializable;

import android.webkit.JavascriptInterface;

/**
 *
 * @author Robson
 *
 */
public class Noticia implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idNoticia;
    private String titulo;
    private String texto;

    public Noticia() {
    }

    public Noticia(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    @JavascriptInterface
    public Long getIdNoticia() {
        return idNoticia;
    }
    @JavascriptInterface
    public String getTitulo() {
        return titulo;
    }
    @JavascriptInterface
    public String getTexto() {
        return texto;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setIdNoticia(Long idNoticia) {
        this.idNoticia = idNoticia;
    }


}
