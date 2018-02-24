package com.example.davidsantos.materialdesign1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;
    RecyclerView recyclerView;
    ArrayList<Episodio> episodios;
    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //coloca a toolbar
        toolbar = findViewById(R.id.minhaToolbar);
        setSupportActionBar(toolbar);
        //coloca logo
        toolbar.setLogo(R.drawable.moeda);

        //botão voltar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Construindo Lista de episodio
        Episodio episodio = new Episodio("David Santos","qualquer descrição","qwerwqer","12 de janeiro de 2018");
        episodios = new ArrayList<Episodio>();
        episodios.add(episodio);
        episodios.add(new Episodio("Teste2","qualquer descrição","qwerwqer","12 de janeiro de 2018"));
        episodios.add(new Episodio("Teste3","qualquer descrição","qwerwqer","12 de janeiro de 2018"));
        episodios.add(new Episodio("Teste4","qualquer descrição","qwerwqer","12 de janeiro de 2018"));
        episodios.add(new Episodio("Teste5","qualquer descrição","qwerwqer","12 de janeiro de 2018"));

        //RecyclerView
        recyclerView = findViewById(R.id.minhaRecView);
        //Com evento de click
        MeuAdaptador meuAdaptador = new MeuAdaptador(episodios, getApplicationContext(), new MeuAdaptador.OnItemClickListener() {
            @Override
            public void onItemClick(Episodio episodio) {
                Toast.makeText(MainActivity.this, "O episodio é: "+episodio.getTitulo(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(meuAdaptador);
        //Configura formato da lista
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        //Botão Flutuante
        floatingActionButton = findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Botão Flutuante", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    //Coloca o menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meu_menu, menu);
        return true;
    }

    //cria os eventos de click no menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_home:
                Toast.makeText(this, "clicou Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_favoritos:
                Toast.makeText(this, "clicou Favoritos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_contato:
                Toast.makeText(this, "clicou Contato", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                Toast.makeText(this, "clicou Voltar", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
