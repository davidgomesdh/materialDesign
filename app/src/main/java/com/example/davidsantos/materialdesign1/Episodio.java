package com.example.davidsantos.materialdesign1;

/**
 * Created by david.santos on 20/02/2018.
 */

public class Episodio {
    private String titulo;
    private String descricao;
    private String youtubeid;
    private String data_exib;

    public Episodio(String titulo, String descricao, String youtubeid, String data_exib) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.youtubeid = youtubeid;
        this.data_exib = data_exib;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getYoutubeid() {
        return youtubeid;
    }

    public String getData_exib() {
        return data_exib;
    }
}
