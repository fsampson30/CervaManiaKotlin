package br.com.cervamania.cervamania.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.cervamania.cervamania.Controller.AdapterListaCervejas;
import br.com.cervamania.cervamania.Controller.TarefaRetornaListaCervejasClassificacao;
import br.com.cervamania.cervamania.Controller.TarefaRetornaListaCervejasClassificacaoNotas;
import br.com.cervamania.cervamania.Controller.TarefaRetornaListaCervejasEstilos;
import br.com.cervamania.cervamania.Controller.TarefaRetornaListaCervejasPaises;
import br.com.cervamania.cervamania.Model.NomesEstilosCervejas;
import br.com.cervamania.cervamania.Model.NomesPaisesCervejas;
import br.com.cervamania.cervamania.R;
import br.com.cervamania.cervamania.sqlite.DataBaseHelper;

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
    private static final String TAG = "ListaCervejasActivity";
    private DataBaseHelper db = new DataBaseHelper(this);

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
                //Código responsável pela pesquisa no SQLite - Nova implementação.
                exibeProgresso();
                recebeListaPaisesCerveja(codigoTipoCerveja);
                escondeProgresso();


                //Código respónsável por acesso externo ao banco de dados - Desativado por Flavio Sampson - 17/06/2021 - 11:19
                //new TarefaRetornaListaCervejasPaises(this).execute(codigoTipoCerveja);
                break;
            }
            case "estilos": {
                //txtTituloEstiloCerveja.setText(nomesEstilos.retornaNomesEstilosCervejas(codigoTipoCerveja));
                //Código responsável pela pesquisa no SQLite - Nova implementação.
                exibeProgresso();
                recebeListaEstiloCerveja(codigoTipoCerveja);
                escondeProgresso();

                //Código respónsável por acesso externo ao banco de dados - Desativado por Flavio Sampson - 17/06/2021 - 10:47
                //new TarefaRetornaListaCervejasEstilos(this).execute(codigoTipoCerveja);
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
                //Código responsável pela pesquisa no SQLite - Nova implementação.
                exibeProgresso();
                recebeListaPesquisaUsuario(textoPesquisadoUsuario);
                escondeProgresso();

                //Código respónsável por acesso externo ao banco de dados - Desativado por Flavio Sampson - 16/06/2021 - 16:23
                //new TarefaRetornaListaCervejasPesquisaUsuario(this).execute(textoPesquisadoUsuario);
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

    public void exibeProgresso(){
        barraCircular.setVisibility(View.VISIBLE);
        txtBaixandoInformacoes.setVisibility(View.VISIBLE);
    }

    public void escondeProgresso(){
        barraCircular.setVisibility(View.GONE);
        txtBaixandoInformacoes.setVisibility(View.GONE);
    }

    public void retornaNotasClassificacao(ArrayList<Double> notasClassificacoes) {
        this.notasClassificacoes = notasClassificacoes;
    }

    public void recebeListaPesquisaUsuario(String nome){
        ArrayList<String> lista = db.selectNomeCervejaPesquisaUsuario(nome);
        adapter = new AdapterListaCervejas(lista, codigoTipoCerveja, origemFragment, notasClassificacoes);
        recyclerViewListaCervejas.setAdapter(adapter);
    }

    private void recebeListaEstiloCerveja(String codigo) {
        ArrayList<String> lista = db.selectNomeCervejaPorTipo(codigo);
        txtTituloEstiloCerveja.setText(nomesEstilos.retornaNomesEstilosCervejas(codigoTipoCerveja));
        adapter = new AdapterListaCervejas(lista, codigoTipoCerveja, origemFragment, notasClassificacoes);
        recyclerViewListaCervejas.setAdapter(adapter);
    }

    private void recebeListaPaisesCerveja(String codigoPais) {
        ArrayList<String> lista = db.selectNomeCervejaPorPais(codigoPais);
        adapter = new AdapterListaCervejas(lista, codigoTipoCerveja, origemFragment, notasClassificacoes);
        recyclerViewListaCervejas.setAdapter(adapter);
    }
}

