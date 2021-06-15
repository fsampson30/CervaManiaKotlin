package br.com.cervamania.cervamania.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import br.com.cervamania.cervamania.Controller.AdapterListaCervejas;
import br.com.cervamania.cervamania.Controller.TarefaRetornaListaCervejasClassificacao;
import br.com.cervamania.cervamania.Controller.TarefaRetornaListaCervejasClassificacaoNotas;
import br.com.cervamania.cervamania.Controller.TarefaRetornaListaCervejasEstilos;
import br.com.cervamania.cervamania.Controller.TarefaRetornaListaCervejasPaises;
import br.com.cervamania.cervamania.Controller.TarefaRetornaListaCervejasPesquisaUsuario;
import br.com.cervamania.cervamania.Model.NomesEstilosCervejas;
import br.com.cervamania.cervamania.Model.NomesPaisesCervejas;
import br.com.cervamania.cervamania.R;

public class ListaCervejasActivity extends AppCompatActivity {

    private AdapterListaCervejas adapter;
    private RecyclerView recyclerViewListaCervejas;
    private String codigoTipoCerveja;
    private String origemFragment = "";
    private String textoPesquisadoUsuario;
    private Toolbar toolbar;
    private TextView txtTituloEstiloCerveja;
    private NomesEstilosCervejas nomesEstilos = new NomesEstilosCervejas();
    private NomesPaisesCervejas nomesPaises = new NomesPaisesCervejas();
    private ArrayList<Double> notasClassificacoes = new ArrayList<>();
    public ProgressBar barraCircular;
    public TextView txtBaixandoInformacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cervejas);
        codigoTipoCerveja = getIntent().getExtras().getString("codigo");
        origemFragment = getIntent().getExtras().getString("origem");
        textoPesquisadoUsuario = getIntent().getExtras().getString("textoPesquisado");

        toolbar = (Toolbar) findViewById(R.id.toolBarListaCervejasActivity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        txtTituloEstiloCerveja = (TextView) findViewById(R.id.txtTituloTipoCerveja);
        barraCircular = (ProgressBar) findViewById(R.id.listaCervejasCircularBar);
        txtBaixandoInformacoes = (TextView) findViewById(R.id.txtBaixandoInformaçoes);

        recyclerViewListaCervejas = (RecyclerView) findViewById(R.id.recyclerViewListaCervejas);
        recyclerViewListaCervejas.setLayoutManager(new LinearLayoutManager(this));

        switch (origemFragment) {
            case "paises": {
                txtTituloEstiloCerveja.setText(nomesPaises.retornaNomesEstilosCervejas(codigoTipoCerveja));
                new TarefaRetornaListaCervejasPaises(this).execute(codigoTipoCerveja);
                break;
            }
            case "estilos": {
                txtTituloEstiloCerveja.setText(nomesEstilos.retornaNomesEstilosCervejas(codigoTipoCerveja));
                new TarefaRetornaListaCervejasEstilos(this).execute(codigoTipoCerveja);
                break;
            }
            case "classificacoes": {
                txtTituloEstiloCerveja.setTextSize(20);
                txtTituloEstiloCerveja.setText("Lista feita com as classificações dos usuários.");
                new TarefaRetornaListaCervejasClassificacaoNotas(this).execute();
                new TarefaRetornaListaCervejasClassificacao(this).execute();
                break;

            }
            case "pesquisa": {
                txtTituloEstiloCerveja.setText("Pesquisa por: " + textoPesquisadoUsuario);
                new TarefaRetornaListaCervejasPesquisaUsuario(this).execute(textoPesquisadoUsuario);
                break;

            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }

    public void retornoTarefaExterna(ArrayList<String> lista) {
        if (lista.isEmpty()) {
            Toast.makeText(this, "Não encontrada", Toast.LENGTH_LONG).show();
            onBackPressed();
        } else if (lista.get(0).equals("ERRO_CONEXAO")) {
            Toast.makeText(this, "Erro de Acesso ao Servidor. Tente Novamente", Toast.LENGTH_LONG).show();
            onBackPressed();
        } else {
            adapter = new AdapterListaCervejas(lista, codigoTipoCerveja, origemFragment, notasClassificacoes);
            recyclerViewListaCervejas.setAdapter(adapter);
        }
    }

    public void retornaNotasClassificacao(ArrayList<Double> notasClassificacoes) {
        this.notasClassificacoes = notasClassificacoes;
    }
}

