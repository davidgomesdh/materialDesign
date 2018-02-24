package com.example.davidsantos.materialdesign1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;

/**
 * Created by david.santos on 20/02/2018.
 */

public class MeuAdaptador extends RecyclerView.Adapter {
    ArrayList<Episodio> episodios;
    Context context;
    OnItemClickListener listener;

    public MeuAdaptador(ArrayList<Episodio> episodios, Context context, OnItemClickListener listener) {
        this.episodios = episodios;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //tranforma o seu layout num dado para inserir dentro de uma view
        View view = LayoutInflater.from(context).inflate(R.layout.minha_celula, parent,false);
        //Configura o ViewHolder
        MeuViewHolder meuViewHolder = new MeuViewHolder(view);

        return meuViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MeuViewHolder meuViewHolder = (MeuViewHolder) holder;

        meuViewHolder.titulo.setText(episodios.get(position).getTitulo());
        meuViewHolder.data_exib.setText(episodios.get(position).getData_exib());
        meuViewHolder.imagem.setImageResource(R.drawable.moeda);

        //Associa item do episodio ao evento do click
        meuViewHolder.bind(episodios.get(position),listener);

    }

    @Override
    public int getItemCount() {
        return episodios.size();
    }

    //Configura Evento de Click
    public interface OnItemClickListener{
        void onItemClick(Episodio episodio);
    }
}
